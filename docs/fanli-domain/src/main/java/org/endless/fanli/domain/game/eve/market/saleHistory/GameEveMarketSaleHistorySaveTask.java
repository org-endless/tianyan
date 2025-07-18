package org.endless.erp.game.eve.market.saleHistory;

import lombok.extern.log4j.Log4j2;
import org.endless.erp.game.eve.item.GameEveItem;
import org.endless.erp.game.eve.share.thread.GameEveAsyncTask;
import org.endless.fanli.common.type.ddd.industry.Industry;
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
 * GameEveMarketSaleHistorySaveTask
 * <p>
 * <p>
 *
 * <p>create 2023/5/26 17:21
 *
 * @author Deng Haozhi
 * @since 0.0.3
 */
@Log4j2
@Component("gameEveMarketSaleHistoryTask")
public class GameEveMarketSaleHistorySaveTask implements GameEveAsyncTask {

    private final org.endless.erp.game.eve.market.saleHistory.GameEveMarketSaleHistoryAdapter marketSaleHistoryAdapter;

    private final MongoBulkOperations bulkRepository;

    public GameEveMarketSaleHistorySaveTask(org.endless.erp.game.eve.market.saleHistory.GameEveMarketSaleHistoryAdapter marketSaleHistoryAdapter, MongoBulkOperations bulkRepository) {
        this.marketSaleHistoryAdapter = marketSaleHistoryAdapter;
        this.bulkRepository = bulkRepository;
    }


    @Override
    public <T> void run(T items) {

        log.debug("Thread: " + Thread.currentThread().getName() + " save executing");

        if (CollectionUtils.isEmpty((List<?>) items)) {
            log.error("This page has no itemIds!");
            return;
        }
        ((List<?>) items).forEach(item -> {
            var itemId = ((GameEveItem) item).getItemId();
            var historyList = marketSaleHistoryAdapter.getHistory(itemId);
            if (CollectionUtils.isEmpty(historyList)) {
                log.debug("The itemId: " + itemId + " get no data from ESI!");
                return;
            }
            List<Pair<Query, Update>> pairs = new ArrayList<>();

            historyList.forEach(history -> {
                var rat = (Map<?, ?>) ObjectToMongoObject.convert(history);
                var date = rat.get("date");
                var id = Industry.GAME_EVE + "_" + date + "_" + itemId;
                var minPrice = Decimal.format(rat.get("lowest"));
                var maxPrice = Decimal.format(rat.get("highest"));
                var averagePrice = Decimal.average(List.of(minPrice, maxPrice));

                var query = Query.query(Criteria.where("id").is(id));
                var update = Update.update("itemId", itemId)
                        .set("industryId", Industry.GAME_EVE)
                        .set("date", date)
                        .set("price.minPrice", minPrice)
                        .set("price.maxPrice", maxPrice)
                        .set("price.averagePrice", averagePrice)
                        .set("totalQuantity", Decimal.format(rat.get("volume")))
                        .set("orderQuantity", Decimal.format(rat.get("order_count")))
                        .set("updateDateTime", DateFormatter.nowIso())
                        .set("updateTimeStamp", System.currentTimeMillis());
                pairs.add(Pair.of(query, update));
            });
            bulkRepository.upsert(pairs, org.endless.erp.game.eve.market.saleHistory.GameEveMarketSaleHistory.class);
        });
        log.info("Thread: " + Thread.currentThread().getName() + " save executed completely!");
    }
}
