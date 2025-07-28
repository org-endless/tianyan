package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.item.rest;

import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.TianyanSalesItemRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderItemFetchReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderItemFetchRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Optional;

/**
 * GameEveMarketOrderItemRestClient
 * <p>
 * create 2025/07/26 03:58
 * <p>
 * update 2025/07/26 04:02
 *
 * @author Deng Haozhi
 * @see TianyanSalesItemRestClient
 * @since 2.0.0
 */
@Lazy
@Component
public class GameEveMarketOrderItemRestClient implements TianyanSalesItemRestClient {

    private final RestClient restClient;

    public GameEveMarketOrderItemRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Optional<String> fetch(String code, String createUserId) {
        return post(
                restClient,
                "/item/game/eve/command/fetch",
                GameEveMarketOrderItemFetchReqDTransfer.builder()
                        .gameEveItemCode(code)
                        .createUserId(createUserId)
                        .build().validate(),
                GameEveMarketOrderItemFetchRespDTransfer.class)
                .map(GameEveMarketOrderItemFetchRespDTransfer::validate)
                .map(GameEveMarketOrderItemFetchRespDTransfer::getItemId);
    }
}
