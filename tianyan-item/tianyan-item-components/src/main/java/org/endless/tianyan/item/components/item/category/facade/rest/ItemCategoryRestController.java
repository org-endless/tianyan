package org.endless.tianyan.item.components.item.category.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.category.application.command.handler.ItemCategoryCommandHandler;
import org.endless.tianyan.item.components.item.category.application.command.transfer.ItemCategoryCreateCReqTransfer;
import org.endless.tianyan.item.components.item.category.application.command.transfer.ItemCategoryCreateCRespTransfer;
import org.endless.tianyan.item.components.item.category.application.query.handler.ItemCategoryQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemCategoryRestController
 * <p>资源项分类领域REST控制器
 * <p>
 * itemCreate 2025/07/21 15:11
 * <p>
 * update 2025/07/21 15:11
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/item-category")
public class ItemCategoryRestController implements TianyanItemRestController {

    /**
     * 资源项分类领域命令处理器
     */
    private final ItemCategoryCommandHandler itemCategoryCommandHandler;

    /**
     * 资源项分类领域查询处理器
     */
    private final ItemCategoryQueryHandler itemCategoryQueryHandler;

    public ItemCategoryRestController(ItemCategoryCommandHandler itemCategoryCommandHandler, ItemCategoryQueryHandler itemCategoryQueryHandler) {
        this.itemCategoryCommandHandler = itemCategoryCommandHandler;
        this.itemCategoryQueryHandler = itemCategoryQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "资源项分类创建命令", value = "#command")
    public ResponseEntity<RestResponse<ItemCategoryCreateCRespTransfer>> create(
            @NotNull(message = "资源项分类创建命令请求传输对象不能为空")
            @Valid @RequestBody ItemCategoryCreateCReqTransfer command) {
        return response(itemCategoryCommandHandler.create(command)).success("资源项分类创建成功");
    }

    @Override
    public String domainDescription() {
        return "资源项分类领域";
    }
}
