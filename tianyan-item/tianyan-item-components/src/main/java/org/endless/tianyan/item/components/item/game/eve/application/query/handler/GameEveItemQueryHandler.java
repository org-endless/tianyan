package org.endless.tianyan.item.components.item.game.eve.application.query.handler;

import org.endless.tianyan.item.common.model.application.query.handler.TianyanItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByItemIdReqQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindCodeRespQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindItemIdRespQTransfer;

/**
 * GameEveItemQueryHandler
 * <p>游戏EVE资源项领域查询处理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryHandler
 * @since 0.0.1
 */
public interface GameEveItemQueryHandler extends TianyanItemQueryHandler {

    GameEveItemFindItemIdRespQTransfer findItemIdByCode(GameEveItemFindByCodeReqQTransfer query);

    GameEveItemFindCodeRespQTransfer findCodeByItemId(GameEveItemFindByItemIdReqQTransfer query);

}
