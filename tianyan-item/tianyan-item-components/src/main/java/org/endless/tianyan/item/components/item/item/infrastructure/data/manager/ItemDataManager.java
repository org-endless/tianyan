package org.endless.tianyan.item.components.item.item.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.item.application.query.anticorruption.ItemQueryRepository;
import org.endless.tianyan.item.components.item.item.domain.anticorruption.ItemRepository;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;
import org.endless.tianyan.item.components.item.item.infrastructure.data.persistence.mapper.ItemMapper;
import org.endless.tianyan.item.components.item.item.infrastructure.data.record.ItemRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ItemDataManager
 * <p>资源项聚合数据管理器
 * <p>
 * create 2025/07/23 01:04
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
public class ItemDataManager implements ItemRepository, ItemQueryRepository, TianyanItemAggregateDataManager<ItemRecord, ItemAggregate> {

    /**
     * 资源项聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemMapper itemMapper;

    public ItemDataManager(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    @Log(message = "保存资源项聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ItemAggregate save(ItemAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ItemAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存资源项聚合数据不能为空"));
        itemMapper.save(ItemRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(ItemAggregate aggregate) {

    }

    @Override
    public ItemAggregate modify(ItemAggregate aggregate) {
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
