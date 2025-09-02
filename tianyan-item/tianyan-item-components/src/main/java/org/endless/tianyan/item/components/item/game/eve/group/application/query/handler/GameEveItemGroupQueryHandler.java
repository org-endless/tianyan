package org.endless.tianyan.item.components.item.game.eve.group.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.query.handler.TianyanItemQueryHandler;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer.FindByGameEveItemGroupCodeQReqTransfer;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer.FindItemGroupIdQRespTransfer;

/**
 * GameEveItemGroupQueryHandler
 * <p>游戏EVE资源项分组领域查询处理器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryHandler
 * @since 0.0.1
 */
public interface GameEveItemGroupQueryHandler extends TianyanItemQueryHandler {

    @Valid
    @NotNull(message = "资源项分组ID查询响应传输对象不能为空")
    FindItemGroupIdQRespTransfer findItemGroupIdByCode(
            @NotNull(message = "根据编码游戏EVE资源项分组查询请求传输对象不能为空")
            @Valid FindByGameEveItemGroupCodeQReqTransfer query);
}
