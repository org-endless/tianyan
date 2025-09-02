package org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.record;

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
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.GameEveMarketGroupAggregate;
import org.springframework.validation.annotation.Validated;

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
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "market_group_game_eve")
public class GameEveMarketGroupRecord implements TianyanSalesRecord<GameEveMarketGroupAggregate> {

    /**
     * 游戏EVE市场分组ID
     */
    @TableId
    @NotBlank(message = "游戏EVE市场分组ID不能为空")
    private String gameEveMarketGroupId;

    /**
     * 市场分组ID
     */
    @NotBlank(message = "市场分组ID不能为空")
    private String marketGroupId;

    /**
     * 游戏EVE市场分组编码
     */
    @NotBlank(message = "游戏EVE市场分组编码不能为空")
    private String code;

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

    @NotNull(message = "游戏EVE市场分组数据记录实体不能为空")
    public static @Valid GameEveMarketGroupRecord from(
            @NotNull(message = "游戏EVE市场分组聚合根不能为空")
            @Valid GameEveMarketGroupAggregate aggregate) {
        return GameEveMarketGroupRecord.builder()
                .gameEveMarketGroupId(aggregate.getGameEveMarketGroupId())
                .marketGroupId(aggregate.getMarketGroupId())
                .code(aggregate.getCode())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    @NotNull(message = "游戏EVE市场分组聚合根不能为空")
    public GameEveMarketGroupAggregate to() {
        ObjectTools.jsrValidate(this).validate();
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
        return this;
    }
}
