package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.universe.transfer;

import org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.transfer.TianyanSalesEsiExchangeTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderFindUniverseItemNameRespDTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * GameEveMarketOrderUniverseExchangeTransfer
 * <p>
 * create 2025/07/25 15:02
 * <p>
 * update 2025/07/25 15:02
 *
 * @author Deng Haozhi
 * @see TianyanSalesEsiExchangeTransfer
 * @since 2.0.0
 */
public interface GameEveMarketOrderUniverseExchangeTransfer extends TianyanSalesEsiExchangeTransfer {


    @PostExchange("/universe/{region_id}/orders/")
    List<GameEveMarketOrderFindUniverseItemNameRespDTransfer> findUniverseItemNameByCode(
            @RequestParam("datasource") String datasource,
            @RequestBody List<String> gameEveItemCodes
    );
}
