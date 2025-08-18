package org.endless.tianyan.sales.components.market.price.market.price.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.price.market.price.domain.entity.MarketPriceAggregate;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketPriceRecord
 * <p>市场价格数据库记录实体
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
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
@TableName(value = "market_price")
public class MarketPriceRecord implements TianyanSalesRecord<MarketPriceAggregate> {

    /**
     * 市场价格ID
     */
    @TableId
    private String marketPriceId;

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

    public static MarketPriceRecord from(MarketPriceAggregate aggregate) {
        String marketPriceId = aggregate.getMarketPriceId();
        return MarketPriceRecord.builder()
                .marketPriceId(marketPriceId)
                .itemId(aggregate.getItemId())
                .buyPrice(aggregate.getBuyPrice())
                .sellPrice(aggregate.getSellPrice())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public MarketPriceAggregate to() {
        validate();
        return MarketPriceAggregate.builder()
                .marketPriceId(marketPriceId)
                .itemId(itemId)
                .buyPrice(buyPrice)
                .sellPrice(sellPrice)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketPriceRecord validate() {
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
            throw new DataRecordValidateException("市场价格ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validateBuyPrice() {
        if (buyPrice == null) {
            throw new DataRecordValidateException("买入价格(17, 2)不能为 null ");
        }
    }

    private void validateSellPrice() {
        if (sellPrice == null) {
            throw new DataRecordValidateException("卖出价格(17, 2)不能为 null ");
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
