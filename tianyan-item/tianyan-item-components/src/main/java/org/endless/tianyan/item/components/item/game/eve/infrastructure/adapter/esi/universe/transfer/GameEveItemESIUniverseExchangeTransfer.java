package org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.esi.universe.transfer;

import org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.transfer.TianyanGameEveESIExchangeTransfer;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.transfer.ESIUniverseItemFindProfileRespDTransfer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * GameEveItemESIUniverseExchangeTransfer
 * <p>
 * create 2025/07/28 05:14
 * <p>
 * update 2025/07/28 05:14
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface GameEveItemESIUniverseExchangeTransfer extends TianyanGameEveESIExchangeTransfer {

    @GetExchange("/universe/types/{type_id}/")
    ESIUniverseItemFindProfileRespDTransfer fetchItem(
            @PathVariable("type_id") String itemCode,
            @RequestParam("datasource") String datasource,
            @RequestParam("language") String language
    );
}
