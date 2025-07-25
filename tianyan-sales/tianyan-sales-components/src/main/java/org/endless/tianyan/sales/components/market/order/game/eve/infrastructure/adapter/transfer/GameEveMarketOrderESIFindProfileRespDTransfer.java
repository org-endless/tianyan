package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer;

import org.endless.tianyan.sales.common.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GameEveMarketOrderESIFindProfileRespDTransfer
 * <p>ESI市场订单信息查询被动响应传输对象
 * <p>
 * create 2025/07/26 04:50
 * <p>
 * update 2025/07/26 04:50
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"order_id", "is_buy_order", "volume_total", "volume_remain", "min_volume", "price", "issued", "duration", "range", "system_id", "location_id"})
public class GameEveMarketOrderESIFindProfileRespDTransfer implements TianyanSalesDrivenTransfer {

    /**
     * 游戏EVE市场订单编号
     */
    private final String order_id;

    /**
     * 游戏EVE市场订单是否为买入订单
     */
    private final Boolean is_buy_order;

    /**
     * 游戏EVE市场订单总数
     */
    private final Integer volume_total;

    /**
     * 游戏EVE市场订单剩余数量
     */
    private final Integer volume_remain;

    /**
     * 游戏EVE市场订单最小交易数量
     */
    private final Integer min_volume;

    /**
     * 游戏EVE市场订单价格
     */
    private final Double price;

    /**
     * 游戏EVE市场订单创建时间(ISO)
     */
    private final String issued;

    /**
     * 游戏EVE市场订单持续时间
     */
    private final String duration;

    /**
     * 游戏EVE市场订单范围
     */
    private final String range;

    /**
     * 游戏EVE市场订单星系编码
     */
    private final String system_id;

    /**
     * 游戏EVE市场订单空间站编码
     */
    private final String location_id;

    @Override
    public GameEveMarketOrderESIFindProfileRespDTransfer validate() {
        validateOrder_id();
        validateIs_buy_order();
        validateVolume_total();
        validateVolume_remain();
        validateMin_volume();
        validatePrice();
        validateIssued();
        validateDuration();
        validateRange();
        validateSystem_id();
        validateLocation_id();
        return this;
    }

    private void validateOrder_id() {
        if (!StringUtils.hasText(order_id)) {
            throw new DrivenTransferValidateException("游戏EVE市场订单编号不能为空");
        }
    }

    private void validateIs_buy_order() {
        if (is_buy_order == null) {
            throw new DrivenTransferValidateException("游戏EVE市场订单是否为买入订单不能为 null ");
        }
    }

    private void validateVolume_total() {
        if (volume_total == null || volume_total < 0) {
            throw new DrivenTransferValidateException("游戏EVE市场订单总数不能为 null 或小于 0，当前值为: " + volume_total);
        }
    }

    private void validateVolume_remain() {
        if (volume_remain == null || volume_remain < 0) {
            throw new DrivenTransferValidateException("游戏EVE市场订单剩余数量不能为 null 或小于 0，当前值为: " + volume_remain);
        }
    }

    private void validateMin_volume() {
        if (min_volume == null || min_volume < 0) {
            throw new DrivenTransferValidateException("游戏EVE市场订单最小交易数量不能为 null 或小于 0，当前值为: " + min_volume);
        }
    }

    private void validatePrice() {
        if (price == null || price < 0) {
            throw new DrivenTransferValidateException("游戏EVE市场订单价格不能为 null 或小于 0，当前值为: " + price);
        }
    }

    private void validateIssued() {
        if (!StringUtils.hasText(issued)) {
            throw new DrivenTransferValidateException("游戏EVE市场订单创建时间(ISO)不能为空");
        }
    }

    private void validateDuration() {
        if (!StringUtils.hasText(duration)) {
            throw new DrivenTransferValidateException("游戏EVE市场订单持续时间不能为空");
        }
    }

    private void validateRange() {
        if (!StringUtils.hasText(range)) {
            throw new DrivenTransferValidateException("游戏EVE市场订单范围不能为空");
        }
    }

    private void validateSystem_id() {
        if (!StringUtils.hasText(system_id)) {
            throw new DrivenTransferValidateException("游戏EVE市场订单星系编码不能为空");
        }
    }

    private void validateLocation_id() {
        if (!StringUtils.hasText(location_id)) {
            throw new DrivenTransferValidateException("游戏EVE市场订单空间站编码不能为空");
        }
    }
}
