package org.endless.tianyan.metadata.components.meta.group.meta.group.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateValidateException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.value.NameValue;
import org.springframework.util.StringUtils;

/**
 * MetaGroupAggregate
 * <p>元分组聚合根
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
public class MetaGroupAggregate implements TianyanMetadataAggregate {

    /**
     * 元分组ID
     */
    private final String metaGroupId;

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

    public static MetaGroupAggregate create(MetaGroupAggregateBuilder builder) {
        return builder
                .metaGroupId(IdGenerator.of())
                .nameZh(builder.nameZh)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public MetaGroupAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<元分组聚合根>不能再次删除, ID: " + metaGroupId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<元分组聚合根>处于不可删除状态, ID: " + metaGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MetaGroupAggregate validate() {
        validateMetaGroupId();
        validateNameZh();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new AggregateValidateException("元分组ID不能为空");
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
