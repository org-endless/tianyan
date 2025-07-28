package org.endless.tianyan.metadata.components.industry.industry.facade.adapter;

import org.endless.tianyan.metadata.common.model.facade.adapter.TianyanMetadataDrivingAdapter;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCTransfer;

/**
 * IndustryDrivingAdapter
 * <p>行业领域主动适配器
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivingAdapter
 * @since 0.0.1
 */
public interface IndustryDrivingAdapter extends TianyanMetadataDrivingAdapter {

    void create(IndustryCreateReqCTransfer command);
}
