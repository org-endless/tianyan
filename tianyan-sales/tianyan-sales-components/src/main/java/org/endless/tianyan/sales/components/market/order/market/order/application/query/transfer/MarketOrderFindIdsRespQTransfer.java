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
 * MarketOrderFindIdsRespQTransfer
 * <p>游戏EVE市场订单ID查询响应传输对象
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
@JSONType(orders = {"marketOrderIds"})
public class MarketOrderFindIdsRespQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 市场订单ID列表
     */
    private final  List<String> marketOrderIds;

    @Override
    public MarketOrderFindIdsRespQTransfer validate() {
        return this;
    }
}
