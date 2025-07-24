package org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity;

import org.endless.tianyan.manufacturing.common.model.domain.entity.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.type.*;
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
 * BlueprintMaterialEntity
 * <p>蓝图物料实体
 * <p>
 * create 2025/07/24 10:42
 * <p>
 * update 2025/07/24 10:42
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingEntity
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class BlueprintMaterialEntity implements TianyanManufacturingEntity {

    /**
     * 蓝图物料ID
     */
    private final String blueprintMaterialId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 蓝图物料数量
     */
    private Long quantity;

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

    public static BlueprintMaterialEntity create(BlueprintMaterialEntityBuilder builder) {
        return builder
                .blueprintMaterialId(IdGenerator.of())
                .itemId(builder.itemId)
                .quantity(builder.quantity)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    protected BlueprintMaterialEntity remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new EntityRemoveException("已经被删除的实体<蓝图物料实体>不能再次删除, ID: " + blueprintMaterialId);
        }
        if (!canRemove()) {
            throw new EntityRemoveException("实体<蓝图物料实体>处于不可删除状态, ID: " + blueprintMaterialId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public BlueprintMaterialEntity validate() {
        validateBlueprintMaterialId();
        validateItemId();
        validateQuantity();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateBlueprintMaterialId() {
        if (!StringUtils.hasText(blueprintMaterialId)) {
            throw new EntityValidateException("蓝图物料ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new EntityValidateException("资源项ID不能为空");
        }
    }

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new EntityValidateException("蓝图物料数量不能为 null 或小于 0，当前值为: " + quantity);
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new EntityValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new EntityValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new EntityValidateException("是否已删除不能为 null ");
        }
    }
}
