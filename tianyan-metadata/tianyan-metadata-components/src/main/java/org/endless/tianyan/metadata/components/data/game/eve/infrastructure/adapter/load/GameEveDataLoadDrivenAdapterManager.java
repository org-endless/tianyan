package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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

    private final static Integer PAGE_SIZE = 100;

    private final GameEveDataLoadTaskFactory gameEveDataLoadTaskFactory;

    public GameEveDataLoadDrivenAdapterManager(GameEveDataLoadTaskFactory gameEveDataLoadTaskFactory) {
        this.gameEveDataLoadTaskFactory = gameEveDataLoadTaskFactory;
    }

    @Override
    public void load(GameEveDataTypeEnum dataType) {
        GameEveDataLoadTask task = gameEveDataLoadTaskFactory.get(dataType);
        try (Scanner scanner = new Scanner(new FileSystemResource(task.getFilePath()).getInputStream())) {
            scanner.useDelimiter(SCANNER_PATTERN);
            Map<String, Object> dataMap = new HashMap<>();
            while (scanner.hasNext()) {
                String itemId = scanner.findInLine(SCANNER_PATTERN).replace(":", "").trim();
                Yaml yaml = new Yaml(new Constructor(Object.class, new LoaderOptions()));
                dataMap.put(itemId, yaml.load(scanner.next()));
                if (dataMap.size() >= PAGE_SIZE) {
                    task.execute(new HashMap<>(dataMap));
                    dataMap.clear();
                }
            }
            if (!dataMap.isEmpty()) {
                task.execute(new HashMap<>(dataMap));
                dataMap.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
