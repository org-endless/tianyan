package org.endless.tianyan.sales.components.market.price.history.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.price.history.domain.entity.MarketPriceHistoryAggregate;
import org.endless.tianyan.sales.components.market.price.history.domain.value.MarketHistoryPriceValue;
import org.endless.tianyan.sales.components.market.price.history.domain.value.MarketPriceHistoryPeriodValue;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketPriceHistoryRecord
 * <p>市场价格历史数据库记录实体
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
@TableName(value = "market_price_history")
public class MarketPriceHistoryRecord implements TianyanSalesRecord<MarketPriceHistoryAggregate> {

    /**
     * 市场价格历史ID
     */
    @TableId
    private String marketPriceHistoryId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 市场价格历史范围开始时间
     */
    private Long periodPeriodStartAt;

    /**
     * 市场价格历史范围结束时间
     */
    private Long periodPeriodEndAt;

    /**
     * 市场历史平均价格(17, 2)
     */
    private BigDecimal buyPriceAverage;

    /**
     * 市场历史最高价格(17, 2)
     */
    private BigDecimal buyPriceHighest;

    /**
     * 市场历史最低价格(17, 2)
     */
    private BigDecimal buyPriceLowest;

    /**
     * 市场历史平均价格(17, 2)
     */
    private BigDecimal sellPriceAverage;

    /**
     * 市场历史最高价格(17, 2)
     */
    private BigDecimal sellPriceHighest;

    /**
     * 市场历史最低价格(17, 2)
     */
    private BigDecimal sellPriceLowest;

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

    public static MarketPriceHistoryRecord from(MarketPriceHistoryAggregate aggregate) {
        String marketPriceHistoryId = aggregate.getMarketPriceHistoryId();
        return MarketPriceHistoryRecord.builder()
                .marketPriceHistoryId(marketPriceHistoryId)
                .itemId(aggregate.getItemId())
                .periodPeriodStartAt(aggregate.getPeriod().getPeriodStartAt())
                .periodPeriodEndAt(aggregate.getPeriod().getPeriodEndAt())
                .buyPriceAverage(aggregate.getBuyPrice().getAverage())
                .buyPriceHighest(aggregate.getBuyPrice().getHighest())
                .buyPriceLowest(aggregate.getBuyPrice().getLowest())
                .sellPriceAverage(aggregate.getSellPrice().getAverage())
                .sellPriceHighest(aggregate.getSellPrice().getHighest())
                .sellPriceLowest(aggregate.getSellPrice().getLowest())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public MarketPriceHistoryAggregate to() {
        validate();
        return MarketPriceHistoryAggregate.builder()
                .marketPriceHistoryId(marketPriceHistoryId)
                .itemId(itemId)
                .period(MarketPriceHistoryPeriodValue.builder()
                        .periodStartAt(periodPeriodStartAt)
                        .periodEndAt(periodPeriodEndAt)
                        .innerBuild())
                .buyPrice(MarketHistoryPriceValue.builder()
                        .average(buyPriceAverage)
                        .highest(buyPriceHighest)
                        .lowest(buyPriceLowest)
                        .innerBuild())
                .sellPrice(MarketHistoryPriceValue.builder()
                        .average(sellPriceAverage)
                        .highest(sellPriceHighest)
                        .lowest(sellPriceLowest)
                        .innerBuild())
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketPriceHistoryRecord validate() {
        validateMarketPriceHistoryId();
        validateItemId();
        validatePeriodPeriodStartAt();
        validatePeriodPeriodEndAt();
        validateBuyPriceAverage();
        validateBuyPriceHighest();
        validateBuyPriceLowest();
        validateSellPriceAverage();
        validateSellPriceHighest();
        validateSellPriceLowest();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketPriceHistoryId() {
        if (!StringUtils.hasText(marketPriceHistoryId)) {
            throw new DataRecordValidateException("市场价格历史ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validatePeriodPeriodStartAt() {
        if (periodPeriodStartAt == null || periodPeriodStartAt < 0) {
            throw new DataRecordValidateException("市场价格历史范围开始时间不能为 null 或小于 0，当前值为: " + periodPeriodStartAt);
        }
    }

    private void validatePeriodPeriodEndAt() {
        if (periodPeriodEndAt == null || periodPeriodEndAt < 0) {
            throw new DataRecordValidateException("市场价格历史范围结束时间不能为 null 或小于 0，当前值为: " + periodPeriodEndAt);
        }
    }

    private void validateBuyPriceAverage() {
        if (buyPriceAverage == null) {
            throw new DataRecordValidateException("市场历史平均价格(17, 2)不能为 null ");
        }
    }

    private void validateBuyPriceHighest() {
        if (buyPriceHighest == null) {
            throw new DataRecordValidateException("市场历史最高价格(17, 2)不能为 null ");
        }
    }

    private void validateBuyPriceLowest() {
        if (buyPriceLowest == null) {
            throw new DataRecordValidateException("市场历史最低价格(17, 2)不能为 null ");
        }
    }

    private void validateSellPriceAverage() {
        if (sellPriceAverage == null) {
            throw new DataRecordValidateException("市场历史平均价格(17, 2)不能为 null ");
        }
    }

    private void validateSellPriceHighest() {
        if (sellPriceHighest == null) {
            throw new DataRecordValidateException("市场历史最高价格(17, 2)不能为 null ");
        }
    }

    private void validateSellPriceLowest() {
        if (sellPriceLowest == null) {
            throw new DataRecordValidateException("市场历史最低价格(17, 2)不能为 null ");
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
