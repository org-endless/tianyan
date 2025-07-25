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
 * MarketOrderCreateRespCTransfer
 * <p>游戏EVE市场订单创建命令响应传输对象
 * <p>
 * create 2025/07/25 14:11
 * <p>
 * update 2025/07/25 14:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"marketOrderId"})
public class MarketOrderCreateRespCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 市场订单ID
     */
    private final String marketOrderId;

    @Override
    public MarketOrderCreateRespCTransfer validate() {
        validateMarketOrderId();
        return this;
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new CommandTransferValidateException("市场订单ID不能为空");
        }
    }
}
