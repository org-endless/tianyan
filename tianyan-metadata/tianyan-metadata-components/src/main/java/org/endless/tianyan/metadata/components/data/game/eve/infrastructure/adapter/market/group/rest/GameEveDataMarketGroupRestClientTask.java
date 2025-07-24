package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.market.group.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanMetadataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveMarketGroupCreateReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveMarketGroupFindByCodeReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveMarketGroupFindIdRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataMarketGroupRestClientTask
 * <p>
 * create 2025/07/22 15:58
 * <p>
 * update 2025/07/22 15:58
 *
 * @author Deng Haozhi
 * @see TianyanMetadataItemRestClient
 * @since 2.0.0
 */
@Lazy
@Component
public class GameEveDataMarketGroupRestClientTask implements GameEveDataMarketGroupRestClient {

    private final RestClient restClient;

    public GameEveDataMarketGroupRestClientTask(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public CompletableFuture<Void> create(GameEveMarketGroupCreateReqDTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMarketGroupCreateReqDTransfer::validate)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项分组创建请求参数不能为空"));
        return CompletableFuture.runAsync(() -> {
            post(restClient, "/market/group/game/eve/command/create", command, null);
        });
    }

    @Override
    public Optional<String> findMarketGroupIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE市场分组编码不能为空"));
        return Optional.ofNullable(post(
                restClient,
                "/market/group/game/eve/query/find_market_group_id_by_code",
                GameEveMarketGroupFindByCodeReqDTransfer.builder()
                        .code(code)
                        .build().validate(),
                GameEveMarketGroupFindIdRespDTransfer.class)
                .orElseThrow(() -> new DrivenAdapterManagerException("游戏EVE市场分组分类根据编码查询ID响应数据为空"))
                .validate()
                .getMarketGroupId());
    }
}
