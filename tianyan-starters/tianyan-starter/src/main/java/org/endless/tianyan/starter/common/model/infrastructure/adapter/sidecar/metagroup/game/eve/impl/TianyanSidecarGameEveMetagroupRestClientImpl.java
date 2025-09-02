package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.TianyanSidecarGameEveMetagroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.exchange.TianyanSidecarGameEveMetagroupRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.FindByGameEveMetagroupCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.FindMetagroupIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.GameEveMetagroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveMetagroupRestClientImpl
 * <p>游戏EVE元分组REST客户端
 * <p>
 * create 2025/08/24 19:16
 * <p>
 * update 2025/08/24 19:17
 *
 * @author Deng Haozhi
 * @see TianyanSidecarGameEveMetagroupRestClient
 * @since 1.0.0
 */
public class TianyanSidecarGameEveMetagroupRestClientImpl implements TianyanSidecarGameEveMetagroupRestClient {

    private final TianyanSidecarGameEveMetagroupRestExchange gameEveMetagroupExchange;

    public TianyanSidecarGameEveMetagroupRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveMetagroupExchange = restExchangeClient.exchange(TianyanSidecarGameEveMetagroupRestExchange.class);
    }

    @Override
    public void create(GameEveMetagroupCreateDReqTransfer command) {
        gameEveMetagroupExchange.create(command).validate();
    }

    @Override
    public Optional<String> findMetagroupIdByCode(String gameEveMetagroupCode) {
        return Optional.ofNullable(gameEveMetagroupExchange.findMetagroupIdByCode(FindByGameEveMetagroupCodeDReqTransfer.builder()
                        .gameEveMetagroupCode(gameEveMetagroupCode).build())
                .validate(FindMetagroupIdDRespTransfer.class)
                .metagroupId());
    }
}
