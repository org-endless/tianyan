package org.endless.tianyan.sales.components.market.price.market.price.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketPriceAggregate
 * <p>市场价格聚合根
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see TianyanSalesAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MarketPriceAggregate implements TianyanSalesAggregate {

    /**
     * 市场价格ID
     */
    private final String marketPriceId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 买入价格(17, 2)
     */
    private BigDecimal buyPrice;

    /**
     * 卖出价格(17, 2)
     */
    private BigDecimal sellPrice;

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

    public static MarketPriceAggregate create(MarketPriceAggregateBuilder builder) {
        return builder
                .marketPriceId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public MarketPriceAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场价格聚合根>不能再次删除, ID: " + marketPriceId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<市场价格聚合根>处于不可删除状态, ID: " + marketPriceId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MarketPriceAggregate validate() {
        validateMarketPriceId();
        validateItemId();
        validateBuyPrice();
        validateSellPrice();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketPriceId() {
        if (!StringUtils.hasText(marketPriceId)) {
            throw new AggregateValidateException("市场价格ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validateBuyPrice() {
        if (buyPrice == null) {
            throw new AggregateValidateException("买入价格(17, 2)不能为 null ");
        }
    }

    private void validateSellPrice() {
        if (sellPrice == null) {
            throw new AggregateValidateException("卖出价格(17, 2)不能为 null ");
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
