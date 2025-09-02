package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.market.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.transfer.GameEveCommonDrivenRespTransfer;

/**
 * ESIMarketOrderFindProfileRespDTransfer
 * <p>ESI市场订单信息查询被动响应传输对象
 * <p>
 * create 2025/07/28 07:09
 * <p>
 * update 2025/07/28 07:09
 *
 * @param order_id      游戏EVE市场订单编号
 * @param is_buy_order  游戏EVE市场订单是否为买入订单
 * @param volume_total  游戏EVE市场订单总数
 * @param volume_remain 游戏EVE市场订单剩余数量
 * @param min_volume    游戏EVE市场订单最小交易数量
 * @param price         游戏EVE市场订单价格
 * @param issued        游戏EVE市场订单创建时间(ISO)
 * @param duration      游戏EVE市场订单持续时间
 * @param range         游戏EVE市场订单范围
 * @param system_id     游戏EVE市场订单星系编码
 * @param location_id   游戏EVE市场订单空间站编码
 * @author Deng Haozhi
 * @see Record
 * @see GameEveCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"order_id", "is_buy_order", "volume_total", "volume_remain", "min_volume", "price", "issued", "duration", "range", "system_id", "location_id"})
public record FindESIMarketOrderDRespTransfer(
        @NotBlank(message = "游戏EVE市场订单编号不能为空") String order_id,
        @NotNull(message = "游戏EVE市场订单是否为买入订单不能为空") Boolean is_buy_order,
        @NotNull(message = "游戏EVE市场订单总数不能为空") Long volume_total,
        @NotNull(message = "游戏EVE市场订单剩余数量不能为空") Long volume_remain,
        @NotNull(message = "游戏EVE市场订单最小交易数量不能为空") Long min_volume,
        @NotNull(message = "游戏EVE市场订单价格不能为空") Double price,
        @NotBlank(message = "游戏EVE市场订单创建时间(ISO)不能为空") String issued,
        @NotBlank(message = "游戏EVE市场订单持续时间不能为空") String duration,
        @NotBlank(message = "游戏EVE市场订单范围不能为空") String range,
        @NotBlank(message = "游戏EVE市场订单星系编码不能为空") String system_id,
        @NotBlank(message = "游戏EVE市场订单空间站编码不能为空") String location_id
) implements GameEveCommonDrivenRespTransfer {

    @Override
    public FindESIMarketOrderDRespTransfer validate() {
        return this;
    }
}
