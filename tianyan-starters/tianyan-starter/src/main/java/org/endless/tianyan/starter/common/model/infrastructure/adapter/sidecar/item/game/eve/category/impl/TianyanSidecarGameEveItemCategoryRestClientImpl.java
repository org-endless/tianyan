package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.impl;

import org.endless.ddd.starter.common.config.rest.client.RestExchangeClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.TianyanSidecarGameEveItemCategoryRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.exchange.TianyanSidecarGameEveItemCategoryRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.FindByGameEveItemCategoryCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.FindItemCategoryIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.GameEveItemCategoryCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveItemCategoryRestClientImpl
 * <p>
 * 游戏EVE资源项分类REST客户端实现类
 * <p>
 * create 2025/08/24 20:08
 * <p>
 * update 2025/08/24 20:08
 *
 * @author Deng Haozhi
 * @see TianyanSidecarGameEveItemCategoryRestClient
 * @since 1.0.0
 */
public class TianyanSidecarGameEveItemCategoryRestClientImpl implements TianyanSidecarGameEveItemCategoryRestClient {

    private final TianyanSidecarGameEveItemCategoryRestExchange gameEveItemCategoryRestExchange;

    public TianyanSidecarGameEveItemCategoryRestClientImpl(RestExchangeClient restExchangeClient) {
        this.gameEveItemCategoryRestExchange = restExchangeClient.exchange(TianyanSidecarGameEveItemCategoryRestExchange.class);
    }

    @Override
    public void create(GameEveItemCategoryCreateDReqTransfer command) {
        gameEveItemCategoryRestExchange.create(command).validate();
    }

    @Override
    public Optional<String> findItemCategoryIdByCode(String gameEveItemCategoryCode) {
        return Optional.ofNullable(gameEveItemCategoryRestExchange.findItemCategoryIdByCode(FindByGameEveItemCategoryCodeDReqTransfer.builder()
                        .gameEveItemCategoryCode(gameEveItemCategoryCode).build())
                .validate(FindItemCategoryIdDRespTransfer.class)
                .itemCategoryId());
    }
}
