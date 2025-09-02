package org.endless.tianyan.sales.components.market.group.infrastructure.data.record;

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
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.domain.value.NameValue;
import org.springframework.validation.annotation.Validated;

/**
 * MarketGroupRecord
 * <p>市场分组数据库记录实体
 * <p>
 * create 2025/07/24 20:31
 * <p>
 * update 2025/07/24 20:31
 *
 * @author Deng Haozhi
 * @see TianyanSalesRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "market_group")
public class MarketGroupRecord implements TianyanSalesRecord<MarketGroupAggregate> {

    /**
     * 市场分组ID
     */
    @TableId
    @NotBlank(message = "市场分组ID不能为空")
    private String marketGroupId;

    /**
     * 市场分组中文全称
     */
    @NotBlank(message = "市场分组中文全称不能为空")
    private String nameZhFullName;

    /**
     * 市场分组中文别名
     */
    private String nameZhAlias;

    /**
     * 市场分组中文简称
     */
    private String nameZhAbbreviation;

    /**
     * 市场分组英文全称
     */
    private String nameEnFullName;

    /**
     * 市场分组英文别名
     */
    private String nameEnAlias;

    /**
     * 市场分组英文简称
     */
    private String nameEnAbbreviation;

    /**
     * 父市场分组ID
     */
    private String parentId;

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

    @NotNull(message = "市场分组数据记录实体不能为空")
    public static @Valid MarketGroupRecord from(
            @NotNull(message = "市场分组聚合根不能为空")
            @Valid MarketGroupAggregate aggregate) {
        return MarketGroupRecord.builder()
                .marketGroupId(aggregate.getMarketGroupId())
                .nameZhFullName(aggregate.getNameZh().fullName())
                .nameZhAlias(aggregate.getNameZh().alias())
                .nameZhAbbreviation(aggregate.getNameZh().abbreviation())
                .nameEnFullName(aggregate.getNameEn() == null ? null : aggregate.getNameEn().fullName())
                .nameEnAlias(aggregate.getNameEn() == null ? null : aggregate.getNameEn().alias())
                .nameEnAbbreviation(aggregate.getNameEn() == null ? null : aggregate.getNameEn().abbreviation())
                .parentId(aggregate.getParentId())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    @NotNull(message = "市场分组聚合根不能为空")
    public MarketGroupAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return MarketGroupAggregate.builder()
                .marketGroupId(marketGroupId)
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
                .parentId(parentId)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public MarketGroupRecord validate() {
        return this;
    }
}
