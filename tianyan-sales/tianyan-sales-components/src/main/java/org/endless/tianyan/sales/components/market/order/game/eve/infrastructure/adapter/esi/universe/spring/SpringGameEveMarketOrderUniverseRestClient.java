package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.universe.spring;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.universe.GameEveMarketOrderUniverseRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.universe.transfer.GameEveMarketOrderUniverseExchangeTransfer;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.GameEveMarketOrderFindUniverseItemNameRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

/**
 * SpringGameEveMarketOrderUniverseRestClient
 * <p>
 * create 2025/07/25 15:21
 * <p>
 * update 2025/07/25 15:21
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringGameEveMarketOrderUniverseRestClient implements GameEveMarketOrderUniverseRestClient {

    private final RestClient restClient;

    public SpringGameEveMarketOrderUniverseRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public String findUniverseItemNameByCode(String itemCode, String datasource, String categoryName) {
        return Optional.ofNullable(exchange(restClient, GameEveMarketOrderUniverseExchangeTransfer.class)
                        .findUniverseItemNameByCode(datasource, List.of(itemCode)))
                .orElseThrow(() -> new DrivenAdapterManagerException("未找到相关的宇宙资源项信息"))
                .stream()
                .filter(system -> system.getCategory().equals(categoryName))
                .findFirst()
                .map(GameEveMarketOrderFindUniverseItemNameRespDTransfer::getName)
                .orElseThrow(() -> new DrivenAdapterManagerException("未找到相关的宇宙资源项名称"));
    }
}
