package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.manufacturing.common.model.application.command.transfer.TianyanManufacturingCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveBlueprintSkillReqCTransfer
 * <p>游戏EVE蓝图技能命令请求传输对象
 * <p>
 * create 2025/07/24 10:43
 * <p>
 * update 2025/07/24 10:43
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "level"})
public class GameEveBlueprintSkillReqCTransfer implements TianyanManufacturingCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图技能等级
     */
    private final String level;

    @Override
    public GameEveBlueprintSkillReqCTransfer validate() {
        validateItemId();
        validateLevel();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandReqTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateLevel() {
        if (!StringUtils.hasText(level)) {
            throw new CommandReqTransferValidateException("蓝图技能等级不能为空");
        }
    }
}
