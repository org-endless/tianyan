package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveItemCreateDReqTransfer
 * <p>游戏EVE资源项创建命令被动请求传输对象
 * <p>
 * create 2025/08/23 03:24
 * <p>
 * update 2025/08/23 04:18
 *
 * @param itemId          资源项ID
 * @param gameEveItemCode 游戏EVE资源项编码
 * @param isPublished     游戏EVE资源项是否发布
 * @param createUserId    创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId", "gameEveItemCode", "isPublished", "createUserId"})
public record GameEveItemCreateDReqTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId,
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
        @NotNull(message = "游戏EVE资源项是否发布不能为空") Boolean isPublished,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public GameEveItemCreateDReqTransfer validate() {
        return this;
    }
}
