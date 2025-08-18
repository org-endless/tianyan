package org.endless.tianyan.finance.components.cost.type.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.finance.common.model.domain.entity.TianyanFinanceAggregate;
import org.endless.tianyan.finance.components.cost.type.domain.value.CostTypeNameValue;
import org.springframework.util.StringUtils;

/**
 * CostTypeAggregate
 * <p>成本类型聚合根
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see TianyanFinanceAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class CostTypeAggregate implements TianyanFinanceAggregate {

    /**
     * 成本类型ID
     */
    private final String costTypeId;

    /**
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 成本类型编码
     */
    private String code;

    /**
     * 成本类型名称
     */
    private CostTypeNameValue name;

    /**
     * 描述
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

    public static CostTypeAggregate create(CostTypeAggregateBuilder builder) {
        return builder
                .costTypeId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    @Override
    public CostTypeAggregate validate() {
        validateCostTypeId();
        validateCode();
        validateName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateCostTypeId() {
        if (!StringUtils.hasText(costTypeId)) {
            throw new AggregateValidateException("成本类型ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("成本类型编码不能为空");
        }
    }

    private void validateName() {
        if (name == null) {
            throw new AggregateValidateException("成本类型名称不能为 null ");
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

    public CostTypeAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<成本类型聚合根>不能再次删除, ID: " + costTypeId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<成本类型聚合根>处于不可删除状态, ID: " + costTypeId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }
}
