package org.endless.tianyan.metadata.components.industry.industry.application.command.handler;

import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.industry.domain.entity.IndustryAggregate;

/**
 * IndustryCommandHandler
 * <p>行业领域命令处理器
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<IndustryAggregate>
 * @since 0.0.1
 */
public interface IndustryCommandHandler extends TianyanMetadataCommandHandler<IndustryAggregate> {

    void create(IndustryCreateReqCTransfer command);

}
