package org.endless.tianyan.metadata.components.industry.industry.infrastructure.data.persistence.mapper;

import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.components.industry.industry.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * IndustryMapper
 * <p>行业聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface IndustryMapper extends TianyanMetadataMapper<IndustryRecord> {
}
