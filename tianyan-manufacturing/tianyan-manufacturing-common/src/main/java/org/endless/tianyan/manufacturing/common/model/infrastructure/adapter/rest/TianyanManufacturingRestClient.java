package org.endless.tianyan.manufacturing.common.model.infrastructure.adapter.rest;

import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.manufacturing.common.model.infrastructure.adapter.transfer.TianyanManufacturingDrivenReqTransfer;

/**
 * TianyanManufacturingDrivenRestAdapter
 * <p>
 * create 2024/09/05 09:40
 * <p>
 * update 2025/01/08 12:45
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 0.0.1
 */
public interface TianyanManufacturingRestClient<T extends TianyanManufacturingDrivenReqTransfer> extends RestClientAdapter {

}
