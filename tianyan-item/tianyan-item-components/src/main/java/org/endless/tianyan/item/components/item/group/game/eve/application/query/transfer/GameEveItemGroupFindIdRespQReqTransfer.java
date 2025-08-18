package org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryRespTransferValidateException;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemGroupFindIdRespQReqTransfer
 * <p>游戏EVE资源项分组ID查询响应传输对象
 * <p>
 * create 2025/07/26 05:25
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
@JSONType(orders = {"itemGroupId"})
public class GameEveItemGroupFindIdRespQReqTransfer implements TianyanItemQueryReqTransfer {

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    @Override
    public GameEveItemGroupFindIdRespQReqTransfer validate() {
        validateItemGroupId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new QueryRespTransferValidateException("资源项分组ID不能为空");
        }
    }
}
