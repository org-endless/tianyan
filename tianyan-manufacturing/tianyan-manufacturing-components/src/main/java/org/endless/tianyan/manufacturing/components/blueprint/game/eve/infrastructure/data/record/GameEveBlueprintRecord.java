package org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity.*;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.type.*;
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
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "blueprint_game_eve")
public class GameEveBlueprintRecord implements TianyanManufacturingRecord<GameEveBlueprintAggregate> {

    /**
     * 游戏EVE蓝图ID
     */
    @TableId
    private String gameEveBlueprintId;

    /**
     * 蓝图ID
     */
    private String blueprintId;

    /**
     * 游戏EVE蓝图编码
     */
    private String code;

    /**
     * 游戏EVE蓝图类型
     */
    private GameEveBlueprintTypeEnum type;

    /**
     * 游戏EVE蓝图最大生产次数
     */
    private Integer maxProductionLimit;

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

    public static GameEveBlueprintRecord from(GameEveBlueprintAggregate aggregate) {
        String gameEveBlueprintId = aggregate.getGameEveBlueprintId();
        return GameEveBlueprintRecord.builder()
                .gameEveBlueprintId(gameEveBlueprintId)
                .blueprintId(aggregate.getBlueprintId())
                .code(aggregate.getCode())
                .type(aggregate.getType())
                .maxProductionLimit(aggregate.getMaxProductionLimit())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveBlueprintAggregate to() {
        validate();
        return GameEveBlueprintAggregate.builder()
                .gameEveBlueprintId(gameEveBlueprintId)
                .blueprintId(blueprintId)
                .code(code)
                .type(type)
                .maxProductionLimit(maxProductionLimit)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveBlueprintRecord validate() {
        validateGameEveBlueprintId();
        validateBlueprintId();
        validateCode();
        validateType();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveBlueprintId() {
        if (!StringUtils.hasText(gameEveBlueprintId)) {
            throw new DataRecordValidateException("游戏EVE蓝图ID不能为空");
        }
    }

    private void validateBlueprintId() {
        if (!StringUtils.hasText(blueprintId)) {
            throw new DataRecordValidateException("蓝图ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE蓝图编码不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new DataRecordValidateException("游戏EVE蓝图类型不能为 null ");
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
