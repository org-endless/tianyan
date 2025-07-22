package org.endless.tianyan.item.components.item.item.domain.entity;

import org.endless.tianyan.item.common.model.domain.entity.*;
import org.endless.tianyan.item.components.item.item.domain.value.*;
import org.endless.tianyan.item.components.item.item.domain.type.*;
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
 * ItemAggregate
 * <p>物品聚合根
 * <p>
 * create 2025/07/21 15:37
 * <p>
 * update 2025/07/21 15:37
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
     * 物品ID
     */
    private final String itemId;

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

    public static ItemAggregate create(ItemAggregateBuilder builder) {
        return builder
                .itemId(IdGenerator.of())
                .nameZh(builder.nameZh)
                .nameEn(builder.nameEn)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public ItemAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<物品聚合根>不能再次删除, ID: " + itemId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<物品聚合根>处于不可删除状态, ID: " + itemId);
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
        validateNameZh();
        validateNameEn();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new AggregateValidateException("物品ID不能为空");
        }
    }

    private void validateNameZh() {
        if (nameZh == null) {
            throw new AggregateValidateException("中文名称不能为 null ");
        }
    }

    private void validateNameEn() {
        if (nameEn == null) {
            throw new AggregateValidateException("英文名称不能为 null ");
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
