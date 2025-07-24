package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.group.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanMetadataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemGroupCreateReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemGroupFindByCodeReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemGroupFindIdRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项分组创建请求参数不能为空"));
        post(restClient, "/item/group/game/eve/command/create", command, null);
    }

    public Optional<String> findItemGroupIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项分组编码不能为空"));
        return Optional.ofNullable(post(
                restClient,
                "/item/group/game/eve/query/find_item_group_id_by_code",
                GameEveItemGroupFindByCodeReqDTransfer.builder()
                        .code(code)
                        .build().validate(),
                GameEveItemGroupFindIdRespDTransfer.class)
                .orElseThrow(() -> new DrivenAdapterManagerException("游戏EVE资源项分组根据编码查询ID响应数据为空"))
                .validate()
                .getItemGroupId());
    }
}
