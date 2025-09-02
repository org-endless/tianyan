package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

import java.util.List;

/**
 * FindByGameEveItemCodesQReqTransfer
 * <p>根据游戏EVE资源项编码列表查询被动请求传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/08/23 04:17
 *
 * @param gameEveItemCodes 游戏EVE资源项编码列表
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCodes"})
public record FindByGameEveItemCodesDReqTransfer(
        @NotEmpty(message = "游戏EVE资源项编码列表不能为空") List<String> gameEveItemCodes
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public FindByGameEveItemCodesDReqTransfer validate() {
        return this;
    }
}
