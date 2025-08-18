package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveBlueprintSkillReqDTransfer
 * <p>游戏EVE蓝图技能命令被动请求传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "level"})
public class GameEveBlueprintSkillReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图技能等级
     */
    private final String level;

    @Override
    public GameEveBlueprintSkillReqDTransfer validate() {
        validateItemId();
        validateLevel();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DrivenReqTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateLevel() {
        if (!StringUtils.hasText(level)) {
            throw new DrivenReqTransferValidateException("蓝图技能等级不能为空");
        }
    }
}
