package org.endless.tianyan.item.components.item.group.item.group.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateReqCTransfer;
import org.endless.tianyan.item.components.item.group.item.group.application.command.transfer.ItemGroupCreateRespCTransfer;

/**
 * ItemGroupDrivingAdapter
 * <p>资源项分组领域主动适配器
 * <p>
 * create 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface ItemGroupDrivingAdapter extends TianyanItemDrivingAdapter {

    ItemGroupCreateRespCTransfer create(ItemGroupCreateReqCTransfer command);
}
