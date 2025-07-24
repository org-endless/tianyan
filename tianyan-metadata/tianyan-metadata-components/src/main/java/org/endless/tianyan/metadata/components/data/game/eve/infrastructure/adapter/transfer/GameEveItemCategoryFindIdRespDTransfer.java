package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.*;
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
 * GameEveItemCategoryFindIdRespDTransfer
 * <p>游戏EVE资源项分类ID查询被动响应传输对象
 * <p>
 * create 2025/07/24 11:50
 * <p>
 * update 2025/07/24 11:50
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCategoryId"})
public class GameEveItemCategoryFindIdRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE资源项分类ID
     */
    private final String gameEveItemCategoryId;

    @Override
    public GameEveItemCategoryFindIdRespDTransfer validate() {
        validateGameEveItemCategoryId();
        return this;
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new DrivenTransferValidateException("游戏EVE资源项分类ID不能为空");
        }
    }
}
