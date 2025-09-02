package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.TianyanSidecarGameEveItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.exchange.TianyanSidecarGameEveItemRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer.*;

import java.util.List;
import java.util.Optional;

/**
 * TianyanCommonGameEveItemRestClientImpl
 * <p>
 * 游戏EVE资源项REST客户端实现类
 * <p>
 * create 2025/08/24 19:57
 * <p>
 * update 2025/08/24 19:57
 *
 * @author Deng Haozhi
 * @see TianyanSidecarGameEveItemRestClient
 * @since 1.0.0
 */
public class TianyanSidecarGameEveItemRestClientImpl implements TianyanSidecarGameEveItemRestClient {

    private final TianyanSidecarGameEveItemRestExchange gameEveItemRestExchange;

    public TianyanSidecarGameEveItemRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveItemRestExchange = restExchangeClient.exchange(TianyanSidecarGameEveItemRestExchange.class);
    }

    @Override
    public void create(GameEveItemCreateDReqTransfer command) {
        gameEveItemRestExchange.create(command).validate();
    }

    @Override
    public Optional<String> fetch(GameEveItemFetchDReqTransfer command) {
        return Optional.ofNullable(gameEveItemRestExchange.fetch(command)
                .validate(GameEveItemFetchDRespTransfer.class)
                .itemId());
    }

    @Override
    public Optional<String> findItemIdByCode(String gameEveItemCode) {
        return Optional.ofNullable(gameEveItemRestExchange.findItemIdByCode(FindByGameEveItemCodeDReqTransfer.builder()
                        .gameEveItemCode(gameEveItemCode).build())
                .validate(FindItemIdDRespTransfer.class).itemId());
    }

    @Override
    public List<String> findItemIdsByCodes(List<String> gameEveItemCodes) {
        return gameEveItemRestExchange.findItemIdsByCodes(FindByGameEveItemCodesDReqTransfer.builder()
                        .gameEveItemCodes(gameEveItemCodes).build())
                .validate(FindItemIdsDRespTransfer.class).itemIds();
    }

    @Override
    public Optional<String> findCodeByItemId(String itemId) {
        return Optional.ofNullable(gameEveItemRestExchange.findCodeByItemId(FindByItemIdDReqTransfer.builder()
                        .itemId(itemId).build())
                .validate(FindGameEveItemCodeDRespTransfer.class).gameEveItemCode());
    }
}
