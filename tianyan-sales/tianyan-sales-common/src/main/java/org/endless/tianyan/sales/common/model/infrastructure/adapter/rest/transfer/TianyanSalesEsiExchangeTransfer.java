package org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.transfer;

import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.transfer.RestExchangeTransfer;
import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.transfer.DrivenTransfer;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * TianyanSalesEsiExchangeTransfer
 * <p>
 * create 2025/07/25 10:23
 * <p>
 * update 2025/07/25 11:15
 *
 * @author Deng Haozhi
 * @see DrivenTransfer
 * @since 2.0.0
 */
@HttpExchange(url = "https://ali-esi.evepc.163.com/latest", contentType = "application/json", accept = "application/json")
public interface TianyanSalesEsiExchangeTransfer extends RestExchangeTransfer {

}
