package org.endless.tianyan.metadata.components.event.type.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;
import org.endless.tianyan.metadata.components.event.type.domain.entity.EventTypeAggregate;
import org.endless.tianyan.metadata.components.event.type.domain.value.EventTypeNameValue;
import org.springframework.util.StringUtils;

/**
 * EventTypeRecord
 * <p>事件类型数据库记录实体
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "event_type")
public class EventTypeRecord implements TianyanMetadataRecord<EventTypeAggregate> {

    /**
     * 事件类型ID
     */
    @TableId
    private String eventTypeId;

    /**
     * 事件类型编码
     */
    private String code;

    /**
     * 事件类型中文名称
     */
    private String nameNameZh;

    /**
     * 事件类型英文名称
     */
    private String nameNameEn;

    /**
     * 事件类型描述
     */
    private String description;

    /**
     * 创建者ID
     */
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    /**
     * 删除时间
     */
    private Long removeAt;

    public static EventTypeRecord from(EventTypeAggregate aggregate) {
        String eventTypeId = aggregate.getEventTypeId();
        return EventTypeRecord.builder()
                .eventTypeId(eventTypeId)
                .code(aggregate.getCode())
                .nameNameZh(aggregate.getName().getNameZh())
                .nameNameEn(aggregate.getName().getNameEn())
                .description(aggregate.getDescription())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public EventTypeAggregate to() {
        validate();
        return EventTypeAggregate.builder()
                .eventTypeId(eventTypeId)
                .code(code)
                .name(EventTypeNameValue.builder()
                        .nameZh(nameNameZh)
                        .nameEn(nameNameEn)
                        .innerBuild())
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public EventTypeRecord validate() {
        validateEventTypeId();
        validateCode();
        validateNameNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new DataRecordValidateException("事件类型ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("事件类型编码不能为空");
        }
    }

    private void validateNameNameZh() {
        if (!StringUtils.hasText(nameNameZh)) {
            throw new DataRecordValidateException("事件类型中文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}
