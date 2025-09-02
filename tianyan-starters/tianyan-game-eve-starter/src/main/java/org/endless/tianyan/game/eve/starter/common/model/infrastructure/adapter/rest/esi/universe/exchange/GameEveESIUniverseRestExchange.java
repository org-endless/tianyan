package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.exchange.GameEveESIRestExchange;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.transfer.FindESIUniverseItemDRespTransfer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * GameEveESICommonRestExchange
 * <p>
 * create 2025/08/27 21:56
 * <p>
 * update 2025/08/27 21:56
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public interface GameEveESIUniverseRestExchange extends GameEveESIRestExchange {

    @Valid
    @NotNull(message = "获取ESI资源项被动响应传输对象不能为空")
    @GetExchange("/universe/types/{type_id}/")
    FindESIUniverseItemDRespTransfer fetchItem(
            @NotBlank(message = "游戏EVE资源项编码不能为空") @PathVariable("type_id") String gameEveIemCode,
            @NotBlank(message = "游戏EVE-ESI数据源不能为空") @RequestParam("datasource") String datasource,
            @NotBlank(message = "游戏EVE-ESI语言不能为空") @RequestParam("language") String language
    );
}
