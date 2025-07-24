package org.endless.tianyan.item.components.item.item.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateReqCTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateRespCTransfer;

/**
 * ItemDrivingAdapter
 * <p>资源项领域主动适配器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface ItemDrivingAdapter extends TianyanItemDrivingAdapter {

    ItemCreateRespCTransfer create(ItemCreateReqCTransfer command);
}
