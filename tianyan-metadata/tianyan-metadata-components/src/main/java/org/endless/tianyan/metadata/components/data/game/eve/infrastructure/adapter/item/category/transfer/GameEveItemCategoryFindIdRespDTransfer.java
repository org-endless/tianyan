package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryFindIdRespDTransfer
 * <p>游戏EVE物品分类ID查询被动响应传输对象
 * <p>
 * create 2025/07/21 16:44
 * <p>
 * update 2025/07/21 16:44
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCategoryId"})
public class GameEveItemCategoryFindIdRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE物品分类ID
     */
    private final String gameEveItemCategoryId;

    @Override
    public GameEveItemCategoryFindIdRespDTransfer validate() {
        validateGameEveItemCategoryId();
        return this;
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new DrivenTransferValidateException("游戏EVE物品分类ID不能为空");
        }
    }
}
