package org.endless.tianyan.item.components.item.game.eve.item.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * GameEveItemCreateReqCReqTransfer
 * <p>游戏EVE资源项创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/28 05:10
 * <p>
 * update 2025/07/28 05:10
 *
 * @param itemId          资源项ID
 * @param gameEveItemCode 游戏EVE资源项编码
 * @param isPublished     游戏EVE资源项是否发布
 * @param createUserId    创建用户ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId", "gameEveItemCode", "isPublished", "createUserId"})
public record GameEveItemCreateCReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId,
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
        @NotNull(message = "游戏EVE资源项是否发布不能为空") Boolean isPublished,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public GameEveItemCreateCReqTransfer validate() {
        return this;
    }
}
