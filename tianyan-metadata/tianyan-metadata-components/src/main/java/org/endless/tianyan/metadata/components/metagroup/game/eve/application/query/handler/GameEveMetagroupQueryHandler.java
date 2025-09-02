package org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.metadata.common.model.application.query.handler.TianyanMetadataQueryHandler;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer.FindByGameEveMetagroupCodeQReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer.FindMetagroupIdQRespTransfer;

/**
 * GameEveMetagroupQueryHandler
 * <p>游戏EVE元分组领域查询处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataQueryHandler
 * @since 0.0.1
 */
public interface GameEveMetagroupQueryHandler extends TianyanMetadataQueryHandler {

    /**
     * 根据游戏EVE元分组编码查询元分组ID
     *
     * @param query 根据游戏EVE元分组编码查询请求传输对象
     * @return {@link FindMetagroupIdQRespTransfer }
     */
    @Valid
    @NotNull(message = "元分组ID查询响应传输对象不能为空")
    FindMetagroupIdQRespTransfer findMetagroupIdByCode(
            @NotNull(message = "根据游戏EVE元分组编码查询请求传输对象不能为空")
            @Valid FindByGameEveMetagroupCodeQReqTransfer query);
}
