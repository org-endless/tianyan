package org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.application.query.transfer.TianyanMetadataQueryRespTransfer;

/**
 * FindMetagroupIdQRespTransfer
 * <p>元分组ID查询响应传输对象
 * <p>
 * create 2025/07/24 16:17
 * <p>
 * update 2025/07/24 16:17
 *
 * @param metagroupId 元分组ID
 * @author Deng Haozhi
 * @see TianyanMetadataQueryRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"metagroupId"})
public record FindMetagroupIdQRespTransfer(
        @NotBlank(message = "元分组ID不能为空") String metagroupId
) implements TianyanMetadataQueryRespTransfer {

    @Override
    public FindMetagroupIdQRespTransfer validate() {
        return this;
    }
}
