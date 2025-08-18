package org.endless.tianyan.item.common.model.facade.rest;


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

    default TianyanItemRestResponse response() {
        return TianyanItemRestResponse.builder().build();
    }
}
