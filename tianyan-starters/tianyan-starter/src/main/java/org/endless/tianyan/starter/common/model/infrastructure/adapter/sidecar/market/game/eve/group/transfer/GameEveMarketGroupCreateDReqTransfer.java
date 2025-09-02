package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveMarketGroupCreateReqCTransfer
 * <p>游戏EVE市场分组创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 20:33
 * <p>
 * update 2025/07/24 20:33
 *
 * @param marketGroupId          市场分组ID
 * @param gameEveMarketGroupCode 游戏EVE市场分组编码
 * @param createUserId           创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveMarketGroupCode", "createUserId"})
public record GameEveMarketGroupCreateDReqTransfer(
        @NotBlank(message = "市场分组ID不能为空") String marketGroupId,
        @NotBlank(message = "游戏EVE市场分组编码不能为空") String gameEveMarketGroupCode,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public GameEveMarketGroupCreateDReqTransfer validate() {
        return this;
    }
}
