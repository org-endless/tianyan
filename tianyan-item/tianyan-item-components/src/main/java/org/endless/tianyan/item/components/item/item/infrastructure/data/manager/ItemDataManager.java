package org.endless.tianyan.item.components.item.item.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.item.application.query.anticorruption.ItemQueryRepository;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.ItemRepository;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;
import org.endless.tianyan.item.components.item.item.infrastructure.data.persistence.mapper.ItemMapper;
import org.endless.tianyan.item.components.item.item.infrastructure.data.record.ItemRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * ItemDataManager
 * <p>资源项聚合根数据管理器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see ItemRepository
 * @see ItemQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
@Validated
public class ItemDataManager implements ItemRepository, ItemQueryRepository, TianyanItemAggregateDataManager<ItemRecord, ItemAggregate> {

    /**
     * 资源项聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemMapper itemMapper;

    public ItemDataManager(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    @Log(message = "保存资源项聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(ItemAggregate aggregate) {
        itemMapper.save(ItemRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除资源项聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(ItemAggregate aggregate) {
        itemMapper.remove(ItemRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改资源项聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(ItemAggregate aggregate) {
        itemMapper.modify(ItemRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询资源项聚合根数据", value = "#itemId", level = LogLevel.TRACE)
    public Optional<ItemAggregate> findById(String itemId) {
        return itemMapper.findById(itemId).map(ItemRecord::to);
    }

    @Override
    public Optional<ItemAggregate> findByIdForUpdate(String itemId) {
        return Optional.empty();
    }
}
