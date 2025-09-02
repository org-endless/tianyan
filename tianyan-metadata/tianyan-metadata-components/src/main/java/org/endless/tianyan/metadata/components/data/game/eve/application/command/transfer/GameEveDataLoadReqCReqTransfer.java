package org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.application.command.transfer.TianyanMetadataCommandReqTransfer;

/**
 * GameEveDataLoadReqCTransfer
 * <p>游戏EVE数据加载命令请求传输对象
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 * update 2025/08/22 01:06
 *
 * @param dataType 数据类型
 * @author Deng Haozhi
 * @see TianyanMetadataCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveDataType"})
public record GameEveDataLoadReqCReqTransfer(
        @NotBlank(message = "游戏EVE数据类型不能为空") String gameEveDataType
) implements TianyanMetadataCommandReqTransfer {

    @Override
    public GameEveDataLoadReqCReqTransfer validate() {
        return this;
    }
}
