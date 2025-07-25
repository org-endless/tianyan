package org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.handler.impl;

import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.anticorruption.MetaGroupQueryRepository;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.handler.MetaGroupQueryHandler;

/**
 * MetaGroupQueryHandlerImpl
 * <p>元分组领域查询处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetaGroupQueryHandler
 * @since 0.0.1
 */
public class MetaGroupQueryHandlerImpl implements MetaGroupQueryHandler {

    /**
     * 元分组聚合查询仓储接口
     */
    private final MetaGroupQueryRepository metaGroupQueryRepository;

    public MetaGroupQueryHandlerImpl(MetaGroupQueryRepository metaGroupQueryRepository) {
        this.metaGroupQueryRepository = metaGroupQueryRepository;
    }
}
