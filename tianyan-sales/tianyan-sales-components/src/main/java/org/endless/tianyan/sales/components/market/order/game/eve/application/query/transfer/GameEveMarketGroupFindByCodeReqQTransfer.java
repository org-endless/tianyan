package org.endless.tianyan.sales.components.market.order.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryTransferValidateException;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveMarketGroupFindByCodeReqQTransfer
 * <p>游戏EVE市场分组根据编码查询请求传输对象
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
@JSONType(orders = {"code"})
public class GameEveMarketGroupFindByCodeReqQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 游戏EVE市场分组编码
     */
    private final String code;

    @Override
    public GameEveMarketGroupFindByCodeReqQTransfer validate() {
        validateCode();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new QueryTransferValidateException("游戏EVE市场分组编码不能为空");
        }
    }
}
