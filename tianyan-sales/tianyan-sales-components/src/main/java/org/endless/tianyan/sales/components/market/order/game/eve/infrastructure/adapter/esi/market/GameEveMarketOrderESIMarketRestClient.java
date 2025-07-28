package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market;

import org.endless.ddd.simplified.starter.common.model.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.TianyanGameEveESIRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketItemFindPageReqDTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketOrderFindPageReqDTransfer;

/**
 * GameEveMarketOrderESIRestClient
 * <p>
 * create 2025/07/25 11:49
 * <p>
 * update 2025/07/28 06:13
 *
 * @author Deng Haozhi
 * @see TianyanGameEveESIRestClient
 * @since 0.0.1
 */
public interface GameEveMarketOrderESIMarketRestClient extends TianyanGameEveESIRestClient {

    FindPageRespTransfer fetchMarketOrderPage(ESIMarketOrderFindPageReqDTransfer query);

    FindPageRespTransfer fetchCodePage(ESIMarketItemFindPageReqDTransfer query);

}
