package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * FindGameEveItemCodeQRespTransfer
 * <p>游戏EVE资源项编码查询被动响应传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/08/23 04:18
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode"})
public record FindGameEveItemCodeDRespTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindGameEveItemCodeDRespTransfer validate() {
        return this;
    }
}
