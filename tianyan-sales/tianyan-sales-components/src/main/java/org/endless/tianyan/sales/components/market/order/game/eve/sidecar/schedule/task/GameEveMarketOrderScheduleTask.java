package org.endless.tianyan.sales.components.market.order.game.eve.sidecar.schedule.task;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

/**
 * GameEveMarketOrderScheduleTask
 * <p>
 * create 2025/07/28 07:17
 * <p>
 * update 2025/07/28 07:17
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface GameEveMarketOrderScheduleTask {

    @Async("virtualThreadExecutor")
    CompletableFuture<Void> execute(String gameEveItemCode);
}
