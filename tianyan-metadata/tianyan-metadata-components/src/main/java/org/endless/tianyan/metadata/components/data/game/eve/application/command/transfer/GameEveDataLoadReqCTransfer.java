package org.endless.tianyan.metadata.components.data.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.endless.tianyan.metadata.common.model.application.command.transfer.TianyanMetadataCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveDataLoadReqCTransfer
 * <p>游戏EVE数据加载命令请求传输对象
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"dataType"})
public class GameEveDataLoadReqCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 数据类型
     */
    private final String dataType;

    @Override
    public GameEveDataLoadReqCTransfer validate() {
        validateDataType();
        return this;
    }

    private void validateDataType() {
        if (!StringUtils.hasText(dataType)) {
            throw new CommandTransferValidateException("数据类型不能为空");
        }
    }
}
