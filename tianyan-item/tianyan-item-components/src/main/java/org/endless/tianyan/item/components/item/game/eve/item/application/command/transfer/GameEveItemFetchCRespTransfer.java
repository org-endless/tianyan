package org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandRespTransfer;

/**
 * GameEveItemFetchCRespTransfer
 * <p>游戏EVE资源项获取命令响应传输对象
 * <p>
 * itemCreate 2025/07/24 20:14
 * <p>
 * update 2025/08/18 18:21:19
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanItemCommandRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record GameEveItemFetchCRespTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanItemCommandRespTransfer {

    @Override
    public GameEveItemFetchCRespTransfer validate() {
        return this;
    }
}
