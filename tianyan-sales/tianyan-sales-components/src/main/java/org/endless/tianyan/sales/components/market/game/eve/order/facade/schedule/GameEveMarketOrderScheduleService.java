package org.endless.tianyan.sales.components.market.game.eve.order.facade.schedule;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.handler.GameEveMarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.game.eve.order.facade.schedule.task.GameEveMarketOrderScheduleTask;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveMarketOrderScheduleService
 * <p>
 * create 2025/07/27 22:50
 * <p>
 * update 2025/07/27 22:50
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Slf4j
@Service
public class GameEveMarketOrderScheduleService {

    private final GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler;

    private final GameEveMarketOrderScheduleTask gameEveMarketOrderScheduleTask;

    public GameEveMarketOrderScheduleService(GameEveMarketOrderQueryHandler gameEveMarketOrderQueryHandler, GameEveMarketOrderScheduleTask gameEveMarketOrderScheduleTask) {
        this.gameEveMarketOrderQueryHandler = gameEveMarketOrderQueryHandler;
        this.gameEveMarketOrderScheduleTask = gameEveMarketOrderScheduleTask;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        fetch();
    }


    // @Scheduled(cron = "0 * */1 * * ?")
    @Log(message = "市场订单获取任务", level = LogLevel.INFO)
    public void fetch() {
        log.info("市场订单获取任务开始执行");
        try {
            List<String> codes = gameEveMarketOrderQueryHandler.fetchCodes()
                    .validate().itemIds();
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            codes.forEach(code -> {
                try {
                    // 收集 CompletableFuture
                    CompletableFuture<Void> future = gameEveMarketOrderScheduleTask.execute(code)
                            .exceptionally(e -> {
                                log.error("市场订单获取任务执行失败, 资源项编码: {}, 错误信息: {}", code, e.getMessage());
                                return null;
                            });
                    futures.add(future);
                    if (futures.size() >= 10) {
                        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
                        futures.clear();
                    }
                } catch (Exception e) {
                    log.error("市场订单获取任务并发失败, 资源项编码: {}, 错误信息: {}", code, e.getMessage());
                    throw e;
                }
            });
            if (!futures.isEmpty()) {
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            }
            log.info("市场订单获取任务执行完成");
        } catch (Exception e) {
            log.error("市场订单获取任务执行失败, 错误信息: {}", e.getMessage(), e);
        }
    }
}
