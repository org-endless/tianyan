package org.endless.tianyan.metadata.components.industry.industry.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.industry.industry.domain.value.IndustryNameValue;
import org.springframework.util.StringUtils;

/**
 * IndustryAggregate
 * <p>行业聚合根
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class IndustryAggregate implements TianyanMetadataAggregate {

    /**
     * 行业ID
     */
    private final String industryId;

    /**
     * 行业分类ID
     */
    private String industryCategoryId;

    /**
     * 行业编码
     */
    private String code;

    /**
     * 行业名称
     */
    private IndustryNameValue name;

    /**
     * 行业描述
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

    public static IndustryAggregate create(IndustryAggregateBuilder builder) {
        return builder
                .industryId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public IndustryAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<行业聚合根>不能再次删除, ID: " + industryId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<行业聚合根>处于不可删除状态, ID: " + industryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public IndustryAggregate validate() {
        validateIndustryId();
        validateIndustryCategoryId();
        validateCode();
        validateName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new AggregateValidateException("行业ID不能为空");
        }
    }

    private void validateIndustryCategoryId() {
        if (!StringUtils.hasText(industryCategoryId)) {
            throw new AggregateValidateException("行业分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("行业编码不能为空");
        }
    }

    private void validateName() {
        if (name == null) {
            throw new AggregateValidateException("行业名称不能为 null ");
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
