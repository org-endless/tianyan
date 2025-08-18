package org.endless.tianyan.sales.components.market.price.market.price.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * MarketPriceCreateReqCTransfer
 * <p>市场价格创建命令请求传输对象
 * <p>
 * create 2025/07/27 21:56
 * <p>
 * update 2025/07/27 21:56
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "buyPrice", "sellPrice", "createUserId"})
public class MarketPriceCreateReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 买入价格(17, 2)
     */
    private final String buyPrice;

    /**
     * 卖出价格(17, 2)
     */
    private final String sellPrice;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public MarketPriceCreateReqCTransfer validate() {
        validateItemId();
        validateBuyPrice();
        validateSellPrice();
        validateCreateUserId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandReqTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateBuyPrice() {
        if (!StringUtils.hasText(buyPrice)) {
            throw new CommandReqTransferValidateException("买入价格(17, 2)不能为空");
        }
    }

    private void validateSellPrice() {
        if (!StringUtils.hasText(sellPrice)) {
            throw new CommandReqTransferValidateException("卖出价格(17, 2)不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
