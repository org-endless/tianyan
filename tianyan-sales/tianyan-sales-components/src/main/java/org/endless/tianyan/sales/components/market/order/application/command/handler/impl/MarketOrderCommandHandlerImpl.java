package org.endless.tianyan.sales.components.market.order.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.config.endless.properties.EndlessProperties;
import org.endless.ddd.starter.common.exception.ddd.application.command.handler.CommandNotFoundException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.ddd.starter.common.utils.model.time.TimestampTools;
import org.endless.tianyan.sales.components.market.order.application.command.handler.MarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.application.command.transfer.*;
import org.endless.tianyan.sales.components.market.order.domain.anticorruption.MarketOrderPriceDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.order.domain.value.MarketOrderItemQuantityValue;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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
@Lazy
@Service
@Validated
public class MarketOrderCommandHandlerImpl implements MarketOrderCommandHandler {

    /**
     * 市场订单聚合仓储接口
     */
    private final MarketOrderRepository marketOrderRepository;

    /**
     * 市场价格被动适配器接口
     */
    private final MarketOrderPriceDrivenAdapter marketOrderPriceDrivenAdapter;

    /**
     * 日期时间格式
     */
    private final String dateTimePattern;

    public MarketOrderCommandHandlerImpl(MarketOrderRepository marketOrderRepository, MarketOrderPriceDrivenAdapter marketOrderPriceDrivenAdapter, EndlessProperties properties) {
        this.marketOrderRepository = marketOrderRepository;
        this.marketOrderPriceDrivenAdapter = marketOrderPriceDrivenAdapter;
        this.dateTimePattern = properties.getDateTimePattern();
    }

    @Override
    @Transactional
    @Log(message = "市场订单创建命令", value = "#command", level = LogLevel.TRACE)
    public MarketOrderCreateCRespTransfer create(MarketOrderCreateCReqTransfer command) {
        MarketOrderAggregate aggregate = MarketOrderAggregate.create(MarketOrderAggregate.builder()
                .itemId(command.itemId())
                .type(MarketOrderTypeEnum.fromCode(command.type()))
                .itemQuantity(MarketOrderItemQuantityValue.create(MarketOrderItemQuantityValue.builder()
                        .total(DecimalTools.format5Bit(command.totalItemQuantity()))
                        .remain(DecimalTools.format5Bit(command.remainItemQuantity()))
                        .min(DecimalTools.format5Bit(command.minItemQuantity()))))
                .price(DecimalTools.format(command.price()))
                .issuedAt(TimestampTools.from(command.issuedAt(), dateTimePattern))
                .expireAt(TimestampTools.from(command.expireAt(), dateTimePattern))
                .createUserId(command.createUserId()));
        marketOrderRepository.save(aggregate);
        return MarketOrderCreateCRespTransfer.builder()
                .marketOrderId(aggregate.getMarketOrderId())
                .build().validate();
    }

    @Override
    @Transactional
    @Log(message = "市场订单删除命令", value = "#command", level = LogLevel.TRACE)
    public void remove(MarketOrderRemoveCReqTransfer command) {
        MarketOrderAggregate aggregate = marketOrderRepository.findById(command.marketOrderId())
                .orElseThrow(() -> new CommandNotFoundException("未找到对应的市场订单聚合"));
        marketOrderRepository.remove(aggregate.remove(command.modifyUserId()));
    }

    @Override
    @Transactional
    @Log(message = "市场订单修改命令", value = "#command", level = LogLevel.TRACE)
    public void modify(MarketOrderModifyCReqTransfer command) {
        MarketOrderAggregate aggregate = marketOrderRepository.findById(command.marketOrderId())
                .orElseThrow(() -> new CommandNotFoundException("未找到对应的市场订单聚合"));
        aggregate.modify(MarketOrderAggregate.builder()
                .itemQuantity(MarketOrderItemQuantityValue.create(MarketOrderItemQuantityValue.builder()
                        .total(DecimalTools.format5Bit(command.totalItemQuantity()))
                        .remain(DecimalTools.format5Bit(command.remainItemQuantity()))
                        .min(DecimalTools.format5Bit(command.minItemQuantity()))))
                .price(DecimalTools.format(command.price()))
                .expireAt(TimestampTools.from(command.expireAt(), dateTimePattern))
                .modifyUserId(command.modifyUserId()));
        marketOrderRepository.modify(aggregate);
    }

    @Override
    @Transactional
    @Log(message = "市场订单生成价格命令", value = "#command", level = LogLevel.TRACE)
    public void generatePrice(MarketOrderGeneratePriceCReqTransfer command) {
        List<MarketOrderAggregate> aggregates = marketOrderRepository.findAllByItemId(command.itemId());
        marketOrderPriceDrivenAdapter.generatePrice(aggregates, command.itemId(), command.createUserId());
    }
}
