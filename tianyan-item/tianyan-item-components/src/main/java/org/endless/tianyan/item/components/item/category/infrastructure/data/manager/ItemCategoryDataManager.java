package org.endless.tianyan.item.components.item.category.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.category.application.query.anticorruption.ItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.domain.anticorruption.ItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.domain.entity.ItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.infrastructure.data.persistence.mapper.ItemCategoryMapper;
import org.endless.tianyan.item.components.item.category.infrastructure.data.record.ItemCategoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * ItemCategoryDataManager
 * <p>资源项分类聚合根数据管理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see ItemCategoryRepository
 * @see ItemCategoryQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
@Validated
public class ItemCategoryDataManager implements ItemCategoryRepository, ItemCategoryQueryRepository, TianyanItemAggregateDataManager<ItemCategoryRecord, ItemCategoryAggregate> {

    /**
     * 资源项分类聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemCategoryMapper itemCategoryMapper;

    public ItemCategoryDataManager(ItemCategoryMapper itemCategoryMapper) {
        this.itemCategoryMapper = itemCategoryMapper;
    }

    @Override
    @Log(message = "保存资源项分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(ItemCategoryAggregate aggregate) {
        itemCategoryMapper.save(ItemCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除资源项分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(ItemCategoryAggregate aggregate) {
        itemCategoryMapper.remove(ItemCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改资源项分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(ItemCategoryAggregate aggregate) {
        itemCategoryMapper.modify(ItemCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询资源项分类聚合根数据", value = "#itemCategoryId", level = LogLevel.TRACE)
    public Optional<ItemCategoryAggregate> findById(String itemCategoryId) {
        return itemCategoryMapper.findById(itemCategoryId).map(ItemCategoryRecord::to);
    }

    @Override
    public Optional<ItemCategoryAggregate> findByIdForUpdate(String itemCategoryId) {
        return Optional.empty();
    }
}
