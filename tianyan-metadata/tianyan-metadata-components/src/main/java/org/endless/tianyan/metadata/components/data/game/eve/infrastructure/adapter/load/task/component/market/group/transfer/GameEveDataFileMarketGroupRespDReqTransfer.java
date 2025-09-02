package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.market.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameDRespTransfer;

/**
 * GameEveDataFileMarketGroupRespDTransfer
 * <p>游戏EVE数据文件市场分组被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param nameID        市场分组名称
 * @param parentGroupID 父市场分组编码
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"nameID", "parentGroupID"})
public record GameEveDataFileMarketGroupRespDReqTransfer(
        @NotNull(message = "市场分组名称不能为空") @Valid GameEveDataFileNameDRespTransfer nameID,
        String parentGroupID
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileMarketGroupRespDReqTransfer validate() {
        return this;
    }
}
