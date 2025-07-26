package org.endless.tianyan.sales.components.market.price.history.domain.entity;

import org.endless.tianyan.sales.common.model.domain.entity.*;
import org.endless.tianyan.sales.components.market.price.history.domain.value.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MarketPriceHistoryAggregate
 * <p>市场价格历史聚合根
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
public class MarketPriceHistoryAggregate implements TianyanSalesAggregate {

    /**
     * 市场价格历史ID
     */
    private final String marketPriceHistoryId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 市场价格历史范围
     */
    private MarketPriceHistoryPeriodValue period;

    /**
     * 市场历史买入价格
     */
    private MarketHistoryPriceValue buyPrice;

    /**
     * 市场历史卖出价格
     */
    private MarketHistoryPriceValue sellPrice;

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

    public static MarketPriceHistoryAggregate create(MarketPriceHistoryAggregateBuilder builder) {
        return builder
                .marketPriceHistoryId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public MarketPriceHistoryAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场价格历史聚合根>不能再次删除, ID: " + marketPriceHistoryId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<市场价格历史聚合根>处于不可删除状态, ID: " + marketPriceHistoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MarketPriceHistoryAggregate validate() {
        validateMarketPriceHistoryId();
        validateItemId();
        validatePeriod();
        validateBuyPrice();
        validateSellPrice();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketPriceHistoryId() {
        if (!StringUtils.hasText(marketPriceHistoryId)) {
            throw new AggregateValidateException("市场价格历史ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validatePeriod() {
        if (period == null) {
            throw new AggregateValidateException("市场价格历史范围不能为 null ");
        }
    }

    private void validateBuyPrice() {
        if (buyPrice == null) {
            throw new AggregateValidateException("市场历史买入价格不能为 null ");
        }
    }

    private void validateSellPrice() {
        if (sellPrice == null) {
            throw new AggregateValidateException("市场历史卖出价格不能为 null ");
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
