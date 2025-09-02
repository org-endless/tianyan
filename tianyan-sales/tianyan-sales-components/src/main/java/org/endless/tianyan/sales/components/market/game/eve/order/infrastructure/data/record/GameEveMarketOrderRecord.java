package org.endless.tianyan.sales.components.market.game.eve.order.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.endless.ddd.starter.common.annotation.validate.ddd.DataRecord;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.entity.GameEveMarketOrderAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMarketOrderRecord
 * <p>游戏EVE市场订单数据库记录实体
 * <p>
 * create 2025/07/26 07:14
 * <p>
 * update 2025/07/26 07:14
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
@TableName(value = "market_order_game_eve")
public class GameEveMarketOrderRecord implements TianyanSalesRecord<GameEveMarketOrderAggregate> {

    /**
     * 游戏EVE市场订单ID
     */
    @TableId
    @NotBlank(message = "游戏EVE市场订单ID不能为空")
    private String gameEveMarketOrderId;

    /**
     * 市场订单ID
     */
    @NotBlank(message = "市场订单ID不能为空")
    private String marketOrderId;

    /**
     * 游戏EVE市场订单编号
     */
    @NotBlank(message = "游戏EVE市场订单编号不能为空")
    private String code;

    /**
     * 游戏EVE市场订单范围
     */
    @NotBlank(message = "游戏EVE市场订单范围不能为空")
    private String orderRange;

    /**
     * 游戏EVE市场订单星系ID
     */
    @NotBlank(message = "游戏EVE市场订单星系ID不能为空")
    private String systemId;

    /**
     * 游戏EVE市场订单空间站ID
     */
    @NotBlank(message = "游戏EVE市场订单空间站ID不能为空")
    private String stationId;

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

    @NotNull(message = "游戏EVE市场订单数据记录实体不能为空")
    public static GameEveMarketOrderRecord from(
            @NotNull(message = "游戏EVE市场订单聚合根不能为空")
            @Valid GameEveMarketOrderAggregate aggregate) {
        return GameEveMarketOrderRecord.builder()
                .gameEveMarketOrderId(aggregate.getGameEveMarketOrderId())
                .marketOrderId(aggregate.getMarketOrderId())
                .code(aggregate.getCode())
                .orderRange(aggregate.getOrderRange())
                .systemId(aggregate.getSystemId())
                .stationId(aggregate.getStationId())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "游戏EVE市场订单聚合根不能为空")
    public GameEveMarketOrderAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return GameEveMarketOrderAggregate.builder()
                .gameEveMarketOrderId(gameEveMarketOrderId)
                .marketOrderId(marketOrderId)
                .code(code)
                .orderRange(orderRange)
                .systemId(systemId)
                .stationId(stationId)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMarketOrderRecord validate() {
        return this;
    }
}
