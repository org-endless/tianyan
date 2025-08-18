package org.endless.tianyan.sales.components.market.order.game.eve.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.springframework.util.StringUtils;

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
@Builder(buildMethodName = "innerBuild")
public class GameEveMarketOrderAggregate implements TianyanSalesAggregate {

    /**
     * 游戏EVE市场订单ID
     */
    private final String gameEveMarketOrderId;

    /**
     * 市场订单ID
     */
    private String marketOrderId;

    /**
     * 游戏EVE市场订单编号
     */
    private String code;

    /**
     * 游戏EVE市场订单范围
     */
    private String orderRange;

    /**
     * 游戏EVE市场订单星系ID
     */
    private String systemId;

    /**
     * 游戏EVE市场订单空间站ID
     */
    private String stationId;

    /**
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static GameEveMarketOrderAggregate create(GameEveMarketOrderAggregateBuilder builder) {
        return builder
                .gameEveMarketOrderId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public GameEveMarketOrderAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE市场订单聚合根>不能再次删除, ID: " + gameEveMarketOrderId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE市场订单聚合根>处于不可删除状态, ID: " + gameEveMarketOrderId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public GameEveMarketOrderAggregate modify(GameEveMarketOrderAggregateBuilder builder) {
        this.code = builder.code == null ? this.code : builder.code;
        this.orderRange = builder.orderRange == null ? this.orderRange : builder.orderRange;
        this.systemId = builder.systemId == null ? this.systemId : builder.systemId;
        this.stationId = builder.stationId == null ? this.stationId : builder.stationId;
        this.modifyUserId = builder.modifyUserId;
        return this.validate();
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveMarketOrderAggregate validate() {
        validateGameEveMarketOrderId();
        validateMarketOrderId();
        validateCode();
        validateOrderRange();
        validateSystemId();
        validateStationId();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveMarketOrderId() {
        if (!StringUtils.hasText(gameEveMarketOrderId)) {
            throw new AggregateValidateException("游戏EVE市场订单ID不能为空");
        }
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new AggregateValidateException("市场订单ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE市场订单编号不能为空");
        }
    }

    private void validateOrderRange() {
        if (!StringUtils.hasText(orderRange)) {
            throw new AggregateValidateException("游戏EVE市场订单范围不能为空");
        }
    }

    private void validateSystemId() {
        if (!StringUtils.hasText(systemId)) {
            throw new AggregateValidateException("游戏EVE市场订单星系ID不能为空");
        }
    }

    private void validateStationId() {
        if (!StringUtils.hasText(stationId)) {
            throw new AggregateValidateException("游戏EVE市场订单空间站ID不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}
