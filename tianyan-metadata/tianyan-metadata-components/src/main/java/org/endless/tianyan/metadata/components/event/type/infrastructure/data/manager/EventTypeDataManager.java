package org.endless.tianyan.metadata.components.event.type.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
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
 * <p>事件类型聚合数据管理器
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
    @Log(message = "保存事件类型聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public EventTypeAggregate save(EventTypeAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(EventTypeAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存事件类型聚合数据不能为空"));
        eventTypeMapper.save(EventTypeRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(EventTypeAggregate aggregate) {

    }

    @Override
    public EventTypeAggregate modify(EventTypeAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<EventTypeAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<EventTypeAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
