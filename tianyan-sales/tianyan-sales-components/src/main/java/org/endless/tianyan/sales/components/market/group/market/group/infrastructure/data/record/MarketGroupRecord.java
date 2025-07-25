package org.endless.tianyan.sales.components.market.group.market.group.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.data.record.TianyanSalesRecord;
import org.endless.tianyan.sales.components.market.group.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.market.group.domain.value.NameValue;
import org.springframework.util.StringUtils;

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
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "market_group")
public class MarketGroupRecord implements TianyanSalesRecord<MarketGroupAggregate> {

    /**
     * 市场分组ID
     */
    @TableId
    private String marketGroupId;

    /**
     * 全称
     */
    private String nameZhFullName;

    /**
     * 别名
     */
    private String nameZhAlias;

    /**
     * 简称
     */
    private String nameZhAbbreviation;

    /**
     * 全称
     */
    private String nameEnFullName;

    /**
     * 别名
     */
    private String nameEnAlias;

    /**
     * 简称
     */
    private String nameEnAbbreviation;

    /**
     * 父市场分组ID
     */
    private String parentId;

    /**
     * 创建者ID
     */
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
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

    public static MarketGroupRecord from(MarketGroupAggregate aggregate) {
        String marketGroupId = aggregate.getMarketGroupId();
        return MarketGroupRecord.builder()
                .marketGroupId(marketGroupId)
                .nameZhFullName(aggregate.getNameZh().getFullName())
                .nameZhAlias(aggregate.getNameZh().getAlias())
                .nameZhAbbreviation(aggregate.getNameZh().getAbbreviation())
                .nameEnFullName(aggregate.getNameEn() == null ? null : aggregate.getNameEn().getFullName())
                .nameEnAlias(aggregate.getNameEn() == null ? null : aggregate.getNameEn().getAlias())
                .nameEnAbbreviation(aggregate.getNameEn() == null ? null : aggregate.getNameEn().getAbbreviation())
                .parentId(aggregate.getParentId())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public MarketGroupAggregate to() {
        validate();
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
        validateMarketGroupId();
        validateNameZhFullName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new DataRecordValidateException("市场分组ID不能为空");
        }
    }

    private void validateNameZhFullName() {
        if (!StringUtils.hasText(nameZhFullName)) {
            throw new DataRecordValidateException("全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}
