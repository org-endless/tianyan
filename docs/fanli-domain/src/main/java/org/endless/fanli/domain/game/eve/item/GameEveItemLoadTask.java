package org.endless.erp.game.eve.item;

import lombok.extern.slf4j.Slf4j;
import org.endless.erp.game.eve.share.thread.GameEveAsyncTask;
import org.endless.fanli.common.type.ddd.item.Item;
import org.endless.spring.boot.com.utiliy.date.DateFormatter;
import org.endless.spring.boot.com.utiliy.decimal.DecimalTools;
import org.endless.spring.boot.com.utiliy.object.ObjectToMongoObject;
import org.endless.spring.boot.data.mongo.bulk.MongoBulkOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.endless.fanli.common.type.ddd.industry.Industry.GAME_EVE;

/**
 * GameEveItemLoadTask
 * <p>游戏EVE资源项/商品数据文件加载异步任务
 * <p>Game EVE item data load loading asynchronous task.
 * <p>
 * <p>create 2023/05/11 11:05
 * <p>update 2023/05/27 19:50
 *
 * @author Deng Haozhi
 * @see GameEveAsyncTask
 * @since 0.0.3
 */
@Slf4j
@Component("gameEveItemLoadTask")
public class GameEveItemLoadTask implements GameEveAsyncTask {

    private final MongoBulkOperations mongoBulkOperations;

    public GameEveItemLoadTask(MongoBulkOperations mongoBulkOperations) {
        this.mongoBulkOperations = mongoBulkOperations;
    }

    /**
     * 运行游戏EVE资源项/商品数据文件加载异步任务
     * <p>Run the game EVE item data load loading asynchronous task.
     *
     * @param scannerMaps 文件扫描结果 (File scan results)
     */
    @Override
    public <T> void run(T scannerMaps) {
        Boolean.valueOf(true);

        log.debug("Thread: " + Thread.currentThread().getName() + " load executing");

        List<Pair<Query, Update>> pairs = new ArrayList<>();

        ((List<?>) scannerMaps).forEach(scannerMap -> {
            var scanner = String.valueOf(((Map<?, ?>) scannerMap).get("scanner"));
            var itemId = String.valueOf(((Map<?, ?>) scannerMap).get("itemId"));
            var rat = (Map<?, ?>) ObjectToMongoObject.convert(new Yaml().load(scanner));

            var id = Item.getId(GAME_EVE, itemId);
            var query = Query.query(Criteria.where("id").is(id));
            var update = Update
                    .update("itemId", itemId)
                    .set("industryId", GAME_EVE)
                    .set("name.enName.fullName", ((Map<?, ?>) rat.get("name")).get("en"))
                    .set("name.zhName.fullName", ((Map<?, ?>) rat.get("name")).get("zh"))
                    .set("price.basePrice", DecimalTools.format(rat.get("basePrice")))
                    .set("mass", DecimalTools.format(rat.get("mass")))
                    .set("volume", DecimalTools.format(rat.get("volume")))
                    .set("published", rat.get("published"))
                    .set("eveGroupId", rat.get("groupID"))
                    .set("eveMarketGroupId", rat.get("marketGroupID"))
                    .set("eveMetaGroupId", rat.get("metaGroupID"))
                    .set("updateDateTime", DateFormatter.nowIso())
                    .set("updateTimeStamp", System.currentTimeMillis());
            pairs.add(Pair.of(query, update));
        });

        log.trace(pairs.toString());
        mongoBulkOperations.upsert(pairs, org.endless.erp.game.eve.item.GameEveItem.class);

        log.info("Thread: " + Thread.currentThread().getName() + " load executed completely!");
    }
}
