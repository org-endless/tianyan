package org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveMarketGroupFindByCodeReqQTransfer
 * <p>游戏EVE市场分组根据编码查询请求传输对象
 * <p>
 * create 2025/07/26 05:28
 * <p>
 * update 2025/07/26 05:28
 *
 * @author Deng Haozhi
 * @see TianyanSalesQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveMarketGroupCode"})
public class GameEveMarketGroupFindByCodeReqQTransfer implements TianyanSalesQueryTransfer {

    /**
     * 游戏EVE市场分组编码
     */
    private final String gameEveMarketGroupCode;

    @Override
    public GameEveMarketGroupFindByCodeReqQTransfer validate() {
        validateGameEveMarketGroupCode();
        return this;
    }

    private void validateGameEveMarketGroupCode() {
        if (!StringUtils.hasText(gameEveMarketGroupCode)) {
            throw new QueryReqTransferValidateException("游戏EVE市场分组编码不能为空");
        }
    }
}
