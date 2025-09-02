package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveMetagroupCreateReqCTransfer
 * <p>游戏EVE元分组创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 20:25
 * <p>
 * update 2025/08/23 22:59
 *
 * @param metagroupId          元分组ID
 * @param gameEveMetagroupCode 游戏EVE元分组编码
 * @param createUserId         创建用户ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"metagroupId", "gameEveMetagroupCode", "createUserId"})
public record GameEveMetagroupCreateDReqTransfer(
        @NotBlank(message = "元分组ID不能为空") String metagroupId,
        @NotBlank(message = "游戏EVE元分组编码不能为空") String gameEveMetagroupCode,
        @NotBlank(message = "创建用户ID不能为空") String createUserId
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public GameEveMetagroupCreateDReqTransfer validate() {
        return this;
    }
}
