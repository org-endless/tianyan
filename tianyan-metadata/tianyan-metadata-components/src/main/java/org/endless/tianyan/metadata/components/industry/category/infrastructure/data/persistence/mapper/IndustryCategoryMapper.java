package org.endless.tianyan.metadata.components.industry.category.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.TianyanMetadataMapper;
import org.endless.tianyan.metadata.components.industry.category.infrastructure.data.record.IndustryCategoryRecord;
import org.springframework.context.annotation.Lazy;

/**
 * IndustryCategoryMapper
 * <p>行业分类聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface IndustryCategoryMapper extends TianyanMetadataMapper<IndustryCategoryRecord> {

}
