package org.endless.tianyan.item.components.item.game.eve.group.domain.entity;

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
 * GameEveItemGroupAggregate
 * <p>游戏EVE资源项分组聚合根
 * <p>
 * itemCreate 2025/07/24 20:20
 * <p>
 * update 2025/07/24 20:20
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
public class GameEveItemGroupAggregate implements TianyanItemAggregate {

    /**
     * 游戏EVE资源项分组ID
     */
    @NotBlank(message = "游戏EVE资源项分组ID不能为空")
    private final String gameEveItemGroupId;

    /**
     * 资源项分组ID
     */
    @NotBlank(message = "资源项分组ID不能为空")
    private String itemGroupId;

    /**
     * 游戏EVE资源项分组编码
     */
    @NotBlank(message = "游戏EVE资源项分组编码不能为空")
    private String code;

    /**
     * 游戏EVE资源项分组是否发布
     */
    @NotNull(message = "游戏EVE资源项分组是否发布不能为空")
    private Boolean isPublished;

    /**
     * 游戏EVE资源项分组是否使用基准价格
     */
    private Boolean isUseBasePrice;

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

    @NotNull(message = "游戏EVE资源项分组聚合根创建方法返回对象不能为空")
    public static @Valid GameEveItemGroupAggregate create(
            @NotNull(message = "游戏EVE资源项分组聚合根构造器不能为空")
            GameEveItemGroupAggregateBuilder builder) {
        return Entity.create(builder, GameEveItemGroupAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "游戏EVE资源项分组聚合根删除方法返回对象不能为空")
    public @Valid GameEveItemGroupAggregate remove(String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的游戏EVE资源项分组聚合根不能再次删除, ID: " + gameEveItemGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public GameEveItemGroupAggregate validate() {
        return this;
    }
}
