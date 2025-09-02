package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * GameEveItemGroupFindByCodeReqQReqTransfer
 * <p>根据游戏EVE资源项分组编码查询被动请求传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/08/23 04:50
 *
 * @param gameEveItemGroupCode 游戏EVE资源项分组编码
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemGroupCode"})
public record FindByGameEveItemGroupCodeDReqTransfer(
        @NotBlank(message = "游戏EVE资源项分组编码不能为空") String gameEveItemGroupCode
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public FindByGameEveItemGroupCodeDReqTransfer validate() {
        return this;
    }
}
