package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market.transfer;

import org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.exchange.TianyanGameEveESIExchange;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketOrderFindProfileRespDTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * GameEveMarketOrderESIMarketExchange
 * <p>
 * create 2025/07/25 11:26
 * <p>
 * update 2025/07/28 06:14
 *
 * @author Deng Haozhi
 * @see TianyanGameEveESIExchange
 * @since 0.0.1
 */
public interface GameEveMarketOrderESIMarketExchange extends TianyanGameEveESIExchange {

    @GetExchange("/markets/{region_id}/orders/")
    ResponseEntity<List<ESIMarketOrderFindProfileRespDTransfer>> fetchMarketOrders(
            @PathVariable("region_id") String regionId,
            @RequestParam("datasource") String datasource,
            @RequestParam("order_type") String orderType,
            @RequestParam("type_id") String itemCode,
            @RequestParam("page") Integer page
    );

    @GetExchange("/markets/{region_id}/types/")
    ResponseEntity<List<String>> fetchCodes(
            @PathVariable("region_id") String regionId,
            @RequestParam("datasource") String datasource,
            @RequestParam("page") Integer page
    );
}
