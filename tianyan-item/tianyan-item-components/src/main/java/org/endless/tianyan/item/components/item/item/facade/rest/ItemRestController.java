package org.endless.tianyan.item.components.item.item.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.item.application.command.handler.ItemCommandHandler;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCRespTransfer;
import org.endless.tianyan.item.components.item.item.application.query.handler.ItemQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemRestController
 * <p>资源项领域REST控制器
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/item")
public class ItemRestController implements TianyanItemRestController {

    /**
     * 资源项领域命令处理器
     */
    private final ItemCommandHandler itemCommandHandler;

    /**
     * 资源项领域查询处理器
     */
    private final ItemQueryHandler itemQueryHandler;

    public ItemRestController(ItemCommandHandler itemCommandHandler, ItemQueryHandler itemQueryHandler) {
        this.itemCommandHandler = itemCommandHandler;
        this.itemQueryHandler = itemQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "资源项创建命令", value = "#command")
    public ResponseEntity<RestResponse<ItemCreateCRespTransfer>> create(
            @NotNull(message = "资源项创建命令请求传输对象不能为空")
            @Valid @RequestBody ItemCreateCReqTransfer command) {
        return response(itemCommandHandler.create(command))
                .success("资源项创建成功");
    }

    @Override
    public String domainDescription() {
        return "资源项领域";
    }
}
