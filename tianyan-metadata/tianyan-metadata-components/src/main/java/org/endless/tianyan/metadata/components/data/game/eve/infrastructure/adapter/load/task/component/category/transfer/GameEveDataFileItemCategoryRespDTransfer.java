package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameRespDTransfer;

/**
 * GameEveDataFileItemCategoryRespDTransfer
 * <p>游戏EVE数据文件物品分类被动响应传输对象
 * <p>
 * create 2025/07/21 13:04
 * <p>
 * update 2025/07/21 13:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"name", "published"})
public class GameEveDataFileItemCategoryRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 物品分类名称
     */
    private final GameEveDataFileNameRespDTransfer name;

    /**
     * 物品分类是否发布
     */
    private final Boolean published;

    @Override
    public GameEveDataFileItemCategoryRespDTransfer validate() {
        validateName();
        validatePublished();
        return this;
    }

    private void validateName() {
        if (name == null) {
            throw new DrivenTransferValidateException("物品分类名称不能为 null ");
        }
    }

    private void validatePublished() {
        if (published == null) {
            throw new DrivenTransferValidateException("物品分类是否发布不能为 null ");
        }
    }
}
