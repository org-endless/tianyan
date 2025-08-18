package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.market.order.spring;

import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.manager.DrivenAdapterException;
import org.endless.ddd.starter.common.utils.model.time.DateTimeTools;
import org.endless.ddd.starter.common.utils.model.time.TimeStampTools;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.GameEveMarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market.GameEveMarketOrderESIMarketRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketOrderFindPageReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketOrderFindProfileRespDTransfer;
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

import static org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.TianyanGameEveESIRestClient.DEFAULT_REGION_ID;


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

    private final MarketOrderDrivingAdapter marketOrderDrivingAdapter;

    private final GameEveMarketOrderESIMarketRestClient gameEveMarketOrderESIMarketRestClient;

    private final String dateTimePattern;

    public SpringGameEveMarketOrderDrivenAdapter(MarketOrderDrivingAdapter marketOrderDrivingAdapter, GameEveMarketOrderESIMarketRestClient gameEveMarketOrderESIMarketRestClient, EndlessProperties properties) {
        this.marketOrderDrivingAdapter = marketOrderDrivingAdapter;
        this.gameEveMarketOrderESIMarketRestClient = gameEveMarketOrderESIMarketRestClient;
        this.dateTimePattern = properties.getDateTimePattern();
    }


    @Override
    public List<GameEveMarketOrderAggregate> fetch(
            List<GameEveMarketOrderAggregate> existedAggregates,
            String itemId,
            String gameEveItemCode,
            String createUserId) {
        Map<String, GameEveMarketOrderAggregate> exeistMap = existedAggregates.stream()
                .collect(Collectors.toMap(GameEveMarketOrderAggregate::getCode, Function.identity()));
        FindPageRespTransfer firstPage = gameEveMarketOrderESIMarketRestClient.fetchMarketOrderPage(ESIMarketOrderFindPageReqDTransfer.builder()
                        .gameEveItemCode(gameEveItemCode)
                        .regionId(DEFAULT_REGION_ID)
                        .orderType("all")
                        .page(1)
                        .build().validate())
                .validate();
        if (firstPage.getTotal() <= 0) {
            throw new DrivenAdapterException("未找到市场订单信息，资源项编码为: " + gameEveItemCode);
        }
        List<GameEveMarketOrderAggregate> aggregates = new ArrayList<>(upsert(firstPage.getRows(ESIMarketOrderFindProfileRespDTransfer.class), exeistMap, itemId, createUserId));
        for (int i = 2; i <= firstPage.getTotal(); i++) {
            FindPageRespTransfer page = gameEveMarketOrderESIMarketRestClient.fetchMarketOrderPage(ESIMarketOrderFindPageReqDTransfer.builder()
                            .gameEveItemCode(gameEveItemCode)
                            .regionId(DEFAULT_REGION_ID)
                            .orderType("all")
                            .page(i)
                            .build().validate())
                    .validate();
            aggregates.addAll(upsert(page.getRows(ESIMarketOrderFindProfileRespDTransfer.class), exeistMap, itemId, createUserId));
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

    private List<GameEveMarketOrderAggregate> upsert(List<ESIMarketOrderFindProfileRespDTransfer> profiles, Map<String, GameEveMarketOrderAggregate> exeistMap, String itemId, String createUserId) {
        return Optional.ofNullable(profiles)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new DrivenAdapterException("未找到市场订单信息，资源项ID为: " + itemId))
                .stream()
                .map(profile -> {
                    GameEveMarketOrderAggregate.GameEveMarketOrderAggregateBuilder gameEveMarketOrderAggregateBuilder = GameEveMarketOrderAggregate.builder()
                            .code(profile.getOrder_id())
                            .orderRange(profile.getRange())
                            .systemId(profile.getSystem_id())
                            .stationId(profile.getLocation_id());
                    if (exeistMap.containsKey(profile.getOrder_id())) {
                        marketOrderDrivingAdapter.modify(MarketOrderModifyReqCTransfer.builder()
                                .marketOrderId(exeistMap.get(profile.getOrder_id()).getMarketOrderId())
                                .totalItemQuantity(String.valueOf(profile.getVolume_total()))
                                .remainItemQuantity(String.valueOf(profile.getVolume_remain()))
                                .minItemQuantity(String.valueOf(profile.getMin_volume()))
                                .price(String.valueOf(profile.getPrice()))
                                .issuedAt(DateTimeTools.from(TimeStampTools.fromISO(profile.getIssued()), dateTimePattern))
                                .expireAt(DateTimeTools.from(Long.parseLong(profile.getDuration()) * TimeStampTools.ONE_DAY + TimeStampTools.now(), dateTimePattern))
                                .modifyUserId(createUserId)
                                .build().validate());
                        return exeistMap.get(profile.getOrder_id()).modify(gameEveMarketOrderAggregateBuilder
                                .modifyUserId(createUserId));
                    } else {
                        String marketOrderId = Optional.ofNullable(marketOrderDrivingAdapter.create(MarketOrderCreateReqCTransfer.builder()
                                                .itemId(itemId)
                                                .type(profile.getIs_buy_order() ? "BUY" : "SELL")
                                                .totalItemQuantity(String.valueOf(profile.getVolume_total()))
                                                .remainItemQuantity(String.valueOf(profile.getVolume_remain()))
                                                .minItemQuantity(String.valueOf(profile.getMin_volume()))
                                                .price(String.valueOf(profile.getPrice()))
                                                .issuedAt(DateTimeTools.from(TimeStampTools.fromISO(profile.getIssued()), dateTimePattern))
                                                .expireAt(DateTimeTools.from(Long.parseLong(profile.getDuration()) * TimeStampTools.ONE_DAY + TimeStampTools.now(), dateTimePattern))
                                                .createUserId(createUserId)
                                                .build().validate())
                                        .validate()
                                        .getMarketOrderId())
                                .orElseThrow(() -> new DrivenAdapterException("创建市场订单失败，资源项ID为: " + itemId));
                        return GameEveMarketOrderAggregate.create(gameEveMarketOrderAggregateBuilder
                                .marketOrderId(marketOrderId)
                                .createUserId(createUserId));
                    }
                })
                .toList();
    }


}
