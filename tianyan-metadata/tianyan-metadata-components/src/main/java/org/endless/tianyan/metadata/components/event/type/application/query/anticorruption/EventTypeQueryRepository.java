package org.endless.tianyan.metadata.components.event.type.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.event.type.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.event.type.domain.entity.*;

/**
 * EventTypeQueryRepository
 * <p>事件类型聚合查询仓储接口
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see EventTypeRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface EventTypeQueryRepository extends EventTypeRepository, TianyanMetadataQueryRepository<EventTypeAggregate> {
}
