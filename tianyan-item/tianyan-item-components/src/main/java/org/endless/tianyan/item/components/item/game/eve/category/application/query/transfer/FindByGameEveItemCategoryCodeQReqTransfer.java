package org.endless.tianyan.item.components.item.game.eve.category.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;

/**
 * FindByGameEveItemCategoryCodeQReqTransfer
 * <p>根据编码游戏EVE资源项分类查询请求传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @param gameEveItemCategoryCode 游戏EVE资源项分类编码
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCategoryCode"})
public record FindByGameEveItemCategoryCodeQReqTransfer(
        @NotBlank(message = "游戏EVE资源项分类编码不能为空") String gameEveItemCategoryCode
) implements TianyanItemQueryReqTransfer {

    @Override
    public FindByGameEveItemCategoryCodeQReqTransfer validate() {
        return this;
    }
}
