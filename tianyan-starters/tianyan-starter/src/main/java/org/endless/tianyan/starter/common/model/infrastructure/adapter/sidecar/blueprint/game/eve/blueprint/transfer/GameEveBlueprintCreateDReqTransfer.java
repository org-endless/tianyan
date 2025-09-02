package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.game.eve.blueprint.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveBlueprintCreateReqCTransfer
 * <p>游戏EVE蓝图创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 10:43
 * <p>
 * update 2025/07/24 10:43
 *
 * @param blueprintId              蓝图ID
 * @param gameEveBlueprintItemCode 游戏EVE蓝图资源项编码
 * @param maxProductionLimit       游戏EVE蓝图最大生产次数
 * @param createUserId             创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"blueprintId", "gameEveBlueprintItemCode", "maxProductionLimit", "createUserId"})
public record GameEveBlueprintCreateDReqTransfer(
        @NotBlank(message = "蓝图ID不能为空") String blueprintId,
        @NotBlank(message = "游戏EVE蓝图资源项编码不能为空") String gameEveBlueprintItemCode,
        @NotNull(message = "游戏EVE蓝图最大生产次数不能为空") Integer maxProductionLimit,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public GameEveBlueprintCreateDReqTransfer validate() {
        return this;
    }
}
