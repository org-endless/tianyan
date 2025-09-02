package org.endless.tianyan.sales.components.market.price.price.infrastructure.data.record;

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
import org.endless.tianyan.sales.components.market.price.price.domain.entity.MarketPriceAggregate;
import org.springframework.validation.annotation.Validated;

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
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "market_price")
public class MarketPriceRecord implements TianyanSalesRecord<MarketPriceAggregate> {

    /**
     * 市场价格ID
     */
    @TableId
    @NotBlank(message = "市场价格ID不能为空")
    private String marketPriceId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 买入价格(17, 2)
     */
    @NotNull(message = "买入价格不能为空")
    private @Amount BigDecimal buyPrice;

    /**
     * 卖出价格(17, 2)
     */
    @NotNull(message = "卖出价格不能为空")
    private @Amount BigDecimal sellPrice;

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

    @NotNull(message = "市场价格数据记录实体不能为空")
    public static MarketPriceRecord from(
            @NotNull(message = "市场价格聚合根不能为空")
            @Valid MarketPriceAggregate aggregate) {
        return MarketPriceRecord.builder()
                .marketPriceId(aggregate.getMarketPriceId())
                .itemId(aggregate.getItemId())
                .buyPrice(aggregate.getBuyPrice())
                .sellPrice(aggregate.getSellPrice())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "市场价格聚合根不能为空")
    public @Valid MarketPriceAggregate to() {
        ObjectTools.jsrValidate(this).validate();
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
        return this;
    }
}
