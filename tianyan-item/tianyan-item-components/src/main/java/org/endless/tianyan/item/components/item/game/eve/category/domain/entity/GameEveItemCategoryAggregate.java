package org.endless.tianyan.item.components.item.game.eve.category.domain.entity;

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
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemCategoryAggregate
 * <p>游戏EVE资源项分类聚合根
 * <p>
 * itemCreate 2025/07/20 22:44
 * <p>
 * update 2025/07/20 22:44
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
public class GameEveItemCategoryAggregate implements TianyanItemAggregate {

    /**
     * 游戏EVE资源项分类ID
     */
    @NotBlank(message = "游戏EVE资源项分类ID不能为空")
    private final String gameEveItemCategoryId;

    /**
     * 资源项分类ID
     */
    @NotBlank(message = "资源项分类ID不能为空")
    private String itemCategoryId;

    /**
     * 游戏EVE资源项分类编码
     */
    @NotBlank(message = "游戏EVE资源项分类编码不能为空")
    private String code;

    /**
     * 游戏EVE资源项分类是否发布
     */
    @NotNull(message = "游戏EVE资源项分类是否发布不能为空")
    private Boolean isPublished;

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

    @NotNull(message = "游戏EVE资源项分类聚合根创建方法返回对象不能为空")
    public static @Valid GameEveItemCategoryAggregate create(
            @NotNull(message = "游戏EVE资源项分类聚合根构造器不能为空") GameEveItemCategoryAggregateBuilder builder) {
        return Entity.create(builder, GameEveItemCategoryAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "游戏EVE资源项分类聚合根删除方法返回对象不能为空")
    public GameEveItemCategoryAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE资源项分类聚合根>不能再次删除, ID: " + gameEveItemCategoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public GameEveItemCategoryAggregate validate() {
        return this;
    }
}
