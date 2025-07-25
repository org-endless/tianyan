package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.item.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanMetadataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemCreateReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemFindByCodeReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemFindIdRespDTransfer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;

import java.util.Optional;

/**
 * GameEveDataItemRestClient
 * <p>
 * create 2025/07/22 23:41
 * <p>
 * update 2025/07/22 23:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataItemRestClient
 * @since 0.0.1
 */
@Component
public class GameEveDataItemRestClient implements TianyanMetadataItemRestClient {

    private final RestClient restClient;

    public GameEveDataItemRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void create(GameEveItemCreateReqDTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCreateReqDTransfer::validate)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项创建请求参数不能为空"));
        post(restClient, "/item/game/eve/command/create", command, null);
    }

    public String findItemIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项编码不能为空"));
        return Optional.ofNullable(post(
                        restClient,
                        "/item/game/eve/query/find_item_id_by_code",
                        GameEveItemFindByCodeReqDTransfer.builder()
                                .gameEveItemCode(code).build().validate(),
                        GameEveItemFindIdRespDTransfer.class)
                        .orElseThrow(() -> new DrivenAdapterManagerException("游戏EVE资源项根据编码查询ID响应数据为空"))
                        .validate()
                        .getItemId())
                .orElseThrow(() -> new DrivenAdapterManagerException("资源项不存在"));
    }
}
