package org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter;

import org.endless.tianyan.metadata.common.model.facade.adapter.TianyanMetadataDrivingAdapter;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateRespCTransfer;

/**
 * MetaGroupDrivingAdapter
 * <p>元分组领域主动适配器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivingAdapter
 * @since 0.0.1
 */
public interface MetaGroupDrivingAdapter extends TianyanMetadataDrivingAdapter {

    MetaGroupCreateRespCTransfer create(MetaGroupCreateReqCTransfer command);
}
