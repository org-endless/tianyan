package org.endless.tianyan.sales.components.market.order.market.order.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.order.market.order.domain.value.MarketOrderItemQuantityValue;
import org.springframework.util.StringUtils;

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
@Builder(buildMethodName = "innerBuild")
public class MarketOrderAggregate implements TianyanSalesAggregate {

    /**
     * 市场订单ID
     */
    private final String marketOrderId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 市场订单类型
     */
    private MarketOrderTypeEnum type;

    /**
     * 市场订单资源项数量
     */
    private MarketOrderItemQuantityValue itemQuantity;

    /**
     * 市场订单价格(17, 2)
     */
    private BigDecimal price;

    /**
     * 市场订单创建时间
     */
    private Long issuedAt;

    /**
     * 市场订单过期时间
     */
    private Long expireAt;

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

    public static MarketOrderAggregate create(MarketOrderAggregateBuilder builder) {
        return builder
                .marketOrderId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public MarketOrderAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场订单聚合根>不能再次删除, ID: " + marketOrderId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<市场订单聚合根>处于不可删除状态, ID: " + marketOrderId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public MarketOrderAggregate modify(MarketOrderAggregateBuilder builder) {
        this.itemQuantity = builder.itemQuantity == null ? this.itemQuantity : builder.itemQuantity;
        this.price = builder.price == null ? this.price : builder.price;
        this.issuedAt = builder.issuedAt == null ? this.issuedAt : builder.issuedAt;
        this.expireAt = builder.expireAt == null ? this.expireAt : builder.expireAt;
        this.modifyUserId = builder.modifyUserId;
        return this.validate();
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MarketOrderAggregate validate() {
        validateMarketOrderId();
        validateItemId();
        validateType();
        validateItemQuantity();
        validatePrice();
        validateIssuedAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new AggregateValidateException("市场订单ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new AggregateValidateException("市场订单类型不能为 null ");
        }
    }

    private void validateItemQuantity() {
        if (itemQuantity == null) {
            throw new AggregateValidateException("市场订单资源项数量不能为 null ");
        }
    }

    private void validatePrice() {
        if (price == null) {
            throw new AggregateValidateException("市场订单价格(17, 2)不能为 null ");
        }
    }

    private void validateIssuedAt() {
        if (issuedAt == null || issuedAt < 0) {
            throw new AggregateValidateException("市场订单创建时间不能为 null 或小于 0，当前值为: " + issuedAt);
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
