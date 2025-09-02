package org.endless.tianyan.item.components.item.category.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;
import org.endless.tianyan.item.components.item.category.domain.value.NameValue;
import org.springframework.validation.annotation.Validated;

/**
 * ItemCategoryAggregate
 * <p>资源项分类聚合根
 * <p>
 * itemCreate 2025/07/24 20:16
 * <p>
 * update 2025/07/24 20:16
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class ItemCategoryAggregate implements TianyanItemAggregate {

    /**
     * 资源项分类ID
     */
    @NotBlank(message = "资源项分类ID不能为空")
    private final String itemCategoryId;

    /**
     * 资源项分类中文名称
     */
    @NotNull(message = "资源项分类中文名称不能为空")
    private @Valid NameValue nameZh;

    /**
     * 资源项分类英文名称
     */
    private @Valid NameValue nameEn;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private final String createUserId;

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

    @NotNull(message = "资源项分类聚合根创建方法返回对象不能为空")
    public static @Valid ItemCategoryAggregate create(
            @NotNull(message = "资源项分类聚合根构造器不能为空") ItemCategoryAggregateBuilder builder) {
        return Entity.create(builder, ItemCategoryAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "资源项聚合根删除方法返回对象不能为空")
    public ItemCategoryAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的资源项分类聚合根不能再次删除, ID: " + itemCategoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public ItemCategoryAggregate validate() {
        return this;
    }
}
