package org.endless.tianyan.finance.components.cost.type.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;
import org.endless.tianyan.finance.components.cost.type.domain.entity.CostTypeAggregate;
import org.endless.tianyan.finance.components.cost.type.domain.value.CostTypeNameValue;
import org.springframework.util.StringUtils;

/**
 * CostTypeRecord
 * <p>成本类型数据库记录实体
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "cost_type")
public class CostTypeRecord implements TianyanFinanceRecord<CostTypeAggregate> {

    /**
     * 成本类型ID
     */
    @TableId
    private String costTypeId;

    /**
     * 成本类型编码
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
     * 描述
     */
    private String description;

    /**
     * 创建用户ID
     */
    private String createUserId;

    /**
     * 修改用户ID
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

    public static CostTypeRecord from(CostTypeAggregate aggregate) {
        String costTypeId = aggregate.getCostTypeId();
        return CostTypeRecord.builder()
                .costTypeId(costTypeId)
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

    @Override
    public CostTypeRecord validate() {
        validateCostTypeId();
        validateCode();
        validateNameNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    public CostTypeAggregate to() {
        validate();
        return CostTypeAggregate.builder()
                .costTypeId(costTypeId)
                .code(code)
                .name(CostTypeNameValue.builder()
                        .nameZh(nameNameZh)
                        .nameEn(nameNameEn)
                        .innerBuild())
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    private void validateCostTypeId() {
        if (!StringUtils.hasText(costTypeId)) {
            throw new DataRecordValidateException("成本类型ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("成本类型编码不能为空");
        }
    }

    private void validateNameNameZh() {
        if (!StringUtils.hasText(nameNameZh)) {
            throw new DataRecordValidateException("事件类型中文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建用户ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改用户ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}
