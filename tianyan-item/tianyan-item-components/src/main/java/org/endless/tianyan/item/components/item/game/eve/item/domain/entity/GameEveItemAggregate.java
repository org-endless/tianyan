package org.endless.tianyan.item.components.item.game.eve.item.domain.entity;

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
 * GameEveItemAggregate
 * <p>游戏EVE资源项聚合根
 * <p>
 * itemCreate 2025/07/24 16:27
 * <p>
 * update 2025/07/24 16:27
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
public class GameEveItemAggregate implements TianyanItemAggregate {

    /**
     * 游戏EVE资源项ID
     */
    @NotBlank(message = "游戏EVE资源项ID不能为空")
    private final String gameEveItemId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 游戏EVE资源项编码
     */
    @NotBlank(message = "游戏EVE资源项编码不能为空")
    private String code;

    /**
     * 游戏EVE资源项是否发布
     */
    @NotNull(message = "游戏EVE资源项是否发布不能为空")
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

    @NotNull(message = "游戏EVE资源项聚合根创建方法返回对象不能为空")
    public static @Valid GameEveItemAggregate create(
            @NotNull(message = "游戏EVE资源项聚合根构造器不能为空")
            GameEveItemAggregateBuilder builder) {
        return Entity.create(builder, GameEveItemAggregate.GameEveItemAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "游戏EVE资源项聚合删除方法返回对象不能为空")
    public @Valid GameEveItemAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的游戏EVE资源项聚合根不能再次删除, ID: " + gameEveItemId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public GameEveItemAggregate validate() {
        return this;
    }
}
