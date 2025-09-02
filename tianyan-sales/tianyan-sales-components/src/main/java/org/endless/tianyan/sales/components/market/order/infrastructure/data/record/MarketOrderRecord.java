package org.endless.tianyan.sales.components.market.order.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.endless.ddd.starter.common.annotation.validate.ddd.DataRecord;
import org.endless.ddd.starter.common.annotation.validate.number.amount.Amount;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.domain.type.MarketOrderStatusEnum;
import org.endless.tianyan.sales.components.market.order.domain.type.MarketOrderTypeEnum;
import org.endless.tianyan.sales.components.market.order.domain.value.MarketOrderItemQuantityValue;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

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
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "market_order")
public class MarketOrderRecord implements TianyanSalesRecord<MarketOrderAggregate> {

    /**
     * 市场订单ID
     */
    @TableId
    @NotBlank(message = "市场订单ID不能为空")
    private String marketOrderId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 市场订单类型
     */
    @NotNull(message = "市场订单类型不能为空")
    private MarketOrderTypeEnum type;

    /**
     * 市场订单资源项总数(20, 5)
     */
    @NotNull(message = "市场订单资源项总数不能为空")
    private BigDecimal itemQuantityTotal;

    /**
     * 市场订单资源项剩余数量(20, 5)
     */
    @NotNull(message = "市场订单资源项剩余数量不能为空")
    private BigDecimal itemQuantityRemain;

    /**
     * 市场订单资源项最小交易数量(20, 5)
     */
    @NotNull(message = "市场订单资源项最小交易数量不能为空")
    private BigDecimal itemQuantityMin;

    /**
     * 市场订单价格(17, 2)
     */
    @NotNull(message = "市场订单价格不能为空")
    private @Amount BigDecimal price;

    /**
     * 市场订单创建时间
     */
    @NotNull(message = "市场订单创建时间不能为空")
    private Long issuedAt;

    /**
     * 市场订单过期时间
     */
    private Long expireAt;

    @NotNull(message = "市场订单状态不能为空")
    private MarketOrderStatusEnum status;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private String createUserId;

    /**
     * 修改用户ID
     */
    @NotBlank(message = "修改用户ID不能为空")
    private String modifyUserId;

    /**
     * 是否已删除
     */
    @NotNull(message = "是否已删除不能为空")
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

    @NotNull(message = "市场订单数据记录实体不能为空")
    public static @Valid MarketOrderRecord from(
            @NotNull(message = "市场订单聚合根不能为空")
            @Valid MarketOrderAggregate aggregate) {
        return MarketOrderRecord.builder()
                .marketOrderId(aggregate.getMarketOrderId())
                .itemId(aggregate.getItemId())
                .type(aggregate.getType())
                .itemQuantityTotal(aggregate.getItemQuantity().getTotal())
                .itemQuantityRemain(aggregate.getItemQuantity().getRemain())
                .itemQuantityMin(aggregate.getItemQuantity().getMin())
                .price(aggregate.getPrice())
                .issuedAt(aggregate.getIssuedAt())
                .expireAt(aggregate.getExpireAt())
                .status(aggregate.getStatus())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "市场订单聚合根不能为空")
    public @Valid MarketOrderAggregate to() {
        ObjectTools.jsrValidate(this).validate();
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
                .status(status)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketOrderRecord validate() {
        return this;
    }
}
