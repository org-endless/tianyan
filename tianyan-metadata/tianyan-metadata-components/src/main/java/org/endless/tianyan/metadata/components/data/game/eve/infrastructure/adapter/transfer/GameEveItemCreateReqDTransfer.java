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
 * GameEveItemCreateReqDTransfer
 * <p>游戏EVE资源项创建命令被动请求传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "metaGroupId", "itemGroupId", "marketGroupId", "fullNameZh", "fullNameEn", "description", "isPublished", "createUserId"})
public class GameEveItemCreateReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE资源项编码
     */
    private final String code;

    /**
     * 元分组ID
     */
    private final String metaGroupId;

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    /**
     * 市场分组ID
     */
    private final String marketGroupId;

    /**
     * 资源项中文全称
     */
    private final String fullNameZh;

    /**
     * 资源项英文全称
     */
    private final String fullNameEn;

    /**
     * 资源项描述
     */
    private final String description;

    /**
     * 游戏EVE资源项是否发布
     */
    private final Boolean isPublished;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveItemCreateReqDTransfer validate() {
        validateCode();
        validateItemGroupId();
        validateFullNameZh();
        validateIsPublished();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new DrivenTransferValidateException("资源项分组ID不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new DrivenTransferValidateException("资源项中文全称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DrivenTransferValidateException("游戏EVE资源项是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenTransferValidateException("创建用户ID不能为空");
        }
    }
}
