package org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer;

import org.endless.tianyan.item.common.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.query.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GameEveItemCategoryFindIdRespQTransfer
 * <p>游戏EVE资源项分类ID查询响应传输对象
 * <p>
 * create 2025/07/26 05:25
 * <p>
 * update 2025/07/26 05:25
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemCategoryId"})
public class GameEveItemCategoryFindIdRespQTransfer implements TianyanItemQueryTransfer {

    /**
     * 资源项分类ID
     */
    private final String itemCategoryId;

    @Override
    public GameEveItemCategoryFindIdRespQTransfer validate() {
        validateItemCategoryId();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new QueryTransferValidateException("资源项分类ID不能为空");
        }
    }
}
