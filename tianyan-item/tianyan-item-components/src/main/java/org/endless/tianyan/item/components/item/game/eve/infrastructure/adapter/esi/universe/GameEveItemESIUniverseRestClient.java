package org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.esi.universe;

import org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.TianyanGameEveESIRestClient;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.transfer.ESIUniverseItemFindProfileRespDTransfer;

/**
 * GameEveItemESIUniverseRestClient
 * <p>
 * create 2025/07/28 05:12
 * <p>
 * update 2025/07/28 05:12
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
public interface GameEveItemESIUniverseRestClient extends TianyanGameEveESIRestClient {

    ESIUniverseItemFindProfileRespDTransfer fetchItem(String gameEveItemCode);
}
