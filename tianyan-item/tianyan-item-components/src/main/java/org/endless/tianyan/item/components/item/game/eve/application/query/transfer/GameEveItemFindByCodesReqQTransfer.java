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
 * GameEveItemFindByCodesReqQTransfer
 * <p>游戏EVE资源项根据编码列表查询请求传输对象
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
@JSONType(orders = {"gameEveItemCodes"})
public class GameEveItemFindByCodesReqQTransfer implements TianyanItemQueryTransfer {

    /**
     * 游戏EVE资源项编码列表
     */
    private final List<String> gameEveItemCodes;

    @Override
    public GameEveItemFindByCodesReqQTransfer validate() {
        validateGameEveItemCodes();
        return this;
    }

    private void validateGameEveItemCodes() {
        if (CollectionUtils.isEmpty(gameEveItemCodes)) {
            throw new QueryTransferValidateException("游戏EVE资源项编码列表不能为空");
        }
    }
}
