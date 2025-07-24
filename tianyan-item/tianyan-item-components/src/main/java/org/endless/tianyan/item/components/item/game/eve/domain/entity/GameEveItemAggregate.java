package org.endless.tianyan.item.components.item.game.eve.domain.entity;

import org.endless.tianyan.item.common.model.domain.entity.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * GameEveItemAggregate
 * <p>游戏EVE资源项聚合根
 * <p>
 * create 2025/07/24 16:27
 * <p>
 * update 2025/07/24 16:27
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveItemAggregate implements TianyanItemAggregate {

    /**
     * 游戏EVE资源项ID
     */
    private final String gameEveItemId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 游戏EVE资源项编码
     */
    private String code;

    /**
     * 游戏EVE资源项是否发布
     */
    private Boolean isPublished;

    /**
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static GameEveItemAggregate create(GameEveItemAggregateBuilder builder) {
        return builder
                .gameEveItemId(IdGenerator.of())
                .itemId(builder.itemId)
                .code(builder.code)
                .isPublished(builder.isPublished)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public GameEveItemAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE资源项聚合根>不能再次删除, ID: " + gameEveItemId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE资源项聚合根>处于不可删除状态, ID: " + gameEveItemId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveItemAggregate validate() {
        validateGameEveItemId();
        validateItemId();
        validateCode();
        validateIsPublished();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveItemId() {
        if (!StringUtils.hasText(gameEveItemId)) {
            throw new AggregateValidateException("游戏EVE资源项ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new AggregateValidateException("游戏EVE资源项是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}
