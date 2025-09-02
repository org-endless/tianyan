package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.exchange.GameEveESIRestExchange;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderDRespTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * GameEveESIMarketOrderRestExchange
 * <p>
 * create 2025/08/27 00:08
 * <p>
 * update 2025/08/27 00:09
 *
 * @author Deng Haozhi
 * @see GameEveESIRestExchange
 * @since 1.0.0
 */
public interface GameEveESIMarketOrderRestExchange extends GameEveESIRestExchange {

    @Valid
    @NotNull(message = "获取游戏EVE市场订单列表返回体不能为空")
    @GetExchange("/markets/{region_id}/orders/")
    ResponseEntity<List<FindESIMarketOrderDRespTransfer>> fetchMarketOrders(
            @NotBlank(message = "游戏EVE星域编码不能为空") @PathVariable("region_id") String regionId,
            @NotBlank(message = "游戏EVE-ESI数据源不能为空") @RequestParam("datasource") String datasource,
            @NotBlank(message = "游戏EVE市场订单类型不能为空") @RequestParam("order_type") String orderType,
            @NotBlank(message = "游戏EVE资源项编码不能为空") @RequestParam("type_id") String itemCode,
            @NotBlank(message = "游戏EVE页码不能为空") @RequestParam("page") Integer page
    );

    @Valid
    @NotNull(message = "获取游戏EVE市场资源项列表返回体不能为空")
    @GetExchange("/markets/{region_id}/types/")
    ResponseEntity<List<String>> fetchMarketItemCodes(
            @NotBlank(message = "游戏EVE星域编码不能为空") @PathVariable("region_id") String regionId,
            @NotBlank(message = "游戏EVE-ESI数据源不能为空") @RequestParam("datasource") String datasource,
            @NotBlank(message = "游戏EVE页码不能为空") @RequestParam("page") Integer page
    );
}
