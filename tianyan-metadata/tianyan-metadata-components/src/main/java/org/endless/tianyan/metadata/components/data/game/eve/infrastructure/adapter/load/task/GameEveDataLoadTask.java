package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task;

import jakarta.validation.constraints.NotEmpty;
import org.endless.tianyan.metadata.common.model.domain.anticorruption.TianyanMetadataDrivenAdapter;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataLoadTask
 * <p>
 * create 2025/07/20 21:33
 * <p>
 * update 2025/07/20 21:34
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenAdapter
 * @since 0.0.1
 */
public interface GameEveDataLoadTask extends TianyanMetadataDrivenAdapter {

    @Async("virtualThreadExecutor")
    CompletableFuture<Void> execute(
            @NotEmpty(message = "数据列表不能为空")
            Map<String, Object> dataMap);

    String filePath();

    Integer pageSize();
}
