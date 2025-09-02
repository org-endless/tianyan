package org.endless.tianyan.sales.components.market.game.eve.order.infrastructure.adapter.market.item;

import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.GameEveESIMarketRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketItemPageDReqTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindGameEveItemCodeDRespTransfer;
import org.endless.tianyan.sales.components.market.game.eve.order.application.query.anticorruption.GameEveMarketOrderItemQueryDrivenAdapter;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption.GameEveMarketOrderItemDrivenAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

import static org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.GameEveESICommonRestClient.DEFAULT_REGION_ID;


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
@Validated
@Component
public class GameEveMarketItemDrivenAdapterImpl implements GameEveMarketOrderItemDrivenAdapter, GameEveMarketOrderItemQueryDrivenAdapter {

    private final GameEveESIMarketRestClient gameEveESIMarketRestClient;

    public GameEveMarketItemDrivenAdapterImpl(GameEveESIMarketRestClient gameEveESIMarketRestClient) {
        this.gameEveESIMarketRestClient = gameEveESIMarketRestClient;
    }

    @Override
    public List<String> fetchCodes() {
        FindPageRespTransfer<FindGameEveItemCodeDRespTransfer> firstPage = gameEveESIMarketRestClient
                .fetchMarketItemCodes(FindESIMarketItemPageDReqTransfer.builder()
                        .regionId(DEFAULT_REGION_ID)
                        .page(1)
                        .build().validate())
                .validate();
        if (firstPage.total() <= 0) {
            throw new DrivenAdapterFailedException("未找到市场订单资源项信息");
        }
        List<String> itemCodes = new ArrayList<>(firstPage.getRows(FindGameEveItemCodeDRespTransfer.class).stream()
                .map(FindGameEveItemCodeDRespTransfer::gameEveItemCode)
                .toList());
        for (int i = 2; i <= firstPage.total(); i++) {
            FindPageRespTransfer<FindGameEveItemCodeDRespTransfer> page = gameEveESIMarketRestClient
                    .fetchMarketItemCodes(FindESIMarketItemPageDReqTransfer.builder()
                            .regionId(DEFAULT_REGION_ID)
                            .page(i)
                            .build().validate())
                    .validate();
            itemCodes.addAll((page.getRows(FindGameEveItemCodeDRespTransfer.class).stream()
                    .map(FindGameEveItemCodeDRespTransfer::gameEveItemCode)
                    .toList()));
        }
        return itemCodes;
    }
}
