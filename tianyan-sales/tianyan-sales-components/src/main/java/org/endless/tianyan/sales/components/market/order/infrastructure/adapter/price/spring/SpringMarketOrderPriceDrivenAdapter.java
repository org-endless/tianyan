package org.endless.tianyan.sales.components.market.order.infrastructure.adapter.price.spring;

import jakarta.validation.constraints.NotEmpty;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.sales.components.market.order.domain.anticorruption.MarketOrderPriceDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.TianyanSidecarMarketPriceRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.transfer.MarketPriceCreateDReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SpringMarketOrderPriceDrivenAdapter
 * <p>
 * create 2025/07/26 19:36
 * <p>
 * update 2025/07/26 19:36
 *
 * @author Deng Haozhi
 * @see MarketOrderPriceDrivenAdapter
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringMarketOrderPriceDrivenAdapter implements MarketOrderPriceDrivenAdapter {

    private static final BigDecimal PRICE_TOLERANCE_PERCENT = DecimalTools.format("0.2");

    private static final BigDecimal QUANTITY_TOLERANCE_PERCENT = DecimalTools.format5Bit("0.005");

    private final TianyanSidecarMarketPriceRestClient marketPriceRestClient;

    public SpringMarketOrderPriceDrivenAdapter(TianyanSidecarMarketPriceRestClient marketPriceRestClient) {
        this.marketPriceRestClient = marketPriceRestClient;
    }

    @Override
    public void generatePrice(List<MarketOrderAggregate> aggregates, String itemId, String createUserId) {
        MarketPriceCreateDReqTransfer command;
        if (CollectionUtils.isEmpty(aggregates)) {
            command = MarketPriceCreateDReqTransfer.builder()
                    .itemId(itemId)
                    .buyPrice(DecimalTools.format("0.00").toString())
                    .sellPrice(DecimalTools.format("0.00").toString())
                    .createUserId(createUserId)
                    .build().validate();
        } else {
            command = filterNoise(aggregates, createUserId);
        }
        marketPriceRestClient.create(command);
    }

    private MarketPriceCreateDReqTransfer filterNoise(
            @NotEmpty(message = "市场订单聚合列表不能为空") List<MarketOrderAggregate> aggregates,
            @NotEmpty(message = "创建用户ID不能为空") String createUserId) {

        String itemId = aggregates.getFirst().getItemId();
        List<BigDecimal> buyPrices = new ArrayList<>();
        BigDecimal buyPrice = DecimalTools.format("0");
        List<BigDecimal> sellPrices = new ArrayList<>();
        BigDecimal sellPrice = DecimalTools.format("0");
        BigDecimal sellQuantity = DecimalTools.format5Bit("0");
        for (MarketOrderAggregate aggregate : aggregates) {
            if (aggregate.getType() == MarketOrderTypeEnum.BUY) {
                buyPrices.add(aggregate.getPrice());
            } else if (aggregate.getType() == MarketOrderTypeEnum.SELL) {
                sellPrices.add(aggregate.getPrice());
                sellQuantity = DecimalTools.add(sellQuantity, aggregate.getItemQuantity().getTotal());
            }
        }
        if (!CollectionUtils.isEmpty(buyPrices)) {
            buyPrice = aggregates.stream()
                    .filter(aggregate -> aggregate.getType() == MarketOrderTypeEnum.BUY)
                    .map(MarketOrderAggregate::getPrice)
                    .map(DecimalTools::format5Bit)
                    .max(BigDecimal::compareTo)
                    .orElseThrow(() -> new DrivenAdapterFailedException("买入价格生成失败"));
        }
        if (!CollectionUtils.isEmpty(sellPrices)) {
            BigDecimal sellMedian = DecimalTools.median(sellPrices);
            BigDecimal finalSellQuantity = sellQuantity;
            sellPrice = aggregates.stream()
                    .filter(aggregate -> aggregate.getType() == MarketOrderTypeEnum.SELL)
                    .filter(aggregate -> aggregate.getItemQuantity().getTotal().compareTo(DecimalTools.multiply(finalSellQuantity, QUANTITY_TOLERANCE_PERCENT)) >= 0
                            || DecimalTools.subtract(aggregate.getPrice(), sellMedian).abs().compareTo(DecimalTools.multiply(sellMedian, PRICE_TOLERANCE_PERCENT)) <= 0)
                    .map(MarketOrderAggregate::getPrice)
                    .map(DecimalTools::format5Bit)
                    .min(BigDecimal::compareTo)
                    .orElseThrow(() -> new DrivenAdapterFailedException("卖出价格生成失败"));
        }

        return MarketPriceCreateDReqTransfer.builder()
                .itemId(itemId)
                .buyPrice(DecimalTools.format(buyPrice).toString())
                .sellPrice(DecimalTools.format(sellPrice).toString())
                .createUserId(createUserId)
                .build();
    }
}
