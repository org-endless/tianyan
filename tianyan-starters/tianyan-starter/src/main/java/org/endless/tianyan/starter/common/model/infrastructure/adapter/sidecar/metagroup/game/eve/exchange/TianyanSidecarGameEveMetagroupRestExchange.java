package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.FindByGameEveMetagroupCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.FindMetagroupIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.GameEveMetagroupCreateDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonGameEveMetagroupRestExchange
 * <p>游戏EVE元分组REST-EXCHANGE接口
 * <p>
 * create 2025/08/23 22:57
 * <p>
 * update 2025/08/23 23:01
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10102/metagroup/game-eve-metagroup")
public interface TianyanSidecarGameEveMetagroupRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "游戏EVE元分组创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<Void> create(
            @NotNull(message = "游戏EVE元分组创建命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveMetagroupCreateDReqTransfer command);

    @Valid
    @NotNull(message = "根据游戏EVE元分组编码查询元分组ID响应体不能为空")
    @PostExchange("/query/find-metagroup-id-by-code")
    RestResponse<FindMetagroupIdDRespTransfer> findMetagroupIdByCode(
            @NotNull(message = "根据游戏EVE元分组编码查询请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveMetagroupCodeDReqTransfer command);
}
