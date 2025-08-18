package org.endless.tianyan.item.components.item.category.item.category.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;
import org.endless.tianyan.item.components.item.category.item.category.domain.value.NameValue;
import org.springframework.util.StringUtils;

/**
 * ItemCategoryAggregate
 * <p>资源项分类聚合根
 * <p>
 * create 2025/07/24 20:16
 * <p>
 * update 2025/07/24 20:16
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ItemCategoryAggregate implements TianyanItemAggregate {

    /**
     * 资源项分类ID
     */
    private final String itemCategoryId;

    /**
     * 中文名称
     */
    private NameValue nameZh;

    /**
     * 英文名称
     */
    private NameValue nameEn;

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

    public static ItemCategoryAggregate create(ItemCategoryAggregateBuilder builder) {
        return builder
                .itemCategoryId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public ItemCategoryAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<资源项分类聚合根>不能再次删除, ID: " + itemCategoryId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<资源项分类聚合根>处于不可删除状态, ID: " + itemCategoryId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ItemCategoryAggregate validate() {
        validateItemCategoryId();
        validateNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new AggregateValidateException("资源项分类ID不能为空");
        }
    }

    private void validateNameZh() {
        if (nameZh == null) {
            throw new AggregateValidateException("中文名称不能为 null ");
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
