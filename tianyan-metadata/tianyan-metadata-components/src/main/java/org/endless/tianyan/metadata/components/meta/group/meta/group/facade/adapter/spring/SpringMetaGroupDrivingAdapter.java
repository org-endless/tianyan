package org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.spring;

import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.handler.MetaGroupCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateRespCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.handler.MetaGroupQueryHandler;
import org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.MetaGroupDrivingAdapter;

/**
 * SpringMetaGroupDrivingAdapter
 * <p>元分组领域主动适配器Spring实现类
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetaGroupDrivingAdapter
 * @since 0.0.1
 */
public class SpringMetaGroupDrivingAdapter implements MetaGroupDrivingAdapter {

    /**
     * 元分组领域命令处理器
     */
    private final MetaGroupCommandHandler metaGroupCommandHandler;

    /**
     * 元分组领域查询处理器
     */
    private final MetaGroupQueryHandler metaGroupQueryHandler;

    public SpringMetaGroupDrivingAdapter(MetaGroupCommandHandler metaGroupCommandHandler, MetaGroupQueryHandler metaGroupQueryHandler) {
        this.metaGroupCommandHandler = metaGroupCommandHandler;
        this.metaGroupQueryHandler = metaGroupQueryHandler;
    }

    @Override
    public MetaGroupCreateRespCTransfer create(MetaGroupCreateReqCTransfer command) {
        return metaGroupCommandHandler.create(command);
    }
}
