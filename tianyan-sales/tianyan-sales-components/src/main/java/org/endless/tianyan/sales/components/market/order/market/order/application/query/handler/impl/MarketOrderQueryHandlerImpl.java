package org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption.MarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.handler.MarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer.MarketOrderFindByItemIdReqQTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer.MarketOrderFindIdsRespQTransfer;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

/**
 * MarketOrderQueryHandlerImpl
 * <p>市场订单领域查询处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderQueryHandler
 * @since 0.0.1
 */
public class MarketOrderQueryHandlerImpl implements MarketOrderQueryHandler {

    /**
     * 市场订单聚合查询仓储接口
     */
    private final MarketOrderQueryRepository marketOrderQueryRepository;

    public MarketOrderQueryHandlerImpl(MarketOrderQueryRepository marketOrderQueryRepository) {
        this.marketOrderQueryRepository = marketOrderQueryRepository;
    }

    @Override
    @Log(message = "市场订单根据资源项ID查询ID列表", value = "#query", level = LogLevel.TRACE)
    public MarketOrderFindIdsRespQTransfer findIdsByItemId(MarketOrderFindByItemIdReqQTransfer query) {
        Optional.ofNullable(query)
                .map(MarketOrderFindByItemIdReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("市场订单根据资源项ID查询ID列表参数不能为空"));
        return MarketOrderFindIdsRespQTransfer.builder()
                .marketOrderIds(Optional.ofNullable(marketOrderQueryRepository.findIdsByItemId(query.getItemId()))
                        .filter(l -> !CollectionUtils.isEmpty(l))
                        .orElse(null))
                .build().validate();
    }
}
