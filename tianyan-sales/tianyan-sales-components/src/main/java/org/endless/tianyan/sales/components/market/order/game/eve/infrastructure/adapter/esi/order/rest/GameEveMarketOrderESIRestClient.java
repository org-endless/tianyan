package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.order.rest;

import org.endless.ddd.simplified.starter.common.model.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.TianyanSalesESIRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderESIFindPageReqDTransfer;

/**
 * GameEveMarketOrderESIRestClient
 * <p>
 * create 2025/07/25 11:49
 * <p>
 * update 2025/07/25 11:50
 *
 * @author Deng Haozhi
 * @see TianyanSalesESIRestClient
 * @since 2.0.0
 */
public interface GameEveMarketOrderESIRestClient extends TianyanSalesESIRestClient {

    FindPageRespTransfer findMarketOrderPage(GameEveMarketOrderESIFindPageReqDTransfer query);
}
