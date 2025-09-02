package org.endless.tianyan.item.components.item.game.eve.item.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryRespTransfer;

/**
 * FindGameEveItemCodeQRespTransfer
 * <p>游戏EVE资源项编码查询响应传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @author Deng Haozhi
 * @see TianyanItemQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode"})
public record FindGameEveItemCodeQRespTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode
) implements TianyanItemQueryRespTransfer {

    @Override
    public FindGameEveItemCodeQRespTransfer validate() {
        return this;
    }
}
