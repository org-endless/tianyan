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
 * GameEveItemGroupCreateReqDTransfer
 * <p>游戏EVE资源项分组创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 17:12
 * <p>
 * update 2025/07/24 17:12
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "gameEveItemCategoryId", "nameZh", "nameEn", "isPublished", "isUseBasePrice", "createUserId"})
public class GameEveItemGroupCreateReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE资源项分组编码
     */
    private final String code;

    /**
     * 游戏EVE资源项分类ID
     */
    private final String gameEveItemCategoryId;

    /**
     * 游戏EVE资源项分组中文名称
     */
    private final String nameZh;

    /**
     * 游戏EVE资源项分组英文名称
     */
    private final String nameEn;

    /**
     * 游戏EVE资源项分组是否发布
     */
    private final Boolean isPublished;

    /**
     * 游戏EVE资源项分组是否使用基准价格
     */
    private final Boolean isUseBasePrice;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveItemGroupCreateReqDTransfer validate() {
        validateCode();
        validateGameEveItemCategoryId();
        validateNameZh();
        validateNameEn();
        validateIsPublished();
        validateIsUseBasePrice();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenTransferValidateException("游戏EVE资源项分组编码不能为空");
        }
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new DrivenTransferValidateException("游戏EVE资源项分类ID不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new DrivenTransferValidateException("游戏EVE资源项分组中文名称不能为空");
        }
    }

    private void validateNameEn() {
        if (!StringUtils.hasText(nameEn)) {
            throw new DrivenTransferValidateException("游戏EVE资源项分组英文名称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DrivenTransferValidateException("游戏EVE资源项分组是否发布不能为 null ");
        }
    }

    private void validateIsUseBasePrice() {
        if (isUseBasePrice == null) {
            throw new DrivenTransferValidateException("游戏EVE资源项分组是否使用基准价格不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenTransferValidateException("创建用户ID不能为空");
        }
    }
}
