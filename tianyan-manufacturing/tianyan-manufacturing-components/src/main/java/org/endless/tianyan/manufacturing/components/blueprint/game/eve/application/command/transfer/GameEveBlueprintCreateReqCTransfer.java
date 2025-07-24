package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer;

import org.endless.tianyan.manufacturing.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.type.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GameEveBlueprintCreateReqCTransfer
 * <p>游戏EVE蓝图创建命令请求传输对象
 * <p>
 * create 2025/07/24 09:48
 * <p>
 * update 2025/07/24 09:48
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "code", "type", "materials", "products", "skills", "cycle", "maxProductionLimit", "createUserId"})
public class GameEveBlueprintCreateReqCTransfer implements TianyanManufacturingCommandTransfer {

    /**
     * 游戏EVE资源项ID
     */
    private final String itemId;

    /**
     * 游戏EVE蓝图编码
     */
    private final String code;

    /**
     * 蓝图类型
     */
    private final String type;

    /**
     * 蓝图物料列表
     */
    private final List<GameEveBlueprintMaterialReqCTransfer> materials;

    /**
     * 蓝图产品列表
     */
    private final List<GameEveBlueprintProductReqCTransfer> products;

    /**
     * 蓝图技能列表
     */
    private final List<GameEveBlueprintSkillReqCTransfer> skills;

    /**
     * 蓝图周期
     */
    private final Long cycle;

    /**
     * 游戏EVE蓝图最大生产次数
     */
    private final Integer maxProductionLimit;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveBlueprintCreateReqCTransfer validate() {
        validateItemId();
        validateCode();
        validateType();
        validateCycle();
        validateCreateUserId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandTransferValidateException("游戏EVE资源项ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE蓝图编码不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandTransferValidateException("蓝图类型不能为空");
        }
    }

    private void validateCycle() {
        if (cycle == null || cycle < 0) {
            throw new CommandTransferValidateException("蓝图周期不能为 null 或小于 0，当前值为: " + cycle);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
