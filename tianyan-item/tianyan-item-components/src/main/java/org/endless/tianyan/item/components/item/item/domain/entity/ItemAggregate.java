package org.endless.tianyan.item.components.item.item.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;
import org.endless.tianyan.item.components.item.item.domain.value.NameValue;
import org.springframework.util.StringUtils;

/**
 * ItemAggregate
 * <p>资源项聚合根
 * <p>
 * create 2025/07/24 20:01
 * <p>
 * update 2025/07/24 20:01
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ItemAggregate implements TianyanItemAggregate {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 元分组ID
     */
    private String metaGroupId;

    /**
     * 资源项分组ID
     */
    private String itemGroupId;

    /**
     * 市场分组ID
     */
    private String marketGroupId;

    /**
     * 中文名称
     */
    private NameValue nameZh;

    /**
     * 英文名称
     */
    private NameValue nameEn;

    /**
     * 资源项描述
     */
    private String description;

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

    public static ItemAggregate create(ItemAggregateBuilder builder) {
        return builder
                .itemId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public ItemAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<资源项聚合根>不能再次删除, ID: " + itemId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<资源项聚合根>处于不可删除状态, ID: " + itemId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ItemAggregate validate() {
        validateItemId();
        validateItemGroupId();
        validateNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("资源项ID不能为空");
        }
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new AggregateValidateException("资源项分组ID不能为空");
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
