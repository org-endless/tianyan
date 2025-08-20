package org.endless.tianyan.item.components.item.group.game.eve.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer.GameEveItemGroupCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer.GameEveItemGroupFindIdRespQReqTransfer;

/**
 * GameEveItemGroupDrivingAdapter
 * <p>游戏EVE资源项分组领域主动适配器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveItemGroupDrivingAdapter extends TianyanItemDrivingAdapter {

    void create(GameEveItemGroupCreateReqCReqTransfer command);

    GameEveItemGroupFindIdRespQReqTransfer findItemGroupIdByCode(GameEveItemGroupFindByCodeReqQReqTransfer query);
}
