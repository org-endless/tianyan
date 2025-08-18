package org.endless.tianyan.sales.components.market.order.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.sales.common.model.application.command.transfer.TianyanSalesCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveMarketOrderFetchReqCTransfer
 * <p>游戏EVE市场订单获取命令请求传输对象
 * <p>
 * create 2025/07/28 00:37
 * <p>
 * update 2025/07/28 00:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCode", "createUserId"})
public class GameEveMarketOrderFetchReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 游戏EVE资源项编码
     */
    private final String gameEveItemCode;

    /**
     * 用户创建ID
     */
    private final String createUserId;

    @Override
    public GameEveMarketOrderFetchReqCTransfer validate() {
        validateGameEveItemCode();
        validateCreateUserId();
        return this;
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new CommandReqTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("用户创建ID不能为空");
        }
    }
}
