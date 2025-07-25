package org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer;

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
            throw new QueryTransferValidateException("游戏EVE市场分组编码不能为空");
        }
    }
}
