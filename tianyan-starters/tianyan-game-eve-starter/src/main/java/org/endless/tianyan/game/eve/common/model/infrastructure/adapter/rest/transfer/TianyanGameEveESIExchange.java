package org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.transfer;

import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * TianyanGameEveESIExchange
 * <p>
 * create 2025/07/25 10:23
 * <p>
 * update 2025/07/28 05:43
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 0.0.1
 */
@HttpExchange(url = "https://ali-esi.evepc.163.com/latest", contentType = "application/json", accept = "application/json")
public interface TianyanGameEveESIExchange extends RestExchange {

}
