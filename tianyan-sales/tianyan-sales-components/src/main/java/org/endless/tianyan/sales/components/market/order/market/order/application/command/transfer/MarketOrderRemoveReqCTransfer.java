package org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer;

import org.endless.tianyan.sales.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.sales.components.market.order.market.order.domain.value.*;
import org.endless.tianyan.sales.components.market.order.market.order.domain.type.*;
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
 * MarketOrderRemoveReqCTransfer
 * <p>游戏EVE市场订单删除命令请求传输对象
 * <p>
 * create 2025/07/25 17:39
 * <p>
 * update 2025/07/25 17:39
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"marketOrderId", "modifyUserId"})
public class MarketOrderRemoveReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 市场订单ID
     */
    private final String marketOrderId;

    /**
     * 修改用户ID
     */
    private final String modifyUserId;

    @Override
    public MarketOrderRemoveReqCTransfer validate() {
        validateMarketOrderId();
        validateModifyUserId();
        return this;
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new CommandTransferValidateException("市场订单ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new CommandTransferValidateException("修改用户ID不能为空");
        }
    }
}
