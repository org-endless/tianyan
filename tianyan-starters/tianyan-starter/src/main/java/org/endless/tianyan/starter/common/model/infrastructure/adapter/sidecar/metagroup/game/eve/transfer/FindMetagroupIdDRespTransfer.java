package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.transfer.TianyanCommonDrivenRespTransfer;

/**
 * FindMetagroupIdDRespTransfer
 * <p>元分组ID查询被动响应传输对象
 * <p>
 * create 2025/07/24 16:17
 * <p>
 * update 2025/08/24 00:35
 *
 * @param metagroupId 元分组ID
 * @author Deng Haozhi
 * @see TianyanCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"metagroupId"})
public record FindMetagroupIdDRespTransfer(
        @NotBlank(message = "元分组ID不能为空") String metagroupId
) implements TianyanCommonDrivenRespTransfer {

    @Override
    public FindMetagroupIdDRespTransfer validate() {
        return this;
    }
}
