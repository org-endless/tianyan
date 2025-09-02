package org.endless.tianyan.finance.components.taxation.tax.rule.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;
import org.endless.tianyan.finance.components.taxation.tax.rule.domain.entity.TaxRuleAggregate;
import org.endless.tianyan.finance.components.taxation.tax.rule.domain.type.TaxRuleTypeEnum;
import org.endless.tianyan.finance.components.taxation.tax.rule.domain.value.TaxRuleNameValue;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * TaxRuleRecord
 * <p>税务规则数据库记录实体
 * <p>
 * create 2025/07/28 18:34
 * <p>
 * update 2025/07/28 18:34
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
@TableName(value = "taxation_tax_rule")
public class TaxRuleRecord implements TianyanFinanceRecord<TaxRuleAggregate> {

    /**
     * 税务规则ID
     */
    @TableId
    private String taxRuleId;

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
    private String nameNameZh;

    /**
     * 税务规则英文名称
     */
    private String nameNameEn;

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

    public static TaxRuleRecord from(TaxRuleAggregate aggregate) {
        String taxRuleId = aggregate.getTaxRuleId();
        return TaxRuleRecord.builder()
                .taxRuleId(taxRuleId)
                .industryId(aggregate.getIndustryId())
                .type(aggregate.getType())
                .code(aggregate.getCode())
                .nameNameZh(aggregate.getName().getNameZh())
                .nameNameEn(aggregate.getName().getNameEn())
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

    public TaxRuleAggregate to() {
        validate();
        return TaxRuleAggregate.builder()
                .taxRuleId(taxRuleId)
                .industryId(industryId)
                .type(type)
                .code(code)
                .name(TaxRuleNameValue.builder()
                        .nameZh(nameNameZh)
                        .nameEn(nameNameEn)
                        .innerBuild())
                .minBaseAmount(minBaseAmount)
                .maxBaseAmount(maxBaseAmount)
                .percentage(percentage)
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public TaxRuleRecord validate() {
        validateTaxRuleId();
        validateIndustryId();
        validateType();
        validateCode();
        validateNameNameZh();
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
            throw new DataRecordValidateException("税务规则ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new DataRecordValidateException("行业ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("税务规则类型不能为 null ");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("税务规则编码不能为空");
        }
    }

    private void validateNameNameZh() {
        if (!StringUtils.hasText(nameNameZh)) {
            throw new DataRecordValidateException("税务规则中文名称不能为空");
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
