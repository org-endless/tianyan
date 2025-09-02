package org.endless.tianyan.metadata.components.metagroup.metagroup.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.value.NameValue;
import org.springframework.validation.annotation.Validated;

/**
 * MetagroupAggregate
 * <p>元分组聚合
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
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class MetagroupAggregate implements TianyanMetadataAggregate {

    /**
     * 元分组ID
     */
    @NotBlank(message = "元分组ID不能为空")
    private final String metagroupId;

    /**
     * 中文名称
     */
    @NotNull(message = "中文名称不能为空")
    private @Valid NameValue nameZh;

    /**
     * 英文名称
     */
    @NotNull(message = "英文名称不能为空")
    private NameValue nameEn;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private final String createUserId;

    /**
     * 修改用户ID
     */
    @NotBlank(message = "修改用户ID不能为空")
    private String modifyUserId;

    /**
     * 是否已删除
     */
    @NotNull(message = "是否已删除不能为空")
    private Boolean isRemoved;

    @NotNull(message = "元分组聚合根创建方法返回对象不能为空")
    public static @Valid MetagroupAggregate create(
            @NotNull(message = "元分组聚合根构造器不能为空") MetagroupAggregateBuilder builder) {
        return Entity.create(builder, MetagroupAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "元分组聚合根根删除方法返回对象不能为空")
    public MetagroupAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的元分组聚合根不能再次删除, ID: " + metagroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public MetagroupAggregate validate() {
        return this;
    }
}
