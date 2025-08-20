package org.endless.tianyan.item.components.item.group.item.group.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.group.item.group.application.query.anticorruption.ItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.item.group.domain.anticorruption.ItemGroupRepository;
import org.endless.tianyan.item.components.item.group.item.group.domain.entity.ItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.item.group.infrastructure.data.persistence.mapper.ItemGroupMapper;
import org.endless.tianyan.item.components.item.group.item.group.infrastructure.data.record.ItemGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ItemGroupDataManager
 * <p>资源项分组聚合数据管理器
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see ItemGroupRepository
 * @see ItemGroupQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class ItemGroupDataManager implements ItemGroupRepository, ItemGroupQueryRepository, TianyanItemAggregateDataManager<ItemGroupRecord, ItemGroupAggregate> {

    /**
     * 资源项分组聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemGroupMapper itemGroupMapper;

    public ItemGroupDataManager(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    @Override
    @Log(message = "保存资源项分组聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public ItemGroupAggregate save(ItemGroupAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(ItemGroupAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存资源项分组聚合数据不能为空"));
        itemGroupMapper.save(ItemGroupRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(ItemGroupAggregate aggregate) {

    }

    @Override
    public ItemGroupAggregate modify(ItemGroupAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<ItemGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<ItemGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
