package org.endless.tianyan.item.components.item.item.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.item.domain.entity.*;

/**
 * ItemQueryRepository
 * <p>物品聚合查询仓储接口
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see ItemRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface ItemQueryRepository extends ItemRepository, TianyanItemQueryRepository<ItemAggregate> {
}
