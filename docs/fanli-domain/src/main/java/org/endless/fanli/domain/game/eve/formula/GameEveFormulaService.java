package org.endless.erp.game.eve.formula;

import lombok.extern.log4j.Log4j2;
import org.endless.erp.game.eve.share.regular.GameEvePattern;
import org.endless.erp.game.eve.share.thread.GameEveAsyncTask;
import org.endless.erp.share.constant.ConstantResource;
import org.endless.fanli.common.type.ddd.formula.FormulaService;
import org.endless.spring.boot.com.utiliy.file.FileLoader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GameEveFormulaService
 * <p>
 * <p>create 2023/4/11 16:51
 * <p>update 2023/9/27 10:29
 *
 * @author Deng Haozhi
 * @see FormulaService
 * @since 0.0.4
 */
@Log4j2
@Service
public class GameEveFormulaService implements FormulaService {

    private final GameEveAsyncTask asyncTask;

    private final org.endless.erp.game.eve.formula.GameEveFormulaRepository formulaRepository;

    public GameEveFormulaService(
            @Qualifier("gameEveFormulaLoadTask") GameEveAsyncTask asyncTask,
            org.endless.erp.game.eve.formula.GameEveFormulaRepository formulaRepository) {

        this.asyncTask = asyncTask;
        this.formulaRepository = formulaRepository;
    }


    @Override
    public <T> void load(T file) {

        var begin = System.currentTimeMillis();
        log.info("Loading!");
        log.debug("Load main thread begin: " + begin);

        var scanner = FileLoader.getScanner(String.valueOf(file), GameEvePattern.getFile());

        if (scanner == null) {
            log.error("The file read failed!");
            return;
        }

        List<List<Map<String, String>>> scannerMaps = new ArrayList<>();
        scannerMaps.add(new ArrayList<>());
        var index = 0;

        while (scanner.hasNext()) {

            var formulaItemId = scanner.findInLine(GameEvePattern.getFile()).replace(":", "").trim();
            var scannerMap = Map.of("formulaItemId", formulaItemId, "scanner", scanner.next());
            scannerMaps.get(index).add(scannerMap);

            if (scannerMaps.get(index).size() % ConstantResource.PAGE_SIZE == 0) {

                log.debug("scannerMap size: " + scannerMaps.get(index).size() + "  scannerMap index: " + index);

                asyncTask.run(scannerMaps.get(index));
                scannerMaps.add(new ArrayList<>());
                index++;
            }
        }
        log.debug("scannerMap size: " + scannerMaps.get(index).size() + "  scannerMap index: " + index);
        asyncTask.run(scannerMaps.get(index));

        log.info("GameEveFormulaService loaded executed!");
        log.debug("main thread cost : " + (System.currentTimeMillis() - begin));
    }

    @Override
    public <T, E extends Enum<E>> void load(T file, Enum<E> categories) {

        var begin = System.currentTimeMillis();
        log.info("Loading!");
        log.debug("Load main thread begin: " + begin);

        if (!categories.equals(org.endless.erp.game.eve.formula.GameEveFormula.Categories.planet)) {
            log.debug("Only for Categories.planet");
            return;
        }
        var scanner = FileLoader.getScanner(String.valueOf(file), GameEvePattern.getFile());

        if (scanner == null) {
            log.error("Loaded failed!");
            return;
        }

        List<List<String>> scannerMaps = new ArrayList<>();
        scannerMaps.add(new ArrayList<>());
        var index = 0;

        while (scanner.hasNext()) {

            scannerMaps.get(index).add(scanner.next());

            if (scannerMaps.get(index).size() % ConstantResource.PAGE_SIZE == 0) {

                log.debug("scannerMap size: " + scannerMaps.get(index).size() + "  scannerMap index: " + index);

                asyncTask.run(scannerMaps.get(index), categories);
                scannerMaps.add(new ArrayList<>());
                index++;
            }
        }
        log.debug("scannerMap size: " + scannerMaps.get(index).size() + "  scannerMap index: " + index);
        asyncTask.run(scannerMaps.get(index), categories);

        log.info("GameEveFormulaService loaded planet executed!");
        log.debug("main thread cost : " + (System.currentTimeMillis() - begin));
    }

    public List<org.endless.erp.game.eve.formula.GameEveFormula> getAll() {
        return formulaRepository.findAll();
    }
}
