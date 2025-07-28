package org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer;

import org.endless.tianyan.sales.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
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
 * GameEveMarketOrderGeneratePriceReqCTransfer
 * <p>游戏EVE市场订单生成价格命令请求传输对象
 * <p>
 * create 2025/07/28 00:37
 * <p>
 * update 2025/07/28 00:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCode", "createUserId"})
public class GameEveMarketOrderGeneratePriceReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 游戏EVE资源项编码
     */
    private final String gameEveItemCode;

    /**
     * 用户创建ID
     */
    private final String createUserId;

    @Override
    public GameEveMarketOrderGeneratePriceReqCTransfer validate() {
        validateGameEveItemCode();
        validateCreateUserId();
        return this;
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new CommandTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("用户创建ID不能为空");
        }
    }
}
