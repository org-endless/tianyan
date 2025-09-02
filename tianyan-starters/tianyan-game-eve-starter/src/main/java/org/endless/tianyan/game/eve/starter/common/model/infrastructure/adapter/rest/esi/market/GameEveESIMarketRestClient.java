package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.ddd.common.transfer.FindPageRespTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.GameEveESICommonRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketItemPageDReqTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderDRespTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindESIMarketOrderPageDReqTransfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer.FindGameEveItemCodeDRespTransfer;

/**
 * GameEveESIMarketOrderRestClient
 * <p>
 * create 2025/08/27 00:01
 * <p>
 * update 2025/08/27 00:06
 *
 * @author Deng Haozhi
 * @see GameEveESICommonRestClient
 * @since 1.0.0
 */
public interface GameEveESIMarketRestClient extends GameEveESICommonRestClient {

    /**
     * 获取市场订单列表
     *
     * @param query ESI市场订单分页查询被动请求传输对象
     * @return {@link FindPageRespTransfer }
     */
    @Valid
    @NotNull(message = "获取市场订单列表分页返回对象不能为空")
    FindPageRespTransfer<FindESIMarketOrderDRespTransfer> fetchMarketOrders(
            @NotNull(message = "ESI市场订单分页查询被动请求传输对象不能为空")
            @Valid FindESIMarketOrderPageDReqTransfer query);

    /**
     * 获取市场资源项列表
     *
     * @param query ESI市场资源项分页查询被动请求传输对象
     * @return {@link FindPageRespTransfer }
     */
    @Valid
    @NotNull(message = "获取市场资源项列表分页返回对象不能为空")
    FindPageRespTransfer<FindGameEveItemCodeDRespTransfer> fetchMarketItemCodes(
            @NotNull(message = "ESI市场资源项分页查询被动请求传输对象不能为空")
            @Valid FindESIMarketItemPageDReqTransfer query);
}
