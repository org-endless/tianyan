package org.endless.tianyan.metadata.components.industry.category.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.TianyanMetadataQueryRepository;
import org.endless.tianyan.metadata.components.industry.category.domain.anticorruption.IndustryCategoryRepository;
import org.endless.tianyan.metadata.components.industry.category.domain.entity.IndustryCategoryAggregate;

/**
 * IndustryCategoryQueryRepository
 * <p>行业分类聚合查询仓储接口
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see IndustryCategoryRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface IndustryCategoryQueryRepository extends IndustryCategoryRepository, TianyanMetadataQueryRepository<IndustryCategoryAggregate> {

    Boolean existsById(String industryCategoryId);
}
