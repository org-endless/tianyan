package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.market.order.spring;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.ddd.simplified.starter.common.model.common.transfer.FindPageRespTransfer;
import org.endless.ddd.simplified.starter.common.utils.model.time.DateTime;
import org.endless.ddd.simplified.starter.common.utils.model.time.TimeStamp;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.order.rest.GameEveMarketOrderESIRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderESIFindPageReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderESIFindProfileRespDTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.MarketOrderDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.TianyanSalesESIRestClient.DEFAULT_REGION_ID;

/**
 * SpringGameEveMarketOrderDrivenAdapter
 * <p>
 * create 2025/07/25 12:16
 * <p>
 * update 2025/07/25 12:16
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringGameEveMarketOrderDrivenAdapter implements GameEveMarketOrderDrivenAdapter {

    private final GameEveMarketOrderESIRestClient gameEveMarketOrderESIRestClient;

    private final MarketOrderDrivingAdapter marketOrderDrivingAdapter;

    private final String dateTimePattern;

    public SpringGameEveMarketOrderDrivenAdapter(GameEveMarketOrderESIRestClient gameEveMarketOrderESIRestClient, MarketOrderDrivingAdapter marketOrderDrivingAdapter, String dateTimePattern) {
        this.gameEveMarketOrderESIRestClient = gameEveMarketOrderESIRestClient;
        this.marketOrderDrivingAdapter = marketOrderDrivingAdapter;
        this.dateTimePattern = dateTimePattern;
    }


    @Override
    public List<GameEveMarketOrderAggregate> fetch(List<GameEveMarketOrderAggregate> existedAggregates, String gameEveItemCode, String createUserId) {
        Map<String, GameEveMarketOrderAggregate> exeistMap = existedAggregates.stream()
                .collect(Collectors.toMap(GameEveMarketOrderAggregate::getCode, Function.identity()));
        FindPageRespTransfer firstPage = gameEveMarketOrderESIRestClient.findMarketOrderPage(GameEveMarketOrderESIFindPageReqDTransfer.builder()
                .gameEveItemCode(gameEveItemCode)
                .regionId(DEFAULT_REGION_ID)
                .orderType("all")
                .page(1)
                .build().validate()).validate();
        if (firstPage.getTotal() <= 0) {
            throw new DrivenAdapterManagerException("未找到市场订单信息，资源项编码为: " + gameEveItemCode);
        }
        List<GameEveMarketOrderAggregate> aggregates = new ArrayList<>(from(firstPage.getRows(), exeistMap, gameEveItemCode, createUserId));
        for (int i = 2; i <= firstPage.getTotal(); i++) {
            FindPageRespTransfer page = gameEveMarketOrderESIRestClient.findMarketOrderPage(GameEveMarketOrderESIFindPageReqDTransfer.builder()
                    .gameEveItemCode(gameEveItemCode)
                    .regionId(DEFAULT_REGION_ID)
                    .orderType("all")
                    .page(i)
                    .build().validate()).validate();
            aggregates.addAll(from(page.getRows(), exeistMap, gameEveItemCode, createUserId));
        }
        return aggregates;
    }

    private List<GameEveMarketOrderAggregate> from(List<?> rows, Map<String, GameEveMarketOrderAggregate> exeistMap, String gameEveItemCode, String createUserId) {
        return Optional.ofNullable(rows)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new DrivenAdapterManagerException("未找到市场订单信息，资源项编码为: " + gameEveItemCode))
                .stream()
                .map(GameEveMarketOrderESIFindProfileRespDTransfer.class::cast)
                .map(profile -> {
                    GameEveMarketOrderAggregate.GameEveMarketOrderAggregateBuilder gameEveMarketOrderAggregateBuilder = GameEveMarketOrderAggregate.builder()
                            .code(profile.getOrder_id())
                            .range(profile.getRange())
                            .systemId(profile.getSystem_id())
                            .stationId(profile.getLocation_id());

                    if (!StringUtils.hasText(marketOrderId)) {
                        throw new DrivenAdapterManagerException("创建市场订单失败，资源项编码为: " + gameEveItemCode);
                    }

                    if (exeistMap.containsKey(profile.getOrder_id())) {
                        return exeistMap.get(profile.getOrder_id()).modify(gameEveMarketOrderAggregateBuilder, createUserId);
                    } else {
                        String marketOrderId = marketOrderDrivingAdapter.create(MarketOrderCreateReqCTransfer.builder()
                                        .type(profile.getIs_buy_order() ? "BUY" : "SELL")
                                        .totalQuantity(String.valueOf(profile.getVolume_total()))
                                        .remainQuantity(String.valueOf(profile.getVolume_remain()))
                                        .minQuantity(String.valueOf(profile.getMin_volume()))
                                        .price(String.valueOf(profile.getPrice()))
                                        .issuedAt(DateTime.from(TimeStamp.fromISO(profile.getIssued()), dateTimePattern))
                                        .expireAt(DateTime.from(Long.parseLong(profile.getDuration()) * TimeStamp.ONE_DAY - TimeStamp.now(), dateTimePattern))
                                        .createUserId(createUserId)
                                        .build().validate())
                                .validate()
                                .getMarketOrderId();
                        return GameEveMarketOrderAggregate.create(builder);
                    }
                })
                .toList();
    }
}
