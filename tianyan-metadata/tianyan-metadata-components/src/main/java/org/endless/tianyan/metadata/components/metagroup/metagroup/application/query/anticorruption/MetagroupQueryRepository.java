package org.endless.tianyan.metadata.components.metagroup.metagroup.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.TianyanMetadataQueryRepository;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.anticorruption.MetagroupRepository;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.entity.MetagroupAggregate;

/**
 * MetagroupQueryRepository
 * <p>元分组聚合查询仓储接口
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetagroupRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface MetagroupQueryRepository extends MetagroupRepository, TianyanMetadataQueryRepository<MetagroupAggregate> {

}
