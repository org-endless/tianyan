package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderGeneratePriceDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderModifyDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.order.transfer.MarketOrderRemoveDReqTransfer;

import java.util.List;
import java.util.Optional;

/**
 * TianyanSidecarMarketOrderRestClient
 * <p>市场订单REST客户端接口
 * <p>
 * create 2025/08/27 12:47
 * <p>
 * update 2025/08/27 12:47
 * update 2025/08/27 12:47
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarMarketOrderRestClient extends TianyanCommonRestClient {

    /**
     * 市场订单创建命令
     *
     * @param command 市场订单创建命令被动请求传输对象
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> create(
            @NotNull(message = "市场订单创建命令被动请求传输对象不能为空")
            @Valid MarketOrderCreateDReqTransfer command);

    /**
     * 市场订单删除命令
     *
     * @param command 市场订单删除命令被动请求传输对象
     */
    void remove(
            @NotNull(message = "市场订单删除命令被动请求传输对象不能为空")
            @Valid MarketOrderRemoveDReqTransfer command);

    /**
     * 市场订单修改命令
     *
     * @param command 市场订单修改命令被动请求传输对象
     */
    void modify(
            @NotNull(message = "市场订单修改命令被动请求传输对象不能为空")
            @Valid MarketOrderModifyDReqTransfer command);

    /**
     * 市场订单生成价格命令
     *
     * @param command 市场订单生成价格命令被动请求传输对象
     */
    void generatePrice(
            @NotNull(message = "市场订单生成价格命令被动请求传输对象不能为空")
            @Valid MarketOrderGeneratePriceDReqTransfer command);

    /**
     * 根据资源项ID查询市场订单ID列表
     *
     * @param itemId 资源项ID
     * @return {@link List }<{@link String }>
     */
    List<String> findIdsByItemId(
            @NotBlank(message = "资源项ID不能为空") String itemId);
}
