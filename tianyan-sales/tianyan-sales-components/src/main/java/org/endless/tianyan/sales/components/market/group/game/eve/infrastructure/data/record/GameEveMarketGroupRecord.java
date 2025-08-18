package org.endless.tianyan.sales.components.market.group.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.group.game.eve.domain.entity.GameEveMarketGroupAggregate;
import org.springframework.util.StringUtils;

/**
 * GameEveMarketGroupRecord
 * <p>游戏EVE市场分组数据库记录实体
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
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
@TableName(value = "market_group_game_eve")
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
     * 游戏EVE市场分组编码
     */
    private String code;

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
                .code(aggregate.getCode())
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
                .code(code)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMarketGroupRecord validate() {
        validateGameEveMarketGroupId();
        validateMarketGroupId();
        validateCode();
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

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE市场分组编码不能为空");
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
