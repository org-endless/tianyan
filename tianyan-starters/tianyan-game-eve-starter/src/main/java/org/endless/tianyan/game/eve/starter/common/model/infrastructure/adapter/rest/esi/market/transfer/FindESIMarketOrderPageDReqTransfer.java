package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.transfer.GameEveCommonDrivenReqTransfer;

/**
 * ESIMarketOrderFindPageReqDTransfer
 * <p>ESI市场订单分页查询被动请求传输对象
 * <p>
 * create 2025/07/28 07:09
 * <p>
 * update 2025/07/28 07:09
 *
 * @param regionId        游戏EVE星域编码
 * @param orderType       游戏EVE订单类型
 * @param gameEveItemCode 游戏EVE资源项编码
 * @param page            游戏EVE页码
 * @author Deng Haozhi
 * @see GameEveCommonDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"regionId", "orderType", "gameEveItemCode", "page"})
public record FindESIMarketOrderPageDReqTransfer(
        @NotBlank(message = "游戏EVE星域编码不能为空") String regionId,
        @NotBlank(message = "游戏EVE订单类型不能为空") String orderType,
        @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
        @NotNull(message = "游戏EVE页码不能为空") Integer page
) implements GameEveCommonDrivenReqTransfer {

    @Override
    public FindESIMarketOrderPageDReqTransfer validate() {
        return this;
    }
}
