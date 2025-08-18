package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryFindByCodeReqDTransfer
 * <p>游戏EVE资源项分类根据编码查询被动请求传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCategoryCode"})
public class GameEveItemCategoryFindByCodeReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE资源项分类编码
     */
    private final String gameEveItemCategoryCode;

    @Override
    public GameEveItemCategoryFindByCodeReqDTransfer validate() {
        validateGameEveItemCategoryCode();
        return this;
    }

    private void validateGameEveItemCategoryCode() {
        if (!StringUtils.hasText(gameEveItemCategoryCode)) {
            throw new DrivenReqTransferValidateException("游戏EVE资源项分类编码不能为空");
        }
    }
}
