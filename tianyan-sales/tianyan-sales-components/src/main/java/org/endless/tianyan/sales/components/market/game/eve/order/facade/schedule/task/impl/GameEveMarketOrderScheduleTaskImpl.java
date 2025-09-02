package org.endless.tianyan.sales.components.market.game.eve.order.facade.schedule.task.impl;

import lombok.extern.slf4j.Slf4j;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.handler.GameEveMarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderFetchCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.application.command.transfer.GameEveMarketOrderGeneratePriceCReqTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.facade.schedule.task.GameEveMarketOrderScheduleTask;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

import static org.endless.tianyan.sales.common.model.application.command.handler.TianyanSalesCommandHandler.TIANYAN_SALES_USER_ID;

/**
 * GameEveMarketOrderScheduleTaskImpl
 * <p>
 * create 2025/07/28 07:18
 * <p>
 * update 2025/07/28 07:18
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class GameEveMarketOrderScheduleTaskImpl implements GameEveMarketOrderScheduleTask {

    private final GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler;

    public GameEveMarketOrderScheduleTaskImpl(GameEveMarketOrderCommandHandler gameEveMarketOrderCommandHandler) {
        this.gameEveMarketOrderCommandHandler = gameEveMarketOrderCommandHandler;
    }


    @Override
    public CompletableFuture<Void> execute(String gameEveItemCode) {
        try {
            gameEveMarketOrderCommandHandler.fetch(
                    GameEveMarketOrderFetchCReqTransfer.builder()
                            .gameEveItemCode(gameEveItemCode)
                            .createUserId(TIANYAN_SALES_USER_ID)
                            .build().validate()
            );
            gameEveMarketOrderCommandHandler.generatePrice(
                    GameEveMarketOrderGeneratePriceCReqTransfer.builder()
                            .gameEveItemCode(gameEveItemCode)
                            .createUserId(TIANYAN_SALES_USER_ID)
                            .build().validate()
            );
            return CompletableFuture.completedFuture(null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return CompletableFuture.failedFuture(e);
        }
    }
}
