package org.endless.tianyan.metadata.components.event.type.infrastructure.data.manager;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.event.type.application.query.anticorruption.EventTypeQueryRepository;
import org.endless.tianyan.metadata.components.event.type.domain.anticorruption.EventTypeRepository;
import org.endless.tianyan.metadata.components.event.type.domain.entity.EventTypeAggregate;
import org.endless.tianyan.metadata.components.event.type.infrastructure.data.persistence.mapper.EventTypeMapper;
import org.endless.tianyan.metadata.components.event.type.infrastructure.data.record.EventTypeRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * EventTypeDataManager
 * <p>事件类型聚合根数据管理器
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see EventTypeRepository
 * @see EventTypeQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class EventTypeDataManager implements EventTypeRepository, EventTypeQueryRepository, TianyanMetadataAggregateDataManager<EventTypeRecord, EventTypeAggregate> {

    /**
     * 事件类型聚合 Mybatis-Plus 数据访问对象
     */
    private final EventTypeMapper eventTypeMapper;

    public EventTypeDataManager(EventTypeMapper eventTypeMapper) {
        this.eventTypeMapper = eventTypeMapper;
    }

    @Override
    @Log(message = "保存事件类型聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(
            @NotNull(message = "保存事件类型聚合根数据不能为空")
            @Valid EventTypeAggregate aggregate) {
        eventTypeMapper.save(EventTypeRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除事件类型聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(
            @NotNull(message = "删除事件类型聚合根数据不能为空")
            EventTypeAggregate aggregate) {
        eventTypeMapper.remove(EventTypeRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改事件类型聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(
            @NotNull(message = "修改事件类型聚合根数据不能为空")
            @Valid EventTypeAggregate aggregate) {
        eventTypeMapper.modify(EventTypeRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询事件类型聚合根数据", value = "#eventTypeId", level = LogLevel.TRACE)
    public Optional<EventTypeAggregate> findById(
            @NotBlank(message = "事件类型数据ID不能为空") String eventTypeId) {
        return eventTypeMapper.findById(eventTypeId).map(EventTypeRecord::to);
    }

    @Override
    public Optional<EventTypeAggregate> findByIdForUpdate(String eventTypeId) {
        return Optional.empty();
    }
}
