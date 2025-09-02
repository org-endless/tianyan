package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveItemCategoryCreateDReqTransfer
 * <p>游戏EVE资源项分类创建命令被动请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:17
 * <p>
 * update 2025/08/23 04:17
 *
 * @param itemCategoryId          资源项分类ID
 * @param gameEveItemCategoryCode 游戏EVE资源项分类编码
 * @param isPublished             游戏EVE资源项分类是否发布
 * @param createUserId            创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemCategoryId", "gameEveItemCategoryCode", "isPublished", "createUserId"})
public record GameEveItemCategoryCreateDReqTransfer(
        @NotBlank(message = "资源项分类ID不能为空") String itemCategoryId,
        @NotBlank(message = "游戏EVE资源项分类编码不能为空") String gameEveItemCategoryCode,
        @NotNull(message = "游戏EVE资源项分类是否发布不能为空") Boolean isPublished,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public GameEveItemCategoryCreateDReqTransfer validate() {
        return this;
    }
}
