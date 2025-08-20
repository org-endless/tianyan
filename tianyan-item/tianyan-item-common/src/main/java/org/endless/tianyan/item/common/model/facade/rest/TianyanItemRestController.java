package org.endless.tianyan.item.common.model.facade.rest;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.common.transfer.RespTransfer;
import org.endless.ddd.starter.common.ddd.facade.rest.RestController;

/**
 * TianyanItemRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 0.0.1
 */
public interface TianyanItemRestController extends RestController {

    default <R extends RespTransfer> RestResponse<R> response(
            @NotNull(message = "REST响应体不能为空")
            @Valid R response) {
        return RestResponse.<R>builder()
                .serviceDescription(serviceDescription())
                .domainDescription(domainDescription())
                .build();
    }

    default RestResponse<Void> response() {
        return RestResponse.<Void>builder()
                .serviceDescription(serviceDescription())
                .domainDescription(domainDescription())
                .build();
    }

    default String serviceDescription() {
        return "天演-资源项服务";
    }

    String domainDescription();
}
