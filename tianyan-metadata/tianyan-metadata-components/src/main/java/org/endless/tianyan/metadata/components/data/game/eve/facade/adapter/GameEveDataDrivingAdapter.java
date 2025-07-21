package org.endless.tianyan.metadata.components.data.game.eve.facade.adapter;

import org.endless.tianyan.metadata.common.model.facade.adapter.TianyanMetadataDrivingAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer.GameEveDataLoadReqCTransfer;

/**
 * GameEveDataDrivingAdapter
 * <p>游戏EVE数据领域主动适配器
 * <p>
 * create 2025/07/20 21:24
 * <p>
 * update 2025/07/20 21:24
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveDataDrivingAdapter extends TianyanMetadataDrivingAdapter {

    void load(GameEveDataLoadReqCTransfer command);
}
