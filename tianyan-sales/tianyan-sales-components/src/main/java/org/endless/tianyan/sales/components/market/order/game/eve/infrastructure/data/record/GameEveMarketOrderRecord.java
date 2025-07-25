package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.*;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.entity.*;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.value.*;
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
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
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
     * 游戏EVE市场订单编号
     */
    private String code;

    /**
     * 订单范围
     */
    private String range;

    /**
     * 游戏EVE市场订单星系编码
     */
    private String systemCode;

    /**
     * 游戏EVE市场订单星系中文名称
     */
    private String systemNameZh;

    /**
     * 游戏EVE市场订单空间站编码
     */
    private String locationCode;

    /**
     * 游戏EVE市场订单空间站中文名称
     */
    private String locationNameZh;

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
                .code(aggregate.getCode())
                .range(aggregate.getRange())
                .systemCode(aggregate.getSystem().getCode())
                .systemNameZh(aggregate.getSystem().getNameZh())
                .locationCode(aggregate.getLocation().getCode())
                .locationNameZh(aggregate.getLocation().getNameZh())
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
                .code(code)
                .range(range)
                .system(GameEveMarketOrderSystemValue.builder()
                        .code(systemCode)
                        .nameZh(systemNameZh)
                        .innerBuild())
                .location(GameEveMarketOrderLocationValue.builder()
                        .code(locationCode)
                        .nameZh(locationNameZh)
                        .innerBuild())
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMarketOrderRecord validate() {
        validateGameEveMarketOrderId();
        validateCode();
        validateRange();
        validateSystemCode();
        validateSystemNameZh();
        validateLocationCode();
        validateLocationNameZh();
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

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE市场订单编号不能为空");
        }
    }

    private void validateRange() {
        if (!StringUtils.hasText(range)) {
            throw new DataRecordValidateException("订单范围不能为空");
        }
    }

    private void validateSystemCode() {
        if (!StringUtils.hasText(systemCode)) {
            throw new DataRecordValidateException("游戏EVE市场订单星系编码不能为空");
        }
    }

    private void validateSystemNameZh() {
        if (!StringUtils.hasText(systemNameZh)) {
            throw new DataRecordValidateException("游戏EVE市场订单星系中文名称不能为空");
        }
    }

    private void validateLocationCode() {
        if (!StringUtils.hasText(locationCode)) {
            throw new DataRecordValidateException("游戏EVE市场订单空间站编码不能为空");
        }
    }

    private void validateLocationNameZh() {
        if (!StringUtils.hasText(locationNameZh)) {
            throw new DataRecordValidateException("游戏EVE市场订单空间站中文名称不能为空");
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
