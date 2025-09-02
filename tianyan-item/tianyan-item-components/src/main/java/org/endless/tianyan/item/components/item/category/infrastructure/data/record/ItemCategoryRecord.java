package org.endless.tianyan.item.components.item.category.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.endless.ddd.starter.common.annotation.validate.ddd.DataRecord;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;
import org.endless.tianyan.item.components.item.category.domain.entity.ItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.domain.value.NameValue;
import org.springframework.validation.annotation.Validated;

/**
 * ItemCategoryRecord
 * <p>资源项分类数据库记录实体
 * <p>
 * itemCreate 2025/07/24 20:16
 * <p>
 * update 2025/07/24 20:16
 *
 * @author Deng Haozhi
 * @see TianyanItemRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "item_category")
public class ItemCategoryRecord implements TianyanItemRecord<ItemCategoryAggregate> {

    /**
     * 资源项分类ID
     */
    @TableId
    @NotBlank(message = "资源项分类ID不能为空")
    private String itemCategoryId;

    /**
     * 资源项分类中文全称
     */
    @NotBlank(message = "资源项分类中文全称不能为空")
    private String nameZhFullName;

    /**
     * 资源项分类中文别名
     */
    private String nameZhAlias;

    /**
     * 资源项分类中文简称
     */
    private String nameZhAbbreviation;

    /**
     * 资源项分类英文全称
     */
    private String nameEnFullName;

    /**
     * 资源项分类英文别名
     */
    private String nameEnAlias;

    /**
     * 资源项分类英文简称
     */
    private String nameEnAbbreviation;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private String createUserId;

    /**
     * 修改用户ID
     */
    @NotBlank(message = "修改用户ID不能为空")
    private String modifyUserId;

    /**
     * 是否已删除
     */
    @NotNull(message = "是否已删除不能为空")
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

    @NotNull(message = "资源项分类数据库记录实体不能为空")
    public static @Valid ItemCategoryRecord from(
            @NotNull(message = "资源项分类聚合根不能为空")
            @Valid ItemCategoryAggregate aggregate) {
        return ItemCategoryRecord.builder()
                .itemCategoryId(aggregate.getItemCategoryId())
                .nameZhFullName(aggregate.getNameZh().fullName())
                .nameZhAlias(aggregate.getNameZh().alias())
                .nameZhAbbreviation(aggregate.getNameZh().abbreviation())
                .nameEnFullName(aggregate.getNameEn() == null ? null : aggregate.getNameEn().fullName())
                .nameEnAlias(aggregate.getNameEn() == null ? null : aggregate.getNameEn().alias())
                .nameEnAbbreviation(aggregate.getNameEn() == null ? null : aggregate.getNameEn().abbreviation())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "资源项分类聚合根不能为空")
    public ItemCategoryAggregate to() {
        ObjectTools.jsrValidate(this).validate();
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
        return this;
    }
}
