package org.endless.tianyan.sales.components.market.order.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.annotation.validate.number.amount.Amount;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.endless.tianyan.sales.components.market.order.domain.type.MarketOrderStatusEnum;
import org.endless.tianyan.sales.components.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.order.domain.value.MarketOrderItemQuantityValue;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

/**
 * MarketOrderAggregate
 * <p>市场订单聚合根
 * <p>
 * create 2025/07/26 18:16
 * <p>
 * update 2025/07/26 18:16
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
public class MarketOrderAggregate implements TianyanSalesAggregate {

    /**
     * 市场订单ID
     */
    @NotBlank(message = "市场订单ID不能为空")
    private final String marketOrderId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 市场订单类型
     */
    @NotNull(message = "市场订单类型不能为空")
    private MarketOrderTypeEnum type;

    /**
     * 市场订单资源项数量
     */
    @NotNull(message = "市场订单资源项数量不能为空")
    private @Valid MarketOrderItemQuantityValue itemQuantity;

    /**
     * 市场订单价格(17, 2)
     */
    @NotNull(message = "市场订单价格不能为空")
    private @Amount BigDecimal price;

    /**
     * 市场订单创建时间
     */
    @NotNull(message = "市场订单创建时间不能为空")
    private Long issuedAt;

    /**
     * 市场订单过期时间
     */
    private Long expireAt;

    @NotNull(message = "市场订单状态不能为空")
    private MarketOrderStatusEnum status;

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

    @NotNull(message = "市场订单聚合根创建方法返回对象不能为空")
    public static @Valid MarketOrderAggregate create(
            @NotNull(message = "市场订单聚合根构造器不能为空")
            MarketOrderAggregateBuilder builder) {
        builder.status = MarketOrderStatusEnum.TRADING;
        return Entity.create(builder, MarketOrderAggregate.MarketOrderAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "市场订单聚合根删除方法返回对象不能为空")
    public @Valid MarketOrderAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场订单聚合根>不能再次删除, ID: " + marketOrderId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @NotNull(message = "市场订单聚合根修改方法返回对象不能为空")
    public @Valid MarketOrderAggregate modify(
            @NotNull(message = "市场订单聚合根构造器不能为空")
            MarketOrderAggregateBuilder builder) {
        this.itemQuantity = builder.itemQuantity == null ? this.itemQuantity : builder.itemQuantity;
        this.price = builder.price == null ? this.price : builder.price;
        this.issuedAt = builder.issuedAt == null ? this.issuedAt : builder.issuedAt;
        this.expireAt = builder.expireAt == null ? this.expireAt : builder.expireAt;
        this.modifyUserId = builder.modifyUserId;
        return this;
    }

    @Override
    public MarketOrderAggregate validate() {
        return this;
    }
}
