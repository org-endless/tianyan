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
 * GameEveMarketOrderESIFindPageReqDTransfer
 * <p>游戏EVE市场订单信息查询被动请求传输对象
 * <p>
 * create 2025/07/25 16:04
 * <p>
 * update 2025/07/25 16:04
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"regionId", "orderType", "gameEveItemCode", "page"})
public class GameEveMarketOrderESIFindPageReqDTransfer implements TianyanSalesDrivenTransfer {

    /**
     * 游戏EVE星域编码
     */
    private final String regionId;

    /**
     * 游戏EVE订单类型
     */
    private final String orderType;

    /**
     * 游戏EVE资源项编码
     */
    private final String gameEveItemCode;

    /**
     * 游戏EVE页码
     */
    private final Integer page;

    @Override
    public GameEveMarketOrderESIFindPageReqDTransfer validate() {
        validateRegionId();
        validateOrderType();
        validateGameEveItemCode();
        validatePage();
        return this;
    }

    private void validateRegionId() {
        if (!StringUtils.hasText(regionId)) {
            throw new DrivenTransferValidateException("游戏EVE星域编码不能为空");
        }
    }

    private void validateOrderType() {
        if (!StringUtils.hasText(orderType)) {
            throw new DrivenTransferValidateException("游戏EVE订单类型不能为空");
        }
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new DrivenTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validatePage() {
        if (page == null || page < 0) {
            throw new DrivenTransferValidateException("游戏EVE页码不能为 null 或小于 0，当前值为: " + page);
        }
    }
}
