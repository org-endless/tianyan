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
 * MarketOrderCreateReqCTransfer
 * <p>市场订单创建命令请求传输对象
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
@JSONType(orders = {"itemId", "type", "totalItemQuantity", "remainItemQuantity", "minItemQuantity", "price", "issuedAt", "expireAt", "createUserId"})
public class MarketOrderCreateReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 市场订单类型
     */
    private final String type;

    /**
     * 市场订单资源项总数(20, 5)
     */
    private final String totalItemQuantity;

    /**
     * 市场订单资源项剩余数量(20, 5)
     */
    private final String remainItemQuantity;

    /**
     * 市场订单资源项最小交易数量(20, 5)
     */
    private final String minItemQuantity;

    /**
     * 市场订单价格(17, 2)
     */
    private final String price;

    /**
     * 市场订单创建时间(yyyy-MM-dd HH:mm:ss:SSS)
     */
    private final String issuedAt;

    /**
     * 市场订单过期时间(yyyy-MM-dd HH:mm:ss:SSS)
     */
    private final String expireAt;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public MarketOrderCreateReqCTransfer validate() {
        validateItemId();
        validateType();
        validateTotalItemQuantity();
        validateRemainItemQuantity();
        validateMinItemQuantity();
        validatePrice();
        validateIssuedAt();
        validateCreateUserId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandTransferValidateException("市场订单类型不能为空");
        }
    }

    private void validateTotalItemQuantity() {
        if (!StringUtils.hasText(totalItemQuantity)) {
            throw new CommandTransferValidateException("市场订单资源项总数(20, 5)不能为空");
        }
    }

    private void validateRemainItemQuantity() {
        if (!StringUtils.hasText(remainItemQuantity)) {
            throw new CommandTransferValidateException("市场订单资源项剩余数量(20, 5)不能为空");
        }
    }

    private void validateMinItemQuantity() {
        if (!StringUtils.hasText(minItemQuantity)) {
            throw new CommandTransferValidateException("市场订单资源项最小交易数量(20, 5)不能为空");
        }
    }

    private void validatePrice() {
        if (!StringUtils.hasText(price)) {
            throw new CommandTransferValidateException("市场订单价格(17, 2)不能为空");
        }
    }

    private void validateIssuedAt() {
        if (!StringUtils.hasText(issuedAt)) {
            throw new CommandTransferValidateException("市场订单创建时间(yyyy-MM-dd HH:mm:ss:SSS)不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
