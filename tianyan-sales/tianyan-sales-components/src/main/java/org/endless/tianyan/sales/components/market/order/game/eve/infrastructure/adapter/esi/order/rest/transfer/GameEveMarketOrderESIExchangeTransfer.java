package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.order.rest.transfer;

import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.transfer.TianyanSalesESIExchangeTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderESIFindProfileRespDTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * GameEveMarketOrderESIExchangeTransfer
 * <p>
 * create 2025/07/25 11:26
 * <p>
 * update 2025/07/25 11:38
 *
 * @author Deng Haozhi
 * @see TianyanSalesESIExchangeTransfer
 * @since 0.0.1
 */
public interface GameEveMarketOrderESIExchangeTransfer extends TianyanSalesESIExchangeTransfer {

    @GetExchange("/markets/{region_id}/orders/")
    ResponseEntity<List<GameEveMarketOrderESIFindProfileRespDTransfer>> findMarketOrderProfiles(
            @PathVariable("region_id") String regionId,
            @RequestParam("datasource") String datasource,
            @RequestParam("order_type") String orderType,
            @RequestParam("type_id") String itemCode,
            @RequestParam("page") Integer page
    );
}
