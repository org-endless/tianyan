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
 * GameEveItemGroupFindByCodeReqQTransfer
 * <p>游戏EVE资源项分组根据编码查询请求传输对象
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
@JSONType(orders = {"gameEveItemGroupCode"})
public class GameEveItemGroupFindByCodeReqQTransfer implements TianyanItemQueryTransfer {

    /**
     * 游戏EVE资源项分组编码
     */
    private final String gameEveItemGroupCode;

    @Override
    public GameEveItemGroupFindByCodeReqQTransfer validate() {
        validateGameEveItemGroupCode();
        return this;
    }

    private void validateGameEveItemGroupCode() {
        if (!StringUtils.hasText(gameEveItemGroupCode)) {
            throw new QueryTransferValidateException("游戏EVE资源项分组编码不能为空");
        }
    }
}
