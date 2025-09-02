package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

/**
 * GameEveDataFileBlueprintMaterialRespDTransfer
 * <p>游戏EVE数据文件蓝图物料被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param typeID   蓝图物料资源项编码
 * @param quantity 蓝图物料数量
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"quantity", "typeID"})
public record GameEveDataFileBlueprintMaterialRespDReqTransfer(
        @NotBlank(message = "蓝图物料资源项编码不能为空") String typeID,
        @NotNull(message = "蓝图物料数量不能为空") Long quantity
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileBlueprintMaterialRespDReqTransfer validate() {
        return this;
    }
}
