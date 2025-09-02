package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

/**
 * GameEveDataFileBlueprintSkillRespDTransfer
 * <p>游戏EVE数据文件蓝图技能被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param typeID 技能资源项编码
 * @param level  技能等级
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"level", "typeID"})
public record GameEveDataFileBlueprintSkillRespDReqTransfer(
        @NotBlank(message = "技能资源项编码不能为空") String typeID,
        @NotBlank(message = "技能等级不能为空") String level
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileBlueprintSkillRespDReqTransfer validate() {
        return this;
    }
}
