package org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.application.query.transfer.TianyanMetadataQueryReqTransfer;

/**
 * FindByGameEveMetagroupCodeQReqTransfer
 * <p>根据游戏EVE元分组编码查询请求传输对象
 * <p>
 * create 2025/07/24 16:17
 * <p>
 * update 2025/07/24 16:17
 *
 * @param gameEveMetagroupCode 游戏EVE元分组编码
 * @author Deng Haozhi
 * @see TianyanMetadataQueryReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"gameEveMetagroupCode"})
public record FindByGameEveMetagroupCodeQReqTransfer(
        @NotBlank(message = "游戏EVE元分组编码不能为空") String gameEveMetagroupCode
) implements TianyanMetadataQueryReqTransfer {

    @Override
    public FindByGameEveMetagroupCodeQReqTransfer validate() {
        return this;
    }
}
