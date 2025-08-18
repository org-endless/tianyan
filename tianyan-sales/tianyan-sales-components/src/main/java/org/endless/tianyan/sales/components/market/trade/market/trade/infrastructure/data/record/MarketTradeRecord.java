package org.endless.tianyan.sales.components.market.trade.market.trade.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.trade.market.trade.domain.entity.MarketTradeAggregate;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * MarketTradeRecord
 * <p>市场交易数据库记录实体
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
@TableName(value = "market_trade")
public class MarketTradeRecord implements TianyanSalesRecord<MarketTradeAggregate> {

    /**
     * 市场交易ID
     */
    @TableId
    private String marketTradeId;

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

    public static MarketTradeRecord from(MarketTradeAggregate aggregate) {
        String marketTradeId = aggregate.getMarketTradeId();
        return MarketTradeRecord.builder()
                .marketTradeId(marketTradeId)
                .itemId(aggregate.getItemId())
                .price(aggregate.getPrice())
                .itemQuantity(aggregate.getItemQuantity())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public MarketTradeAggregate to() {
        validate();
        return MarketTradeAggregate.builder()
                .marketTradeId(marketTradeId)
                .itemId(itemId)
                .price(price)
                .itemQuantity(itemQuantity)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketTradeRecord validate() {
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
            throw new DataRecordValidateException("市场交易ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validatePrice() {
        if (price == null) {
            throw new DataRecordValidateException("成交价格(17, 2)不能为 null ");
        }
    }

    private void validateItemQuantity() {
        if (!StringUtils.hasText(itemQuantity)) {
            throw new DataRecordValidateException("资源项交易数量(20, 5)不能为空");
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
