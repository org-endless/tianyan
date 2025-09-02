package org.endless.tianyan.sales.components.market.game.eve.order.infrastructure.adapter.market.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterNotFoundException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.ddd.starter.common.utils.model.time.DateTimeTools;
import org.endless.ddd.starter.common.utils.model.time.TimestampTools;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.GameEveESIMarketRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderDRespTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderPageDReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderDrivenAdapter;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderRepository;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.entity.GameEveMarketOrderAggregate;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.TianyanSidecarGameEveItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer.GameEveItemFetchDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.TianyanSidecarMarketOrderRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderGeneratePriceDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderModifyDReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;
import static org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.GameEveESICommonRestClient.DEFAULT_REGION_ID;

/**
 * SpringGameEveMarketOrderDrivenAdapter
 * <p>
 * create 2025/07/25 12:16
 * <p>
 * update 2025/08/27 14:52
 *
 * @author Deng Haozhi
 * @see GameEveMarketOrderDrivenAdapter
 * @since 0.0.1
 */
@Lazy
@Validated
@Component
public class GameEveMarketOrderDrivenAdapterImpl implements GameEveMarketOrderDrivenAdapter {

    private final GameEveESIMarketRestClient gameEveESIMarketRestClient;

    private final TianyanSidecarGameEveItemRestClient gameEveItemRestClient;

    private final TianyanSidecarMarketOrderRestClient marketOrderRestClient;

    private final GameEveMarketOrderRepository marketOrderRepository;

    private final String dateTimePattern;

    public GameEveMarketOrderDrivenAdapterImpl(GameEveESIMarketRestClient gameEveESIMarketRestClient, TianyanSidecarGameEveItemRestClient gameEveItemRestClient, TianyanSidecarMarketOrderRestClient marketOrderRestClient, GameEveMarketOrderRepository marketOrderRepository, EndlessProperties properties) {
        this.gameEveESIMarketRestClient = gameEveESIMarketRestClient;
        this.gameEveItemRestClient = gameEveItemRestClient;
        this.marketOrderRestClient = marketOrderRestClient;
        this.marketOrderRepository = marketOrderRepository;
        this.dateTimePattern = properties.getDateTimePattern();
    }

    @Override
    public List<GameEveMarketOrderAggregate> fetch(String gameEveItemCode, String createUserId) {
        String itemId = gameEveItemRestClient.fetch(GameEveItemFetchDReqTransfer.builder()
                        .gameEveItemCode(gameEveItemCode).createUserId(createUserId).build())
                .orElseThrow(() -> new DrivenAdapterNotFoundException("未找到游戏EVE资源项ID，资源项编码为: " + gameEveItemCode));
        List<String> existedMarketOrderIds = marketOrderRestClient.findIdsByItemId(itemId);
        Map<String, GameEveMarketOrderAggregate> exeistMap;
        if (!CollectionUtils.isEmpty(existedMarketOrderIds)) {
            exeistMap = marketOrderRepository.findAllByMarketOrderIds(existedMarketOrderIds).stream()
                    .collect(Collectors.toMap(GameEveMarketOrderAggregate::getCode, Function.identity()));
        } else {
            exeistMap = new HashMap<>();
        }
        FindPageRespTransfer<FindESIMarketOrderDRespTransfer> firstPage = gameEveESIMarketRestClient.fetchMarketOrders(FindESIMarketOrderPageDReqTransfer.builder()
                        .gameEveItemCode(gameEveItemCode)
                        .regionId(DEFAULT_REGION_ID)
                        .orderType("all")
                        .page(1)
                        .build().validate())
                .validate();
        if (firstPage.total() <= 0) {
            throw new DrivenAdapterNotFoundException("未找到市场订单信息，资源项编码为: " + gameEveItemCode);
        }
        List<GameEveMarketOrderAggregate> aggregates =
                new ArrayList<>(upsert(firstPage.getRows(FindESIMarketOrderDRespTransfer.class), exeistMap, itemId, createUserId));
        for (int i = 2; i <= firstPage.total(); i++) {
            FindPageRespTransfer<FindESIMarketOrderDRespTransfer> page = gameEveESIMarketRestClient.fetchMarketOrders(FindESIMarketOrderPageDReqTransfer.builder()
                            .gameEveItemCode(gameEveItemCode)
                            .regionId(DEFAULT_REGION_ID)
                            .orderType("all")
                            .page(i)
                            .build().validate())
                    .validate();
            aggregates.addAll(upsert(page.getRows(FindESIMarketOrderDRespTransfer.class), exeistMap, itemId, createUserId));
        }
        Set<String> newCodes = aggregates.stream()
                .map(GameEveMarketOrderAggregate::getCode)
                .collect(Collectors.toSet());
        List<GameEveMarketOrderAggregate> removed = exeistMap.keySet().stream()
                .filter(code -> !newCodes.contains(code))
                .map(code -> exeistMap.get(code).remove(createUserId))
                .toList();
        aggregates.addAll(removed);
        return aggregates;
    }

