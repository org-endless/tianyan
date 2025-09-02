package org.endless.tianyan.metadata.components.industry.category.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;
import org.endless.tianyan.metadata.components.industry.category.domain.entity.IndustryCategoryAggregate;
import org.endless.tianyan.metadata.components.industry.category.domain.value.IndustryCategoryNameValue;
import org.springframework.util.StringUtils;

/**
 * IndustryCategoryRecord
 * <p>行业分类数据库记录实体
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "industry_category")
public class IndustryCategoryRecord implements TianyanMetadataRecord<IndustryCategoryAggregate> {

    /**
     * 行业分类ID
     */
    @TableId
    private String industryCategoryId;

    /**
     * 行业分类编码
     */
    private String code;

    /**
     * 行业分类中文名称
     */
    private String nameNameZh;

    /**
     * 行业分类英文名称
     */
    private String nameNameEn;

    /**
     * 行业分类描述
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

    public static IndustryCategoryRecord from(IndustryCategoryAggregate aggregate) {
        String industryCategoryId = aggregate.getIndustryCategoryId();
        return IndustryCategoryRecord.builder()
                .industryCategoryId(industryCategoryId)
                .code(aggregate.getCode())
                .nameNameZh(aggregate.getName().getNameZh())
                .nameNameEn(aggregate.getName().getNameEn())
                .description(aggregate.getDescription())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public IndustryCategoryAggregate to() {
        validate();
        return IndustryCategoryAggregate.builder()
                .industryCategoryId(industryCategoryId)
                .code(code)
                .name(IndustryCategoryNameValue.builder()
                        .nameZh(nameNameZh)
                        .nameEn(nameNameEn)
                        .innerBuild())
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public IndustryCategoryRecord validate() {
        validateIndustryCategoryId();
        validateCode();
        validateNameNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateIndustryCategoryId() {
        if (!StringUtils.hasText(industryCategoryId)) {
            throw new DataRecordValidateException("行业分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("行业分类编码不能为空");
        }
    }

    private void validateNameNameZh() {
        if (!StringUtils.hasText(nameNameZh)) {
            throw new DataRecordValidateException("行业分类中文名称不能为空");
        }
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
