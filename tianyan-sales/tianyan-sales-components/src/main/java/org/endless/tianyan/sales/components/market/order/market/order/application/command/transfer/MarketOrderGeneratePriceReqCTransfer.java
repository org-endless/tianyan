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
 * MarketOrderGeneratePriceReqCTransfer
 * <p>市场订单生成价格命令请求传输对象
 * <p>
 * create 2025/07/28 00:46
 * <p>
 * update 2025/07/28 00:46
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "createUserId"})
public class MarketOrderGeneratePriceReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public MarketOrderGeneratePriceReqCTransfer validate() {
        validateItemId();
        validateCreateUserId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
