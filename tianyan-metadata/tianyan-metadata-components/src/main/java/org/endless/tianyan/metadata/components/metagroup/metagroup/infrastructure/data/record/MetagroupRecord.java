package org.endless.tianyan.metadata.components.metagroup.metagroup.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.endless.ddd.starter.common.annotation.validate.ddd.DataRecord;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.entity.MetagroupAggregate;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.value.NameValue;

/**
 * MetagroupRecord
 * <p>元分组数据库记录实体
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@DataRecord
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "metagroup")
public class MetagroupRecord implements TianyanMetadataRecord<MetagroupAggregate> {

    /**
     * 元分组ID
     */
    @TableId
    @NotBlank(message = "元分组ID不能为空")
    private String metagroupId;

    /**
     * 元分组中文全称
     */
    @NotBlank(message = "元分组中文全称不能为空")
    private String nameZhFullName;

    /**
     * 元分组中文别名
     */
    private String nameZhAlias;

    /**
     * 元分组中文简称
     */
    private String nameZhAbbreviation;

    /**
     * 元分组英文全称
     */
    private String nameEnFullName;

    /**
     * 元分组英文别名
     */
    private String nameEnAlias;

    /**
     * 元分组英文简称
     */
    private String nameEnAbbreviation;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private String createUserId;

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

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    /**
     * 删除时间
     */
    private Long removeAt;

    @NotNull(message = "元分组数据记录实体不能为空")
    public static @Valid MetagroupRecord from(
            @NotNull(message = "元分组聚合根不能为空")
            @Valid MetagroupAggregate aggregate) {
        return MetagroupRecord.builder()
                .metagroupId(aggregate.getMetagroupId())
                .nameZhFullName(aggregate.getNameZh().fullName())
                .nameZhAlias(aggregate.getNameZh().alias())
                .nameZhAbbreviation(aggregate.getNameZh().abbreviation())
                .nameEnFullName(aggregate.getNameEn() == null ? null : aggregate.getNameEn().fullName())
                .nameEnAlias(aggregate.getNameEn() == null ? null : aggregate.getNameEn().alias())
                .nameEnAbbreviation(aggregate.getNameEn() == null ? null : aggregate.getNameEn().abbreviation())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    @NotNull(message = "元分组聚合根不能为空")
    public MetagroupAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return MetagroupAggregate.builder()
                .metagroupId(metagroupId)
                .nameZh(NameValue.builder()
                        .fullName(nameZhFullName)
                        .alias(nameZhAlias)
                        .abbreviation(nameZhAbbreviation)
                        .innerBuild())
                .nameEn(NameValue.builder()
                        .fullName(nameEnFullName)
                        .alias(nameEnAlias)
                        .abbreviation(nameEnAbbreviation)
                        .innerBuild())
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MetagroupRecord validate() {
        return this;
    }
}
