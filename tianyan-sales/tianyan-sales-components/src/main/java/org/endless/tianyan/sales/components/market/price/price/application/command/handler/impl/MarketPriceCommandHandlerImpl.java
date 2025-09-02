package org.endless.tianyan.sales.components.market.price.price.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.sales.components.market.price.price.application.command.handler.MarketPriceCommandHandler;
import org.endless.tianyan.sales.components.market.price.price.application.command.transfer.MarketPriceCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.price.price.domain.anticorruption.MarketPriceRepository;
import org.endless.tianyan.sales.components.market.price.price.domain.entity.MarketPriceAggregate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * MarketPriceCommandHandlerImpl
 * <p>市场价格领域命令处理器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see MarketPriceCommandHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class MarketPriceCommandHandlerImpl implements MarketPriceCommandHandler {

    /**
     * 市场价格聚合仓储接口
     */
    private final MarketPriceRepository marketPriceRepository;

    public MarketPriceCommandHandlerImpl(MarketPriceRepository marketPriceRepository) {
        this.marketPriceRepository = marketPriceRepository;
    }

    @Override
    @Transactional
    @Log(message = "市场价格创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(MarketPriceCreateCReqTransfer command) {
        Optional.ofNullable(command)
                .map(MarketPriceCreateCReqTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场价格创建命令参数不能为空"));
        MarketPriceAggregate aggregate = MarketPriceAggregate.create(MarketPriceAggregate.builder()
                .itemId(command.itemId())
                .buyPrice(DecimalTools.format(command.buyPrice()))
                .sellPrice(DecimalTools.format(command.sellPrice()))
                .createUserId(command.createUserId()));
        marketPriceRepository.save(aggregate);
    }
}
