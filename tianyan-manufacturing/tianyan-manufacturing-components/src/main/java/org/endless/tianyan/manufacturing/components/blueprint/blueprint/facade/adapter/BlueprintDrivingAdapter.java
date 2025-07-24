package org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter;

import org.endless.tianyan.manufacturing.common.model.facade.adapter.TianyanManufacturingDrivingAdapter;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateReqCTransfer;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer.BlueprintCreateRespCTransfer;

/**
 * BlueprintDrivingAdapter
 * <p>蓝图领域主动适配器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 * update 2025/07/24 09:43
 * update 2025/07/24 09:43
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingDrivingAdapter
 * @since 0.0.1
 */
public interface BlueprintDrivingAdapter extends TianyanManufacturingDrivingAdapter {

    BlueprintCreateRespCTransfer create(BlueprintCreateReqCTransfer command);
}
