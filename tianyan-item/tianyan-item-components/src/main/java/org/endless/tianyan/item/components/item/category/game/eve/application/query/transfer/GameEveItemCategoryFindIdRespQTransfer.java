package org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.QueryTransferValidateException;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryFindIdRespQTransfer
 * <p>游戏EVE资源项分类ID查询响应传输对象
 * <p>
 * create 2025/07/21 16:10
 * <p>
 * update 2025/07/21 16:10
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCategoryId"})
public class GameEveItemCategoryFindIdRespQTransfer implements TianyanItemQueryTransfer {

    /**
     * 游戏EVE资源项分类ID
     */
    private final String gameEveItemCategoryId;

    @Override
    public GameEveItemCategoryFindIdRespQTransfer validate() {
        validateGameEveItemCategoryId();
        return this;
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new QueryTransferValidateException("游戏EVE资源项分类ID不能为空");
        }
    }
}
