package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item;

import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * GameEveDataItemLoadTask
 * <p>
 * create 2025/07/20 21:36
 * <p>
 * update 2025/07/20 21:50
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 2.0.0
 */
@Lazy
@Component
public class GameEveDataItemLoadTask implements GameEveDataLoadTask {


    @Override
    public void execute(Map<String, Object> dataMap) {

    }

    @Override
    public String getFilePath() {
        return "data/game/eve/typeIDs.yaml";
    }


}
