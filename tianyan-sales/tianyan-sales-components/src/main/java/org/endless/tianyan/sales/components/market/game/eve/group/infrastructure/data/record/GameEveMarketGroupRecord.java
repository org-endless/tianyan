package org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.*;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.*;
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
 * GameEveMarketGroupRecord
 * <p>游戏EVE市场分组数据库记录实体
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
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
@TableName(value = "market_game_eve_group")
public class GameEveMarketGroupRecord implements TianyanSalesRecord<GameEveMarketGroupAggregate> {

    /**
     * 游戏EVE市场分组ID
     */
    @TableId
    private String gameEveMarketGroupId;

    /**
     * 市场分组ID
     */
    private String marketGroupId;

    /**
     * 游戏EVE市场分组描述
     */
    private String description;

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

    public static GameEveMarketGroupRecord from(GameEveMarketGroupAggregate aggregate) {
        String gameEveMarketGroupId = aggregate.getGameEveMarketGroupId();
        return GameEveMarketGroupRecord.builder()
                .gameEveMarketGroupId(gameEveMarketGroupId)
                .marketGroupId(aggregate.getMarketGroupId())
                .description(aggregate.getDescription())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveMarketGroupAggregate to() {
        validate();
        return GameEveMarketGroupAggregate.builder()
                .gameEveMarketGroupId(gameEveMarketGroupId)
                .marketGroupId(marketGroupId)
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMarketGroupRecord validate() {
        validateGameEveMarketGroupId();
        validateMarketGroupId();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveMarketGroupId() {
        if (!StringUtils.hasText(gameEveMarketGroupId)) {
            throw new DataRecordValidateException("游戏EVE市场分组ID不能为空");
        }
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new DataRecordValidateException("市场分组ID不能为空");
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
