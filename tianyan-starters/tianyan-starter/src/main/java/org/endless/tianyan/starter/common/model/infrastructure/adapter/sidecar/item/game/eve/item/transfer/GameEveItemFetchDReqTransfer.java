package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveItemFetchCReqTransfer
 * <p>游戏EVE资源项获取命令被动请求传输对象
 * <p>
 * itemCreate 2025/07/28 05:10
 * <p>
 * update 2025/08/27 22:08
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @param createUserId    创建用户ID
 * @author Deng Haozhi
 * @see Record
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode", "createUserId"})
public record GameEveItemFetchDReqTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public GameEveItemFetchDReqTransfer validate() {
        return this;
    }
}
