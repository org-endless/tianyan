package org.endless.tianyan.finance.common.model.infrastructure.adapter.rest;

import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.finance.common.model.infrastructure.adapter.transfer.TianyanFinanceDrivenTransfer;

/**
 * TianyanFinanceDrivenRestAdapter
 * <p>
 * create 2024/09/05 09:40
 * <p>
 * update 2025/01/08 12:45
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 0.0.1
 */
public interface TianyanFinanceRestClient<T extends TianyanFinanceDrivenTransfer>
        extends RestClientAdapter {

}
