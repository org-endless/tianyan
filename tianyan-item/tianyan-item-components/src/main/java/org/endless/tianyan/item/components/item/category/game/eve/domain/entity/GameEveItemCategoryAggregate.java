package org.endless.tianyan.item.components.item.category.game.eve.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateRemoveException;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.AggregateValidateException;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryAggregate
 * <p>游戏EVE资源项分类聚合根
 * <p>
 * create 2025/07/20 22:44
 * <p>
 * update 2025/07/20 22:44
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveItemCategoryAggregate implements TianyanItemAggregate {

    /**
     * 游戏EVE资源项分类ID
     */
    private final String gameEveItemCategoryId;

    /**
     * 资源项分类ID
     */
    private String itemCategoryId;

    /**
     * 游戏EVE资源项分类编码
     */
    private String code;

    /**
     * 游戏EVE资源项分类是否发布
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

    public static GameEveItemCategoryAggregate create(GameEveItemCategoryAggregateBuilder builder) {
        return builder
                .gameEveItemCategoryId(IdGenerator.of())
                .itemCategoryId(builder.itemCategoryId)
                .code(builder.code)
                .isPublished(builder.isPublished)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public GameEveItemCategoryAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE资源项分类聚合根>不能再次删除, ID: " + gameEveItemCategoryId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE资源项分类聚合根>处于不可删除状态, ID: " + gameEveItemCategoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveItemCategoryAggregate validate() {
        validateGameEveItemCategoryId();
        validateItemCategoryId();
        validateCode();
        validateIsPublished();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new AggregateValidateException("游戏EVE资源项分类ID不能为空");
        }
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new AggregateValidateException("资源项分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE资源项分类编码不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new AggregateValidateException("游戏EVE资源项分类是否发布不能为 null ");
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
