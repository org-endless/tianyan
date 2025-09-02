package org.endless.tianyan.item.components.item.group.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.group.application.query.anticorruption.ItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.domain.anticorruption.ItemGroupRepository;
import org.endless.tianyan.item.components.item.group.domain.entity.ItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.infrastructure.data.persistence.mapper.ItemGroupMapper;
import org.endless.tianyan.item.components.item.group.infrastructure.data.record.ItemGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * ItemGroupDataManager
 * <p>资源项分组聚合根数据管理器
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
@Validated
public class ItemGroupDataManager implements ItemGroupRepository, ItemGroupQueryRepository, TianyanItemAggregateDataManager<ItemGroupRecord, ItemGroupAggregate> {

    /**
     * 资源项分组聚合 Mybatis-Plus 数据访问对象
     */
    private final ItemGroupMapper itemGroupMapper;

    public ItemGroupDataManager(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    @Override
    @Log(message = "保存资源项分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(ItemGroupAggregate aggregate) {
        itemGroupMapper.save(ItemGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除资源项分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(ItemGroupAggregate aggregate) {
        itemGroupMapper.remove(ItemGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改资源项分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(ItemGroupAggregate aggregate) {
        itemGroupMapper.modify(ItemGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询资源项分组聚合根数据", value = "#itemGroupId", level = LogLevel.TRACE)
    public Optional<ItemGroupAggregate> findById(String itemGroupId) {
        return itemGroupMapper.findById(itemGroupId).map(ItemGroupRecord::to);
    }

    @Override
    public Optional<ItemGroupAggregate> findByIdForUpdate(String itemGroupId) {
        return Optional.empty();
    }
}
