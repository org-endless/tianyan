package org.endless.tianyan.sales.components.market.group.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.sales.common.model.facade.rest.TianyanSalesRestController;
import org.endless.tianyan.sales.components.market.group.application.command.handler.MarketGroupCommandHandler;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateCReqTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupCreateCRespTransfer;
import org.endless.tianyan.sales.components.market.group.application.command.transfer.MarketGroupModifyParentCReqTransfer;
import org.endless.tianyan.sales.components.market.group.application.query.handler.MarketGroupQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MarketGroupRestController
 * <p>市场分组领域REST控制器
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/market/market-group")
public class MarketGroupRestController implements TianyanSalesRestController {

    /**
     * 市场分组领域命令处理器
     */
    private final MarketGroupCommandHandler marketGroupCommandHandler;

    /**
     * 市场分组领域查询处理器
     */
    private final MarketGroupQueryHandler marketGroupQueryHandler;

    public MarketGroupRestController(MarketGroupCommandHandler marketGroupCommandHandler, MarketGroupQueryHandler marketGroupQueryHandler) {
        this.marketGroupCommandHandler = marketGroupCommandHandler;
        this.marketGroupQueryHandler = marketGroupQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "市场分组创建命令", value = "#command")
    public ResponseEntity<RestResponse<MarketGroupCreateCRespTransfer>> create(
            @NotNull(message = "市场分组创建命令请求传输对象不能为空")
            @Valid @RequestBody MarketGroupCreateCReqTransfer command) {
        return response(marketGroupCommandHandler.create(command))
                .success("市场分组创建成功");
    }

    @PostMapping("/command/modify-parent")
    @Log(message = "市场分组修改父分组命令", value = "#command")
    public ResponseEntity<RestResponse<Void>> modifyParent(
            @NotNull(message = "市场分组修改父分组命令请求传输对象不能为空")
            @Valid @RequestBody MarketGroupModifyParentCReqTransfer command) {
        marketGroupCommandHandler.modifyParent(command);
        return response().success("市场分组修改父分组成功");
    }

    @Override
    public String domainDescription() {
        return "市场分组领域";
    }
}
