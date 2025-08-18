package org.endless.tianyan.item.components.item.group.game.eve.application.query.handler;

import org.endless.tianyan.item.common.model.application.query.handler.TianyanItemQueryHandler;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindIdRespQReqTransfer;

/**
 * GameEveItemGroupQueryHandler
 * <p>游戏EVE资源项分组领域查询处理器
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryHandler
 * @since 0.0.1
 */
public interface GameEveItemGroupQueryHandler extends TianyanItemQueryHandler {

    GameEveItemGroupFindIdRespQReqTransfer findItemGroupIdByCode(GameEveItemGroupFindByCodeReqQReqTransfer query);

}
