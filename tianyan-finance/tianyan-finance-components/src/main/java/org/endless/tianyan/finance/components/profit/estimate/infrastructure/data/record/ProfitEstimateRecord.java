package org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordAddItemException;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.finance.common.model.infrastructure.data.record.TianyanFinanceRecord;
import org.endless.tianyan.finance.components.profit.estimate.domain.entity.ProfitEstimateAggregate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProfitEstimateRecord
 * <p>预估利润数据库记录实体
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
@TableName(value = "profit_estimate")
public class ProfitEstimateRecord implements TianyanFinanceRecord<ProfitEstimateAggregate> {

    /**
     * 预估利润ID
     */
    @TableId
    private String profitEstimateId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 行业ID
     */
    private String industryId;

    /**
     * 事件类型ID
     */
    private String eventTypeId;

    /**
     * 预估成本ID
     */
    private String costEstimateId;

    /**
     * 预估收入ID
     */
    private String revenueEstimateId;

    /**
     * 预估税务ID
     */
    private String taxEstimateId;

    /**
     * 预估费用ID
     */
    private String feeEstimateId;

    /**
     * 利润指标列表
     */
    @TableField(exist = false)
    @Builder.Default
    private final List<ProfitMetricRecord> metrics = new ArrayList<>();

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

    public static ProfitEstimateRecord from(ProfitEstimateAggregate aggregate) {
        String profitEstimateId = aggregate.getProfitEstimateId();
        return ProfitEstimateRecord.builder()
                .profitEstimateId(profitEstimateId)
                .itemId(aggregate.getItemId())
                .industryId(aggregate.getIndustryId())
                .eventTypeId(aggregate.getEventTypeId())
                .costEstimateId(aggregate.getCostEstimateId())
                .revenueEstimateId(aggregate.getRevenueEstimateId())
                .taxEstimateId(aggregate.getTaxEstimateId())
                .feeEstimateId(aggregate.getFeeEstimateId())
                .metrics(aggregate.getMetrics() == null ? new ArrayList<>() : aggregate.getMetrics().stream()
                        .map(record -> ProfitMetricRecord.from(record, profitEstimateId)).collect(Collectors.toList()))
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public ProfitEstimateAggregate to() {
        validate();
        return ProfitEstimateAggregate.builder()
                .profitEstimateId(profitEstimateId)
                .itemId(itemId)
                .industryId(industryId)
                .eventTypeId(eventTypeId)
                .costEstimateId(costEstimateId)
                .revenueEstimateId(revenueEstimateId)
                .taxEstimateId(taxEstimateId)
                .feeEstimateId(feeEstimateId)
                .metrics(metrics == null ? new ArrayList<>() : metrics.stream()
                        .map(ProfitMetricRecord::to).collect(Collectors.toList()))
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    public ProfitEstimateRecord addMetric(ProfitMetricRecord metric) {
        if (metric == null) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体 ProfitMetricRecord 不能为 null");
        }
        this.metrics.add(metric);
        return this;
    }

    public ProfitEstimateRecord addMetrics(List<ProfitMetricRecord> metrics) {
        if (CollectionUtils.isEmpty(metrics)) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体列表 List<ProfitMetricRecord> 不能为空");
        }
        this.metrics.addAll(metrics);
        return this;
    }

    @Override
    public ProfitEstimateRecord validate() {
        validateProfitEstimateId();
        validateItemId();
        validateIndustryId();
        validateEventTypeId();
        validateCostEstimateId();
        validateRevenueEstimateId();
        validateTaxEstimateId();
        validateFeeEstimateId();
        validateMetrics();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateProfitEstimateId() {
        if (!StringUtils.hasText(profitEstimateId)) {
            throw new DataRecordValidateException("预估利润ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new DataRecordValidateException("行业ID不能为空");
        }
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new DataRecordValidateException("事件类型ID不能为空");
        }
    }

    private void validateCostEstimateId() {
        if (!StringUtils.hasText(costEstimateId)) {
            throw new DataRecordValidateException("预估成本ID不能为空");
        }
    }

    private void validateRevenueEstimateId() {
        if (!StringUtils.hasText(revenueEstimateId)) {
            throw new DataRecordValidateException("预估收入ID不能为空");
        }
    }

    private void validateTaxEstimateId() {
        if (!StringUtils.hasText(taxEstimateId)) {
            throw new DataRecordValidateException("预估税务ID不能为空");
        }
    }

    private void validateFeeEstimateId() {
        if (!StringUtils.hasText(feeEstimateId)) {
            throw new DataRecordValidateException("预估费用ID不能为空");
        }
    }

    private void validateMetrics() {
        if (CollectionUtils.isEmpty(metrics)) {
            throw new DataRecordValidateException("利润指标列表不能为空");
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
