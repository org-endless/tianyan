package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryFindByCodeReqDTransfer
 * <p>游戏EVE物品分类根据编码查询被动请求传输对象
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
@JSONType(orders = {"code"})
public class GameEveItemCategoryFindByCodeReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE物品分类编码
     */
    private final String code;

    @Override
    public GameEveItemCategoryFindByCodeReqDTransfer validate() {
        validateCode();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenTransferValidateException("游戏EVE物品分类编码不能为空");
        }
    }
}
