package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.market.group;

import lombok.extern.slf4j.Slf4j;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.GameEveDataLoadTask;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.market.group.transfer.GameEveDataFileMarketGroupRespDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.TianyanSidecarGameEveMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.GameEveMarketGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.TianyanSidecarMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupModifyParentDReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataMarketGroupLoadTask
 * <p>
 * create 2025/07/22 10:08
 * <p>
 * update 2025/07/22 10:08
 *
 * @author Deng Haozhi
 * @see GameEveDataLoadTask
 * @since 0.0.1
 */
@Slf4j
@Lazy
@Component
public class GameEveDataMarketGroupLoadTask implements GameEveDataLoadTask {

    private final TianyanSidecarMarketGroupRestClient marketGroupRestClient;

    private final TianyanSidecarGameEveMarketGroupRestClient gameEveMarketGroupRestClient;

    public GameEveDataMarketGroupLoadTask(
            TianyanSidecarMarketGroupRestClient marketGroupRestClient,
            TianyanSidecarGameEveMarketGroupRestClient gameEveMarketGroupRestClient) {
        this.marketGroupRestClient = marketGroupRestClient;
        this.gameEveMarketGroupRestClient = gameEveMarketGroupRestClient;
    }

    @Override
    public CompletableFuture<Void> execute(Map<String, Object> dataMap) {
        return CompletableFuture.runAsync(() -> {
            List<Map<String, String>> parents = new ArrayList<>();
            dataMap.forEach((gameEveMarketGroupCode, gameEveMarketGroup) -> {
                try {
                    GameEveDataFileMarketGroupRespDReqTransfer marketGroup =
                            ObjectTools.of(gameEveMarketGroup, GameEveDataFileMarketGroupRespDReqTransfer.class).validate();
                    String marketGroupId = marketGroupRestClient.create(MarketGroupCreateDReqTransfer.builder()
                                    .fullNameZh(StringUtils.hasText(marketGroup.nameID().zh())
                                            ? marketGroup.nameID().zh()
                                            : marketGroup.nameID().en())
                                    .fullNameEn(marketGroup.nameID().en())
                                    .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                                    .build())
                            .orElseThrow(() -> new DrivenAdapterFailedException("市场分组创建失败"));
                    gameEveMarketGroupRestClient.create(GameEveMarketGroupCreateDReqTransfer.builder()
                            .marketGroupId(marketGroupId)
                            .gameEveMarketGroupCode(gameEveMarketGroupCode)
                            .createUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                            .build());
                    if (StringUtils.hasText(marketGroup.parentGroupID())) {
                        parents.add(Map.of("marketGroupId", marketGroupId, "parentGameEveMarketGroupCode", marketGroup.parentGroupID()));
                    }
                } catch (Exception e) {
                    log.error("加载市场分组数据失败，gameEveMarketGroupCode:{}, gameEveMarketGroup:{}, error:{}", gameEveMarketGroupCode, gameEveMarketGroup, e.getMessage(), e);
                }
            });
            parents.forEach(parentGameEveMarketGroup -> {
                try {
                    String parentMarketGroupId = gameEveMarketGroupRestClient.findMarketGroupIdByCode(parentGameEveMarketGroup.get("parentGameEveMarketGroupCode"))
                            .orElseThrow(() -> new DrivenAdapterFailedException("父节点市场分组查询失败"));
                    marketGroupRestClient.modifyParent(MarketGroupModifyParentDReqTransfer.builder()
                            .marketGroupId(parentGameEveMarketGroup.get("marketGroupId"))
                            .parentId(parentMarketGroupId)
                            .modifyUserId(TianyanMetadataCommandHandler.TIANYAN_METADATA_USER_ID)
                            .build());
                } catch (Exception e) {
                    log.error("加载市场分组父节点数据失败，parentGameEveMarketGroup:{}, error:{}", parentGameEveMarketGroup, e.getMessage(), e);
                }
            });
        });
    }

    @Override
    public String filePath() {
        return "data/game/eve/marketGroups.yaml";
    }

    @Override
    public Integer pageSize() {
        return 10000;
    }
}
