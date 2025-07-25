package org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateRemoveException;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateValidateException;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.type.GameEveBlueprintTypeEnum;
import org.springframework.util.StringUtils;

/**
 * GameEveBlueprintAggregate
 * <p>游戏EVE蓝图聚合根
 * <p>
 * create 2025/07/24 09:58
 * <p>
 * update 2025/07/24 09:58
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveBlueprintAggregate implements TianyanManufacturingAggregate {

    /**
     * 游戏EVE蓝图ID
     */
    private final String gameEveBlueprintId;

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
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static GameEveBlueprintAggregate create(GameEveBlueprintAggregateBuilder builder) {
        return builder
                .gameEveBlueprintId(IdGenerator.of())
                .blueprintId(builder.blueprintId)
                .code(builder.code)
                .type(builder.type)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public GameEveBlueprintAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE蓝图聚合根>不能再次删除, ID: " + gameEveBlueprintId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE蓝图聚合根>处于不可删除状态, ID: " + gameEveBlueprintId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveBlueprintAggregate validate() {
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
            throw new AggregateValidateException("游戏EVE蓝图ID不能为空");
        }
    }

    private void validateBlueprintId() {
        if (!StringUtils.hasText(blueprintId)) {
            throw new AggregateValidateException("蓝图ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE蓝图编码不能为空");
        }
    }

    private void validateType() {
        if (type == null) {
            throw new AggregateValidateException("游戏EVE蓝图类型不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}
