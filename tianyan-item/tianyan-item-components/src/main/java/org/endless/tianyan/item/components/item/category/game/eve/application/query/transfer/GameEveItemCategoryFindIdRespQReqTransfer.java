package org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryRespTransferValidateException;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryFindIdRespQReqTransfer
 * <p>游戏EVE资源项分类ID查询响应传输对象
 * <p>
 * itemCreate 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemCategoryId"})
public class GameEveItemCategoryFindIdRespQReqTransfer implements TianyanItemQueryReqTransfer {

    /**
     * 资源项分类ID
     */
    private final String itemCategoryId;

    @Override
    public GameEveItemCategoryFindIdRespQReqTransfer validate() {
        validateItemCategoryId();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new QueryRespTransferValidateException("资源项分类ID不能为空");
        }
    }
}
