package org.endless.tianyan.manufacturing.components.blueprint.game.eve.facade.adapter;

import org.endless.tianyan.manufacturing.common.model.facade.adapter.TianyanManufacturingDrivingAdapter;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer.GameEveBlueprintCreateReqCTransfer;

/**
 * GameEveBlueprintDrivingAdapter
 * <p>游戏EVE蓝图领域主动适配器
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveBlueprintDrivingAdapter extends TianyanManufacturingDrivingAdapter {

    void create(GameEveBlueprintCreateReqCTransfer command);
}
