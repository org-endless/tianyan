package org.endless.tianyan.sales.components.market.order.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.sales.common.model.facade.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.order.application.command.handler.MarketOrderCommandHandler;
import org.endless.tianyan.sales.components.market.order.application.command.transfer.*;
import org.endless.tianyan.sales.components.market.order.application.query.handler.MarketOrderQueryHandler;
import org.endless.tianyan.sales.components.market.order.application.query.transfer.FindByItemIdQReqTransfer;
import org.endless.tianyan.sales.components.market.order.application.query.transfer.FindMarketOrderIdsQRespTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketOrderRestController
 * <p>市场订单领域REST控制器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/market-order")
public class MarketOrderRestController implements TianyanSalesRestController {

    /**
     * 市场订单领域命令处理器
     */
    private final MarketOrderCommandHandler marketOrderCommandHandler;

    /**
     * 市场订单领域查询处理器
     */
    private final MarketOrderQueryHandler marketOrderQueryHandler;

    public MarketOrderRestController(MarketOrderCommandHandler marketOrderCommandHandler, MarketOrderQueryHandler marketOrderQueryHandler) {
        this.marketOrderCommandHandler = marketOrderCommandHandler;
        this.marketOrderQueryHandler = marketOrderQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "市场订单创建命令", value = "#command")
    public ResponseEntity<RestResponse<MarketOrderCreateCRespTransfer>> create(
            @NotNull(message = "市场订单创建命令请求传输对象不能为空")
            @Valid @RequestBody MarketOrderCreateCReqTransfer command) {
        return response(marketOrderCommandHandler.create(command))
                .success("市场订单创建成功");
    }

    @PostMapping("/command/remove")
    @Log(message = "市场订单删除命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> remove(
            @NotNull(message = "市场订单删除命令请求传输对象不能为空")
            @Valid @RequestBody MarketOrderRemoveCReqTransfer command) {
        marketOrderCommandHandler.remove(command);
        return response().success("市场订单删除成功");
    }

    @PostMapping("/command/modify")
    @Log(message = "市场订单修改命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> modify(
            @NotNull(message = "市场订单修改命令请求传输对象不能为空")
            @Valid @RequestBody MarketOrderModifyCReqTransfer command) {
        marketOrderCommandHandler.modify(command);
        return response().success("市场订单修改成功");
    }


    @PostMapping("/command/generate-price")
    @Log(message = "市场订单生成价格命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> generatePrice(
            @NotNull(message = "市场订单生成价格命令请求传输对象不能为空")
            @Valid @RequestBody MarketOrderGeneratePriceCReqTransfer command) {
        marketOrderCommandHandler.generatePrice(command);
        return response().success("市场订单生成价格成功");
    }

    @PostMapping("/query/find-ids-by-item-id")
    @Log(message = "根据资源项ID查询市场订单ID列表", value = "#query")
    public ResponseEntity<RestResponse<FindMarketOrderIdsQRespTransfer>> findIdsByItemId(
            @NotNull(message = "根据资源项ID查询请求传输对象不能为空")
            @Valid @RequestBody FindByItemIdQReqTransfer query) {
        return response(marketOrderQueryHandler.findIdsByItemId(query))
                .success("根据资源项ID查询市场订单ID列表成功");
    }

    @Override
    public String domainDescription() {
        return "市场订单领域";
    }
}
