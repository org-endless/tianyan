package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.GameEveDataLoadDrivenAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.GameEveDataTypeEnum;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.factory.GameEveDataLoadTaskFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

/**
 * GameEveDataLoadDrivenAdapterManager
 * <p>
 * create 2025/07/20 21:29
 * <p>
 * update 2025/07/20 23:07
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadDrivenAdapter
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveDataLoadDrivenAdapterManager implements GameEveDataLoadDrivenAdapter {

    private final static Pattern SCANNER_PATTERN = Pattern.compile("^\\d{1,10}:$", Pattern.MULTILINE);

    private final static Integer MAX_TASK_SIZE = 100;

    private final GameEveDataLoadTaskFactory gameEveDataLoadTaskFactory;

    public GameEveDataLoadDrivenAdapterManager(GameEveDataLoadTaskFactory gameEveDataLoadTaskFactory) {
        this.gameEveDataLoadTaskFactory = gameEveDataLoadTaskFactory;
    }

    @Override
    public void load(GameEveDataTypeEnum dataType) {
        GameEveDataLoadTask task = gameEveDataLoadTaskFactory.get(dataType);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileSystemResource(task.filePath()).getInputStream())) {
            scanner.useDelimiter(SCANNER_PATTERN);
            Map<String, Object> dataMap = new HashMap<>();
            while (scanner.hasNext()) {
                String itemId = scanner.findInLine(SCANNER_PATTERN).replace(":", "").trim();
                Yaml yaml = new Yaml(new Constructor(Object.class, new LoaderOptions()));
                dataMap.put(itemId, yaml.load(scanner.next()));
                if (dataMap.size() >= task.pageSize()) {
                    futures.add(task.execute(new HashMap<>(dataMap)));
                    dataMap.clear();
                }
                if (futures.size() >= MAX_TASK_SIZE) {
                    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
                    futures.clear();
                }
            }
            if (!dataMap.isEmpty()) {
                futures.add(task.execute(new HashMap<>(dataMap)));
                dataMap.clear();
            }
            if (!futures.isEmpty()) {
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            }

        } catch (IOException e) {
            throw new DrivenAdapterManagerException("加载数据失败", e);
        }
    }
}
