package org.endless.tianyan.finance.common.model.sidecar.rest;


import org.endless.ddd.starter.common.ddd.facade.rest.RestController;

/**
 * TianyanFinanceRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 0.0.1
 */
public interface TianyanFinanceRestController extends RestController {

    default TianyanFinanceRestResponse response() {
        return TianyanFinanceRestResponse.builder().build();
    }
}
