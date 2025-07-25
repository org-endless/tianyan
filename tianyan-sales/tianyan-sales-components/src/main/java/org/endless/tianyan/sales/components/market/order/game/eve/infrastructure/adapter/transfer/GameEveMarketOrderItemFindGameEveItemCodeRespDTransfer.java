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
 * GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer
 * <p>资源项游戏EVE编码查询被动响应传输对象
 * <p>
 * create 2025/07/26 04:50
 * <p>
 * update 2025/07/26 04:50
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCode"})
public class GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer implements TianyanSalesDrivenTransfer {

    /**
     * 游戏EVE资源项编码
     */
    private final String gameEveItemCode;

    @Override
    public GameEveMarketOrderItemFindGameEveItemCodeRespDTransfer validate() {
        validateGameEveItemCode();
        return this;
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new DrivenTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }
}
