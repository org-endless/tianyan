package org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.record;

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
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.TianyanManufacturingRecord;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.GameEveBlueprintAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveBlueprintRecord
 * <p>游戏EVE蓝图数据库记录实体
 * <p>
 * create 2025/07/24 09:58
 * <p>
 * update 2025/07/24 09:58
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "blueprint_game_eve")
public class GameEveBlueprintRecord implements TianyanManufacturingRecord<GameEveBlueprintAggregate> {

    /**
     * 游戏EVE蓝图ID
     */
    @TableId
    @NotBlank(message = "游戏EVE蓝图ID不能为空")
    private String gameEveBlueprintId;

    /**
     * 蓝图ID
     */
    @NotBlank(message = "蓝图ID不能为空")
    private String blueprintId;

    /**
     * 游戏EVE蓝图编码
     */
    @NotBlank(message = "游戏EVE蓝图编码不能为空")
    private String code;

    /**
     * 游戏EVE蓝图最大生产次数
     */
    @NotNull(message = "游戏EVE蓝图最大生产次数不能为空")
    private Integer maxProductionLimit;

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

    @NotNull(message = "游戏EVE蓝图数据记录实体不能为空")
    public static @Valid GameEveBlueprintRecord from(
            @NotNull(message = "游戏EVE蓝图聚合根不能为空")
            @Valid GameEveBlueprintAggregate aggregate) {
        return GameEveBlueprintRecord.builder()
                .gameEveBlueprintId(aggregate.getGameEveBlueprintId())
                .blueprintId(aggregate.getBlueprintId())
                .code(aggregate.getCode())
                .maxProductionLimit(aggregate.getMaxProductionLimit())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "游戏EVE蓝图聚合根不能为空")
    public GameEveBlueprintAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return GameEveBlueprintAggregate.builder()
                .gameEveBlueprintId(gameEveBlueprintId)
                .blueprintId(blueprintId)
                .code(code)
                .maxProductionLimit(maxProductionLimit)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveBlueprintRecord validate() {
        return this;
    }
}
