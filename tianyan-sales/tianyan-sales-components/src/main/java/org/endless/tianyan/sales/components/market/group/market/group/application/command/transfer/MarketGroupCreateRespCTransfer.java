package org.endless.tianyan.sales.components.market.group.market.group.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandRespTransferValidateException;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * MarketGroupCreateRespCTransfer
 * <p>市场分组创建命令响应传输对象
 * <p>
 * create 2025/07/24 20:31
 * <p>
 * update 2025/07/24 20:31
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
            throw new CommandRespTransferValidateException("市场分组ID不能为空");
        }
    }
}
