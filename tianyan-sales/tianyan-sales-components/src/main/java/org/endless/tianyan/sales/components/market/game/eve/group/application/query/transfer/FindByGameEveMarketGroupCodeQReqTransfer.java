package org.endless.tianyan.sales.components.market.game.eve.group.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.sales.common.model.application.query.transfer.TianyanSalesQueryReqTransfer;

/**
 * FindByGameEveMarketGroupCodeQReqTransfer
 * <p>根据游戏EVE市场分组编码查询请求传输对象
 * <p>
 * create 2025/07/26 05:28
 * <p>
 * update 2025/07/26 05:28
 *
 * @param gameEveMarketGroupCode 游戏EVE市场分组编码
 * @author Deng Haozhi
 * @see TianyanSalesQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveMarketGroupCode"})
public record FindByGameEveMarketGroupCodeQReqTransfer(
        @NotBlank(message = "游戏EVE市场分组编码不能为空") String gameEveMarketGroupCode
) implements TianyanSalesQueryReqTransfer {

    @Override
    public FindByGameEveMarketGroupCodeQReqTransfer validate() {
        return this;
    }
}
