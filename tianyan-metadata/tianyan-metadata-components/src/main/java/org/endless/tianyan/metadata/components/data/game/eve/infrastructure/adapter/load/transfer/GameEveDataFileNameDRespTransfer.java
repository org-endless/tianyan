package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;

/**
 * GameEveDataFileNameRespDTransfer
 * <p>游戏EVE数据文件名称被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param de 德文名称
 * @param en 英文名称
 * @param es 西班牙文名称
 * @param fr 法文名称
 * @param ja 日文名称
 * @param ru 俄文名称
 * @param zh 中文名称
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"de", "en", "es", "fr", "ja", "ru", "zh"})
public record GameEveDataFileNameDRespTransfer(
        String de,
        @NotBlank(message = "英文名称不能为空") String en,
        String es,
        String fr,
        String ja,
        String ru,
        String zh
) implements TianyanMetadataDrivenReqTransfer {

    @Override
    public GameEveDataFileNameDRespTransfer validate() {
        return this;
    }
}
