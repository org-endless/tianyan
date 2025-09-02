package org.endless.tianyan.item.components.item.game.eve.item.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryRespTransfer;

import java.util.List;

/**
 * FindItemIdsQRespTransfer
 * <p>资源项ID列表查询响应传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @param itemIds 资源项ID列表
 * @author Deng Haozhi
 * @see TianyanItemQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemIds"})
public record FindItemIdsQRespTransfer(
        @NotEmpty(message = "资源项ID列表不能为空") List<String> itemIds
) implements TianyanItemQueryRespTransfer {

    @Override
    public FindItemIdsQRespTransfer validate() {
        return this;
    }
}
