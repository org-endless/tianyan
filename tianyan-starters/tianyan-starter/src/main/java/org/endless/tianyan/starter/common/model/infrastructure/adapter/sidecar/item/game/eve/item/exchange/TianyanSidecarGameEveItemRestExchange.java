package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonGameEveItemRestExchange
 * <p>
 * 游戏EVE资源项REST-EXCHANGE接口
 * <p>
 * create 2025/08/23 03:22
 * <p>
 * update 2025/08/24 20:04
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10101/item/game-eve-item", contentType = "application/json;charset=UTF-8", accept = "application/json")
public interface TianyanSidecarGameEveItemRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "游戏EVE资源项创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<Void> create(
            @NotNull(message = "游戏EVE资源项创建命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveItemCreateDReqTransfer command);

    @Valid
    @NotNull(message = "游戏EVE资源项获取命令响应体不能为空")
    @PostExchange("/command/fetch")
    RestResponse<GameEveItemFetchDRespTransfer> fetch(
            @NotNull(message = "游戏EVE资源项获取命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveItemFetchDReqTransfer command);

    @Valid
    @NotNull(message = "根据游戏EVE资源项编码查询资源项ID响应体不能为空")
    @PostExchange("/query/find-item-id-by-code")
    RestResponse<FindItemIdDRespTransfer> findItemIdByCode(
            @NotNull(message = "根据游戏EVE资源项编码查询被动请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveItemCodeDReqTransfer query);

    @Valid
    @NotNull(message = "根据游戏EVE资源项编码列表查询资源项ID列表响应体不能为空")
    @PostExchange("/query/find-item-ids-by-codes")
    RestResponse<FindItemIdsDRespTransfer> findItemIdsByCodes(
            @NotNull(message = "根据游戏EVE资源项编码列表查询被动请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveItemCodesDReqTransfer query);

    @Valid
    @NotNull(message = "根据资源项ID查询游戏EVE资源项编码响应体不能为空")
    @PostExchange("/query/find-code-by-item-id")
    RestResponse<FindGameEveItemCodeDRespTransfer> findCodeByItemId(
            @NotNull(message = "根据资源项ID查询被动请求传输对象不能为空")
            @Valid @RequestBody FindByItemIdDReqTransfer query);
}
