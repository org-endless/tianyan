package org.endless.tianyan.sales.components.market.group.market.group.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.sales.components.market.group.market.group.application.command.handler.MarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.market.group.application.command.transfer.MarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.market.group.application.command.transfer.MarketGroupCreateRespCTransfer;
import org.endless.tianyan.sales.components.market.group.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.market.group.domain.value.NameValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * MarketGroupCommandHandlerImpl
 * <p>市场分组领域命令处理器
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see MarketGroupCommandHandler
 * @since 0.0.1
 */
public class MarketGroupCommandHandlerImpl implements MarketGroupCommandHandler {

    /**
     * 市场分组聚合仓储接口
     */
    private final MarketGroupRepository marketGroupRepository;

    public MarketGroupCommandHandlerImpl(MarketGroupRepository marketGroupRepository) {
        this.marketGroupRepository = marketGroupRepository;
    }

    @Override
    @Transactional
    @Log(message = "市场分组创建命令", value = "#command", level = LogLevel.TRACE)
    public MarketGroupCreateRespCTransfer create(MarketGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场分组创建命令参数不能为空"));
        MarketGroupAggregate aggregate = MarketGroupAggregate.create(MarketGroupAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.getFullNameEn())))
                .parentId(command.getParentId())
                .createUserId(command.getCreateUserId()));
        marketGroupRepository.save(aggregate);
        return MarketGroupCreateRespCTransfer.builder()
                .marketGroupId(aggregate.getMarketGroupId())
                .build().validate();
    }
}
