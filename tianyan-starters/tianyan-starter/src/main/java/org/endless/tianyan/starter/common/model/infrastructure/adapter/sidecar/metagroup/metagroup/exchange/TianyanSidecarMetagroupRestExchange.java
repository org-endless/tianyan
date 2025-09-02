package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.exchange.TianyanCommonRestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer.MetagroupCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.metagroup.transfer.MetagroupCreateDRespTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanSidecarMetagroupRestExchange
 * <p>元分组REST-EXCHANGE接口
 * <p>
 * create 2025/08/26 14:40
 * <p>
 * update 2025/08/26 14:41
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10102/metagroup/metagroup")
public interface TianyanSidecarMetagroupRestExchange extends TianyanCommonRestExchange {

    @Valid
    @NotNull(message = "元分组创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<MetagroupCreateDRespTransfer> create(
            @NotNull(message = "市场分组创建命令被动请求传输对象不能为空")
            @Valid @RequestBody MetagroupCreateDReqTransfer command);
}
