package org.endless.tianyan.item.components.item.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemLoadReqCTransfer
 * <p>游戏EVE资源项加载命令请求传输对象
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"createUserId"})
public class GameEveItemLoadReqCTransfer implements TianyanItemCommandTransfer {

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveItemLoadReqCTransfer validate() {
        validateCreateUserId();
        return this;
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
