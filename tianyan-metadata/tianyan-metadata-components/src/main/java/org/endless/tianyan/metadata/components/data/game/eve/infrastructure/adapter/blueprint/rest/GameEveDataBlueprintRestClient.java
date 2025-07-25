package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.blueprint.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanManufacturingRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveBlueprintCreateReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

/**
 * GameEveDataBlueprintRestClient
 * <p>
 * create 2025/07/23 15:48
 * <p>
 * update 2025/07/23 15:57
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRestClient
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveDataBlueprintRestClient implements TianyanManufacturingRestClient {

    private final RestClient restClient;

    public GameEveDataBlueprintRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void create(GameEveBlueprintCreateReqDTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveBlueprintCreateReqDTransfer::validate)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE蓝图创建请求参数不能为空"));
        post(restClient, "/blueprint/game/eve/command/create", command, null);
    }
}
