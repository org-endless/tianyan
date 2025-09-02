package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.GameEveESICommonRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.transfer.FindESIUniverseItemDRespTransfer;

/**
 * GameEveESIUniverseRestClient
 * <p>
 * create 2025/08/27 21:35
 * <p>
 * update 2025/08/27 21:57
 *
 * @author Deng Haozhi
 * @see GameEveESICommonRestClient
 * @since 1.0.0
 */
public interface GameEveESIUniverseRestClient extends GameEveESICommonRestClient {

    /**
     * 获取资源项
     *
     * @param gameEveItemCode 游戏EVE资源项编码
     * @return {@link FindPageRespTransfer }
     */
    @Valid
    @NotNull(message = "获取ESI资源项被动响应传输对象不能为空")
    FindESIUniverseItemDRespTransfer fetchItem(
            @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode);
}
