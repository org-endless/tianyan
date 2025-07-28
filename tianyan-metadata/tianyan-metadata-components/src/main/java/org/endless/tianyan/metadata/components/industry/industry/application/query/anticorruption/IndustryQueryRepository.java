package org.endless.tianyan.metadata.components.industry.industry.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.industry.industry.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.industry.industry.domain.entity.*;

/**
 * IndustryQueryRepository
 * <p>行业聚合查询仓储接口
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see IndustryRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface IndustryQueryRepository extends IndustryRepository, TianyanMetadataQueryRepository<IndustryAggregate> {
}
