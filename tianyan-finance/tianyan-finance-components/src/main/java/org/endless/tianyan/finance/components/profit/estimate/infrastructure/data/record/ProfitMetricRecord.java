package org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.ddd.starter.common.utils.model.decimal.DecimalTools;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;
import org.endless.tianyan.finance.components.profit.estimate.domain.entity.ProfitMetricEntity;
import org.endless.tianyan.finance.components.profit.estimate.domain.type.ProfitMetricTypeEnum;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * ProfitMetricRecord
 * <p>利润指标数据库记录实体
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
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
@TableName(value = "profit_metric")
public class ProfitMetricRecord implements TianyanFinanceRecord<ProfitMetricEntity> {

    /**
     * 利润指标ID
     */
    @TableId
    private String profitMetricId;

    /**
     * 预估利润ID
     */
    private String profitEstimateId;

    /**
     * 利润指标类型
     */
    private ProfitMetricTypeEnum type;

    /**
     * 利润金额(17, 2)
     */
    private BigDecimal amount;

    /**
     * 利润率百分比(5, 2)
     */
    private BigDecimal marginPercentage;

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

    public static ProfitMetricRecord from(ProfitMetricEntity entity, String profitEstimateId) {
        return ProfitMetricRecord.builder()
                .profitMetricId(entity.getProfitMetricId())
                .profitEstimateId(profitEstimateId)
                .type(entity.getType())
                .amount(entity.getAmount())
                .marginPercentage(entity.getMarginPercentage())
                .createUserId(entity.getCreateUserId())
                .modifyUserId(entity.getModifyUserId())
                .isRemoved(entity.getIsRemoved())
                .build()
                .validate();
    }

    protected ProfitMetricEntity to() {
        validate();
        return ProfitMetricEntity.builder()
                .profitMetricId(profitMetricId)
                .type(type)
                .amount(amount)
                .marginPercentage(marginPercentage)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public ProfitMetricRecord validate() {
        validateProfitMetricId();
        validateProfitEstimateId();
        validateType();
        validateAmount();
        validateMarginPercentage();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateProfitMetricId() {
        if (!StringUtils.hasText(profitMetricId)) {
            throw new DataRecordValidateException("利润指标ID不能为空");
        }
    }

    private void validateProfitEstimateId() {
        if (!StringUtils.hasText(profitEstimateId)) {
            throw new DataRecordValidateException("预估利润ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("利润指标类型不能为 null ");
        }
    }

    private void validateAmount() {
        DecimalTools.validateAmount(amount);
    }

    private void validateMarginPercentage() {
        DecimalTools.validatePercentage(marginPercentage);
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
