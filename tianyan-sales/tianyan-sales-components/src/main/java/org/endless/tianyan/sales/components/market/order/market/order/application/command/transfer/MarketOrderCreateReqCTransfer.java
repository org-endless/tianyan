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
 * <p>游戏EVE市场订单创建命令请求传输对象
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
@JSONType(orders = {"type", "totalQuantity", "remainQuantity", "minQuantity", "price", "issuedAt", "expireAt", "createUserId"})
public class MarketOrderCreateReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 市场订单类型
     */
    private final String type;

    /**
     * 市场订单总数(20, 5)
     */
    private final String totalQuantity;

    /**
     * 市场订单剩余数量(20, 5)
     */
    private final String remainQuantity;

    /**
     * 市场订单最小交易数量(20, 5)
     */
    private final String minQuantity;

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
        validateType();
        validateTotalQuantity();
        validateRemainQuantity();
        validateMinQuantity();
        validatePrice();
        validateIssuedAt();
        validateCreateUserId();
        return this;
    }

    private void validateType() {
        if (!StringUtils.hasText(type)) {
            throw new CommandTransferValidateException("市场订单类型不能为空");
        }
    }

    private void validateTotalQuantity() {
        if (!StringUtils.hasText(totalQuantity)) {
            throw new CommandTransferValidateException("市场订单总数(20, 5)不能为空");
        }
    }

    private void validateRemainQuantity() {
        if (!StringUtils.hasText(remainQuantity)) {
            throw new CommandTransferValidateException("市场订单剩余数量(20, 5)不能为空");
        }
    }

    private void validateMinQuantity() {
        if (!StringUtils.hasText(minQuantity)) {
            throw new CommandTransferValidateException("市场订单最小交易数量(20, 5)不能为空");
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
