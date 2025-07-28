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
 * GameEveMarketOrderItemFetchRespDTransfer
 * <p>游戏EVE市场订单资源项获取命令被动响应传输对象
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
@JSONType(orders = {"itemId"})
public class GameEveMarketOrderItemFetchRespDTransfer implements TianyanSalesDrivenTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    @Override
    public GameEveMarketOrderItemFetchRespDTransfer validate() {
        validateItemId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DrivenTransferValidateException("资源项ID不能为空");
        }
    }
}
