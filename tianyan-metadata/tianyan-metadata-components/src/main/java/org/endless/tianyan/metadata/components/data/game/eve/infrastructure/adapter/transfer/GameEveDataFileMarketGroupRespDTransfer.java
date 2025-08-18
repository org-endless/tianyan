package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;

/**
 * GameEveDataFileMarketGroupRespDTransfer
 * <p>游戏EVE数据文件市场分组被动响应传输对象
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
@JSONType(orders = {"nameID", "parentGroupID"})
public class GameEveDataFileMarketGroupRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 市场分组名称
     */
    private final GameEveDataFileNameRespDTransfer nameID;

    /**
     * 父市场分组编码
     */
    private final String parentGroupID;

    @Override
    public GameEveDataFileMarketGroupRespDTransfer validate() {
        validateNameID();
        return this;
    }

    private void validateNameID() {
        if (nameID == null) {
            throw new DrivenRespTransferValidateException("市场分组名称不能为 null ");
        }
    }
}
