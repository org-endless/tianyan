package org.endless.tianyan.metadata.components.industry.category.application.query.handler;

import org.endless.tianyan.metadata.common.model.application.query.handler.TianyanMetadataQueryHandler;
import org.endless.tianyan.metadata.components.industry.category.application.query.transfer.IndustryCategoryFindByIdReqQReqTransfer;

/**
 * IndustryCategoryQueryHandler
 * <p>行业分类领域查询处理器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataQueryHandler
 * @since 0.0.1
 */
public interface IndustryCategoryQueryHandler extends TianyanMetadataQueryHandler {

    void existsById(IndustryCategoryFindByIdReqQReqTransfer query);

}
