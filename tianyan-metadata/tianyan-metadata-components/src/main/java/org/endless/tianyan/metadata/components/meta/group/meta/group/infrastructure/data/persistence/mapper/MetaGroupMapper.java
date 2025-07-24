package org.endless.tianyan.metadata.components.meta.group.meta.group.infrastructure.data.persistence.mapper;

import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.components.meta.group.meta.group.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * MetaGroupMapper
 * <p>元分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MetaGroupMapper extends TianyanMetadataMapper<MetaGroupRecord> {
}
