package org.endless.tianyan.sales.components.market.group.market.group.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryTransfer;
import org.springframework.util.StringUtils;

/**
 * MarketGroupFindByIdReqQTransfer
 * <p>市场分组根ID查询请求传输对象
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"marketGroupId"})
public class MarketGroupFindByIdReqQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 市场分组ID
     */
    private final String marketGroupId;

    @Override
    public MarketGroupFindByIdReqQTransfer validate() {
        validateMarketGroupId();
        return this;
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new QueryReqTransferValidateException("市场分组ID不能为空");
        }
    }
}
