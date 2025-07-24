package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BlueprintRecord
 * <p>蓝图数据库记录实体
 * <p>
 * create 2025/07/24 09:52
 * <p>
 * update 2025/07/24 09:52
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "blueprint")
public class BlueprintRecord implements TianyanManufacturingRecord<BlueprintAggregate> {

    /**
     * 蓝图ID
     */
    @TableId
    private String blueprintId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 蓝图物料列表
     */
    @TableField(exist = false)
    @Builder.Default
    private final List<BlueprintMaterialRecord> materials = new ArrayList<>();

    /**
     * 蓝图产品列表
     */
    @TableField(exist = false)
    @Builder.Default
    private final List<BlueprintProductRecord> products = new ArrayList<>();

    /**
     * 蓝图所需技能列表
     */
    @TableField(exist = false)
    @Builder.Default
    private final List<BlueprintSkillRecord> skills = new ArrayList<>();

    /**
     * 周期
     */
    private Long cycle;

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

    public static BlueprintRecord from(BlueprintAggregate aggregate) {
        String blueprintId = aggregate.getBlueprintId();
        return BlueprintRecord.builder()
                .blueprintId(blueprintId)
                .itemId(aggregate.getItemId())
                .materials(aggregate.getMaterials() == null ? new ArrayList<>() : aggregate.getMaterials().stream()
                        .map(record -> BlueprintMaterialRecord.from(record, blueprintId)).collect(Collectors.toList()))
                .products(aggregate.getProducts() == null ? new ArrayList<>() : aggregate.getProducts().stream()
                        .map(record -> BlueprintProductRecord.from(record, blueprintId)).collect(Collectors.toList()))
                .skills(aggregate.getSkills() == null ? new ArrayList<>() : aggregate.getSkills().stream()
                        .map(record -> BlueprintSkillRecord.from(record, blueprintId)).collect(Collectors.toList()))
                .cycle(aggregate.getCycle())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public BlueprintAggregate to() {
        validate();
        return BlueprintAggregate.builder()
                .blueprintId(blueprintId)
                .itemId(itemId)
                .materials(materials== null? new ArrayList<>() : materials.stream()
                        .map(BlueprintMaterialRecord::to).collect(Collectors.toList()))
                .products(products== null? new ArrayList<>() : products.stream()
                        .map(BlueprintProductRecord::to).collect(Collectors.toList()))
                .skills(skills== null? new ArrayList<>() : skills.stream()
                        .map(BlueprintSkillRecord::to).collect(Collectors.toList()))
                .cycle(cycle)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    public BlueprintRecord addMaterial(BlueprintMaterialRecord material) {
        if (material == null) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体 BlueprintMaterialRecord 不能为 null");
        }
        this.materials.add(material);
        return this;
    }

    public BlueprintRecord addMaterials(List<BlueprintMaterialRecord> materials) {
        if (CollectionUtils.isEmpty(materials)) {
                throw new DataRecordAddItemException("数据库实体要添加的子实体列表 List<BlueprintMaterialRecord> 不能为空");
        }
        this.materials.addAll(materials);
        return this;
    }

    public BlueprintRecord addProduct(BlueprintProductRecord product) {
        if (product == null) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体 BlueprintProductRecord 不能为 null");
        }
        this.products.add(product);
        return this;
    }

    public BlueprintRecord addProducts(List<BlueprintProductRecord> products) {
        if (CollectionUtils.isEmpty(products)) {
                throw new DataRecordAddItemException("数据库实体要添加的子实体列表 List<BlueprintProductRecord> 不能为空");
        }
        this.products.addAll(products);
        return this;
    }

    public BlueprintRecord addSkill(BlueprintSkillRecord skill) {
        if (skill == null) {
            throw new DataRecordAddItemException("数据库实体要添加的子实体 BlueprintSkillRecord 不能为 null");
        }
        this.skills.add(skill);
        return this;
    }

    public BlueprintRecord addSkills(List<BlueprintSkillRecord> skills) {
        if (CollectionUtils.isEmpty(skills)) {
                throw new DataRecordAddItemException("数据库实体要添加的子实体列表 List<BlueprintSkillRecord> 不能为空");
        }
        this.skills.addAll(skills);
        return this;
    }

    @Override
    public BlueprintRecord validate() {
        validateBlueprintId();
        validateItemId();
        validateCycle();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateBlueprintId() {
        if (!StringUtils.hasText(blueprintId)) {
            throw new DataRecordValidateException("蓝图ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validateCycle() {
        if (cycle == null || cycle < 0) {
            throw new DataRecordValidateException("周期不能为 null 或小于 0，当前值为: " + cycle);
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
