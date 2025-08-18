package org.endless.tianyan.sales.components.market.trade.history.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.endless.tianyan.sales.components.market.trade.history.domain.value.MarketTradeHistoryPeriodValue;
import org.endless.tianyan.sales.components.market.trade.history.domain.value.MarketTradeHistoryPriceValue;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketTradeHistoryAggregate
 * <p>市场交易历史聚合根
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see TianyanSalesAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MarketTradeHistoryAggregate implements TianyanSalesAggregate {

    /**
     * 市场交易历史ID
     */
    private final String marketTradeHistoryId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 市场交易历史范围
     */
    private MarketTradeHistoryPeriodValue period;

    /**
     * 市场交易历史成交价格
     */
    private MarketTradeHistoryPriceValue price;

    /**
     * 市场交易历史订单数量(15, 0)
     */
    private BigDecimal orderCount;

    /**
     * 市场交易历史资源项交易数量(20, 5)
     */
    private BigDecimal itemQuantity;

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

    public static MarketTradeHistoryAggregate create(MarketTradeHistoryAggregateBuilder builder) {
        return builder
                .marketTradeHistoryId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public MarketTradeHistoryAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场交易历史聚合根>不能再次删除, ID: " + marketTradeHistoryId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<市场交易历史聚合根>处于不可删除状态, ID: " + marketTradeHistoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MarketTradeHistoryAggregate validate() {
        validateMarketTradeHistoryId();
        validateItemId();
        validatePeriod();
        validatePrice();
        validateOrderCount();
        validateItemQuantity();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketTradeHistoryId() {
        if (!StringUtils.hasText(marketTradeHistoryId)) {
            throw new AggregateValidateException("市场交易历史ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validatePeriod() {
        if (period == null) {
            throw new AggregateValidateException("市场交易历史范围不能为 null ");
        }
    }

    private void validatePrice() {
        if (price == null) {
            throw new AggregateValidateException("市场交易历史成交价格不能为 null ");
        }
    }

    private void validateOrderCount() {
        if (orderCount == null) {
            throw new AggregateValidateException("市场交易历史订单数量(15, 0)不能为 null ");
        }
    }

    private void validateItemQuantity() {
        if (itemQuantity == null) {
            throw new AggregateValidateException("市场交易历史资源项交易数量(20, 5)不能为 null ");
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
