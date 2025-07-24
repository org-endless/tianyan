package org.endless.tianyan.item.components.item.item.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.endless.ddd.simplified.starter.common.model.domain.type.MassUnitEnum;
import org.endless.ddd.simplified.starter.common.model.domain.type.VolumeUnitEnum;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;
import org.endless.tianyan.item.components.item.item.domain.entity.ItemAggregate;
import org.endless.tianyan.item.components.item.item.domain.value.MassValue;
import org.endless.tianyan.item.components.item.item.domain.value.NameValue;
import org.endless.tianyan.item.components.item.item.domain.value.VolumeValue;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * ItemRecord
 * <p>资源项数据库记录实体
 * <p>
 * create 2025/07/24 16:27
 * <p>
 * update 2025/07/24 16:27
 *
 * @author Deng Haozhi
 * @see TianyanItemRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "item")
public class ItemRecord implements TianyanItemRecord<ItemAggregate> {

    /**
     * 资源项ID
     */
    @TableId
    private String itemId;

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
     * 质量数量是否科学计数
     */
    private Boolean massIsScientific;

    /**
     * 质量数量(20, 5)
     */
    private BigDecimal massQuantity;

    /**
     * 质量数量科学计数
     */
    private String massScientific;

    /**
     * 质量单位
     */
    private MassUnitEnum massUnit;

    /**
     * 体积数量是否科学计数
     */
    private Boolean volumeIsScientific;

    /**
     * 体积数量(20, 5)
     */
    private BigDecimal volumeQuantity;

    /**
     * 体积数量科学计数
     */
    private String volumeScientific;

    /**
     * 体积单位
     */
    private VolumeUnitEnum volumeUnit;

    /**
     * 描述
     */
    private String description;

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

    public static ItemRecord from(ItemAggregate aggregate) {
        String itemId = aggregate.getItemId();
        return ItemRecord.builder()
                .itemId(itemId)
                .metaGroupId(aggregate.getMetaGroupId())
                .itemGroupId(aggregate.getItemGroupId())
                .marketGroupId(aggregate.getMarketGroupId())
                .nameZhFullName(aggregate.getNameZh().getFullName())
                .nameZhAlias(aggregate.getNameZh().getAlias())
                .nameZhAbbreviation(aggregate.getNameZh().getAbbreviation())
                .nameEnFullName(aggregate.getNameEn() == null ? null : aggregate.getNameEn().getFullName())
                .nameEnAlias(aggregate.getNameEn() == null ? null : aggregate.getNameEn().getAlias())
                .nameEnAbbreviation(aggregate.getNameEn() == null ? null : aggregate.getNameEn().getAbbreviation())
                .massIsScientific(aggregate.getMass() == null ? null : aggregate.getMass().getIsScientific())
                .massQuantity(aggregate.getMass() == null ? null : aggregate.getMass().getQuantity())
                .massScientific(aggregate.getMass() == null ? null : aggregate.getMass().getScientific())
                .massUnit(aggregate.getMass() == null ? null : aggregate.getMass().getUnit())
                .volumeIsScientific(aggregate.getVolume() == null ? null : aggregate.getVolume().getIsScientific())
                .volumeQuantity(aggregate.getVolume() == null ? null : aggregate.getVolume().getQuantity())
                .volumeScientific(aggregate.getVolume() == null ? null : aggregate.getVolume().getScientific())
                .volumeUnit(aggregate.getVolume() == null ? null : aggregate.getVolume().getUnit())
                .description(aggregate.getDescription())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public ItemAggregate to() {
        validate();
        return ItemAggregate.builder()
                .itemId(itemId)
                .metaGroupId(metaGroupId)
                .itemGroupId(itemGroupId)
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
                .mass(MassValue.builder()
                        .isScientific(massIsScientific)
                        .quantity(massQuantity)
                        .scientific(massScientific)
                        .unit(massUnit)
                        .innerBuild())
                .volume(VolumeValue.builder()
                        .isScientific(volumeIsScientific)
                        .quantity(volumeQuantity)
                        .scientific(volumeScientific)
                        .unit(volumeUnit)
                        .innerBuild())
                .description(description)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public ItemRecord validate() {
        validateItemId();
        validateMetaGroupId();
        validateItemGroupId();
        validateNameZhFullName();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new DataRecordValidateException("元分组ID不能为空");
        }
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new DataRecordValidateException("资源项分组ID不能为空");
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
