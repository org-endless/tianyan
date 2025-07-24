package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint;

import com.alibaba.fastjson2.util.TypeUtils;
import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.blueprint.rest.GameEveDataBlueprintRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.item.rest.GameEveDataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataBlueprintLoadTask
 * <p>
 * create 2025/07/23 11:29
 * <p>
 * update 2025/07/23 11:29
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 2.0.0
 */
@Slf4j
@Lazy
@Component
public class GameEveDataBlueprintLoadTask implements GameEveDataLoadTask {

    private final GameEveDataBlueprintRestClient gameEveDataBlueprintRestClient;

    private final GameEveDataItemRestClient gameEveDataItemRestClient;

    public GameEveDataBlueprintLoadTask(GameEveDataBlueprintRestClient gameEveDataBlueprintRestClient, GameEveDataItemRestClient gameEveDataItemRestClient) {
        this.gameEveDataBlueprintRestClient = gameEveDataBlueprintRestClient;
        this.gameEveDataItemRestClient = gameEveDataItemRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        Optional.ofNullable(dataMap)
                .filter(m -> !CollectionUtils.isEmpty(m))
                .orElseThrow(() -> new DrivenAdapterManagerException("蓝图数据列表为空，无法执行数据加载任务"));
        return CompletableFuture.runAsync(() -> {
            dataMap.forEach((key, value) -> {
                try {

                    GameEveDataFileBlueprintRespDTransfer blueprint = TypeUtils.cast(value, GameEveDataFileBlueprintRespDTransfer.class).validate();
                    String itemId = gameEveDataItemRestClient.findItemIdByCode(blueprint.getBlueprintTypeID());
                    GameEveDataFileBlueprintActivityRespDTransfer manufacturing = blueprint.getActivities().getManufacturing();
                    if (manufacturing != null) {
                        createActivity(itemId, blueprint.getBlueprintTypeID(), "PRODUCTION", blueprint.getMaxProductionLimit(), manufacturing);
                    }
                    GameEveDataFileBlueprintActivityRespDTransfer invention = blueprint.getActivities().getInvention();
                    if (invention != null) {
                        createActivity(itemId, blueprint.getBlueprintTypeID(), "INVENTION", null, invention);
                    }
                    GameEveDataFileBlueprintActivityRespDTransfer blueprintCopying = blueprint.getActivities().getCopying();
                    if (blueprintCopying != null) {
                        createActivity(itemId, blueprint.getBlueprintTypeID(), "BLUEPRINT_COPYING", null, blueprintCopying);
                    }
                    GameEveDataFileBlueprintActivityRespDTransfer blueprintMaterialImprovement = blueprint.getActivities().getResearch_material();
                    if (blueprintMaterialImprovement != null) {
                        createActivity(itemId, blueprint.getBlueprintTypeID(), "BLUEPRINT_MATERIAL_IMPROVEMENT", null, blueprintMaterialImprovement);
                    }
                    GameEveDataFileBlueprintActivityRespDTransfer blueprintCycleImprovement = blueprint.getActivities().getResearch_time();
                    if (blueprintCycleImprovement != null) {
                        createActivity(itemId, blueprint.getBlueprintTypeID(), "BLUEPRINT_CYCLE_IMPROVEMENT", null, blueprintCycleImprovement);
                    }
                    log.info("加载蓝图数据成功，key:{}, value:{}", key, blueprint);
                } catch (Exception e) {
                    log.error("加载蓝图数据失败，key:{}, value:{}, error:{}", key, value, e.getMessage());
                }
            });
        });
    }

    @Override
    public String filePath() {
        return "data/game/eve/blueprints.yaml";
    }

    @Override
    public Integer pageSize() {
        return 100;
    }

    private void createActivity(String itemId, String code, String type, Integer maxProductionLimit, GameEveDataFileBlueprintActivityRespDTransfer activity) {
        List<GameEveDataFileBlueprintMaterialRespDTransfer> materials = activity.getMaterials();
        List<GameEveDataFileBlueprintProductRespDTransfer> products = activity.getProducts();
        List<GameEveDataFileBlueprintSkillRespDTransfer> skills = activity.getSkills();
        gameEveDataBlueprintRestClient.create(GameEveBlueprintCreateReqDTransfer.builder()
                .itemId(itemId)
                .code(code)
                .type(type)
                .materials(CollectionUtils.isEmpty(materials) ? null : materials.stream()
                        .map(material -> GameEveBlueprintMaterialReqDTransfer.builder()
                                .itemId(gameEveDataItemRestClient.findItemIdByCode(material.getTypeID()))
                                .quantity(material.getQuantity()).build().validate())
                        .toList())
                .products(CollectionUtils.isEmpty(products) ? null : products.stream()
                        .map(product -> GameEveBlueprintProductReqDTransfer.builder()
                                .itemId(gameEveDataItemRestClient.findItemIdByCode(product.getTypeID()))
                                .quantity(product.getQuantity())
                                .successRate(product.getProbability())
                                .build().validate())
                        .toList())
                .skills(CollectionUtils.isEmpty(skills) ? null : skills.stream()
                        .map(skill -> GameEveBlueprintSkillReqDTransfer.builder()
                                .itemId(gameEveDataItemRestClient.findItemIdByCode(skill.getTypeID()))
                                .level(skill.getLevel()).build().validate())
                        .toList())
                .cycle(activity.getTime() * 60 * 1000)
                .maxProductionLimit(maxProductionLimit)
                .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                .build().validate());
    }

}
