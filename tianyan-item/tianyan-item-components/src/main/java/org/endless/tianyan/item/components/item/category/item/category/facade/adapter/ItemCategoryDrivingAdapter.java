package org.endless.tianyan.item.components.item.category.item.category.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.item.category.application.command.transfer.ItemCategoryCreateRespCTransfer;

/**
 * ItemCategoryDrivingAdapter
 * <p>资源项分类领域主动适配器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface ItemCategoryDrivingAdapter extends TianyanItemDrivingAdapter {

    ItemCategoryCreateRespCTransfer create(ItemCategoryCreateReqCTransfer command);
}
