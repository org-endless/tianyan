package org.endless.tianyan.item.components.item.item.infrastructure.data.manager;

import org.endless.tianyan.item.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.item.components.item.item.application.query.anticorruption.*;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.*;
import org.endless.tianyan.item.components.item.item.domain.entity.*;
import org.endless.tianyan.item.components.item.item.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.item.components.item.item.infrastructure.data.record.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * ItemDataManager
 * <p>物品聚合数据管理器
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see ItemRepository
 * @see ItemQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class ItemDataManager implements ItemRepository, ItemQueryRepository, TianyanItemAggregateDataManager<ItemRecord, ItemAggregate> {

    /**
     * 物品聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemMapper itemMapper;

    public ItemDataManager(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemAggregate save(ItemAggregate itemAggregate) {
        return null;
    }

    @Override
    public void remove(ItemAggregate itemAggregate) {

    }

    @Override
    public ItemAggregate modify(ItemAggregate itemAggregate) {
        return null;
    }

    @Override
    public Optional<ItemAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<ItemAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
