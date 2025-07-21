package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task;

import org.endless.tianyan.metadata.common.model.domain.anticorruption.TianyanMetadataDrivenAdapter;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;

/**
 * GameEveDataLoadTask
 * <p>
 * create 2025/07/20 21:33
 * <p>
 * update 2025/07/20 21:34
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenAdapter
 * @since 2.0.0
 */
public interface GameEveDataLoadTask extends TianyanMetadataDrivenAdapter {

    @Async("virtualThreadExecutor")
    void execute(Map<String, Object> dataMap);

    String getFilePath();
}
