package org.endless.tianyan.item.components.item.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.endless.ddd.starter.common.annotation.validate.ddd.transfer.Transfer;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryRespTransfer;

/**
 * FindItemIdQRespTransfer
 * <p>资源项ID查询响应传输对象
 * <p>
 * itemCreate 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @param itemId 资源项ID
 * @author Deng Haozhi
 * @see TianyanItemQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"itemId"})
public record FindItemIdQRespTransfer(
        @NotBlank(message = "资源项ID不能为空") String itemId
) implements TianyanItemQueryRespTransfer {

    @Override
    public FindItemIdQRespTransfer validate() {
        return this;
    }
}
