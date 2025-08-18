package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.market.item.spring;

import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.manager.DrivenAdapterException;
import org.endless.tianyan.sales.components.market.order.game.eve.application.query.anticorruption.GameEveMarketOrderItemQueryDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption.GameEveMarketOrderItemDrivenAdapter;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.esi.market.GameEveMarketOrderESIMarketRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.item.rest.GameEveMarketOrderItemRestClient;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer.ESIMarketItemFindPageReqDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.endless.tianyan.game.eve.common.model.infrastructure.adapter.rest.TianyanGameEveESIRestClient.DEFAULT_REGION_ID;


/**
 * SpringGameEveMarketOrderDrivenAdapter
 * <p>
 * create 2025/07/28 00:20
 * <p>
 * update 2025/07/28 00:20
 *
 * @author Deng Haozhi
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringGameEveMarketOrderItemDrivenAdapter implements GameEveMarketOrderItemDrivenAdapter, GameEveMarketOrderItemQueryDrivenAdapter {

    private final GameEveMarketOrderItemRestClient gameEveMarketOrderItemRestClient;

    private final GameEveMarketOrderESIMarketRestClient gameEveMarketOrderESIMarketRestClient;

    public SpringGameEveMarketOrderItemDrivenAdapter(GameEveMarketOrderItemRestClient gameEveMarketOrderItemRestClient, GameEveMarketOrderESIMarketRestClient gameEveMarketOrderESIMarketRestClient) {
        this.gameEveMarketOrderItemRestClient = gameEveMarketOrderItemRestClient;
        this.gameEveMarketOrderESIMarketRestClient = gameEveMarketOrderESIMarketRestClient;
    }

    @Override
    public Optional<String> fetch(String code, String createUserId) {
        return gameEveMarketOrderItemRestClient.fetch(code, createUserId);
    }

    @Override
    public List<String> fetchCodes() {
        FindPageRespTransfer firstPage = gameEveMarketOrderESIMarketRestClient.fetchCodePage(ESIMarketItemFindPageReqDTransfer.builder()
                        .regionId(DEFAULT_REGION_ID)
                        .page(1)
                        .build().validate())
                .validate();
        if (firstPage.getTotal() <= 0) {
            throw new DrivenAdapterException("未找到市场订单资源项信息");
        }
        List<String> itemCodes = new ArrayList<>(firstPage.getRows().stream().map(String::valueOf).toList());
        for (int i = 2; i <= firstPage.getTotal(); i++) {
            FindPageRespTransfer page = gameEveMarketOrderESIMarketRestClient.fetchCodePage(ESIMarketItemFindPageReqDTransfer.builder()
                            .regionId(DEFAULT_REGION_ID)
                            .page(i)
                            .build().validate())
                    .validate();
            itemCodes.addAll((page.getRows().stream().map(String::valueOf).toList()));
        }
        return itemCodes;
    }
}
