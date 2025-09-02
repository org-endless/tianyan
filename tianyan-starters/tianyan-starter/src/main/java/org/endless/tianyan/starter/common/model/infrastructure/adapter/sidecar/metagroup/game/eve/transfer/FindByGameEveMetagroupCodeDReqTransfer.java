package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenReqTransfer;

/**
 * FindByGameEveMetagroupCodeDReqTransfer
 * <p>根据游戏EVE元分组编码查询被动请求传输对象
 * <p>
 * create 2025/07/24 16:17
 * <p>
 * update 2025/08/24 00:34
 *
 * @param gameEveMetagroupCode 游戏EVE元分组编码
 * @author Deng Haozhi
 * @see TianyanCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveMetagroupCode"})
public record FindByGameEveMetagroupCodeDReqTransfer(
        @NotBlank(message = "游戏EVE元分组编码不能为空") String gameEveMetagroupCode
) implements TianyanCommonDrivenReqTransfer {

    @Override
    public FindByGameEveMetagroupCodeDReqTransfer validate() {
        return this;
    }
}
