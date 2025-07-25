package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.item.rest;

import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.TianyanSalesItemRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderItemDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderItemFindByIdReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer;
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
public class GameEveMarketOrderItemRestClient implements GameEveMarketOrderItemDrivenAdapter, TianyanSalesItemRestClient {

    private final RestClient restClient;

    public GameEveMarketOrderItemRestClient(RestClient restClient) {
        this.restClient = restClient;
    }


    @Override
    public Optional<String> findGameEveItemCodeByItemId(String itemId) {
        return post(
                restClient,
                "/item/game/eve/query/find_code_by_item_id",
                GameEveMarketOrderItemFindByIdReqDTransfer.builder().itemId(itemId).build().validate(),
                GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer.class)
                .map(GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer::validate)
                .map(GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer::getGameEveItemCode);
    }
}
