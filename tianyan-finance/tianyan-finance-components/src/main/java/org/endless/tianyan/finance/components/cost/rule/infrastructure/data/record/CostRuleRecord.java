package org.endless.tianyan.finance.components.cost.rule.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;
import org.endless.tianyan.finance.components.cost.rule.domain.entity.CostRuleAggregate;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * CostRuleRecord
 * <p>成本规则数据库记录实体
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
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
@TableName(value = "cost_rule")
public class CostRuleRecord implements TianyanFinanceRecord<CostRuleAggregate> {

    /**
     * 成本规则ID
     */
    @TableId
    private String costRuleId;

    /**
     * 行业ID
     */
    private String industryId;

    /**
     * 事件ID
     */
    private String eventTypeId;

    /**
     * 成本类型ID
     */
    private String costTypeId;

    /**
     * 成本规则最小基准金额(17, 2)
     */
    private BigDecimal minBaseAmount;

    /**
     * 成本规则最大基准金额(17, 2)
     */
    private BigDecimal maxBaseAmount;

    /**
     * 成本规则比例(5, 2)
     */
    private BigDecimal percentage;

    /**
     * 成本规则描述
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

    public static CostRuleRecord from(CostRuleAggregate aggregate) {
        String costRuleId = aggregate.getCostRuleId();
        return CostRuleRecord.builder()
                .costRuleId(costRuleId)
                .industryId(aggregate.getIndustryId())
                .eventTypeId(aggregate.getEventTypeId())
                .costTypeId(aggregate.getCostTypeId())
                .minBaseAmount(aggregate.getMinBaseAmount())
                .maxBaseAmount(aggregate.getMaxBaseAmount())
                .percentage(aggregate.getPercentage())
                .description(aggregate.getDescription())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @Override
    public CostRuleRecord validate() {
        validateCostRuleId();
        validateIndustryId();
        validateEventTypeId();
        validateCostTypeId();
        validateMinBaseAmount();
        validateMaxBaseAmount();
        validatePercentage();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    public CostRuleAggregate to() {
        validate();
        return CostRuleAggregate.builder()
                .costRuleId(costRuleId)
                .industryId(industryId)
                .eventTypeId(eventTypeId)
                .costTypeId(costTypeId)
                .minBaseAmount(minBaseAmount)
                .maxBaseAmount(maxBaseAmount)
                .percentage(percentage)
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    private void validateCostRuleId() {
        if (!StringUtils.hasText(costRuleId)) {
            throw new DataRecordValidateException("成本规则ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new DataRecordValidateException("行业ID不能为空");
        }
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new DataRecordValidateException("事件ID不能为空");
        }
    }

    private void validateCostTypeId() {
        if (!StringUtils.hasText(costTypeId)) {
            throw new DataRecordValidateException("成本类型ID不能为空");
        }
    }

    private void validateMinBaseAmount() {
        DecimalTools.validateAmount(minBaseAmount);
    }

    private void validateMaxBaseAmount() {
        DecimalTools.validateAmount(maxBaseAmount);
    }

    private void validatePercentage() {
        DecimalTools.validatePercentage(percentage);
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
