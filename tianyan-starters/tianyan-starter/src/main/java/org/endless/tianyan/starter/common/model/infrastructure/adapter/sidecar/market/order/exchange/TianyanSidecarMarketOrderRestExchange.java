package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.exchange.TianyanCommonRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanSidecarMarketOrderRestExchange
 * <p>市场订单REST-EXCHANGE接口
 * <p>
 * create 2025/08/27 12:51
 * <p>
 * update 2025/08/27 12:51
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10003/market/market-order")
public interface TianyanSidecarMarketOrderRestExchange extends TianyanCommonRestExchange {

    @Valid
    @NotNull(message = "市场订单创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<MarketOrderCreateDRespTransfer> create(
            @NotNull(message = "市场订单创建命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketOrderCreateDReqTransfer command);

    @Valid
    @NotNull(message = "市场订单删除命令响应体不能为空")
    @PostExchange("/command/remove")
    RestResponse<Void> remove(
            @NotNull(message = "市场订单删除命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketOrderRemoveDReqTransfer command);

    @Valid
    @NotNull(message = "市场订单修改命令响应体不能为空")
    @PostExchange("/command/modify")
    RestResponse<Void> modify(
            @NotNull(message = "市场订单修改命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketOrderModifyDReqTransfer command);

    @Valid
    @NotNull(message = "市场订单生成价格命令响应体不能为空")
    @PostExchange("/command/generate-price")
    RestResponse<Void> generatePrice(
            @NotNull(message = "市场订单生成价格命令被动请求传输对象不能为空")
            @Valid @RequestBody MarketOrderGeneratePriceDReqTransfer command);

    @Valid
    @NotNull(message = "根据资源项ID查询市场订单ID列表响应体不能为空")
    @PostExchange("/query/find-ids-by-item-id")
    RestResponse<FindMarketOrderIdsDRespTransfer> findIdsByItemId(
            @NotNull(message = "根据资源项ID查询被动请求传输对象不能为空")
            @Valid @RequestBody FindByItemIdDReqTransfer query);
}
