package org.endless.tianyan.item.components.item.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * GameEveItemFetchRespCReqTransfer
 * <p>游戏EVE资源项获取命令响应传输对象
 * <p>
 * create 2025/07/28 05:10
 * <p>
 * update 2025/07/28 05:10
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record GameEveItemFetchRespCReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanItemCommandReqTransfer {

    @Override
    public GameEveItemFetchRespCReqTransfer validate() {
        return this;
    }
}
