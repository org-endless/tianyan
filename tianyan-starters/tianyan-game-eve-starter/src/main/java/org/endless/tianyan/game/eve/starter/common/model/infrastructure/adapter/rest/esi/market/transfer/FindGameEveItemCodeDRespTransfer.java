package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.transfer.GameEveCommonDrivenRespTransfer;

/**
 * FindGameEveItemCodeDRespTransfer
 * <p>游戏EVE资源项编码查询被动响应传输对象
 * <p>
 * create 2025/08/27 15:40
 * <p>
 * update 2025/08/27 15:42
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @author Deng Haozhi
 * @see Record
 * @see GameEveCommonDrivenRespTransfer
 * @since 1.0.0
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode"})
public record FindGameEveItemCodeDRespTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode
) implements GameEveCommonDrivenRespTransfer {

    @Override
    public FindGameEveItemCodeDRespTransfer validate() {
        return this;
    }
}
