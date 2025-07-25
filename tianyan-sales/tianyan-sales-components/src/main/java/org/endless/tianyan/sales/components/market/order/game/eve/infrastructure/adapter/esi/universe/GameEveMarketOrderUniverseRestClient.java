package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.universe;

import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.TianyanSalesESIRestClient;

/**
 * GameEveMarketOrderUniverseRestClient
 * <p>
 * create 2025/07/25 15:00
 * <p>
 * update 2025/07/25 15:01
 *
 * @author Deng Haozhi
 * @see TianyanSalesESIRestClient
 * @since 2.0.0
 */
public interface GameEveMarketOrderUniverseRestClient extends TianyanSalesESIRestClient {

    String findUniverseItemNameByCode(String itemCode, String datasource, String categoryName);
}
