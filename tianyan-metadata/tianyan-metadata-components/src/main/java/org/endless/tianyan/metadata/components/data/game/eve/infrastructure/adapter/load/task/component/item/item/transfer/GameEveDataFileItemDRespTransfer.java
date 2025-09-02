package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenRespTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameDRespTransfer;

/**
 * GameEveDataFileItemRespDTransfer
 * <p>游戏EVE数据文件资源项被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param groupID       游戏EVE资源项分组编码
 * @param metaGroupID   游戏EVE元分组编码
 * @param marketGroupID 游戏EVE市场分组编码
 * @param name          游戏EVE资源项名称
 * @param basePrice     游戏EVE资源项基准价格
 * @param published     游戏EVE资源项是否发布
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"groupID", "metaGroupID", "marketGroupID", "name", "basePrice", "published"})
public record GameEveDataFileItemDRespTransfer(
        @NotBlank(message = "游戏EVE资源项分组编码不能为空") String groupID,
        String metaGroupID,
        String marketGroupID,
        @NotNull(message = "游戏EVE资源项名称不能为空") @Valid GameEveDataFileNameDRespTransfer name,
        String basePrice,
        @NotNull(message = "游戏EVE资源项是否发布不能为空") Boolean published
) implements TianyanMetadataDrivenRespTransfer {

    @Override
    public GameEveDataFileItemDRespTransfer validate() {
        return this;
    }
}
