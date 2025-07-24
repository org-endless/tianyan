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
 * GameEveItemCategoryFindByCodeReqQTransfer
 * <p>游戏EVE资源项分类根据编码查询请求传输对象
 * <p>
 * create 2025/07/24 20:18
 * <p>
 * update 2025/07/24 20:18
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code"})
public class GameEveItemCategoryFindByCodeReqQTransfer implements TianyanItemQueryTransfer {

    /**
     * 游戏EVE资源项分类编码
     */
    private final String code;

    @Override
    public GameEveItemCategoryFindByCodeReqQTransfer validate() {
        validateCode();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new QueryTransferValidateException("游戏EVE资源项分类编码不能为空");
        }
    }
}
