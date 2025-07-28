package org.endless.tianyan.item.components.item.game.eve.application.query.transfer;

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
 * GameEveItemFindItemIdsRespQTransfer
 * <p>游戏EVE资源项ID列表查询响应传输对象
 * <p>
 * create 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemIds"})
public class GameEveItemFindItemIdsRespQTransfer implements TianyanItemQueryTransfer {

    /**
     * 资源项ID列表
     */
    private final List<String> itemIds;

    @Override
    public GameEveItemFindItemIdsRespQTransfer validate() {
        validateItemIds();
        return this;
    }

    private void validateItemIds() {
        if (CollectionUtils.isEmpty(itemIds)) {
            throw new QueryTransferValidateException("资源项ID列表不能为空");
        }
    }
}
