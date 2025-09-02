package org.endless.tianyan.metadata.components.event.type.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.event.type.domain.value.EventTypeNameValue;
import org.springframework.validation.annotation.Validated;

/**
 * EventTypeAggregate
 * <p>事件类型聚合根
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class EventTypeAggregate implements TianyanMetadataAggregate {

    /**
     * 事件类型ID
     */
    private final String eventTypeId;

    /**
     * 事件类型编码
     */
    private String code;

    /**
     * 事件类型名称
     */
    private EventTypeNameValue name;

    /**
     * 事件类型描述
     */
    private String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    /**
     * 修改用户ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static EventTypeAggregate create(EventTypeAggregateBuilder builder) {
        return builder
                .eventTypeId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public EventTypeAggregate remove(String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的聚合根<事件类型聚合根>不能再次删除, ID: " + eventTypeId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public EventTypeAggregate validate() {
        return this;
    }
}
