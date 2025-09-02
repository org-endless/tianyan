package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

/**
 * GameEveDataFileBlueprintActivitiesRespDTransfer
 * <p>游戏EVE数据文件蓝图工序被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param copying           复制工序
 * @param invention         研发工艺
 * @param manufacturing     生产工序
 * @param research_material 物流研究工序
 * @param research_time     周期研究工序
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"copying", "invention", "manufacturing", "research_material", "research_time"})
public record GameEveDataFileBlueprintActivitiesRespDReqTransfer(
        @Valid GameEveDataFileBlueprintActivityRespDReqTransfer copying,
        @Valid GameEveDataFileBlueprintActivityRespDReqTransfer invention,
        @Valid GameEveDataFileBlueprintActivityRespDReqTransfer manufacturing,
        @Valid GameEveDataFileBlueprintActivityRespDReqTransfer research_material,
        @Valid GameEveDataFileBlueprintActivityRespDReqTransfer research_time
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileBlueprintActivitiesRespDReqTransfer validate() {
        return this;
    }
}
