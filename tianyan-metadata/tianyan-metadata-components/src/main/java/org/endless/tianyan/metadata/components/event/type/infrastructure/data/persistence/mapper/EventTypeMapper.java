package org.endless.tianyan.metadata.components.event.type.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.TianyanMetadataMapper;
import org.endless.tianyan.metadata.components.event.type.infrastructure.data.record.EventTypeRecord;
import org.springframework.context.annotation.Lazy;

/**
 * EventTypeMapper
 * <p>事件类型聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface EventTypeMapper extends TianyanMetadataMapper<EventTypeRecord> {

}
