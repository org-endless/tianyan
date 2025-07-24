package org.endless.tianyan.manufacturing.common.model.sidecar.rest;

import org.endless.ddd.simplified.starter.common.model.sidecar.rest.RestController;

/**
 * TianyanManufacturingRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 0.0.1
 */
public interface TianyanManufacturingRestController extends RestController {

    default TianyanManufacturingRestResponse response() {
        return TianyanManufacturingRestResponse.builder().build();
    }
}
