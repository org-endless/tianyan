package org.endless.tianyan.item.components.item.game.eve.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindByItemIdReqQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindCodeRespQTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.GameEveItemFindItemIdRespQTransfer;

/**
 * GameEveItemDrivingAdapter
 * <p>游戏EVE资源项领域主动适配器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveItemDrivingAdapter extends TianyanItemDrivingAdapter {

    void create(GameEveItemCreateReqCTransfer command);

    GameEveItemFindItemIdRespQTransfer findItemIdByCode(GameEveItemFindByCodeReqQTransfer query);

    GameEveItemFindCodeRespQTransfer findCodeByItemId(GameEveItemFindByItemIdReqQTransfer query);
}
