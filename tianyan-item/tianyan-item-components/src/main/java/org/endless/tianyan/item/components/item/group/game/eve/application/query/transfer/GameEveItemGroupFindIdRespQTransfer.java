package org.endless.tianyan.item.components.item.group.game.eve.application.query.transfer;

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
 * GameEveItemGroupFindIdRespQTransfer
 * <p>游戏EVE资源项分组ID查询响应传输对象
 * <p>
 * create 2025/07/23 00:42
 * <p>
 * update 2025/07/23 00:42
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemGroupId"})
public class GameEveItemGroupFindIdRespQTransfer implements TianyanItemQueryTransfer {

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    @Override
    public GameEveItemGroupFindIdRespQTransfer validate() {
        validateItemGroupId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new QueryTransferValidateException("资源项分组ID不能为空");
        }
    }
}
