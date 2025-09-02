package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

import java.util.List;

/**
 * GameEveDataFileBlueprintActivityRespDTransfer
 * <p>游戏EVE数据文件蓝图工序被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param materials 工序物料列表
 * @param products  工序产品列表
 * @param skills    工序技能列表
 * @param time      工序耗时
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"time", "materials", "products", "skills"})
public record GameEveDataFileBlueprintActivityRespDReqTransfer(
        @Valid List<GameEveDataFileBlueprintMaterialRespDReqTransfer> materials,
        @NotEmpty @Valid List<GameEveDataFileBlueprintProductRespDReqTransfer> products,
        @Valid List<GameEveDataFileBlueprintSkillRespDReqTransfer> skills,
        @NotNull(message = "工序耗时不能为空") Long time
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileBlueprintActivityRespDReqTransfer validate() {
        return this;
    }
}
