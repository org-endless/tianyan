package org.endless.tianyan.metadata.common.model.facade.rest;


import org.endless.ddd.starter.common.ddd.facade.rest.RestController;

/**
 * TianyanMetadataRestController
 * <p>
 * create 2024/09/06 15:29
 * <p>
 * update 2024/09/11 00:59
 *
 * @author Deng Haozhi
 * @see RestController
 * @since 0.0.1
 */
public interface TianyanMetadataRestController extends RestController {

    default String serviceDescription() {
        return "天演-元数据服务";
    }

    String domainDescription();
}
