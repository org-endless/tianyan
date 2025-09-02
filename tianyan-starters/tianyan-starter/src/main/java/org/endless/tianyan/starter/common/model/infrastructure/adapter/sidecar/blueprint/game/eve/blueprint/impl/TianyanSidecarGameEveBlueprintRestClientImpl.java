package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.TianyanSidecarGameEveBlueprintRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.exchange.TianyanSidecarGameEveBlueprintRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.transfer.GameEveBlueprintCreateDReqTransfer;

/**
 * TianyanCommonGameEveBlueprintRestClientImpl
 * <p>
 * 游戏EVE蓝图REST客户端实现类
 * <p>
 * create 2025/08/24 20:02
 * <p>
 * update 2025/08/24 20:02
 *
 * @author Deng Haozhi
 * @see TianyanSidecarGameEveBlueprintRestClient
 * @since 1.0.0
 */
public class TianyanSidecarGameEveBlueprintRestClientImpl implements TianyanSidecarGameEveBlueprintRestClient {

    private final TianyanSidecarGameEveBlueprintRestExchange gameEveBlueprintRestExchange;

    public TianyanSidecarGameEveBlueprintRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveBlueprintRestExchange = restExchangeClient.exchange(TianyanSidecarGameEveBlueprintRestExchange.class);
    }

    @Override
    public void create(GameEveBlueprintCreateDReqTransfer command) {
        gameEveBlueprintRestExchange.create(command).validate();
    }
}
