package org.endless.tianyan.item.common.model.sidecar.rest;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.endless.ddd.simplified.starter.common.model.sidecar.rest.AbstractRestResponse;

/**
 * TianyanItemRestResponse
 * <p>
 * create 2024/09/06 15:28
 * <p>
 * update 2024/09/06 15:29
 *
 * @author Deng Haozhi
 * @see AbstractRestResponse
 * @since 0.0.1
 */
@Getter
@SuperBuilder
public class TianyanItemRestResponse extends AbstractRestResponse {


    private static final String SERVICE_DESCRIPTION = "天演-物品服务";

    @Override
    public TianyanItemRestResponse createInstance(String status, String errorCode, String message, Object data) {
        return TianyanItemRestResponse.builder().status(status).errorCode(errorCode).message(message).data(data).build();
    }

    @Override
    public String getServiceDescription() {
        return SERVICE_DESCRIPTION;
    }
}
