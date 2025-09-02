package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.TianyanSidecarGameEveItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.exchange.TianyanSidecarGameEveItemGroupRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer.FindByGameEveItemGroupCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer.FindItemGroupIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer.GameEveItemGroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveItemGroupRestClientImpl
 * <p>
 * 游戏EVE资源项分组REST客户端实现类
 * <p>
 * create 2025/08/24 20:09
 * <p>
 * update 2025/08/24 20:09
 *
 * @author Deng Haozhi
 * @see TianyanSidecarGameEveItemGroupRestClient
 * @since 1.0.0
 */
public class TianyanSidecarGameEveItemGroupRestClientImpl implements TianyanSidecarGameEveItemGroupRestClient {

    private final TianyanSidecarGameEveItemGroupRestExchange gameEveItemGroupRestExchange;

    public TianyanSidecarGameEveItemGroupRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveItemGroupRestExchange = restExchangeClient.exchange(TianyanSidecarGameEveItemGroupRestExchange.class);
    }

    @Override
    public void create(GameEveItemGroupCreateDReqTransfer command) {
        gameEveItemGroupRestExchange.create(command).validate();
    }

    @Override
    public Optional<String> findItemGroupIdByCode(String gameEveItemGroupCode) {
        return Optional.ofNullable(gameEveItemGroupRestExchange.findItemGroupIdByCode(FindByGameEveItemGroupCodeDReqTransfer.builder()
                        .gameEveItemGroupCode(gameEveItemGroupCode).build())
                .validate(FindItemGroupIdDRespTransfer.class)
                .itemGroupId());
    }
}
