package org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.transfer;

import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.transfer.RestExchangeTransfer;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * TianyanGameEveESIExchangeTransfer
 * <p>
 * create 2025/07/25 10:23
 * <p>
 * update 2025/07/28 05:43
 *
 * @author Deng Haozhi
 * @see RestExchangeTransfer
 * @since 0.0.1
 */
@HttpExchange(url = "https://ali-esi.evepc.163.com/latest", contentType = "application/json", accept = "application/json")
public interface TianyanGameEveESIExchangeTransfer extends RestExchangeTransfer {

}
