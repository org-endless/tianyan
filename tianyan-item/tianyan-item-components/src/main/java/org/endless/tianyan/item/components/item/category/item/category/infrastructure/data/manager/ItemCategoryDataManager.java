package org.endless.tianyan.item.components.item.category.item.category.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.category.item.category.application.query.anticorruption.ItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.item.category.domain.anticorruption.ItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.item.category.domain.entity.ItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.item.category.infrastructure.data.persistence.mapper.ItemCategoryMapper;
import org.endless.tianyan.item.components.item.category.item.category.infrastructure.data.record.ItemCategoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ItemCategoryDataManager
 * <p>物品分类聚合数据管理器
 * <p>
 * create 2025/07/20 22:39
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
public class ItemCategoryDataManager implements ItemCategoryRepository, ItemCategoryQueryRepository, TianyanItemAggregateDataManager<ItemCategoryRecord, ItemCategoryAggregate> {

    /**
     * 物品分类聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemCategoryMapper itemCategoryMapper;

    public ItemCategoryDataManager(ItemCategoryMapper itemCategoryMapper) {
        this.itemCategoryMapper = itemCategoryMapper;
    }

    @Override
    @Log(message = "保存物品分类聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ItemCategoryAggregate save(ItemCategoryAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ItemCategoryAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存物品分类聚合数据不能为空"));
        itemCategoryMapper.save(ItemCategoryRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(ItemCategoryAggregate aggregate) {

    }

    @Override
    public ItemCategoryAggregate modify(ItemCategoryAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<ItemCategoryAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<ItemCategoryAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
