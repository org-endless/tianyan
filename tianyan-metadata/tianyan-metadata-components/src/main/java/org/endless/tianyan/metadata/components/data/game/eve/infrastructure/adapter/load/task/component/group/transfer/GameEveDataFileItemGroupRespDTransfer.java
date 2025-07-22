package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.task.component.group.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.load.transfer.GameEveDataFileNameRespDTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveDataFileItemGroupRespDTransfer
 * <p>游戏EVE数据文件物品分组被动响应传输对象
 * <p>
 * create 2025/07/21 15:57
 * <p>
 * update 2025/07/21 15:57
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"name", "categoryID", "published", "useBasePrice"})
public class GameEveDataFileItemGroupRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 物品分组名称
     */
    private final GameEveDataFileNameRespDTransfer name;

    /**
     * 物品分类编码
     */
    private final String categoryID;

    /**
     * 物品分组是否发布
     */
    private final Boolean published;

    /**
     * 物品分组是否使用基准价格
     */
    private final Boolean useBasePrice;

    @Override
    public GameEveDataFileItemGroupRespDTransfer validate() {
        validateName();
        validateCategoryID();
        validatePublished();
        validateUseBasePrice();
        return this;
    }

    private void validateName() {
        if (name == null) {
            throw new DrivenTransferValidateException("物品分组名称不能为 null ");
        }
    }

    private void validateCategoryID() {
        if (!StringUtils.hasText(categoryID)) {
            throw new DrivenTransferValidateException("物品分类编码不能为空");
        }
    }

    private void validatePublished() {
        if (published == null) {
            throw new DrivenTransferValidateException("物品分组是否发布不能为 null ");
        }
    }

    private void validateUseBasePrice() {
        if (useBasePrice == null) {
            throw new DrivenTransferValidateException("物品分组是否使用基准价格不能为 null ");
        }
    }
}
