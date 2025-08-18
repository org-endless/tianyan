package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemGroupFindByCodeReqDTransfer
 * <p>游戏EVE资源项分组根据编码查询被动请求传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemGroupCode"})
public class GameEveItemGroupFindByCodeReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE资源项分组编码
     */
    private final String gameEveItemGroupCode;

    @Override
    public GameEveItemGroupFindByCodeReqDTransfer validate() {
        validateGameEveItemGroupCode();
        return this;
    }

    private void validateGameEveItemGroupCode() {
        if (!StringUtils.hasText(gameEveItemGroupCode)) {
            throw new DrivenReqTransferValidateException("游戏EVE资源项分组编码不能为空");
        }
    }
}
