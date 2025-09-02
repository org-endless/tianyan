package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.exchange;

import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.exchange.GameEveCommonRestExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * TianyanGameEveESIExchange
 * <p>
 * create 2025/07/25 10:23
 * <p>
 * update 2025/07/28 05:43
 *
 * @author Deng Haozhi
 * @see GameEveCommonRestExchange
 * @since 0.0.1
 */
@HttpExchange(url = "https://ali-esi.evepc.163.com/latest", contentType = "application/json", accept = "application/json")
public interface GameEveESIRestExchange extends GameEveCommonRestExchange {

}
