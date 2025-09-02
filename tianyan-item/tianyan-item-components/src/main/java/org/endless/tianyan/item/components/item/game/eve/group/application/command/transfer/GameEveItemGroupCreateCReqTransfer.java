package org.endless.tianyan.item.components.item.game.eve.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * GameEveItemGroupCreateReqCReqTransfer
 * <p>游戏EVE资源项分组创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:19
 * <p>
 * update 2025/07/24 20:19
 *
 * @param itemGroupId          资源项分组ID
 * @param gameEveItemGroupCode 游戏EVE资源项分组编码
 * @param isPublished          游戏EVE资源项分组是否发布
 * @param isUseBasePrice       游戏EVE资源项分组是否使用基准价格
 * @param createUserId         创建用户ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@JSONType(orders = {"gameEveItemGroupCode", "itemGroupId", "isPublished", "isUseBasePrice", "createUserId"})
public record GameEveItemGroupCreateCReqTransfer(
        @NotBlank(message = "资源项分组ID不能为空") String itemGroupId,
        @NotBlank(message = "游戏EVE资源项分组编码不能为空") String gameEveItemGroupCode,
        @NotNull(message = "游戏EVE资源项分组是否发布不能为空") Boolean isPublished,
        @NotNull(message = "游戏EVE资源项分组是否使用基准价格不能为空") Boolean isUseBasePrice,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public GameEveItemGroupCreateCReqTransfer validate() {
        return this;
    }
}
