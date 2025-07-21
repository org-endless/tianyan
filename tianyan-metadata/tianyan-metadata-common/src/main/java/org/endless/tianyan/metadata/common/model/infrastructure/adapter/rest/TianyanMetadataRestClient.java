package org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest;

import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;

/**
 * TianyanMetadataDrivenRestAdapter
 * <p>
 * create 2024/09/05 09:40
 * <p>
 * update 2025/01/08 12:45
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 0.0.1
 */
public interface TianyanMetadataRestClient<T extends TianyanMetadataDrivenTransfer>
        extends RestClientAdapter {

}
