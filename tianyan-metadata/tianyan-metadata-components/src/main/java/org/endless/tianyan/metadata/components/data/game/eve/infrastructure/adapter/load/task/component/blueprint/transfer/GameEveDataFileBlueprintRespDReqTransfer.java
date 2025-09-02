package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

/**
 * GameEveDataFileBlueprintRespDTransfer
 * <p>游戏EVE数据文件蓝图被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param blueprintTypeID    蓝图资源项编码
 * @param activities         蓝图工序列表
 * @param maxProductionLimit 蓝图最大生产次数
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"activities", "blueprintTypeID", "maxProductionLimit"})
public record GameEveDataFileBlueprintRespDReqTransfer(
        @NotBlank(message = "蓝图资源项编码不能为空") String blueprintTypeID,
        @NotNull(message = "蓝图工序列表不能为空") @Valid GameEveDataFileBlueprintActivitiesRespDReqTransfer activities,
        @NotNull(message = "蓝图最大生产次数不能为空") Integer maxProductionLimit
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileBlueprintRespDReqTransfer validate() {
        return this;
    }
}
