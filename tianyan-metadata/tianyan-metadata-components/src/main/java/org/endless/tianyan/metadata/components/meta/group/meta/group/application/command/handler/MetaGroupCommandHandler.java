package org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.handler;

import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateRespCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.entity.MetaGroupAggregate;

/**
 * MetaGroupCommandHandler
 * <p>元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler<MetaGroupAggregate>
 * @since 0.0.1
 */
public interface MetaGroupCommandHandler extends TianyanMetadataCommandHandler<MetaGroupAggregate> {

    MetaGroupCreateRespCTransfer create(MetaGroupCreateReqCTransfer command);

}
