package org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveBlueprintAggregate
 * <p>游戏EVE蓝图聚合根
 * <p>
 * create 2025/07/24 09:58
 * <p>
 * update 2025/07/24 09:58
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class GameEveBlueprintAggregate implements TianyanManufacturingAggregate {

    /**
     * 游戏EVE蓝图ID
     */
    @NotBlank(message = "游戏EVE蓝图ID不能为空")
    private final String gameEveBlueprintId;

    /**
     * 蓝图ID
     */
    @NotBlank(message = "蓝图ID不能为空")
    private String blueprintId;

    /**
     * 游戏EVE蓝图编码
     */
    @NotBlank(message = "游戏EVE蓝图编码不能为空")
    private String code;

    /**
     * 游戏EVE蓝图最大生产次数
     */
    @NotNull(message = "游戏EVE蓝图最大生产次数不能为空")
    private Integer maxProductionLimit;

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

    @NotNull(message = "游戏EVE蓝图聚合根创建方法返回对象不能为空")
    public static @Valid GameEveBlueprintAggregate create(
            @NotNull(message = "游戏EVE蓝图聚合根构造器不能为空") GameEveBlueprintAggregateBuilder builder) {
        return Entity.create(builder, GameEveBlueprintAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "游戏EVE蓝图聚合根删除方法返回对象不能为空")
    public GameEveBlueprintAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的游戏EVE蓝图聚合根不能再次删除, ID: " + gameEveBlueprintId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public GameEveBlueprintAggregate validate() {
        return this;
    }
}
