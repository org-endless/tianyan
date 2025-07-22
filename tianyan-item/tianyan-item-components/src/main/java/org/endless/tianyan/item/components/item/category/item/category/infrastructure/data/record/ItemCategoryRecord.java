package org.endless.tianyan.item.components.item.category.item.category.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;
import org.endless.tianyan.item.components.item.category.item.category.domain.entity.ItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.item.category.domain.value.NameValue;
import org.springframework.util.StringUtils;

/**
 * ItemCategoryRecord
 * <p>物品分类数据库记录实体
 * <p>
 * create 2025/07/21 15:36
 * <p>
 * update 2025/07/21 15:36
 *
 * @author Deng Haozhi
 * @see TianyanItemRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "item_category")
public class ItemCategoryRecord implements TianyanItemRecord<ItemCategoryAggregate> {

    /**
     * 物品分类ID
     */
    @TableId
    private String itemCategoryId;

    /**
     * 全称
     */
    private String nameZhFullName;

    /**
     * 别名
     */
    private String nameZhAlias;

    /**
     * 简称
     */
    private String nameZhAbbreviation;

    /**
     * 全称
     */
    private String nameEnFullName;

    /**
     * 别名
     */
    private String nameEnAlias;

    /**
     * 简称
     */
    private String nameEnAbbreviation;

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

    public static ItemCategoryRecord from(ItemCategoryAggregate aggregate) {
        String itemCategoryId = aggregate.getItemCategoryId();
        return ItemCategoryRecord.builder()
                .itemCategoryId(itemCategoryId)
                .nameZhFullName(aggregate.getNameZh().getFullName())
                .nameZhAlias(aggregate.getNameZh().getAlias())
                .nameZhAbbreviation(aggregate.getNameZh().getAbbreviation())
                .nameEnFullName(aggregate.getNameEn().getFullName())
                .nameEnAlias(aggregate.getNameEn().getAlias())
                .nameEnAbbreviation(aggregate.getNameEn().getAbbreviation())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public ItemCategoryAggregate to() {
        validate();
        return ItemCategoryAggregate.builder()
                .itemCategoryId(itemCategoryId)
                .nameZh(NameValue.builder()
                        .fullName(nameZhFullName)
                        .alias(nameZhAlias)
                        .abbreviation(nameZhAbbreviation)
                        .innerBuild())
                .nameEn(NameValue.builder()
                        .fullName(nameEnFullName)
                        .alias(nameEnAlias)
                        .abbreviation(nameEnAbbreviation)
                        .innerBuild())
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public ItemCategoryRecord validate() {
        validateItemCategoryId();
        validateNameZhFullName();
        validateNameEnFullName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new DataRecordValidateException("物品分类ID不能为空");
        }
    }

    private void validateNameZhFullName() {
        if (!StringUtils.hasText(nameZhFullName)) {
            throw new DataRecordValidateException("全称不能为空");
        }
    }

    private void validateNameEnFullName() {
        if (!StringUtils.hasText(nameEnFullName)) {
            throw new DataRecordValidateException("全称不能为空");
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
