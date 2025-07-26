package org.endless.tianyan.sales.components.market.trade.market.trade.domain.entity;

import org.endless.tianyan.sales.common.model.domain.entity.*;
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
 * MarketTradeAggregate
 * <p>市场交易聚合根
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
public class MarketTradeAggregate implements TianyanSalesAggregate {

    /**
     * 市场交易ID
     */
    private final String marketTradeId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 成交价格(17, 2)
     */
    private BigDecimal price;

    /**
     * 资源项交易数量(20, 5)
     */
    private String itemQuantity;

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

    public static MarketTradeAggregate create(MarketTradeAggregateBuilder builder) {
        return builder
                .marketTradeId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public MarketTradeAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场交易聚合根>不能再次删除, ID: " + marketTradeId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<市场交易聚合根>处于不可删除状态, ID: " + marketTradeId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MarketTradeAggregate validate() {
        validateMarketTradeId();
        validateItemId();
        validatePrice();
        validateItemQuantity();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketTradeId() {
        if (!StringUtils.hasText(marketTradeId)) {
            throw new AggregateValidateException("市场交易ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validatePrice() {
        if (price == null) {
            throw new AggregateValidateException("成交价格(17, 2)不能为 null ");
        }
    }

    private void validateItemQuantity() {
        if (!StringUtils.hasText(itemQuantity)) {
            throw new AggregateValidateException("资源项交易数量(20, 5)不能为空");
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
