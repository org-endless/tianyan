package org.endless.tianyan.item.components.item.category.item.category.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper.TianyanItemMapper;
import org.endless.tianyan.item.components.item.category.item.category.infrastructure.data.record.ItemCategoryRecord;
import org.springframework.context.annotation.Lazy;

/**
 * ItemCategoryMapper
 * <p>资源项分类聚合 Mybatis-Plus 数据访问对象
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface ItemCategoryMapper extends TianyanItemMapper<ItemCategoryRecord> {

}
