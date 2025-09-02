package org.endless.tianyan.metadata.components.metagroup.metagroup.application.query.handler.impl;

import org.endless.tianyan.metadata.components.metagroup.metagroup.application.query.anticorruption.MetagroupQueryRepository;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.query.handler.MetagroupQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * MetagroupQueryHandlerImpl
 * <p>元分组领域查询处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetagroupQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class MetagroupQueryHandlerImpl implements MetagroupQueryHandler {

    /**
     * 元分组聚合查询仓储接口
     */
    private final MetagroupQueryRepository metaGroupQueryRepository;

    public MetagroupQueryHandlerImpl(MetagroupQueryRepository metaGroupQueryRepository) {
        this.metaGroupQueryRepository = metaGroupQueryRepository;
    }
}
