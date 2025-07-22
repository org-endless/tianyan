package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.group.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanMetadataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemGroupCreateReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

/**
 * GameEveDataItemGroupRestClient
 * <p>
 * create 2025/07/21 16:51
 * <p>
 * update 2025/07/21 16:51
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 2.0.0
 */
@Lazy
@Component
public class GameEveDataItemGroupRestClient implements TianyanMetadataItemRestClient {

    private final RestClient restClient;

    public GameEveDataItemGroupRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void create(GameEveItemGroupCreateReqDTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemGroupCreateReqDTransfer::validate)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE物品分组创建请求参数不能为空"));
        post(restClient, "/item/group/game/eve/command/create", command, null);

    }
}
