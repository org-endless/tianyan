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
 * GameEveMetaGroupFindMetaGroupIdRespQTransfer
 * <p>游戏EVE元分组ID查询响应传输对象
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
@JSONType(orders = {"metaGroupId"})
public class GameEveMetaGroupFindMetaGroupIdRespQTransfer implements TianyanMetadataQueryTransfer {

    /**
     * 元分组ID
     */
    private final String metaGroupId;

    @Override
    public GameEveMetaGroupFindMetaGroupIdRespQTransfer validate() {
        validateMetaGroupId();
        return this;
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new QueryTransferValidateException("元分组ID不能为空");
        }
    }
}
