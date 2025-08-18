package org.endless.tianyan.sales.components.market.order.market.order.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryTransfer;
import org.springframework.util.StringUtils;

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
            throw new QueryReqTransferValidateException("资源项ID不能为空");
        }
    }
}
