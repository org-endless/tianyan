package org.endless.tianyan.sales.components.market.game.eve.order.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMarketOrderAggregate
 * <p>游戏EVE市场订单聚合根
 * <p>
 * create 2025/07/25 16:33
 * <p>
 * update 2025/07/26 07:14
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
public class GameEveMarketOrderAggregate implements TianyanSalesAggregate {

    /**
     * 游戏EVE市场订单ID
     */
    @NotBlank(message = "游戏EVE市场订单ID不能为空")
    private final String gameEveMarketOrderId;

    /**
     * 市场订单ID
     */
    @NotBlank(message = "市场订单ID不能为空")
    private String marketOrderId;

    /**
     * 游戏EVE市场订单编号
     */
    @NotBlank(message = "游戏EVE市场订单编号不能为空")
    private String code;

    /**
     * 游戏EVE市场订单范围
     */
    @NotBlank(message = "游戏EVE市场订单范围不能为空")
    private String orderRange;

    /**
     * 游戏EVE市场订单星系ID
     */
    @NotBlank(message = "游戏EVE市场订单星系ID不能为空")
    private String systemId;

    /**
     * 游戏EVE市场订单空间站ID
     */
    @NotBlank(message = "游戏EVE市场订单空间站ID不能为空")
    private String stationId;

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

    @NotNull(message = "游戏EVE市场订单聚合根创建方法返回对象不能为空")
    public static GameEveMarketOrderAggregate create(
            @NotNull(message = "游戏EVE市场订单聚合根构造器不能为空")
            GameEveMarketOrderAggregateBuilder builder) {
        return builder
                .gameEveMarketOrderId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    @NotNull(message = "游戏EVE市场订单聚合根删除方法返回对象不能为空")
    public GameEveMarketOrderAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的游戏EVE市场订单聚合根不能再次删除, ID: " + gameEveMarketOrderId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @NotNull(message = "游戏EVE市场订单聚合根修改方法返回对象不能为空")
    public @Valid GameEveMarketOrderAggregate modify(
            @NotNull(message = "游戏EVE市场订单聚合根构造器不能为空")
            GameEveMarketOrderAggregateBuilder builder) {
        this.code = builder.code == null ? this.code : builder.code;
        this.orderRange = builder.orderRange == null ? this.orderRange : builder.orderRange;
        this.systemId = builder.systemId == null ? this.systemId : builder.systemId;
        this.stationId = builder.stationId == null ? this.stationId : builder.stationId;
        this.modifyUserId = builder.modifyUserId;
        return this.validate();
    }

    @Override
    public GameEveMarketOrderAggregate validate() {
        return this;
    }
}
