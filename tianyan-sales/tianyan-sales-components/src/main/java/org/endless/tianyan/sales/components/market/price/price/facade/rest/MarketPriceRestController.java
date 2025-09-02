package org.endless.tianyan.sales.components.market.price.price.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.sales.common.model.facade.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.price.price.application.command.handler.MarketPriceCommandHandler;
import org.endless.tianyan.sales.components.market.price.price.application.command.transfer.MarketPriceCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.price.price.application.query.handler.MarketPriceQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketPriceRestController
 * <p>市场价格领域REST控制器
 * <p>
 * create 2025/07/26 18:56
 * <p>
 * update 2025/07/26 18:56
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/market-price")
public class MarketPriceRestController implements TianyanSalesRestController {

    /**
     * 市场价格领域命令处理器
     */
    private final MarketPriceCommandHandler marketPriceCommandHandler;

    /**
     * 市场价格领域查询处理器
     */
    private final MarketPriceQueryHandler marketPriceQueryHandler;

    public MarketPriceRestController(MarketPriceCommandHandler marketPriceCommandHandler, MarketPriceQueryHandler marketPriceQueryHandler) {
        this.marketPriceCommandHandler = marketPriceCommandHandler;
        this.marketPriceQueryHandler = marketPriceQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "市场价格创建命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> create(
            @NotNull(message = "市场价格创建命令请求传输对象不能为空")
            @Valid @RequestBody MarketPriceCreateCReqTransfer command) {
        marketPriceCommandHandler.create(command);
        return response().success("市场价格创建成功");
    }

    @Override
    public String domainDescription() {
        return "市场价格领域";
    }
}
