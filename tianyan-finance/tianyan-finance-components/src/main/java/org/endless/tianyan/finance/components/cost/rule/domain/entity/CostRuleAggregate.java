package org.endless.tianyan.finance.components.cost.rule.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * CostRuleAggregate
 * <p>成本规则聚合根
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see TianyanFinanceAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class CostRuleAggregate implements TianyanFinanceAggregate {

    /**
     * 成本规则ID
     */
    private final String costRuleId;

    /**
     * 创建者ID
     */
    private final String createUserId;

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
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static CostRuleAggregate create(CostRuleAggregateBuilder builder) {
        return builder
                .costRuleId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    @Override
    public CostRuleAggregate validate() {
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

    private void validateCostRuleId() {
        if (!StringUtils.hasText(costRuleId)) {
            throw new AggregateValidateException("成本规则ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new AggregateValidateException("行业ID不能为空");
        }
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new AggregateValidateException("事件ID不能为空");
        }
    }

    private void validateCostTypeId() {
        if (!StringUtils.hasText(costTypeId)) {
            throw new AggregateValidateException("成本类型ID不能为空");
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

    public CostRuleAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<成本规则聚合根>不能再次删除, ID: " + costRuleId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<成本规则聚合根>处于不可删除状态, ID: " + costRuleId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }
}
