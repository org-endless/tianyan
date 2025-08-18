package org.endless.tianyan.sales.components.market.order.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryRespTransferValidateException;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveMarketGroupFindIdRespQTransfer
 * <p>游戏EVE市场分组ID查询响应传输对象
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"marketGroupId"})
public class GameEveMarketGroupFindIdRespQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 市场分组ID
     */
    private final String marketGroupId;

    @Override
    public GameEveMarketGroupFindIdRespQTransfer validate() {
        validateMarketGroupId();
        return this;
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new QueryRespTransferValidateException("市场分组ID不能为空");
        }
    }
}
