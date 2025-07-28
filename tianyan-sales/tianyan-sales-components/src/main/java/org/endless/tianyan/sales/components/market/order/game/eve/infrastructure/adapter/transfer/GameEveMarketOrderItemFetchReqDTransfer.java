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
 * GameEveMarketOrderItemFetchReqDTransfer
 * <p>游戏EVE市场订单资源项获取命令被动请求传输对象
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
@JSONType(orders = {"gameEveItemCode", "createUserId"})
public class GameEveMarketOrderItemFetchReqDTransfer implements TianyanSalesDrivenTransfer {

    /**
     * 游戏EVE资源项编码
     */
    private final String gameEveItemCode;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveMarketOrderItemFetchReqDTransfer validate() {
        validateGameEveItemCode();
        validateCreateUserId();
        return this;
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new DrivenTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenTransferValidateException("创建用户ID不能为空");
        }
    }
}
