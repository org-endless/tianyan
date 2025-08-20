package org.endless.tianyan.item.components.item.group.game.eve.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;
import org.springframework.util.StringUtils;

/**
 * GameEveItemGroupAggregate
 * <p>游戏EVE资源项分组聚合根
 * <p>
 * itemCreate 2025/07/24 20:20
 * <p>
 * update 2025/07/24 20:20
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveItemGroupAggregate implements TianyanItemAggregate {

    /**
     * 游戏EVE资源项分组ID
     */
    private final String gameEveItemGroupId;

    /**
     * 资源项分组ID
     */
    private String itemGroupId;

    /**
     * 资源项分类ID
     */
    private String itemCategoryId;

    /**
     * 游戏EVE资源项分组编码
     */
    private String code;

    /**
     * 游戏EVE资源项分组是否发布
     */
    private Boolean isPublished;

    /**
     * 游戏EVE资源项分组是否使用基准价格
     */
    private Boolean isUseBasePrice;

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

    public static GameEveItemGroupAggregate create(GameEveItemGroupAggregateBuilder builder) {
        return builder
                .gameEveItemGroupId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public GameEveItemGroupAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE资源项分组聚合根>不能再次删除, ID: " + gameEveItemGroupId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE资源项分组聚合根>处于不可删除状态, ID: " + gameEveItemGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveItemGroupAggregate validate() {
        validateGameEveItemGroupId();
        validateItemGroupId();
        validateItemCategoryId();
        validateCode();
        validateIsPublished();
        validateIsUseBasePrice();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveItemGroupId() {
        if (!StringUtils.hasText(gameEveItemGroupId)) {
            throw new AggregateValidateException("游戏EVE资源项分组ID不能为空");
        }
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new AggregateValidateException("资源项分组ID不能为空");
        }
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new AggregateValidateException("资源项分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE资源项分组编码不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new AggregateValidateException("游戏EVE资源项分组是否发布不能为 null ");
        }
    }

    private void validateIsUseBasePrice() {
        if (isUseBasePrice == null) {
            throw new AggregateValidateException("游戏EVE资源项分组是否使用基准价格不能为 null ");
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
