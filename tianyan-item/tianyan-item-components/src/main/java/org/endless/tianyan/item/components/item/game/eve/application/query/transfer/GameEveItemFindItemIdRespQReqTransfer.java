package org.endless.tianyan.item.components.item.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryRespTransferValidateException;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemFindItemIdRespQReqTransfer
 * <p>游戏EVE资源项ID查询响应传输对象
 * <p>
 * create 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId"})
public class GameEveItemFindItemIdRespQReqTransfer implements TianyanItemQueryReqTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    @Override
    public GameEveItemFindItemIdRespQReqTransfer validate() {
        validateItemId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new QueryRespTransferValidateException("资源项ID不能为空");
        }
    }
}
