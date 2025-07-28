package org.endless.tianyan.sales.components.market.order.market.order.infrastructure.adapter.price.spring;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderPriceDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.price.market.price.application.command.transfer.MarketPriceCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.price.market.price.facade.adapter.MarketPriceDrivingAdapter;
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

    private static final BigDecimal PRICE_TOLERANCE_PERCENT = Decimal.format("0.2");

    private static final BigDecimal QUANTITY_TOLERANCE_PERCENT = Decimal.format5Bit("0.005");

    private final MarketPriceDrivingAdapter marketPriceDrivingAdapter;

    public SpringMarketOrderPriceDrivenAdapter(MarketPriceDrivingAdapter marketPriceDrivingAdapter) {
        this.marketPriceDrivingAdapter = marketPriceDrivingAdapter;
    }

    @Override
    public void generatePrice(List<MarketOrderAggregate> aggregates, String itemId, String createUserId) {
        MarketPriceCreateReqCTransfer command;
        if (CollectionUtils.isEmpty(aggregates)) {
            command = MarketPriceCreateReqCTransfer.builder()
                    .itemId(itemId)
                    .buyPrice(Decimal.format("0.00").toString())
                    .sellPrice(Decimal.format("0.00").toString())
                    .createUserId(createUserId)
                    .build().validate();
        } else {
            command = filterNoise(aggregates, createUserId);
        }
        marketPriceDrivingAdapter.create(command);
    }

    private MarketPriceCreateReqCTransfer filterNoise(List<MarketOrderAggregate> aggregates, String createUserId) {

        String itemId = aggregates.getFirst().getItemId();
        List<BigDecimal> buyPrices = new ArrayList<>();
        BigDecimal buyPrice = Decimal.format("0");
        List<BigDecimal> sellPrices = new ArrayList<>();
        BigDecimal sellPrice = Decimal.format("0");
        BigDecimal sellQuantity = Decimal.format5Bit("0");
        for (MarketOrderAggregate aggregate : aggregates) {
            if (aggregate.getType() == MarketOrderTypeEnum.BUY) {
                buyPrices.add(aggregate.getPrice());
            } else if (aggregate.getType() == MarketOrderTypeEnum.SELL) {
                sellPrices.add(aggregate.getPrice());
                sellQuantity = Decimal.add(sellQuantity, aggregate.getItemQuantity().getTotal());
            }
        }
        if (!CollectionUtils.isEmpty(buyPrices)) {
            BigDecimal buyMedian = Decimal.median(buyPrices);
            buyPrice = aggregates.stream()
                    .filter(aggregate -> aggregate.getType() == MarketOrderTypeEnum.BUY)
                    .map(MarketOrderAggregate::getPrice)
                    // .filter(price -> Decimal.subtract(price, buyMedian).abs().compareTo(PRICE_TOLERANCE_PERCENT) <= 0)
                    .map(Decimal::format5Bit)
                    .max(BigDecimal::compareTo)
                    .orElseThrow(() -> new DrivenAdapterManagerException("买入价格生成失败"));
        }
        if (!CollectionUtils.isEmpty(sellPrices)) {
            BigDecimal sellMedian = Decimal.median(sellPrices);
            BigDecimal finalSellQuantity = sellQuantity;
            sellPrice = aggregates.stream()
                    .filter(aggregate -> aggregate.getType() == MarketOrderTypeEnum.SELL)
                    .filter(aggregate -> aggregate.getItemQuantity().getTotal().compareTo(Decimal.multiply(finalSellQuantity, QUANTITY_TOLERANCE_PERCENT)) >= 0
                            || Decimal.subtract(aggregate.getPrice(), sellMedian).abs().compareTo(Decimal.multiply(sellMedian, PRICE_TOLERANCE_PERCENT)) <= 0)
                    .map(MarketOrderAggregate::getPrice)
                    .map(Decimal::format5Bit)
                    .max(BigDecimal::compareTo)
                    .orElseThrow(() -> new DrivenAdapterManagerException("卖出价格生成失败"));
        }

        return MarketPriceCreateReqCTransfer.builder()
                .itemId(itemId)
                .buyPrice(Decimal.format(buyPrice).toString())
                .sellPrice(Decimal.format(sellPrice).toString())
                .createUserId(createUserId)
                .build().validate();
    }
}
