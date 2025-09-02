package org.endless.tianyan.item.components.item.category.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.item.common.model.application.command.handler.TianyanItemCommandHandler;
import org.endless.tianyan.item.components.item.category.application.command.transfer.ItemCategoryCreateCReqTransfer;
import org.endless.tianyan.item.components.item.category.application.command.transfer.ItemCategoryCreateCRespTransfer;
import org.endless.tianyan.item.components.item.category.domain.entity.ItemCategoryAggregate;

/**
 * ItemCategoryCommandHandler
 * <p>资源项分类领域命令处理器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandHandler<ItemCategoryAggregate>
 * @since 0.0.1
 */
public interface ItemCategoryCommandHandler extends TianyanItemCommandHandler<ItemCategoryAggregate> {

    /**
     * 资源项分类创建命令
     *
     * @param command 资源项分类创建命令请求传输对象
     * @return {@link ItemCategoryCreateCRespTransfer }
     */
    @Valid
    @NotNull(message = "资源项分类创建命令响应传输对象不能为空")
    ItemCategoryCreateCRespTransfer create(
            @NotNull(message = "资源项分类创建命令请求传输对象不能为空")
            @Valid ItemCategoryCreateCReqTransfer command);

}
