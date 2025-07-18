package org.endless.erp.game.eve.market.order;

import lombok.extern.slf4j.Slf4j;
import org.endless.erp.game.eve.share.thread.GameEveAsyncTask;
import org.endless.fanli.common.type.ddd.industry.Industry;
import org.endless.fanli.common.type.ddd.order.Order;
import org.endless.spring.boot.com.utiliy.date.DateFormatter;
import org.endless.spring.boot.com.utiliy.decimal.Decimal;
import org.endless.spring.boot.com.utiliy.object.ObjectToMongoObject;
import org.endless.spring.boot.data.mongo.bulk.MongoBulkOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GameEveMarketOrderSaveTask
 *
 * <p>create 2023/05/25 21:45
 *
 * @author Deng Haozhi
 * @see GameEveAsyncTask
 * @since 0.0.3
 */
@Slf4j
@Component("gameEveMarketOrderLoadTask")
public class GameEveMarketOrderSaveTask implements GameEveAsyncTask {

    private final org.endless.erp.game.eve.market.order.GameEveMarketOrderAdapter marketOrderAdapter;

    private final MongoBulkOperations bulkRepository;

    public GameEveMarketOrderSaveTask(org.endless.erp.game.eve.market.order.GameEveMarketOrderAdapter marketOrderAdapter, MongoBulkOperations bulkRepository) {
        this.marketOrderAdapter = marketOrderAdapter;
        this.bulkRepository = bulkRepository;
    }


    @Override
    public <T> void run(T page) {

        long begin = System.currentTimeMillis();
        log.debug("Thread: " + Thread.currentThread().getName() + " loading begin: " + begin);

        var orderList = marketOrderAdapter.getOrders(Integer.parseInt(String.valueOf(page)));

        if (CollectionUtils.isEmpty(orderList)) {
            log.error("Get NOTHING from the page " + page);
            return;
        }

        List<Pair<Query, Update>> pairs = new ArrayList<>();

        orderList.forEach(order -> {

            var rat = (Map<?, ?>) ObjectToMongoObject.convert(order);
            var orderId = String.valueOf(rat.get("order_id"));
            var id = Industry.GAME_EVE + "_" + orderId;

            var query = Query.query(Criteria.where("id").is(id));
            var update = Update.update("orderId", orderId)
                    .set("industryId", Industry.GAME_EVE)
                    .set("itemId", rat.get("type_id"))
                    .set("categories", ((Boolean) rat.get("is_buy_order")) ? Order.Categories.purchase : Order.Categories.sale)
                    .set("minPurchaseQuantity", Decimal.format(rat.get("min_volume")))
                    .set("remainQuantity", Decimal.format(rat.get("volume_remain")))
                    .set("totalQuantity", Decimal.format(rat.get("volume_total")))
                    .set("orderPrice", Decimal.format(rat.get("price")))
                    .set("existed", true)
                    .set("updateDateTime", DateFormatter.nowIso())
                    .set("updateTimeStamp", System.currentTimeMillis());

            pairs.add(Pair.of(query, update));
        });
        bulkRepository.upsert(pairs, org.endless.erp.game.eve.market.order.GameEveMarketOrder.class);

        long end = System.currentTimeMillis();
        log.debug("Thread: " + Thread.currentThread().getName() + " loading end: " + end);
        log.info("Thread: " + Thread.currentThread().getName() + " loaded completed!");
    }
}
