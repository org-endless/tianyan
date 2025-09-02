package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.metagroup.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameDRespTransfer;

/**
 * GameEveDataFileMetaGroupRespDTransfer
 * <p>游戏EVE数据文件元分组被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/08/24 00:22
 *
 * @param name 元分组名称
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"nameID"})
public record GameEveDataFileMetagroupDRespTransfer(
        @NotNull(message = "元分组名称不能为空")
        @Valid GameEveDataFileNameDRespTransfer nameID
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileMetagroupDRespTransfer validate() {
        return this;
    }
}
