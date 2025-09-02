package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * FindByGameEveMarketGroupCodeQReqTransfer
 * <p>根据游戏EVE市场分组编码查询被动请求传输对象
 * <p>
 * create 2025/07/26 05:28
 * <p>
 * update 2025/07/26 05:28
 *
 * @param gameEveMarketGroupCode 游戏EVE市场分组编码
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveMarketGroupCode"})
public record FindByGameEveMarketGroupCodeDReqTransfer(
        @NotBlank(message = "游戏EVE市场分组编码不能为空") String gameEveMarketGroupCode
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public FindByGameEveMarketGroupCodeDReqTransfer validate() {
        return this;
    }
}
