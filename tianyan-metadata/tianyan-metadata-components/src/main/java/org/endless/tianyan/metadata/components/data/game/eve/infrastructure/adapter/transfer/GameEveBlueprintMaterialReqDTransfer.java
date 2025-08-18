package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveBlueprintMaterialReqDTransfer
 * <p>游戏EVE蓝图物料命令被动请求传输对象
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
@JSONType(orders = {"itemId", "quantity"})
public class GameEveBlueprintMaterialReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图物料数量
     */
    private final Long quantity;

    @Override
    public GameEveBlueprintMaterialReqDTransfer validate() {
        validateItemId();
        validateQuantity();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DrivenReqTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new DrivenReqTransferValidateException("蓝图物料数量不能为 null 或小于 0，当前值为: " + quantity);
        }
    }
}
