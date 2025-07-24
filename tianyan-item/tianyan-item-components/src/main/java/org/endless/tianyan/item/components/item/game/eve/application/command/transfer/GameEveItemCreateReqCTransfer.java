package org.endless.tianyan.item.components.item.game.eve.application.command.transfer;

import org.endless.tianyan.item.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
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
 * GameEveItemCreateReqCTransfer
 * <p>游戏EVE资源项创建命令请求传输对象
 * <p>
 * create 2025/07/24 16:47
 * <p>
 * update 2025/07/24 16:47
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "metaGroupId", "itemGroupId", "marketGroupId", "fullNameZh", "fullNameEn", "massQuantity", "massUnit", "volumeQuantity", "volumeUnit", "description", "isPublished", "createUserId"})
public class GameEveItemCreateReqCTransfer implements TianyanItemCommandTransfer {

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
     * 中文全称
     */
    private final String fullNameZh;

    /**
     * 英文全称
     */
    private final String fullNameEn;

    /**
     * 质量数量
     */
    private final String massQuantity;

    /**
     * 质量单位
     */
    private final String massUnit;

    /**
     * 体积数量
     */
    private final String volumeQuantity;

    /**
     * 体积单位
     */
    private final String volumeUnit;

    /**
     * 描述
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
    public GameEveItemCreateReqCTransfer validate() {
        validateCode();
        validateItemGroupId();
        validateFullNameZh();
        validateIsPublished();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new CommandTransferValidateException("资源项分组ID不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandTransferValidateException("中文全称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new CommandTransferValidateException("游戏EVE资源项是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
