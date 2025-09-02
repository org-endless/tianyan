package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenReqTransfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenRespTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameDRespTransfer;

/**
 * GameEveDataFileItemCategoryRespDTransfer
 * <p>游戏EVE数据文件资源项分类被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/08/24 01:21
 *
 * @param name      资源项分类名称
 * @param published 资源项分类是否发布
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenReqTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"name", "published"})
public record GameEveDataFileItemCategoryDRespTransfer(
        @NotNull(message = "资源项分类名称不能为空")
        @Valid GameEveDataFileNameDRespTransfer name,
        @NotNull(message = "资源项分类是否发布不能为空") Boolean published
) implements TianyanMetadataDrivenRespTransfer {

    @Override
    public GameEveDataFileItemCategoryDRespTransfer validate() {
        return this;
    }
}
