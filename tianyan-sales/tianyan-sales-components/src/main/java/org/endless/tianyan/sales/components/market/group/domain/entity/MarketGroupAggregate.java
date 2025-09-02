package org.endless.tianyan.sales.components.market.group.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.endless.tianyan.sales.components.market.group.domain.value.NameValue;
import org.springframework.validation.annotation.Validated;

/**
 * MarketGroupAggregate
 * <p>市场分组聚合根
 * <p>
 * create 2025/07/24 20:31
 * <p>
 * update 2025/07/24 20:31
 *
 * @author Deng Haozhi
 * @see TianyanSalesAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class MarketGroupAggregate implements TianyanSalesAggregate {

    /**
     * 市场分组ID
     */
    @NotBlank(message = "市场分组ID不能为空")
    private final String marketGroupId;

    /**
     * 市场分组中文名称
     */
    @NotNull(message = "市场分组中文名称不能为空")
    private @Valid NameValue nameZh;

    /**
     * 英文名称
     */
    private @Valid NameValue nameEn;

    /**
     * 父市场分组ID
     */
    private String parentId;

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

    @NotNull(message = "市场分组聚合根创建方法返回对象不能为空")
    public static @Valid MarketGroupAggregate create(
            @NotNull(message = "市场分组聚合根构造器不能为空")
            MarketGroupAggregateBuilder builder) {
        return Entity.create(builder, MarketGroupAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "市场分组聚合根删除方法返回对象不能为空")
    public MarketGroupAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除市场分组聚合根不能再次删除, ID: " + marketGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @NotNull(message = "市场分组聚合根修改父分组方法返回对象不能为空")
    public @Valid MarketGroupAggregate modifyParent(
            @NotBlank(message = "父市场分组ID不能为空") String parentId,
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        this.parentId = parentId;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public MarketGroupAggregate validate() {
        return this;
    }
}
