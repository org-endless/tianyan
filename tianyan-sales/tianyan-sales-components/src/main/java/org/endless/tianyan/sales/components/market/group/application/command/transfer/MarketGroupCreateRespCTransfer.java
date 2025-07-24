package org.endless.tianyan.sales.components.market.group.application.command.transfer;

import org.endless.tianyan.sales.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.sales.components.market.group.domain.value.*;
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
 * MarketGroupCreateRespCTransfer
 * <p>市场分组创建命令响应传输对象
 * <p>
 * create 2025/07/22 16:09
 * <p>
 * update 2025/07/22 16:09
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"marketGroupId"})
public class MarketGroupCreateRespCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 市场分组ID
     */
    private final String marketGroupId;

    @Override
    public MarketGroupCreateRespCTransfer validate() {
        validateMarketGroupId();
        return this;
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new CommandTransferValidateException("市场分组ID不能为空");
        }
    }
}
