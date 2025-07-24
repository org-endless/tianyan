package org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter;

import org.endless.tianyan.metadata.common.model.facade.adapter.TianyanMetadataDrivingAdapter;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindByCodeReqQTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindMetaGroupIdRespQTransfer;

/**
 * GameEveMetaGroupDrivingAdapter
 * <p>游戏EVE元分组领域主动适配器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveMetaGroupDrivingAdapter extends TianyanMetadataDrivingAdapter {

    void create(GameEveMetaGroupCreateReqCTransfer command);

    GameEveMetaGroupFindMetaGroupIdRespQTransfer findMetaGroupIdByCode(GameEveMetaGroupFindByCodeReqQTransfer query);
}
