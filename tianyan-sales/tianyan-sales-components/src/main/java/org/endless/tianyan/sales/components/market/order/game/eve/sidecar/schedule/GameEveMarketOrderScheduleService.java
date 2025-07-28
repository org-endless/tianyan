package org.endless.tianyan.sales.components.market.order.game.eve.sidecar.schedule;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.tianyan.sales.components.market.order.game.eve.facade.adapter.GameEveMarketOrderDrivingAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.sidecar.schedule.task.GameEveMarketOrderScheduleTask;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
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

    private final GameEveMarketOrderDrivingAdapter gameEveMarketOrderDrivingAdapter;

    private final GameEveMarketOrderScheduleTask gameEveMarketOrderScheduleTask;


    public GameEveMarketOrderScheduleService(GameEveMarketOrderDrivingAdapter gameEveMarketOrderDrivingAdapter, GameEveMarketOrderScheduleTask gameEveMarketOrderScheduleTask) {
        this.gameEveMarketOrderDrivingAdapter = gameEveMarketOrderDrivingAdapter;
        this.gameEveMarketOrderScheduleTask = gameEveMarketOrderScheduleTask;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        fetch();
    }


    @Scheduled(cron = "0 * */1 * * ?")
    @Log(message = "市场订单获取任务", level = LogLevel.INFO)
    public void fetch() {
        try {
            List<String> codes = gameEveMarketOrderDrivingAdapter.fetchCodes()
                    .validate().getItemIds();
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            codes.forEach(code -> {
                try {
                    gameEveMarketOrderScheduleTask.execute(code);
                    if (futures.size() >= 10) {
                        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
                        futures.clear();
                    }
                } catch (Exception e) {
                    log.error("市场订单获取任务执行失败, 资源项编码: {}, 错误信息: {}", code, e.getMessage());
                    throw e;
                }
            });
            if (!futures.isEmpty()) {
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            }
        } catch (Exception e) {
            log.error("市场订单获取任务执行失败, 错误信息: {}", e.getMessage(), e);
        }
    }
}
