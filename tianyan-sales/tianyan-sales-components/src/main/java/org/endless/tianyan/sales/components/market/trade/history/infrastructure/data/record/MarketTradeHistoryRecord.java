package org.endless.tianyan.sales.components.market.trade.history.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.trade.history.domain.entity.MarketTradeHistoryAggregate;
import org.endless.tianyan.sales.components.market.trade.history.domain.value.MarketTradeHistoryPeriodValue;
import org.endless.tianyan.sales.components.market.trade.history.domain.value.MarketTradeHistoryPriceValue;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketTradeHistoryRecord
 * <p>市场交易历史数据库记录实体
 * <p>
 * create 2025/07/26 18:57
 * <p>
 * update 2025/07/26 18:57
 *
 * @author Deng Haozhi
 * @see TianyanSalesRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "market_trade_history")
public class MarketTradeHistoryRecord implements TianyanSalesRecord<MarketTradeHistoryAggregate> {

    /**
     * 市场交易历史ID
     */
    @TableId
    private String marketTradeHistoryId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 市场交易历史范围开始时间
     */
    private Long periodPeriodStartAt;

    /**
     * 市场交易历史范围结束时间
     */
    private Long periodPeriodEndAt;

    /**
     * 市场交易历史平均成交价格(17, 2)
     */
    private BigDecimal priceAverage;

    /**
     * 市场交易历史最高成交价格(17, 2)
     */
    private BigDecimal priceHighest;

    /**
     * 市场交易历史最低成交价格(17, 2)
     */
    private BigDecimal priceLowest;

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
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    /**
     * 删除时间
     */
    private Long removeAt;

    public static MarketTradeHistoryRecord from(MarketTradeHistoryAggregate aggregate) {
        String marketTradeHistoryId = aggregate.getMarketTradeHistoryId();
        return MarketTradeHistoryRecord.builder()
                .marketTradeHistoryId(marketTradeHistoryId)
                .itemId(aggregate.getItemId())
                .periodPeriodStartAt(aggregate.getPeriod().getPeriodStartAt())
                .periodPeriodEndAt(aggregate.getPeriod().getPeriodEndAt())
                .priceAverage(aggregate.getPrice().getAverage())
                .priceHighest(aggregate.getPrice().getHighest())
                .priceLowest(aggregate.getPrice().getLowest())
                .orderCount(aggregate.getOrderCount())
                .itemQuantity(aggregate.getItemQuantity())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public MarketTradeHistoryAggregate to() {
        validate();
        return MarketTradeHistoryAggregate.builder()
                .marketTradeHistoryId(marketTradeHistoryId)
                .itemId(itemId)
                .period(MarketTradeHistoryPeriodValue.builder()
                        .periodStartAt(periodPeriodStartAt)
                        .periodEndAt(periodPeriodEndAt)
                        .innerBuild())
                .price(MarketTradeHistoryPriceValue.builder()
                        .average(priceAverage)
                        .highest(priceHighest)
                        .lowest(priceLowest)
                        .innerBuild())
                .orderCount(orderCount)
                .itemQuantity(itemQuantity)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketTradeHistoryRecord validate() {
        validateMarketTradeHistoryId();
        validateItemId();
        validatePeriodPeriodStartAt();
        validatePeriodPeriodEndAt();
        validatePriceAverage();
        validatePriceHighest();
        validatePriceLowest();
        validateOrderCount();
        validateItemQuantity();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketTradeHistoryId() {
        if (!StringUtils.hasText(marketTradeHistoryId)) {
            throw new DataRecordValidateException("市场交易历史ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validatePeriodPeriodStartAt() {
        if (periodPeriodStartAt == null || periodPeriodStartAt < 0) {
            throw new DataRecordValidateException("市场交易历史范围开始时间不能为 null 或小于 0，当前值为: " + periodPeriodStartAt);
        }
    }

    private void validatePeriodPeriodEndAt() {
        if (periodPeriodEndAt == null || periodPeriodEndAt < 0) {
            throw new DataRecordValidateException("市场交易历史范围结束时间不能为 null 或小于 0，当前值为: " + periodPeriodEndAt);
        }
    }

    private void validatePriceAverage() {
        if (priceAverage == null) {
            throw new DataRecordValidateException("市场交易历史平均成交价格(17, 2)不能为 null ");
        }
    }

    private void validatePriceHighest() {
        if (priceHighest == null) {
            throw new DataRecordValidateException("市场交易历史最高成交价格(17, 2)不能为 null ");
        }
    }

    private void validatePriceLowest() {
        if (priceLowest == null) {
            throw new DataRecordValidateException("市场交易历史最低成交价格(17, 2)不能为 null ");
        }
    }

    private void validateOrderCount() {
        if (orderCount == null) {
            throw new DataRecordValidateException("市场交易历史订单数量(15, 0)不能为 null ");
        }
    }

    private void validateItemQuantity() {
        if (itemQuantity == null) {
            throw new DataRecordValidateException("市场交易历史资源项交易数量(20, 5)不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}
