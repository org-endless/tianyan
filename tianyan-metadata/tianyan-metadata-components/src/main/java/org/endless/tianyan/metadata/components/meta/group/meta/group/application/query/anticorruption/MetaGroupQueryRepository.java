package org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.entity.*;

/**
 * MetaGroupQueryRepository
 * <p>元分组聚合查询仓储接口
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetaGroupRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface MetaGroupQueryRepository extends MetaGroupRepository, TianyanMetadataQueryRepository<MetaGroupAggregate> {
}
