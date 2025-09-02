package org.endless.tianyan.item.components.item.game.eve.group.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;

/**
 * FindByGameEveItemGroupCodeQReqTransfer
 * <p>根据游戏EVE资源项分组编码查询请求传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @param gameEveItemGroupCode 游戏EVE资源项分组编码
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemGroupCode"})
public record FindByGameEveItemGroupCodeQReqTransfer(
        @NotBlank(message = "游戏EVE资源项分组编码不能为空") String gameEveItemGroupCode
) implements TianyanItemQueryReqTransfer {

    @Override
    public FindByGameEveItemGroupCodeQReqTransfer validate() {
        return this;
    }
}
