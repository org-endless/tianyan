package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.market.group.rest;

import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanMetadataSalesRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveMarketGroupCreateReqDTransfer;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * GameEveDataMarketGroupRestClient
 * <p>
 * create 2025/07/22 18:05
 * <p>
 * update 2025/07/22 18:05
 * update 2025/07/22 18:05
 *
 * @author Deng Haozhi
 * @see TianyanMetadataSalesRestClient
 * @since 2.0.0
 */
public interface GameEveDataMarketGroupRestClient extends TianyanMetadataSalesRestClient {

    @Async("virtualThreadExecutor")
    CompletableFuture<Void> create(GameEveMarketGroupCreateReqDTransfer command);

    Optional<String> findMarketGroupIdByCode(String code);
}
