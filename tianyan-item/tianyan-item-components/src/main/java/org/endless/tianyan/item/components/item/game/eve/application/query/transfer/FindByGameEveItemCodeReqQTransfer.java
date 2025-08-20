package org.endless.tianyan.item.components.item.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;

/**
 * FindByGameEveItemCodeReqQTransfer
 * <p>根据游戏EVE资源项编码查询请求传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @param gameEveItemCode 游戏EVE资源项编码
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCode"})
public record FindByGameEveItemCodeReqQTransfer(
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode
) implements TianyanItemQueryReqTransfer {

    @Override
    public FindByGameEveItemCodeReqQTransfer validate() {
        return this;
    }
}
