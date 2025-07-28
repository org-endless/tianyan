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
 * ProfitMetricEntity
 * <p>利润指标实体
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceEntity
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ProfitMetricEntity implements TianyanFinanceEntity {

    /**
     * 利润指标ID
     */
    private final String profitMetricId;

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
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static ProfitMetricEntity create(ProfitMetricEntityBuilder builder) {
        return builder
                .profitMetricId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    protected ProfitMetricEntity remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new EntityRemoveException("已经被删除的实体<利润指标实体>不能再次删除, ID: " + profitMetricId);
        }
        if (!canRemove()) {
            throw new EntityRemoveException("实体<利润指标实体>处于不可删除状态, ID: " + profitMetricId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ProfitMetricEntity validate() {
        validateProfitMetricId();
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
            throw new EntityValidateException("利润指标ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new EntityValidateException("利润指标类型不能为 null ");
        }
    }

    private void validateAmount() {
        Decimal.validateAmount(amount);
    }

    private void validateMarginPercentage() {
        Decimal.validatePercentage(marginPercentage);
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new EntityValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new EntityValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new EntityValidateException("是否已删除不能为 null ");
        }
    }
}
