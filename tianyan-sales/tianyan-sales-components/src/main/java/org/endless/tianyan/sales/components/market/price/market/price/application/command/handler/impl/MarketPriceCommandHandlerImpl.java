package org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.sales.components.market.price.market.price.application.command.handler.MarketPriceCommandHandler;
import org.endless.tianyan.sales.components.market.price.market.price.application.command.transfer.MarketPriceCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.price.market.price.domain.anticorruption.MarketPriceRepository;
import org.endless.tianyan.sales.components.market.price.market.price.domain.entity.MarketPriceAggregate;
import org.springframework.transaction.annotation.Transactional;

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
    public void create(MarketPriceCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(MarketPriceCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("市场价格创建命令参数不能为空"));
        MarketPriceAggregate aggregate = MarketPriceAggregate.create(MarketPriceAggregate.builder()
                .itemId(command.getItemId())
                .buyPrice(DecimalTools.format(command.getBuyPrice()))
                .sellPrice(DecimalTools.format(command.getSellPrice()))
                .createUserId(command.getCreateUserId()));
        marketPriceRepository.save(aggregate);
    }
}
