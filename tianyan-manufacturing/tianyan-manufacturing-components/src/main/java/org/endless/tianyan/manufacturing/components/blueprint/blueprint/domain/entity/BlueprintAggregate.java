package org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateAddItemException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveItemException;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingAggregate;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.type.BlueprintTypeEnum;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * BlueprintAggregate
 * <p>蓝图聚合根
 * <p>
 * create 2025/07/24 10:42
 * <p>
 * update 2025/07/24 10:42
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class BlueprintAggregate implements TianyanManufacturingAggregate {

    /**
     * 蓝图ID
     */
    @NotBlank(message = "蓝图ID不能为空")
    private final String blueprintId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 蓝图类型
     */
    @NotNull(message = "蓝图类型不能为空")
    private BlueprintTypeEnum type;

    /**
     * 蓝图物料列表
     */
    private final List<BlueprintMaterialEntity> materials;

    /**
     * 蓝图产品列表
     */
    @NotEmpty(message = "蓝图产品列表不能为空")
    private final List<BlueprintProductEntity> products;

    /**
     * 蓝图所需技能列表
     */
    private final List<BlueprintSkillEntity> skills;

    /**
     * 周期
     */
    @NotNull(message = "周期不能为空")
    private Long cycle;

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

    public static BlueprintAggregate create(BlueprintAggregateBuilder builder) {
        return builder
                .blueprintId(IdGenerator.of())
                .itemId(builder.itemId)
                .type(builder.type)
                .materials(builder.materials == null ? new ArrayList<>() : new ArrayList<>(builder.materials))
                .products(builder.products == null ? new ArrayList<>() : new ArrayList<>(builder.products))
                .skills(builder.skills == null ? new ArrayList<>() : new ArrayList<>(builder.skills))
                .cycle(builder.cycle)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    public BlueprintAggregate remove(String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的蓝图聚合根不能再次删除, ID: " + blueprintId);
        }
        this.materials.forEach(materials -> materials.remove(modifyUserId));
        this.products.forEach(products -> products.remove(modifyUserId));
        this.skills.forEach(kills -> kills.remove(modifyUserId));
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate addMaterial(BlueprintMaterialEntity material, String modifyUserId) {
        if (material == null) {
            throw new AggregateAddItemException("聚合根要添加的子实体 BlueprintMaterialEntity 不能为 null");
        }
        this.materials.add(material);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate addMaterials(List<BlueprintMaterialEntity> materials, String modifyUserId) {
        if (CollectionUtils.isEmpty(materials)) {
            throw new AggregateAddItemException("聚合根要添加的子实体列表 List<BlueprintMaterialEntity> 不能为空");
        }
        this.materials.addAll(materials);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate addProduct(BlueprintProductEntity product, String modifyUserId) {
        if (product == null) {
            throw new AggregateAddItemException("聚合根要添加的子实体 BlueprintProductEntity 不能为 null");
        }
        this.products.add(product);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate addProducts(List<BlueprintProductEntity> products, String modifyUserId) {
        if (CollectionUtils.isEmpty(products)) {
            throw new AggregateAddItemException("聚合根要添加的子实体列表 List<BlueprintProductEntity> 不能为空");
        }
        this.products.addAll(products);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate addSkill(BlueprintSkillEntity skill, String modifyUserId) {
        if (skill == null) {
            throw new AggregateAddItemException("聚合根要添加的子实体 BlueprintSkillEntity 不能为 null");
        }
        this.skills.add(skill);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate addSkills(List<BlueprintSkillEntity> skills, String modifyUserId) {
        if (CollectionUtils.isEmpty(skills)) {
            throw new AggregateAddItemException("聚合根要添加的子实体列表 List<BlueprintSkillEntity> 不能为空");
        }
        this.skills.addAll(skills);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate removeMaterial(BlueprintMaterialEntity material, String modifyUserId) {
        if (material == null) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体 BlueprintMaterialEntity 不能为 null");
        }
        this.materials.stream()
                .filter(exist -> exist.getBlueprintMaterialId().equals(material.getBlueprintMaterialId()))
                .findFirst()
                .orElseThrow(() -> new AggregateRemoveItemException("未找到要删除的子实体 BlueprintMaterialEntity ID: " + material.getBlueprintMaterialId()))
                .remove(modifyUserId);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate removeMaterials(List<BlueprintMaterialEntity> materials, String modifyUserId) {
        if (CollectionUtils.isEmpty(materials)) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体列表 List<BlueprintMaterialEntity> 不能为空");
        }
        Set<String> existIds = this.materials.stream()
                .map(BlueprintMaterialEntity::getBlueprintMaterialId)
                .collect(Collectors.toSet());
        materials.forEach(remove -> {
            if (!existIds.contains(remove.getBlueprintMaterialId())) {
                throw new AggregateRemoveItemException("要删除的子实体列表 List<BlueprintMaterialEntity> 中包含不存在的子实体 ID: " + remove.getBlueprintMaterialId());
            }
            this.materials.stream()
                    .filter(exist -> exist.getBlueprintMaterialId().equals(remove.getBlueprintMaterialId()))
                    .findFirst()
                    .ifPresent(material -> material.remove(modifyUserId));
        });
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate removeProduct(BlueprintProductEntity product, String modifyUserId) {
        if (product == null) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体 BlueprintProductEntity 不能为 null");
        }
        this.products.stream()
                .filter(exist -> exist.getBlueprintProductId().equals(product.getBlueprintProductId()))
                .findFirst()
                .orElseThrow(() -> new AggregateRemoveItemException("未找到要删除的子实体 BlueprintProductEntity ID: " + product.getBlueprintProductId()))
                .remove(modifyUserId);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate removeProducts(List<BlueprintProductEntity> products, String modifyUserId) {
        if (CollectionUtils.isEmpty(products)) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体列表 List<BlueprintProductEntity> 不能为空");
        }
        Set<String> existIds = this.products.stream()
                .map(BlueprintProductEntity::getBlueprintProductId)
                .collect(Collectors.toSet());
        products.forEach(remove -> {
            if (!existIds.contains(remove.getBlueprintProductId())) {
                throw new AggregateRemoveItemException("要删除的子实体列表 List<BlueprintProductEntity> 中包含不存在的子实体 ID: " + remove.getBlueprintProductId());
            }
            this.products.stream()
                    .filter(exist -> exist.getBlueprintProductId().equals(remove.getBlueprintProductId()))
                    .findFirst()
                    .ifPresent(product -> product.remove(modifyUserId));
        });
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate removeSkill(BlueprintSkillEntity skill, String modifyUserId) {
        if (skill == null) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体 BlueprintSkillEntity 不能为 null");
        }
        this.skills.stream()
                .filter(exist -> exist.getBlueprintSkillId().equals(skill.getBlueprintSkillId()))
                .findFirst()
                .orElseThrow(() -> new AggregateRemoveItemException("未找到要删除的子实体 BlueprintSkillEntity ID: " + skill.getBlueprintSkillId()))
                .remove(modifyUserId);
        this.modifyUserId = modifyUserId;
        return this;
    }

    public BlueprintAggregate removeSkills(List<BlueprintSkillEntity> skills, String modifyUserId) {
        if (CollectionUtils.isEmpty(skills)) {
            throw new AggregateRemoveItemException("聚合根要删除的子实体列表 List<BlueprintSkillEntity> 不能为空");
        }
        Set<String> existIds = this.skills.stream()
                .map(BlueprintSkillEntity::getBlueprintSkillId)
                .collect(Collectors.toSet());
        skills.forEach(remove -> {
            if (!existIds.contains(remove.getBlueprintSkillId())) {
                throw new AggregateRemoveItemException("要删除的子实体列表 List<BlueprintSkillEntity> 中包含不存在的子实体 ID: " + remove.getBlueprintSkillId());
            }
            this.skills.stream()
                    .filter(exist -> exist.getBlueprintSkillId().equals(remove.getBlueprintSkillId()))
                    .findFirst()
                    .ifPresent(skill -> skill.remove(modifyUserId));
        });
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public BlueprintAggregate validate() {
        return this;
    }
}
