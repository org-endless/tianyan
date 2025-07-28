package org.endless.tianyan.metadata.components.industry.category.application.command.handler;

import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.industry.category.application.command.transfer.IndustryCategoryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.category.domain.entity.IndustryCategoryAggregate;

/**
 * IndustryCategoryCommandHandler
 * <p>行业分类领域命令处理器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<IndustryCategoryAggregate>
 * @since 0.0.1
 */
public interface IndustryCategoryCommandHandler extends TianyanMetadataCommandHandler<IndustryCategoryAggregate> {

    void create(IndustryCategoryCreateReqCTransfer command);

}
