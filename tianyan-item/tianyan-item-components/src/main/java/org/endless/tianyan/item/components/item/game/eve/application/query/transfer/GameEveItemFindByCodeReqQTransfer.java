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
 * GameEveItemFindByCodeReqQTransfer
 * <p>游戏EVE根据编码查询请求传输对象
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
@JSONType(orders = {"gameEveItemCode"})
public class GameEveItemFindByCodeReqQTransfer implements TianyanItemQueryTransfer {

    /**
     * 游戏EVE资源项编码
     */
    private final String gameEveItemCode;

    @Override
    public GameEveItemFindByCodeReqQTransfer validate() {
        validateGameEveItemCode();
        return this;
    }

    private void validateGameEveItemCode() {
        if (!StringUtils.hasText(gameEveItemCode)) {
            throw new QueryTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }
}
