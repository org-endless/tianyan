package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.*;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.*;
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
 * GameEveMarketOrderRecord
 * <p>游戏EVE市场订单数据库记录实体
 * <p>
 * create 2025/07/25 16:33
 * <p>
 * update 2025/07/25 16:33
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
@TableName(value = "market_order_game_eve")
public class GameEveMarketOrderRecord implements TianyanSalesRecord<GameEveMarketOrderAggregate> {

    /**
     * 游戏EVE市场订单ID
     */
    @TableId
    private String gameEveMarketOrderId;

    /**
     * 市场订单ID
     */
    private String marketOrderId;

    /**
     * 游戏EVE市场订单编号
     */
    private String code;

    /**
     * 游戏EVE市场订单范围
     */
    private String range;

    /**
     * 游戏EVE市场订单星系ID
     */
    private String systemId;

    /**
     * 游戏EVE市场订单空间站ID
     */
    private String stationId;

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

    public static GameEveMarketOrderRecord from(GameEveMarketOrderAggregate aggregate) {
        String gameEveMarketOrderId = aggregate.getGameEveMarketOrderId();
        return GameEveMarketOrderRecord.builder()
                .gameEveMarketOrderId(gameEveMarketOrderId)
                .marketOrderId(aggregate.getMarketOrderId())
                .code(aggregate.getCode())
                .range(aggregate.getRange())
                .systemId(aggregate.getSystemId())
                .stationId(aggregate.getStationId())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveMarketOrderAggregate to() {
        validate();
        return GameEveMarketOrderAggregate.builder()
                .gameEveMarketOrderId(gameEveMarketOrderId)
                .marketOrderId(marketOrderId)
                .code(code)
                .range(range)
                .systemId(systemId)
                .stationId(stationId)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMarketOrderRecord validate() {
        validateGameEveMarketOrderId();
        validateMarketOrderId();
        validateCode();
        validateRange();
        validateSystemId();
        validateStationId();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveMarketOrderId() {
        if (!StringUtils.hasText(gameEveMarketOrderId)) {
            throw new DataRecordValidateException("游戏EVE市场订单ID不能为空");
        }
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new DataRecordValidateException("市场订单ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE市场订单编号不能为空");
        }
    }

    private void validateRange() {
        if (!StringUtils.hasText(range)) {
            throw new DataRecordValidateException("游戏EVE市场订单范围不能为空");
        }
    }

    private void validateSystemId() {
        if (!StringUtils.hasText(systemId)) {
            throw new DataRecordValidateException("游戏EVE市场订单星系ID不能为空");
        }
    }

    private void validateStationId() {
        if (!StringUtils.hasText(stationId)) {
            throw new DataRecordValidateException("游戏EVE市场订单空间站ID不能为空");
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
