package org.endless.tianyan.finance.components.taxation.tax.rule.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;
import org.endless.tianyan.finance.components.taxation.tax.rule.domain.type.TaxRuleTypeEnum;
import org.endless.tianyan.finance.components.taxation.tax.rule.domain.value.TaxRuleNameValue;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * TaxRuleAggregate
 * <p>税务规则聚合根
 * <p>
 * create 2025/07/28 18:34
 * <p>
 * update 2025/07/28 18:34
 *
 * @author Deng Haozhi
 * @see TianyanFinanceAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class TaxRuleAggregate implements TianyanFinanceAggregate {

    /**
     * 税务规则ID
     */
    private final String taxRuleId;

    /**
     * 行业ID
     */
    private String industryId;

    /**
     * 税务规则类型
     */
    private TaxRuleTypeEnum type;

    /**
     * 税务规则编码
     */
    private String code;

    /**
     * 税务规则中文名称
     */
    private TaxRuleNameValue name;

    /**
     * 税务规则最小基准金额(17, 2)
     */
    private BigDecimal minBaseAmount;

    /**
     * 税务规则最大基准金额(17, 2)
     */
    private BigDecimal maxBaseAmount;

    /**
     * 税务规则比例(5, 2)
     */
    private BigDecimal percentage;

    /**
     * 税务规则描述
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

    public static TaxRuleAggregate create(TaxRuleAggregateBuilder builder) {
        return builder
                .taxRuleId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public TaxRuleAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<税务规则聚合根>不能再次删除, ID: " + taxRuleId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<税务规则聚合根>处于不可删除状态, ID: " + taxRuleId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public TaxRuleAggregate validate() {
        validateTaxRuleId();
        validateIndustryId();
        validateType();
        validateCode();
        validateName();
        validateMinBaseAmount();
        validateMaxBaseAmount();
        validatePercentage();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateTaxRuleId() {
        if (!StringUtils.hasText(taxRuleId)) {
            throw new AggregateValidateException("税务规则ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new AggregateValidateException("行业ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new AggregateValidateException("税务规则类型不能为 null ");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("税务规则编码不能为空");
        }
    }

    private void validateName() {
        if (name == null) {
            throw new AggregateValidateException("税务规则中文名称不能为 null ");
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
}
