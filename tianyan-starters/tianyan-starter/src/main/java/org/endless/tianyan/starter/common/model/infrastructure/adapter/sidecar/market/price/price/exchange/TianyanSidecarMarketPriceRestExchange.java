package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.exchange.TianyanCommonRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.price.price.transfer.MarketPriceCreateDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanSidecarMarketPriceRestExchange
 * <p>
 * create 2025/08/27 12:28
 * <p>
 * update 2025/08/27 12:28
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10003/market/market-price", contentType = "application/json;charset=UTF-8", accept = "application/json")
public interface TianyanSidecarMarketPriceRestExchange extends TianyanCommonRestExchange {

    @Valid
    @NotNull(message = "市场价格创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<Void> create(
            @NotNull(message = "市场价格创建命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketPriceCreateDReqTransfer command);
}
