package org.endless.tianyan.metadata.components.industry.category.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.industry.category.domain.value.IndustryCategoryNameValue;
import org.springframework.util.StringUtils;

/**
 * IndustryCategoryAggregate
 * <p>行业分类聚合根
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class IndustryCategoryAggregate implements TianyanMetadataAggregate {

    /**
     * 行业分类ID
     */
    private final String industryCategoryId;

    /**
     * 行业分类编码
     */
    private String code;

    /**
     * 行业分类名称
     */
    private IndustryCategoryNameValue name;

    /**
     * 行业分类描述
     */
    private String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    /**
     * 修改用户ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static IndustryCategoryAggregate create(IndustryCategoryAggregateBuilder builder) {
        return builder
                .industryCategoryId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public IndustryCategoryAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<行业分类聚合根>不能再次删除, ID: " + industryCategoryId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<行业分类聚合根>处于不可删除状态, ID: " + industryCategoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public IndustryCategoryAggregate validate() {
        validateIndustryCategoryId();
        validateCode();
        validateName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    private void validateIndustryCategoryId() {
        if (!StringUtils.hasText(industryCategoryId)) {
            throw new AggregateValidateException("行业分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("行业分类编码不能为空");
        }
    }

    private void validateName() {
        if (name == null) {
            throw new AggregateValidateException("行业分类名称不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建用户ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改用户ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}
