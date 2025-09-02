package org.endless.tianyan.sales.components.market.price.price.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.annotation.validate.number.amount.Amount;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.sales.common.model.domain.entity.TianyanSalesAggregate;
import org.springframework.validation.annotation.Validated;

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
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class MarketPriceAggregate implements TianyanSalesAggregate {

    /**
     * 市场价格ID
     */
    @NotBlank(message = "市场价格ID不能为空")
    private final String marketPriceId;

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
    private final String createUserId;

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

    @NotNull(message = "市场价格聚合根创建方法返回对象不能为空")
    public static @Valid MarketPriceAggregate create(
            @NotNull(message = "市场价格聚合根构造器不能为空")
            MarketPriceAggregateBuilder builder) {
        return builder
                .marketPriceId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    @NotNull(message = "市场价格聚合根删除方法返回对象不能为空")
    public @Valid MarketPriceAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场价格聚合根>不能再次删除, ID: " + marketPriceId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public MarketPriceAggregate validate() {
        return this;
    }
}
