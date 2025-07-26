package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.market.order.spring;

import org.endless.ddd.simplified.starter.common.config.endless.EndlessAutoConfiguration;
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
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderModifyReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderRemoveReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.facade.adapter.MarketOrderDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
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
 * @since 0.0.1
 */
@Lazy
@Component
public class SpringGameEveMarketOrderDrivenAdapter implements GameEveMarketOrderDrivenAdapter {

    private final GameEveMarketOrderESIRestClient gameEveMarketOrderESIRestClient;

    private final MarketOrderDrivingAdapter marketOrderDrivingAdapter;

    private final String dateTimePattern;

    public SpringGameEveMarketOrderDrivenAdapter(GameEveMarketOrderESIRestClient gameEveMarketOrderESIRestClient, MarketOrderDrivingAdapter marketOrderDrivingAdapter, EndlessAutoConfiguration configuration) {
        this.gameEveMarketOrderESIRestClient = gameEveMarketOrderESIRestClient;
        this.marketOrderDrivingAdapter = marketOrderDrivingAdapter;
        this.dateTimePattern = configuration.dateTimePattern();
    }


    @Override
    public List<GameEveMarketOrderAggregate> fetch(
            List<GameEveMarketOrderAggregate> existedAggregates,
            String itemId,
            String gameEveItemCode,
            String createUserId) {
        Map<String, GameEveMarketOrderAggregate> exeistMap = existedAggregates.stream()
                .collect(Collectors.toMap(GameEveMarketOrderAggregate::getCode, Function.identity()));
        FindPageRespTransfer firstPage = gameEveMarketOrderESIRestClient.findMarketOrderPage(GameEveMarketOrderESIFindPageReqDTransfer.builder()
                        .gameEveItemCode(gameEveItemCode)
                        .regionId(DEFAULT_REGION_ID)
                        .orderType("all")
                        .page(1)
                        .build().validate())
                .validate();
        if (firstPage.getTotal() <= 0) {
            throw new DrivenAdapterManagerException("未找到市场订单信息，资源项编码为: " + gameEveItemCode);
        }
        List<GameEveMarketOrderAggregate> aggregates = new ArrayList<>(upsert(firstPage.getRows(), exeistMap, itemId, createUserId));
        for (int i = 2; i <= firstPage.getTotal(); i++) {
            FindPageRespTransfer page = gameEveMarketOrderESIRestClient.findMarketOrderPage(GameEveMarketOrderESIFindPageReqDTransfer.builder()
                            .gameEveItemCode(gameEveItemCode)
                            .regionId(DEFAULT_REGION_ID)
                            .orderType("all")
                            .page(i)
                            .build().validate())
                    .validate();
            aggregates.addAll(upsert(page.getRows(), exeistMap, itemId, createUserId));
        }
        Set<String> newCodes = aggregates.stream()
                .map(GameEveMarketOrderAggregate::getCode)
                .collect(Collectors.toSet());
        exeistMap.keySet().stream()
                .filter(code -> !newCodes.contains(code))
                .forEach(code -> {
                    marketOrderDrivingAdapter.remove(MarketOrderRemoveReqCTransfer.builder()
                            .marketOrderId(exeistMap.get(code).getMarketOrderId())
                            .modifyUserId(createUserId)
                            .build().validate());
                    aggregates.add(exeistMap.get(code).remove(createUserId));
                });
        return aggregates;
    }

    private List<GameEveMarketOrderAggregate> upsert(List<?> rows, Map<String, GameEveMarketOrderAggregate> exeistMap, String itemId, String createUserId) {
        return Optional.ofNullable(rows)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new DrivenAdapterManagerException("未找到市场订单信息，资源项ID为: " + itemId))
                .stream()
                .map(GameEveMarketOrderESIFindProfileRespDTransfer.class::cast)
                .map(profile -> {
                    GameEveMarketOrderAggregate.GameEveMarketOrderAggregateBuilder gameEveMarketOrderAggregateBuilder = GameEveMarketOrderAggregate.builder()
                            .code(profile.getOrder_id())
                            .orderRange(profile.getRange())
                            .systemId(profile.getSystem_id())
                            .stationId(profile.getLocation_id());
                    if (exeistMap.containsKey(profile.getOrder_id())) {
                        marketOrderDrivingAdapter.modify(MarketOrderModifyReqCTransfer.builder()
                                .marketOrderId(exeistMap.get(profile.getOrder_id()).getMarketOrderId())
                                .totalQuantity(String.valueOf(profile.getVolume_total()))
                                .remainQuantity(String.valueOf(profile.getVolume_remain()))
                                .minQuantity(String.valueOf(profile.getMin_volume()))
                                .price(String.valueOf(profile.getPrice()))
                                .issuedAt(DateTime.from(TimeStamp.fromISO(profile.getIssued()), dateTimePattern))
                                .expireAt(DateTime.from(Long.parseLong(profile.getDuration()) * TimeStamp.ONE_DAY + TimeStamp.now(), dateTimePattern))
                                .modifyUserId(createUserId)
                                .build().validate());
                        return exeistMap.get(profile.getOrder_id()).modify(gameEveMarketOrderAggregateBuilder
                                .modifyUserId(createUserId));
                    } else {
                        String marketOrderId = Optional.ofNullable(marketOrderDrivingAdapter.create(MarketOrderCreateReqCTransfer.builder()
                                                .itemId(itemId)
                                                .type(profile.getIs_buy_order() ? "BUY" : "SELL")
                                                .totalQuantity(String.valueOf(profile.getVolume_total()))
                                                .remainQuantity(String.valueOf(profile.getVolume_remain()))
                                                .minQuantity(String.valueOf(profile.getMin_volume()))
                                                .price(String.valueOf(profile.getPrice()))
                                                .issuedAt(DateTime.from(TimeStamp.fromISO(profile.getIssued()), dateTimePattern))
                                                .expireAt(DateTime.from(Long.parseLong(profile.getDuration()) * TimeStamp.ONE_DAY + TimeStamp.now(), dateTimePattern))
                                                .createUserId(createUserId)
                                                .build().validate())
                                        .validate()
                                        .getMarketOrderId())
                                .orElseThrow(() -> new DrivenAdapterManagerException("创建市场订单失败，资源项ID为: " + itemId));
                        return GameEveMarketOrderAggregate.create(gameEveMarketOrderAggregateBuilder
                                .marketOrderId(marketOrderId)
                                .createUserId(createUserId));
                    }
                })
                .toList();
    }
}
