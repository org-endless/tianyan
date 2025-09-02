package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.TianyanSidecarGameEveMarketGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.exchange.TianyanSidecarGameEveMarketGroupRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.FindByGameEveMarketGroupCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.FindMarketGroupIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.GameEveMarketGroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveMarketGroupRestClientImpl
 * <p>
 * create 2025/08/24 19:32
 * <p>
 * update 2025/08/24 19:32
 *
 * @author Deng Haozhi
 * @see TianyanSidecarGameEveMarketGroupRestClient
 * @since 1.0.0
 */
public class TianyanSidecarGameEveMarketGroupRestClientImpl implements TianyanSidecarGameEveMarketGroupRestClient {

    private final TianyanSidecarGameEveMarketGroupRestExchange gameEveMarketGroupRestExchange;

    public TianyanSidecarGameEveMarketGroupRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveMarketGroupRestExchange = restExchangeClient.exchange(TianyanSidecarGameEveMarketGroupRestExchange.class);
    }

    @Override
    public void create(GameEveMarketGroupCreateDReqTransfer command) {
        gameEveMarketGroupRestExchange.create(command).validate();
    }

    @Override
    public Optional<String> findMarketGroupIdByCode(String gameEveMarketGroupCode) {
        return Optional.ofNullable(gameEveMarketGroupRestExchange
                .findMarketGroupIdByCode(FindByGameEveMarketGroupCodeDReqTransfer.builder()
                        .gameEveMarketGroupCode(gameEveMarketGroupCode).build())
                .validate(FindMarketGroupIdDRespTransfer.class)
                .marketGroupId());
    }
}
