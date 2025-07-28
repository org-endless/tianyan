package org.endless.tianyan.sales.components.market.order.game.eve.sidecar.schedule.task.impl;

import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderFetchReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer.GameEveMarketOrderGeneratePriceReqCTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.GameEveMarketOrderDrivingAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.sidecar.schedule.task.GameEveMarketOrderScheduleTask;
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
@Lazy
@Component
public class GameEveMarketOrderScheduleTaskImpl implements GameEveMarketOrderScheduleTask {

    private final GameEveMarketOrderDrivingAdapter gameEveMarketOrderDrivingAdapter;

    public GameEveMarketOrderScheduleTaskImpl(GameEveMarketOrderDrivingAdapter gameEveMarketOrderDrivingAdapter) {
        this.gameEveMarketOrderDrivingAdapter = gameEveMarketOrderDrivingAdapter;
    }

    @Override
    public CompletableFuture<Void> execute(String gameEveItemCode) {
        return CompletableFuture.runAsync(() -> {
            gameEveMarketOrderDrivingAdapter.fetch(GameEveMarketOrderFetchReqCTransfer.builder()
                    .gameEveItemCode(gameEveItemCode)
                    .createUserId(TIANYAN_SALES_USER_ID)
                    .build().validate());
            gameEveMarketOrderDrivingAdapter.generatePrice(GameEveMarketOrderGeneratePriceReqCTransfer.builder()
                    .gameEveItemCode(gameEveItemCode)
                    .createUserId(TIANYAN_SALES_USER_ID)
                    .build().validate());
        });
    }
}
