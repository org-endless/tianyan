package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * FindByGameEveItemCategoryCodeDReqTransfer
 * <p>根据游戏EVE资源项分类编码查询被动请求传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/08/23 04:16
 *
 * @param gameEveItemCategoryCode 游戏EVE资源项分类编码
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCategoryCode"})
public record FindByGameEveItemCategoryCodeDReqTransfer(
        @NotBlank(message = "游戏EVE资源项分类编码不能为空") String gameEveItemCategoryCode
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public FindByGameEveItemCategoryCodeDReqTransfer validate() {
        return this;
    }
}
