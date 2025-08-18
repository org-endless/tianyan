package org.endless.tianyan.sales.components.market.order.market.order.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * MarketOrderModifyReqCTransfer
 * <p>市场订单修改命令请求传输对象
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
@JSONType(orders = {"marketOrderId", "totalItemQuantity", "remainItemQuantity", "minItemQuantity", "price", "issuedAt", "expireAt", "modifyUserId"})
public class MarketOrderModifyReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 市场订单ID
     */
    private final String marketOrderId;

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
     * 修改用户ID
     */
    private final String modifyUserId;

    @Override
    public MarketOrderModifyReqCTransfer validate() {
        validateMarketOrderId();
        validateTotalItemQuantity();
        validateRemainItemQuantity();
        validateMinItemQuantity();
        validatePrice();
        validateIssuedAt();
        validateModifyUserId();
        return this;
    }

    private void validateMarketOrderId() {
        if (!StringUtils.hasText(marketOrderId)) {
            throw new CommandReqTransferValidateException("市场订单ID不能为空");
        }
    }

    private void validateTotalItemQuantity() {
        if (!StringUtils.hasText(totalItemQuantity)) {
            throw new CommandReqTransferValidateException("市场订单资源项总数(20, 5)不能为空");
        }
    }

    private void validateRemainItemQuantity() {
        if (!StringUtils.hasText(remainItemQuantity)) {
            throw new CommandReqTransferValidateException("市场订单资源项剩余数量(20, 5)不能为空");
        }
    }

    private void validateMinItemQuantity() {
        if (!StringUtils.hasText(minItemQuantity)) {
            throw new CommandReqTransferValidateException("市场订单资源项最小交易数量(20, 5)不能为空");
        }
    }

    private void validatePrice() {
        if (!StringUtils.hasText(price)) {
            throw new CommandReqTransferValidateException("市场订单价格(17, 2)不能为空");
        }
    }

    private void validateIssuedAt() {
        if (!StringUtils.hasText(issuedAt)) {
            throw new CommandReqTransferValidateException("市场订单创建时间(yyyy-MM-dd HH:mm:ss:SSS)不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new CommandReqTransferValidateException("修改用户ID不能为空");
        }
    }
}
