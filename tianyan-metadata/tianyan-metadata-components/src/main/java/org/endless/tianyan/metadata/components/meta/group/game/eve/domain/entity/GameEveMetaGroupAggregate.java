package org.endless.tianyan.metadata.components.meta.group.game.eve.domain.entity;

import org.endless.tianyan.metadata.common.model.domain.entity.*;
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
 * GameEveMetaGroupAggregate
 * <p>游戏EVE元分组聚合根
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveMetaGroupAggregate implements TianyanMetadataAggregate {

    /**
     * 游戏EVE元分组ID
     */
    private final String gameEveMetaGroupId;

    /**
     * 元分组ID
     */
    private String metaGroupId;

    /**
     * 游戏EVE元分组编码
     */
    private String code;

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

    public static GameEveMetaGroupAggregate create(GameEveMetaGroupAggregateBuilder builder) {
        return builder
                .gameEveMetaGroupId(IdGenerator.of())
                .metaGroupId(builder.metaGroupId)
                .code(builder.code)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public GameEveMetaGroupAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE元分组聚合根>不能再次删除, ID: " + gameEveMetaGroupId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE元分组聚合根>处于不可删除状态, ID: " + gameEveMetaGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveMetaGroupAggregate validate() {
        validateGameEveMetaGroupId();
        validateMetaGroupId();
        validateCode();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveMetaGroupId() {
        if (!StringUtils.hasText(gameEveMetaGroupId)) {
            throw new AggregateValidateException("游戏EVE元分组ID不能为空");
        }
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new AggregateValidateException("元分组ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE元分组编码不能为空");
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
