package org.endless.tianyan.sales.components.market.order.game.eve.application.query.transfer;

import org.endless.tianyan.sales.common.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.*;
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
 * GameEveMarketOrderFindItemIdsRespQTransfer
 * <p>游戏EVE市场订单资源项ID列表查询响应传输对象
 * <p>
 * create 2025/07/28 00:25
 * <p>
 * update 2025/07/28 00:25
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemIds"})
public class GameEveMarketOrderFindItemIdsRespQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 资源项ID列表
     */
    private final List<String> itemIds;

    @Override
    public GameEveMarketOrderFindItemIdsRespQTransfer validate() {
        validateItemIds();
        return this;
    }

    private void validateItemIds() {
        if (CollectionUtils.isEmpty(itemIds)) {
            throw new QueryTransferValidateException("资源项ID列表不能为空");
        }
    }
}
