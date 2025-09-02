package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

/**
 * GameEveDataFileBlueprintProductRespDTransfer
 * <p>游戏EVE数据文件蓝图产品被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param typeID      资源项编码
 * @param quantity    蓝图产品数量
 * @param probability 成功率
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"quantity", "typeID", "probability"})
public record GameEveDataFileBlueprintProductRespDReqTransfer(
        @NotBlank(message = "资源项编码不能为空") String typeID,
        @NotNull(message = "蓝图产品数量不能为空") Long quantity,
        String probability) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileBlueprintProductRespDReqTransfer validate() {
        return this;
    }
}
