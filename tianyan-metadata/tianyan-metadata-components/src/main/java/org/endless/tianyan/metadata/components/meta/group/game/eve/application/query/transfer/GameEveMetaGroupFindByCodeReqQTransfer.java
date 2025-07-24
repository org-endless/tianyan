package org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer;

import org.endless.tianyan.metadata.common.model.application.query.transfer.*;
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
 * GameEveMetaGroupFindByCodeReqQTransfer
 * <p>游戏EVE元分组根据编码查询请求传输对象
 * <p>
 * create 2025/07/24 16:17
 * <p>
 * update 2025/07/24 16:17
 *
 * @author Deng Haozhi
 * @see TianyanMetadataQueryTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code"})
public class GameEveMetaGroupFindByCodeReqQTransfer implements TianyanMetadataQueryTransfer {

    /**
     * 游戏EVE元分组编码
     */
    private final String code;

    @Override
    public GameEveMetaGroupFindByCodeReqQTransfer validate() {
        validateCode();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new QueryTransferValidateException("游戏EVE元分组编码不能为空");
        }
    }
}
