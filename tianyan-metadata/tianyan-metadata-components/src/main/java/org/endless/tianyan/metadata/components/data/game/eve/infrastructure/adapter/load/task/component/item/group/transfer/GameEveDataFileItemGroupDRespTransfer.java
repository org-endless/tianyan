package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.item.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenRespTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameDRespTransfer;

/**
 * GameEveDataFileItemGroupRespDTransfer
 * <p>游戏EVE数据文件资源项分组被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @param name         资源项分组名称
 * @param categoryID   资源项分类编码
 * @param published    资源项分组是否发布
 * @param useBasePrice 资源项分组是否使用基准价格
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"name", "categoryID", "published", "useBasePrice"})
public record GameEveDataFileItemGroupDRespTransfer(
        @NotBlank(message = "资源项分类编码不能为空") String categoryID,
        @NotNull(message = "资源项分组名称不能为空") @Valid GameEveDataFileNameDRespTransfer name,
        @NotNull(message = "资源项分组是否发布不能为空") Boolean published,
        Boolean useBasePrice
) implements TianyanMetadataDrivenRespTransfer {

    @Override
    public GameEveDataFileItemGroupDRespTransfer validate() {
        return this;
    }
}
