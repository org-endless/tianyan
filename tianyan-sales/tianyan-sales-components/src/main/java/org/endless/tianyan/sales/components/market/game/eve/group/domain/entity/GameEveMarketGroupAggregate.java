package org.endless.tianyan.sales.components.market.game.eve.group.domain.entity;

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
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMarketGroupAggregate
 * <p>游戏EVE市场分组聚合根
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
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
public class GameEveMarketGroupAggregate implements TianyanSalesAggregate {

    /**
     * 游戏EVE市场分组ID
     */
    @NotBlank(message = "游戏EVE市场分组ID不能为空")
    private final String gameEveMarketGroupId;

    /**
     * 市场分组ID
     */
    @NotBlank(message = "市场分组ID不能为空")
    private String marketGroupId;

    /**
     * 游戏EVE市场分组编码
     */
    @NotBlank(message = "游戏EVE市场分组编码不能为空")
    private String code;

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

    @NotNull(message = "游戏EVE市场分组聚合根创建方法返回对象不能为空")
    public static @Valid GameEveMarketGroupAggregate create(
            @NotNull(message = "游戏EVE市场分组聚合根构造器不能为空") GameEveMarketGroupAggregateBuilder builder) {
        return Entity.create(builder, GameEveMarketGroupAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "游戏EVE市场分组聚合根删除方法返回对象不能为空")
    public GameEveMarketGroupAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的游戏EVE市场分组聚合根不能再次删除, ID: " + gameEveMarketGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public GameEveMarketGroupAggregate validate() {
        return this;
    }
}