    @Override
    public void generatePrice(String gameEveItemCode, String createUserId) {
        String itemId = gameEveItemRestClient.findItemIdByCode(gameEveItemCode)
                .orElseThrow(() -> new DrivenAdapterNotFoundException("未找到游戏EVE资源项ID，资源项编码为: " + gameEveItemCode));
        marketOrderRestClient.generatePrice(MarketOrderGeneratePriceDReqTransfer.builder()
                .itemId(itemId)
                .createUserId(createUserId).build());
    }

    private List<GameEveMarketOrderAggregate> upsert(
            @NotNull(message = "市场订单列表不能为空对象") List<FindESIMarketOrderDRespTransfer> marketOrders,
            @NotNull(message = "已存在的市场订单聚合对象不能为空对象") Map<String, GameEveMarketOrderAggregate> exeistMap,
            @NotBlank(message = "资源项ID不能为空") String itemId,
            @NotBlank(message = "创建用户ID不能为空") String createUserId) {

        return marketOrders
                .stream()
                .map(order -> {
                    GameEveMarketOrderAggregate.GameEveMarketOrderAggregateBuilder gameEveMarketOrderAggregateBuilder = GameEveMarketOrderAggregate.builder()
                            .code(order.order_id())
                            .orderRange(order.range())
                            .systemId(order.system_id())
                            .stationId(order.location_id());
                    if (exeistMap.containsKey(order.order_id())) {
                        marketOrderRestClient.modify(MarketOrderModifyDReqTransfer.builder()
                                .marketOrderId(exeistMap.get(order.order_id()).getMarketOrderId())
                                .totalItemQuantity(DecimalTools.format5Bit(BigDecimal.valueOf(order.volume_total())).toString())
                                .remainItemQuantity(DecimalTools.format5Bit(BigDecimal.valueOf(order.volume_remain())).toString())
                                .minItemQuantity(DecimalTools.format5Bit(BigDecimal.valueOf(order.min_volume())).toString())
                                .price(DecimalTools.format(BigDecimal.valueOf(order.price())).toString())
                                .issuedAt(DateTimeTools.from(TimestampTools.fromISO(order.issued()), dateTimePattern))
                                .expireAt(DateTimeTools.from(parseLong(order.duration())
                                        * TimestampTools.ONE_DAY + TimestampTools.fromISO(order.issued()), dateTimePattern))
                                .modifyUserId(createUserId)
                                .build().validate());
                        return exeistMap.get(order.order_id()).modify(gameEveMarketOrderAggregateBuilder
                                .modifyUserId(createUserId));
                    } else {
                        String marketOrderId = marketOrderRestClient.create(MarketOrderCreateDReqTransfer.builder()
                                        .itemId(itemId)
                                        .type(order.is_buy_order() ? "BUY" : "SELL")
                                        .totalItemQuantity(DecimalTools.format5Bit(BigDecimal.valueOf(order.volume_total())).toString())
                                        .remainItemQuantity(DecimalTools.format5Bit(BigDecimal.valueOf(order.volume_remain())).toString())
                                        .minItemQuantity(DecimalTools.format5Bit(BigDecimal.valueOf(order.min_volume())).toString())
                                        .price(DecimalTools.format(BigDecimal.valueOf(order.price())).toString())
                                        .issuedAt(DateTimeTools.from(TimestampTools.fromISO(order.issued()), dateTimePattern))
                                        .expireAt(DateTimeTools.from(parseLong(order.duration())
                                                * TimestampTools.ONE_DAY + TimestampTools.fromISO(order.issued()), dateTimePattern))
                                        .createUserId(createUserId)
                                        .build())
                                .orElseThrow(() -> new DrivenAdapterFailedException("创建市场订单失败，资源项ID为: " + itemId));
                        return GameEveMarketOrderAggregate.create(gameEveMarketOrderAggregateBuilder
                                .marketOrderId(marketOrderId)
                                .createUserId(createUserId));
                    }
                })
                .toList();
    }
}
