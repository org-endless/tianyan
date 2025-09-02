package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer.*;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.TianyanSidecarGameEveBlueprintRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.transfer.GameEveBlueprintCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.TianyanSidecarGameEveItemRestClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID;

/**
 * GameEveDataBlueprintLoadTask
 * <p>
 * create 2025/07/23 11:29
 * <p>
 * update 2025/07/23 11:29
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 0.0.1
 */
@Slf4j
@Lazy
@Component
public class GameEveDataBlueprintLoadTask implements GameEveDataLoadTask {


    private final TianyanSidecarGameEveItemRestClient gameEveDataItemRestClient;

    private final TianyanSidecarGameEveBlueprintRestClient gameEveBlueprintRestClient;

    public GameEveDataBlueprintLoadTask(TianyanSidecarGameEveItemRestClient gameEveDataItemRestClient, TianyanSidecarGameEveBlueprintRestClient gameEveBlueprintRestClient) {
        this.gameEveDataItemRestClient = gameEveDataItemRestClient;
        this.gameEveBlueprintRestClient = gameEveBlueprintRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        return CompletableFuture.runAsync(() ->
                dataMap.forEach(this::handleBlueprint)
        );
    }

    @Override
    public String filePath() {
        return "data/game/eve/blueprints.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }

    private void handleBlueprint(String gameEveBlueprintCode, Object gameEveBlueprint) {
        try {
            GameEveDataFileBlueprintRespDReqTransfer blueprint =
                    ObjectTools.of(gameEveBlueprint, GameEveDataFileBlueprintRespDReqTransfer.class);
            String itemId = gameEveDataItemRestClient.findItemIdByCode(blueprint.blueprintTypeID())
                    .orElseThrow(() -> new DrivenAdapterFailedException("游戏EVE资源项编码不存在"));
            processActivities(itemId, blueprint);
        } catch (Exception e) {
            log.error("加载蓝图数据失败，key:{}, value:{}, error:{}", gameEveBlueprintCode, gameEveBlueprint, e.getMessage());
        }
    }

    private void processActivities(String itemId, GameEveDataFileBlueprintRespDReqTransfer blueprint) {
        Map<String, GameEveDataFileBlueprintActivityRespDReqTransfer> activities = Map.of(
                "PRODUCTION", blueprint.activities().manufacturing(),
                "INVENTION", blueprint.activities().invention(),
                "BLUEPRINT_COPYING", blueprint.activities().copying(),
                "BLUEPRINT_MATERIAL_IMPROVEMENT", blueprint.activities().research_material(),
                "BLUEPRINT_CYCLE_IMPROVEMENT", blueprint.activities().research_time()
        );

        activities.forEach((type, activity) -> {
            if (activity != null) {
                Integer limit = "PRODUCTION".equals(type) ? blueprint.maxProductionLimit() : null;
                createActivity(itemId, blueprint.blueprintTypeID(), type, limit, activity);
            }
        });
    }

    private void createActivity(String blueprintItemId, String gameEveBlueprintItemCode, String type, Integer maxProductionLimit, GameEveDataFileBlueprintActivityRespDReqTransfer activity) {
        List<GameEveDataFileBlueprintMaterialRespDReqTransfer> materials = activity.materials();
        List<GameEveDataFileBlueprintProductRespDReqTransfer> products = activity.products();
        List<GameEveDataFileBlueprintSkillRespDReqTransfer> skills = activity.skills();
        String blueprintId = gameEveDataBlueprintRestClient.create(GameEveBlueprintCreateReqDReqTransfer.builder()
                .itemId(itemId)
                .code(code)
                .type(type)
                .materials(CollectionUtils.isEmpty(materials) ? null : materials.stream()
                        .map(material -> GameEveBlueprintMaterialReqDReqTransfer.builder()
                                .itemId(gameEveDataItemRestClient.findItemIdByCode(material.typeID()))
                                .quantity(material.quantity()).build().validate())
                        .toList())
                .products(CollectionUtils.isEmpty(products) ? null : products.stream()
                        .map(product -> GameEveBlueprintProductReqDReqTransfer.builder()
                                .itemId(gameEveDataItemRestClient.findItemIdByCode(product.typeID()))
                                .quantity(product.quantity())
                                .successRate(product.probability())
                                .build().validate())
                        .toList())
                .skills(CollectionUtils.isEmpty(skills) ? null : skills.stream()
                        .map(skill -> GameEveBlueprintSkillReqDReqTransfer.builder()
                                .itemId(gameEveDataItemRestClient.findItemIdByCode(skill.typeID()))
                                .level(skill.level()).build().validate())
                        .toList())
                .cycle(activity.time() * 1000)
                .maxProductionLimit(maxProductionLimit)
                .createUserId(TIANYAN_METADATA_USER_ID)
                .build().validate());
        gameEveBlueprintRestClient.create(GameEveBlueprintCreateDReqTransfer.builder()
                .blueprintId(blueprintId)
                .gameEveBlueprintItemCode(gameEveBlueprintItemCode)
                .maxProductionLimit(maxProductionLimit)
                .createUserId(TIANYAN_METADATA_USER_ID)
                .build());
    }
}
