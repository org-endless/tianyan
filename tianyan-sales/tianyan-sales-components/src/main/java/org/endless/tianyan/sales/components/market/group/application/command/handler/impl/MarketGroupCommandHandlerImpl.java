package org.endless.tianyan.sales.components.market.group.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.tianyan.sales.components.market.group.application.command.handler.MarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateCRespTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupModifyParentCReqTransfer;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.domain.value.NameValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

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
@Lazy
@Service
@Validated
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
    public MarketGroupCreateCRespTransfer create(MarketGroupCreateCReqTransfer command) {
        MarketGroupAggregate aggregate = MarketGroupAggregate.create(MarketGroupAggregate.builder()
                .nameZh(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameZh())))
                .nameEn(NameValue.create(NameValue.builder()
                        .fullName(command.fullNameEn())))
                .parentId(command.parentId())
                .createUserId(command.createUserId()));
        marketGroupRepository.save(aggregate);
        return MarketGroupCreateCRespTransfer.builder()
                .marketGroupId(aggregate.getMarketGroupId())
                .build().validate();
    }

    @Override
    @Log(message = "市场分组修改父分组命令", value = "#command", level = LogLevel.TRACE)
    public void modifyParent(MarketGroupModifyParentCReqTransfer command) {
        MarketGroupAggregate aggregate = marketGroupRepository.findById(command.marketGroupId())
                .orElseThrow(() -> new CommandNotFoundException("市场分组不存在"));
        marketGroupRepository.modify(aggregate.modifyParent(command.parentId(), command.modifyUserId()));
    }
}
