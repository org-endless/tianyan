package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemGroupFindIdRespDTransfer
 * <p>游戏EVE资源项分组ID查询被动响应传输对象
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
@JSONType(orders = {"itemGroupId"})
public class GameEveItemGroupFindIdRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    @Override
    public GameEveItemGroupFindIdRespDTransfer validate() {
        validateItemGroupId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new DrivenRespTransferValidateException("资源项分组ID不能为空");
        }
    }
}
