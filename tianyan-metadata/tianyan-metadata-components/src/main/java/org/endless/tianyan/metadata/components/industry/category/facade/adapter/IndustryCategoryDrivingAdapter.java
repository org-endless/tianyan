package org.endless.tianyan.metadata.components.industry.category.facade.adapter;

import org.endless.tianyan.metadata.common.model.facade.adapter.TianyanMetadataDrivingAdapter;
import org.endless.tianyan.metadata.components.industry.category.application.command.transfer.IndustryCategoryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.category.application.query.transfer.IndustryCategoryFindByIdReqQTransfer;

/**
 * IndustryCategoryDrivingAdapter
 * <p>行业分类领域主动适配器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivingAdapter
 * @since 0.0.1
 */
public interface IndustryCategoryDrivingAdapter extends TianyanMetadataDrivingAdapter {

    void create(IndustryCategoryCreateReqCTransfer command);

    void existsById(IndustryCategoryFindByIdReqQTransfer query);
}
