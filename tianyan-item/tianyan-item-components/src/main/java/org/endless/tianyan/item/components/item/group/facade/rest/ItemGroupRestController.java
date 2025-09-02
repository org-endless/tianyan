package org.endless.tianyan.item.components.item.group.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.group.application.command.handler.ItemGroupCommandHandler;
import org.endless.tianyan.item.components.item.group.application.command.transfer.ItemGroupCreateCReqTransfer;
import org.endless.tianyan.item.components.item.group.application.command.transfer.ItemGroupCreateCRespTransfer;
import org.endless.tianyan.item.components.item.group.application.query.handler.ItemGroupQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemGroupRestController
 * <p>资源项分组领域REST控制器
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/item-group")
public class ItemGroupRestController implements TianyanItemRestController {

    /**
     * 资源项分组领域命令处理器
     */
    private final ItemGroupCommandHandler itemGroupCommandHandler;

    /**
     * 资源项分组领域查询处理器
     */
    private final ItemGroupQueryHandler itemGroupQueryHandler;

    public ItemGroupRestController(ItemGroupCommandHandler itemGroupCommandHandler, ItemGroupQueryHandler itemGroupQueryHandler) {
        this.itemGroupCommandHandler = itemGroupCommandHandler;
        this.itemGroupQueryHandler = itemGroupQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "资源项分组创建命令", value = "#command")
    public ResponseEntity<RestResponse<ItemGroupCreateCRespTransfer>> create(
            @NotNull(message = "资源项分组创建命令请求传输对象不能为空")
            @Valid @RequestBody ItemGroupCreateCReqTransfer command) {
        return response(itemGroupCommandHandler.create(command)).success("资源项分组创建成功");
    }

    @Override
    public String domainDescription() {
        return "资源项分组领域";
    }
}
