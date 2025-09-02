package org.endless.tianyan.manufacturing.common.model.facade.rest;

import org.endless.ddd.starter.common.ddd.facade.rest.RestController;

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

    default String serviceDescription() {
        return "天演-制造服务";
    }

    String domainDescription();
}
