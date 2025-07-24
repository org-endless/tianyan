package org.endless.tianyan.sales.components.market.group.application.query.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.handler.QueryHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.sales.components.market.group.application.query.anticorruption.MarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.application.query.handler.MarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.group.application.query.transfer.MarketGroupFindByIdReqQTransfer;

import java.util.Optional;

/**
 * MarketGroupQueryHandlerImpl
 * <p>市场分组领域查询处理器
 * <p>
 * create 2025/07/22 16:05
 * <p>
 * update 2025/07/22 16:05
 *
 * @author Deng Haozhi
 * @see MarketGroupQueryHandler
 * @since 0.0.1
 */
public class MarketGroupQueryHandlerImpl implements MarketGroupQueryHandler {

    /**
     * 市场分组聚合查询仓储接口
     */
    private final MarketGroupQueryRepository marketGroupQueryRepository;

    public MarketGroupQueryHandlerImpl(MarketGroupQueryRepository marketGroupQueryRepository) {
        this.marketGroupQueryRepository = marketGroupQueryRepository;
    }

    @Override
    @Log(message = "市场分组根据ID查询是否存在", value = "#command", level = LogLevel.TRACE)
    public void existsById(MarketGroupFindByIdReqQTransfer query) {
        Optional.ofNullable(query)
                .map(MarketGroupFindByIdReqQTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("市场分组根据ID查询是否存在是否存在参数不能为空"));
        if (!marketGroupQueryRepository.existsById(query.getMarketGroupId())) {
            throw new QueryHandlerNotFoundException("不存在该分组");
        }
    }
}
