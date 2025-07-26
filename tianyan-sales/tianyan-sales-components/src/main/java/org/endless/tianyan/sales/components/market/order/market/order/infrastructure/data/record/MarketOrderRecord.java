package org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.value.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MarketOrderRecord
 * <p>市场订单数据库记录实体
 * <p>
 * create 2025/07/26 18:16
 * <p>
 * update 2025/07/26 18:16
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
@TableName(value = "market_order")
public class MarketOrderRecord implements TianyanSalesRecord<MarketOrderAggregate> {

    /**
     * 市场订单ID
     */
    @TableId
    private String marketOrderId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 市场订单类型
     */
    private MarketOrderTypeEnum type;

    /**
     * 市场订单资源项总数(20, 5)
     */
    private BigDecimal itemQuantityTotal;

    /**
     * 市场订单资源项剩余数量(20, 5)
     */
    private BigDecimal itemQuantityRemain;

    /**
     * 市场订单资源项最小交易数量(20, 5)
     */
    private BigDecimal itemQuantityMin;

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

    public static MarketOrderRecord from(MarketOrderAggregate aggregate) {
        String marketOrderId = aggregate.getMarketOrderId();
        return MarketOrderRecord.builder()
                .marketOrderId(marketOrderId)
                .itemId(aggregate.getItemId())
                .type(aggregate.getType())
                .itemQuantityTotal(aggregate.getItemQuantity().getTotal())
                .itemQuantityRemain(aggregate.getItemQuantity().getRemain())
                .itemQuantityMin(aggregate.getItemQuantity().getMin())
                .price(aggregate.getPrice())
                .issuedAt(aggregate.getIssuedAt())
                .expireAt(aggregate.getExpireAt())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public MarketOrderAggregate to() {
        validate();
        return MarketOrderAggregate.builder()
                .marketOrderId(marketOrderId)
                .itemId(itemId)
                .type(type)
                .itemQuantity(MarketOrderItemQuantityValue.builder()
                        .total(itemQuantityTotal)
                        .remain(itemQuantityRemain)
                        .min(itemQuantityMin)
                        .innerBuild())
                .price(price)
                .issuedAt(issuedAt)
                .expireAt(expireAt)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketOrderRecord validate() {
        validateMarketOrderId();
        validateItemId();
        validateType();
        validateItemQuantityTotal();
        validateItemQuantityRemain();
        validateItemQuantityMin();
        validatePrice();
        validateIssuedAt();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new DataRecordValidateException("市场订单ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("市场订单类型不能为 null ");
        }
    }

    private void validateItemQuantityTotal() {
        if (itemQuantityTotal == null) {
            throw new DataRecordValidateException("市场订单资源项总数(20, 5)不能为 null ");
        }
    }

    private void validateItemQuantityRemain() {
        if (itemQuantityRemain == null) {
            throw new DataRecordValidateException("市场订单资源项剩余数量(20, 5)不能为 null ");
        }
    }

    private void validateItemQuantityMin() {
        if (itemQuantityMin == null) {
            throw new DataRecordValidateException("市场订单资源项最小交易数量(20, 5)不能为 null ");
        }
    }

    private void validatePrice() {
        if (price == null) {
            throw new DataRecordValidateException("市场订单价格(17, 2)不能为 null ");
        }
    }

    private void validateIssuedAt() {
        if (issuedAt == null || issuedAt < 0) {
            throw new DataRecordValidateException("市场订单创建时间不能为 null 或小于 0，当前值为: " + issuedAt);
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
