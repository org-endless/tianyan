package org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.ddd.starter.common.utils.model.time.TimeStampTools;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.handler.MarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderPriceDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.order.market.order.domain.value.MarketOrderItemQuantityValue;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    /**
     * 市场价格被动适配器接口
     */
    private final MarketOrderPriceDrivenAdapter marketOrderPriceDrivenAdapter;

    private final String dateTimePattern;

    public MarketOrderCommandHandlerImpl(MarketOrderRepository marketOrderRepository, MarketOrderPriceDrivenAdapter marketOrderPriceDrivenAdapter, EndlessProperties properties) {
        this.marketOrderRepository = marketOrderRepository;
        this.marketOrderPriceDrivenAdapter = marketOrderPriceDrivenAdapter;
        this.dateTimePattern = properties.getDateTimePattern();
    }

    @Override
    @Transactional
    @Log(message = "市场订单创建命令", value = "#command", level = LogLevel.TRACE)
    public MarketOrderCreateRespCTransfer create(MarketOrderCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单创建命令参数不能为空"));
        MarketOrderAggregate aggregate = MarketOrderAggregate.create(MarketOrderAggregate.builder()
                .itemId(command.getItemId())
                .type(MarketOrderTypeEnum.fromCode(command.getType()))
                .itemQuantity(MarketOrderItemQuantityValue.create(MarketOrderItemQuantityValue.builder()
                        .total(DecimalTools.format5Bit(command.getTotalItemQuantity()))
                        .remain(DecimalTools.format5Bit(command.getRemainItemQuantity()))
                        .min(DecimalTools.format5Bit(command.getMinItemQuantity()))))
                .price(DecimalTools.format(command.getPrice()))
                .issuedAt(TimeStampTools.from(command.getIssuedAt(), dateTimePattern))
                .expireAt(TimeStampTools.from(command.getExpireAt(), dateTimePattern))
                .createUserId(command.getCreateUserId()));
        marketOrderRepository.save(aggregate);
        return MarketOrderCreateRespCTransfer.builder()
                .marketOrderId(aggregate.getMarketOrderId())
                .build().validate();
    }

    @Override
    @Transactional
    @Log(message = "市场订单修改命令", value = "#command", level = LogLevel.TRACE)
    public void modify(MarketOrderModifyReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderModifyReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单修改命令参数不能为空"));
        MarketOrderAggregate aggregate = marketOrderRepository.findById(command.getMarketOrderId())
                .orElseThrow(() -> new CommandNotFoundException("未找到对应的市场订单聚合"));
        aggregate.modify(MarketOrderAggregate.builder()
                .itemQuantity(MarketOrderItemQuantityValue.create(MarketOrderItemQuantityValue.builder()
                        .total(DecimalTools.format5Bit(command.getTotalItemQuantity()))
                        .remain(DecimalTools.format5Bit(command.getRemainItemQuantity()))
                        .min(DecimalTools.format5Bit(command.getMinItemQuantity()))))
                .price(DecimalTools.format(command.getPrice()))
                .issuedAt(TimeStampTools.from(command.getIssuedAt(), dateTimePattern))
                .expireAt(TimeStampTools.from(command.getExpireAt(), dateTimePattern))
                .modifyUserId(command.getModifyUserId()));
        marketOrderRepository.modify(aggregate);
    }

    @Override
    @Transactional
    @Log(message = "市场订单删除命令", value = "#command", level = LogLevel.TRACE)
    public void remove(MarketOrderRemoveReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderRemoveReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单删除命令参数不能为空"));
        MarketOrderAggregate aggregate = marketOrderRepository.findById(command.getMarketOrderId())
                .orElseThrow(() -> new CommandNotFoundException("未找到对应的市场订单聚合"));
        marketOrderRepository.remove(aggregate.remove(command.getModifyUserId()));
    }

    @Override
    @Transactional
    @Log(message = "市场订单生成价格命令", value = "#command", level = LogLevel.TRACE)
    public void generatePrice(MarketOrderGeneratePriceReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketOrderGeneratePriceReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场订单生成价格命令参数不能为空"));
        List<MarketOrderAggregate> aggregates = marketOrderRepository.findAllByItemId(command.getItemId());
        marketOrderPriceDrivenAdapter.generatePrice(aggregates, command.getItemId(), command.getCreateUserId());
    }
}
