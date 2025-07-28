package org.endless.tianyan.item.components.item.game.eve.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchReqCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.command.transfer.GameEveItemFetchRespCTransfer;
import org.endless.tianyan.item.components.item.game.eve.application.query.transfer.*;

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

    GameEveItemFetchRespCTransfer fetch(GameEveItemFetchReqCTransfer command);

    GameEveItemFindItemIdRespQTransfer findItemIdByCode(GameEveItemFindByCodeReqQTransfer query);

    GameEveItemFindItemIdsRespQTransfer findItemIdsByCodes(GameEveItemFindByCodesReqQTransfer query);

    GameEveItemFindCodeRespQTransfer findCodeByItemId(GameEveItemFindByItemIdReqQTransfer query);
}
