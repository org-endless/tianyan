package org.endless.tianyan.item.components.item.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;

import java.util.List;

/**
 * FindByGameEveItemCodesQReqTransfer
 * <p>根据游戏EVE资源项编码列表查询请求传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @param gameEveItemCodes 游戏EVE资源项编码列表
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveItemCodes"})
public record FindByGameEveItemCodesQReqTransfer(
        @NotEmpty(message = "游戏EVE资源项编码列表不能为空") List<String> gameEveItemCodes
) implements TianyanItemQueryReqTransfer {

    @Override
    public FindByGameEveItemCodesQReqTransfer validate() {
        return this;
    }
}
