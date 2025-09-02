package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDRespTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonItemRestExchange
 * <p>资源项REST-EXCHANGE接口
 * <p>
 * create 2025/08/18 19:49
 * <p>
 * update 2025/08/18 19:49
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 0.0.1
 */
@HttpExchange(url = "http://127.0.0.1:10101/item/item", contentType = "application/json;charset=UTF-8", accept = "application/json")
public interface TianyanSidecarItemRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "资源项创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<ItemCreateDRespTransfer> create(
            @NotNull(message = "资源项创建命令被动请求传输对象不能为空")
            @Valid @RequestBody ItemCreateDReqTransfer command);
}
