package org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer;

import org.endless.tianyan.sales.common.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.*;
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
 * MarketOrderFindByItemIdReqQTransfer
 * <p>游戏EVE市场订单根据资源项ID查询请求传输对象
 * <p>
 * create 2025/07/26 05:38
 * <p>
 * update 2025/07/26 05:38
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId"})
public class MarketOrderFindByItemIdReqQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    @Override
    public MarketOrderFindByItemIdReqQTransfer validate() {
        validateItemId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new QueryTransferValidateException("资源项ID不能为空");
        }
    }
}
