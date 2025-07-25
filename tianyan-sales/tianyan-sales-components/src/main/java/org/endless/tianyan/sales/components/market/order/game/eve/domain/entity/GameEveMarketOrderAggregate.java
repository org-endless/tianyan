package org.endless.tianyan.sales.components.market.order.game.eve.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateRemoveException;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateValidateException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.value.GameEveMarketOrderLocationValue;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.value.GameEveMarketOrderSystemValue;
import org.springframework.util.StringUtils;

/**
 * GameEveMarketOrderAggregate
 * <p>游戏EVE市场订单聚合根
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
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
     * 游戏EVE市场订单编号
     */
    private String code;

    /**
     * 订单范围
     */
    private String range;

    /**
     * 游戏EVE市场订单星系
     */
    private GameEveMarketOrderSystemValue system;

    /**
     * 游戏EVE市场订单空间站
     */
    private GameEveMarketOrderLocationValue location;

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

    public GameEveMarketOrderAggregate modify(GameEveMarketOrderAggregateBuilder builder, String modifyUserId) {
        this.code = builder.code == null ? this.code : builder.code;
        this.range = builder.range == null ? this.range : builder.range;
        this.system = builder.system == null ? this.system : builder.system;
        this.location = builder.location == null ? this.location : builder.location;
        this.modifyUserId = modifyUserId;
        return this.validate();
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveMarketOrderAggregate validate() {
        validateGameEveMarketOrderId();
        validateCode();
        validateRange();
        validateSystem();
        validateLocation();
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

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE市场订单编号不能为空");
        }
    }

    private void validateRange() {
        if (!StringUtils.hasText(range)) {
            throw new AggregateValidateException("订单范围不能为空");
        }
    }

    private void validateSystem() {
        if (system == null) {
            throw new AggregateValidateException("游戏EVE市场订单星系不能为 null ");
        }
    }

    private void validateLocation() {
        if (location == null) {
            throw new AggregateValidateException("游戏EVE市场订单空间站不能为 null ");
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
