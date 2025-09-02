package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.FindByGameEveMarketGroupCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.FindMarketGroupIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.GameEveMarketGroupCreateDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonGameEveMarketGroupRestExchange
 * <p>游戏EVE市场分组REST-EXCHANGE接口
 * <p>
 * create 2025/08/24 05:27
 * <p>
 * update 2025/08/24 05:39
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10003/market/game-eve-market-group")
public interface TianyanSidecarGameEveMarketGroupRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "游戏EVE市场分组创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<Void> create(
            @NotNull(message = "游戏EVE市场分组创建命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveMarketGroupCreateDReqTransfer command);

    @Valid
    @NotNull(message = "根据游戏EVE市场分组编码查询市场分组ID响应体不能为空")
    @PostExchange("/query/find-market-group-id-by-code")
    RestResponse<FindMarketGroupIdDRespTransfer> findMarketGroupIdByCode(
            @NotNull(message = "根据游戏EVE市场分组编码查询被动请求传输对象")
            @Valid @RequestBody FindByGameEveMarketGroupCodeDReqTransfer query);
}
