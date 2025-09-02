package org.endless.tianyan.item.components.item.game.eve.category.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;

/**
 * GameEveItemCategoryCreateCReqTransfer
 * <p>游戏EVE资源项分类创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:17
 * <p>
 * update 2025/07/24 20:17
 *
 * @param itemCategoryId          资源项分类ID
 * @param gameEveItemCategoryCode 游戏EVE资源项分类编码
 * @param isPublished             游戏EVE资源项分类是否发布
 * @param createUserId            创建用户ID
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemCategoryId", "gameEveItemCategoryCode", "isPublished", "createUserId"})
public record GameEveItemCategoryCreateCReqTransfer(
        @NotBlank(message = "资源项分类ID不能为空") String itemCategoryId,
        @NotBlank(message = "游戏EVE资源项分类编码不能为空") String gameEveItemCategoryCode,
        @NotNull(message = "游戏EVE资源项分类是否发布不能为空") Boolean isPublished,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanItemCommandReqTransfer {

    @Override
    public GameEveItemCategoryCreateCReqTransfer validate() {
        return this;
    }
}
