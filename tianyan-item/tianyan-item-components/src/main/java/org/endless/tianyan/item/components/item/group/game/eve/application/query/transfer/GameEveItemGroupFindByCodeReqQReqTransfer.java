package org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemGroupFindByCodeReqQReqTransfer
 * <p>游戏EVE资源项分组根据编码查询请求传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemGroupCode"})
public class GameEveItemGroupFindByCodeReqQReqTransfer implements TianyanItemQueryReqTransfer {

    /**
     * 游戏EVE资源项分组编码
     */
    private final String gameEveItemGroupCode;

    @Override
    public GameEveItemGroupFindByCodeReqQReqTransfer validate() {
        validateGameEveItemGroupCode();
        return this;
    }

    private void validateGameEveItemGroupCode() {
        if (!StringUtils.hasText(gameEveItemGroupCode)) {
            throw new QueryReqTransferValidateException("游戏EVE资源项分组编码不能为空");
        }
    }
}
