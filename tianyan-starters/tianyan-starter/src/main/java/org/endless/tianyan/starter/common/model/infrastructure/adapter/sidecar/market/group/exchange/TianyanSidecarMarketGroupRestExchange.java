package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.exchange.TianyanCommonRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupCreateDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.group.transfer.MarketGroupModifyParentDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonMarketGroupRestExchange
 * <p>市场分组REST-EXCHANGE接口
 * <p>
 * create 2025/08/24 05:12
 * <p>
 * update 2025/08/24 05:16
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10003/market/market-group")
public interface TianyanSidecarMarketGroupRestExchange extends TianyanCommonRestExchange {

    @Valid
    @NotNull(message = "市场分组创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<MarketGroupCreateDRespTransfer> create(
            @NotNull(message = "市场分组创建命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketGroupCreateDReqTransfer command);

    @Valid
    @NotNull(message = "市场分组修改父分组命令响应体不能为空")
    @PostExchange("/command/modify-parent")
    RestResponse<Void> modifyParent(
            @NotNull(message = "市场分组修改父分组命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketGroupModifyParentDReqTransfer command);
}
