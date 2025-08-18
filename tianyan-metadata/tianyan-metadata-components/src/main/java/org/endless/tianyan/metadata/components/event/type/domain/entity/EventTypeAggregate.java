package org.endless.tianyan.metadata.components.event.type.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.event.type.domain.value.EventTypeNameValue;
import org.springframework.util.StringUtils;

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
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 修改者ID
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
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<事件类型聚合根>不能再次删除, ID: " + eventTypeId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<事件类型聚合根>处于不可删除状态, ID: " + eventTypeId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public EventTypeAggregate validate() {
        validateEventTypeId();
        validateCode();
        validateName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new AggregateValidateException("事件类型ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("事件类型编码不能为空");
        }
    }

    private void validateName() {
        if (name == null) {
            throw new AggregateValidateException("事件类型名称不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}
