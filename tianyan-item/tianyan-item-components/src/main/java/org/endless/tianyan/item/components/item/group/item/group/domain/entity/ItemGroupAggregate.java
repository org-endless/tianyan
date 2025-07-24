package org.endless.tianyan.item.components.item.group.item.group.domain.entity;

import org.endless.tianyan.item.common.model.domain.entity.*;
import org.endless.tianyan.item.components.item.group.item.group.domain.value.*;
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
 * ItemGroupAggregate
 * <p>资源项分组聚合根
 * <p>
 * create 2025/07/24 20:23
 * <p>
 * update 2025/07/24 20:23
 *
 * @author Deng Haozhi
 * @see TianyanItemAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class ItemGroupAggregate implements TianyanItemAggregate {

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    /**
     * 资源项分组中文名称
     */
    private NameValue nameZh;

    /**
     * 资源项分组英文名称
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

    public static ItemGroupAggregate create(ItemGroupAggregateBuilder builder) {
        return builder
                .itemGroupId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public ItemGroupAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<资源项分组聚合根>不能再次删除, ID: " + itemGroupId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<资源项分组聚合根>处于不可删除状态, ID: " + itemGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public ItemGroupAggregate validate() {
        validateItemGroupId();
        validateNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new AggregateValidateException("资源项分组ID不能为空");
        }
    }

    private void validateNameZh() {
        if (nameZh == null) {
            throw new AggregateValidateException("资源项分组中文名称不能为 null ");
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
