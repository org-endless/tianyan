package org.endless.tianyan.finance.components.profit.estimate.domain.entity;

import org.endless.tianyan.finance.common.model.domain.entity.*;
import org.endless.tianyan.finance.components.profit.estimate.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ProfitEstimateAggregate
 * <p>预估利润聚合根
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ProfitEstimateAggregate implements TianyanFinanceAggregate {

    /**
     * 预估利润ID
     */
    private final String profitEstimateId;

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
    private final List<ProfitMetricEntity> metrics;

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

    public static ProfitEstimateAggregate create(ProfitEstimateAggregateBuilder builder) {
        return builder
                .profitEstimateId(IdGenerator.of())
                .metrics(builder.metrics == null ? new ArrayList<>() : new ArrayList<>(builder.metrics))
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public ProfitEstimateAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<预估利润聚合根>不能再次删除, ID: " + profitEstimateId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<预估利润聚合根>处于不可删除状态, ID: " + profitEstimateId);
        }
        this.metrics.forEach(metrics -> metrics.remove(modifyUserId));
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    public ProfitEstimateAggregate addMetric(ProfitMetricEntity metric, String modifyUserId) {
        if (metric == null) {
            throw new AggregateAddItemException("聚合根要添加的子实体 ProfitMetricEntity 不能为 null");
        }
        this.metrics.add(metric);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ProfitEstimateAggregate addMetrics(List<ProfitMetricEntity> metrics, String modifyUserId) {
        if (CollectionUtils.isEmpty(metrics)) {
                throw new AggregateAddItemException("聚合根要添加的子实体列表 List<ProfitMetricEntity> 不能为空");
        }
        this.metrics.addAll(metrics);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ProfitEstimateAggregate removeMetric(ProfitMetricEntity metric, String modifyUserId) {
        if (metric == null) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体 ProfitMetricEntity 不能为 null");
        }
        this.metrics.stream()
                .filter(exist -> exist.getProfitMetricId().equals(metric.getProfitMetricId()))
                .findFirst()
                .orElseThrow(() -> new AggregateRemoveItemException("未找到要删除的子实体 ProfitMetricEntity ID: " + metric.getProfitMetricId()))
                .remove(modifyUserId);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public ProfitEstimateAggregate removeMetrics(List<ProfitMetricEntity> metrics, String modifyUserId) {
        if (CollectionUtils.isEmpty(metrics)) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体列表 List<ProfitMetricEntity> 不能为空");
        }
        Set<String> existIds = this.metrics.stream()
                .map(ProfitMetricEntity::getProfitMetricId)
                .collect(Collectors.toSet());
        metrics.forEach(remove -> {
            if (!existIds.contains(remove.getProfitMetricId())) {
                throw new AggregateRemoveItemException("要删除的子实体列表 List<ProfitMetricEntity> 中包含不存在的子实体 ID: " + remove.getProfitMetricId());
            }
            this.metrics.stream()
                    .filter(exist -> exist.getProfitMetricId().equals(remove.getProfitMetricId()))
                    .findFirst()
                    .ifPresent(metric -> metric.remove(modifyUserId));
        });
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public ProfitEstimateAggregate validate() {
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
            throw new AggregateValidateException("预估利润ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new AggregateValidateException("行业ID不能为空");
        }
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new AggregateValidateException("事件类型ID不能为空");
        }
    }

    private void validateCostEstimateId() {
        if (!StringUtils.hasText(costEstimateId)) {
            throw new AggregateValidateException("预估成本ID不能为空");
        }
    }

    private void validateRevenueEstimateId() {
        if (!StringUtils.hasText(revenueEstimateId)) {
            throw new AggregateValidateException("预估收入ID不能为空");
        }
    }

    private void validateTaxEstimateId() {
        if (!StringUtils.hasText(taxEstimateId)) {
            throw new AggregateValidateException("预估税务ID不能为空");
        }
    }

    private void validateFeeEstimateId() {
        if (!StringUtils.hasText(feeEstimateId)) {
            throw new AggregateValidateException("预估费用ID不能为空");
        }
    }

    private void validateMetrics() {
        if (CollectionUtils.isEmpty(metrics)) {
            throw new AggregateValidateException("利润指标列表不能为空");
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
