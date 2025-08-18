package org.endless.tianyan.item.components.item.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * GameEveItemFetchReqCReqTransfer
 * <p>游戏EVE资源项获取命令请求传输对象
 * <p>
 * create 2025/07/28 05:10
 * <p>
 * update 2025/07/28 05:10
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @param createUserId    创建用户ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode", "createUserId"})
public record GameEveItemFetchReqCReqTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public GameEveItemFetchReqCReqTransfer validate() {
        return this;
    }
}
