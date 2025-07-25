package org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.endless.EndlessAutoConfiguration;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.handler.CommandHandlerNotFoundException;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.ddd.simplified.starter.common.utils.model.time.TimeStamp;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.MarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderCreateRespCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderModifyReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.MarketOrderRemoveReqCTransfer;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.order.market.order.domain.value.MarketOrderQuantityValue;

import java.util.Optional;

/**
 * MarketOrderCommandHandlerImpl
 * <p>市场订单领域命令处理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderCommandHandler
 * @since 0.0.1
 */
public class MarketOrderCommandHandlerImpl implements MarketOrderCommandHandler {

    /**
     * 市场订单聚合仓储接口
     */
    private final MarketOrderRepository marketOrderRepository;

    private final String dateTimePattern;

    public MarketOrderCommandHandlerImpl(MarketOrderRepository marketOrderRepository, EndlessAutoConfiguration configuration) {
        this.marketOrderRepository = marketOrderRepository;
        this.dateTimePattern = configuration.dateTimePattern();
    }

    @Override
    @Log(message = "市场订单创建命令", value = "#command", level = LogLevel.TRACE)
    public MarketOrderCreateRespCTransfer create(MarketOrderCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单创建命令参数不能为空"));
        MarketOrderAggregate aggregate = MarketOrderAggregate.create(MarketOrderAggregate.builder()
                .type(MarketOrderTypeEnum.fromCode(command.getType()))
                .quantity(MarketOrderQuantityValue.create(MarketOrderQuantityValue.builder()
                        .total(Decimal.format5Bit(command.getTotalQuantity()))
                        .remain(Decimal.format5Bit(command.getRemainQuantity()))
                        .min(Decimal.format5Bit(command.getMinQuantity()))))
                .price(Decimal.format(command.getPrice()))
                .issuedAt(TimeStamp.from(command.getIssuedAt(), dateTimePattern))
                .expireAt(TimeStamp.from(command.getExpireAt(), dateTimePattern))
                .createUserId(command.getCreateUserId()));
        marketOrderRepository.save(aggregate);
        return MarketOrderCreateRespCTransfer.builder()
                .marketOrderId(aggregate.getMarketOrderId())
                .build().validate();
    }

    @Override
    @Log(message = "市场订单修改命令", value = "#command", level = LogLevel.TRACE)
    public void modify(MarketOrderModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单修改命令参数不能为空"));
        MarketOrderAggregate aggregate = marketOrderRepository.findById(command.getMarketOrderId())
                .orElseThrow(() -> new CommandHandlerNotFoundException("未找到对应的市场订单聚合"));
        aggregate.modify(MarketOrderAggregate.builder()
                .quantity(MarketOrderQuantityValue.create(MarketOrderQuantityValue.builder()
                        .total(Decimal.format5Bit(command.getTotalQuantity()))
                        .remain(Decimal.format5Bit(command.getRemainQuantity()))
                        .min(Decimal.format5Bit(command.getMinQuantity()))))
                .price(Decimal.format(command.getPrice()))
                .issuedAt(TimeStamp.from(command.getIssuedAt(), dateTimePattern))
                .expireAt(TimeStamp.from(command.getExpireAt(), dateTimePattern))
                .modifyUserId(command.getModifyUserId()));
        marketOrderRepository.modify(aggregate);
    }

    @Override
    @Log(message = "市场订单删除命令", value = "#command", level = LogLevel.TRACE)
    public void remove(MarketOrderRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单删除命令参数不能为空"));
        MarketOrderAggregate aggregate = marketOrderRepository.findById(command.getMarketOrderId())
                .orElseThrow(() -> new CommandHandlerNotFoundException("未找到对应的市场订单聚合"));
        marketOrderRepository.remove(aggregate.remove(command.getModifyUserId()));
    }
}
