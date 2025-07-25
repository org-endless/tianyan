package org.endless.tianyan.finance.components.taxation.tax.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateRemoveException;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateValidateException;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;
import org.springframework.util.StringUtils;

/**
 * TaxAggregate
 * <p>税务聚合根
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see TianyanFinanceAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class TaxAggregate implements TianyanFinanceAggregate {

    /**
     * 税务ID
     */
    private final String taxId;

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

    public static TaxAggregate create(TaxAggregateBuilder builder) {
        return builder
                .taxId(IdGenerator.of())
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public TaxAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<税务聚合根>不能再次删除, ID: " + taxId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<税务聚合根>处于不可删除状态, ID: " + taxId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public TaxAggregate validate() {
        validateTaxId();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateTaxId() {
        if (!StringUtils.hasText(taxId)) {
            throw new AggregateValidateException("税务ID不能为空");
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
