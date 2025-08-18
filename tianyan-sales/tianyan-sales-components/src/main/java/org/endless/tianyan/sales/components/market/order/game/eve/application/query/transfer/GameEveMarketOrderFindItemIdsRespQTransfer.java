package org.endless.tianyan.sales.components.market.order.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryRespTransferValidateException;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryTransfer;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
            throw new QueryRespTransferValidateException("资源项ID列表不能为空");
        }
    }
}
