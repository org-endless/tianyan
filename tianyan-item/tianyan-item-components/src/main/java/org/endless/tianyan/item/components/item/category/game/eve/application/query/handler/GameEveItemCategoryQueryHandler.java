package org.endless.tianyan.item.components.item.category.game.eve.application.query.handler;

import org.endless.tianyan.item.common.model.application.query.handler.TianyanItemQueryHandler;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindIdRespQTransfer;

/**
 * GameEveItemCategoryQueryHandler
 * <p>游戏EVE资源项分类领域查询处理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryHandler
 * @since 0.0.1
 */
public interface GameEveItemCategoryQueryHandler extends TianyanItemQueryHandler {

    GameEveItemCategoryFindIdRespQTransfer findIdByCode(GameEveItemCategoryFindByCodeReqQTransfer query);

}
