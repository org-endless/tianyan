package org.endless.tianyan.sales.components.market.game.eve.order.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryRespTransfer;

import java.util.List;

/**
 * GameEveMarketOrderFindItemIdsRespQTransfer
 * <p>资源项ID列表查询响应传输对象
 * <p>
 * create 2025/07/28 00:25
 * <p>
 * update 2025/07/28 00:25
 *
 * @param itemIds 资源项ID列表
 * @author Deng Haozhi
 * @see TianyanSalesQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemIds"})
public record FindItemIdsRespQReqTransfer(
        List<String> itemIds
) implements TianyanSalesQueryRespTransfer {

    @Override
    public FindItemIdsRespQReqTransfer validate() {
        return this;
    }
}
