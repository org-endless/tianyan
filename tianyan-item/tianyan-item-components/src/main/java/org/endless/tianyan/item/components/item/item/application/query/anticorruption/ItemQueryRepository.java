package org.endless.tianyan.item.components.item.item.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.ItemRepository;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;

/**
 * ItemQueryRepository
 * <p>资源项聚合查询仓储接口
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see ItemRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface ItemQueryRepository extends ItemRepository, TianyanItemQueryRepository<ItemAggregate> {

}
