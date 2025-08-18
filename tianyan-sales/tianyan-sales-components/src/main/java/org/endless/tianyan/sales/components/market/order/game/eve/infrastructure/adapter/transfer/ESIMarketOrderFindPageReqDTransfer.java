package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenReqTransferValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.adapter.transfer.TianyanSalesDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * ESIMarketOrderFindPageReqDTransfer
 * <p>ESI市场订单分页查询被动请求传输对象
 * <p>
 * create 2025/07/28 07:09
 * <p>
 * update 2025/07/28 07:09
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"regionId", "orderType", "gameEveItemCode", "page"})
public class ESIMarketOrderFindPageReqDTransfer implements TianyanSalesDrivenTransfer {

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
    public ESIMarketOrderFindPageReqDTransfer validate() {
        validateRegionId();
        validateOrderType();
        validateGameEveItemCode();
        validatePage();
        return this;
    }

    private void validateRegionId() {
        if (!StringUtils.hasText(regionId)) {
            throw new DrivenReqTransferValidateException("游戏EVE星域编码不能为空");
        }
    }

    private void validateOrderType() {
        if (!StringUtils.hasText(orderType)) {
            throw new DrivenReqTransferValidateException("游戏EVE订单类型不能为空");
        }
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new DrivenReqTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validatePage() {
        if (page == null || page < 0) {
            throw new DrivenReqTransferValidateException("游戏EVE页码不能为 null 或小于 0，当前值为: " + page);
        }
    }
}
