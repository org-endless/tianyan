package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.*;
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
 * GameEveBlueprintCreateReqDTransfer
 * <p>游戏EVE蓝图创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 10:31
 * <p>
 * update 2025/07/24 10:31
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "code", "type", "materials", "products", "skills", "cycle", "maxProductionLimit", "createUserId"})
public class GameEveBlueprintCreateReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 资源项ID
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
    private final List<GameEveBlueprintMaterialReqDTransfer> materials;

    /**
     * 蓝图产品列表
     */
    private final List<GameEveBlueprintProductReqDTransfer> products;

    /**
     * 蓝图技能列表
     */
    private final List<GameEveBlueprintSkillReqDTransfer> skills;

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
    public GameEveBlueprintCreateReqDTransfer validate() {
        validateItemId();
        validateCode();
        validateType();
        validateCycle();
        validateCreateUserId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DrivenTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenTransferValidateException("游戏EVE蓝图编码不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new DrivenTransferValidateException("蓝图类型不能为空");
        }
    }

    private void validateCycle() {
        if (cycle == null || cycle < 0) {
            throw new DrivenTransferValidateException("蓝图周期不能为 null 或小于 0，当前值为: " + cycle);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenTransferValidateException("创建用户ID不能为空");
        }
    }
}
