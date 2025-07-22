package org.endless.tianyan.item.components.item.group.item.group.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.group.item.group.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.group.item.group.domain.entity.*;

/**
 * ItemGroupQueryRepository
 * <p>物品分组聚合查询仓储接口
 * <p>
 * create 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface ItemGroupQueryRepository extends ItemGroupRepository, TianyanItemQueryRepository<ItemGroupAggregate> {
}
