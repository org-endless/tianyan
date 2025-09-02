package org.endless.tianyan.sales.components.market.group.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.tianyan.sales.components.market.group.application.query.anticorruption.MarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.application.query.handler.MarketGroupQueryHandler;
import org.endless.tianyan.sales.components.market.group.application.query.transfer.MarketGroupFindByIdReqQReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * MarketGroupQueryHandlerImpl
 * <p>市场分组领域查询处理器
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see MarketGroupQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
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
    public void existsById(MarketGroupFindByIdReqQReqTransfer query) {
        if (!marketGroupQueryRepository.existsById(query.marketGroupId())) {
            throw new QueryNotFoundException("不存在该分组");
        }
    }
}
