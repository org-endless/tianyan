package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.record.TianyanManufacturingRecord;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity.BlueprintMaterialEntity;
import org.springframework.util.StringUtils;

/**
 * BlueprintMaterialRecord
 * <p>蓝图物料数据库记录实体
 * <p>
 * create 2025/07/24 10:42
 * <p>
 * update 2025/07/24 10:42
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
@TableName(value = "blueprint_material")
public class BlueprintMaterialRecord implements TianyanManufacturingRecord<BlueprintMaterialEntity> {

    /**
     * 蓝图物料ID
     */
    @TableId
    private String blueprintMaterialId;

    /**
     * 蓝图ID
     */
    private String blueprintId;

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

    public static BlueprintMaterialRecord from(BlueprintMaterialEntity entity, String blueprintId) {
        return BlueprintMaterialRecord.builder()
                .blueprintMaterialId(entity.getBlueprintMaterialId())
                .blueprintId(blueprintId)
                .itemId(entity.getItemId())
                .quantity(entity.getQuantity())
                .createUserId(entity.getCreateUserId())
                .modifyUserId(entity.getModifyUserId())
                .isRemoved(entity.getIsRemoved())
                .build()
                .validate();
    }

    protected BlueprintMaterialEntity to() {
        validate();
        return BlueprintMaterialEntity.builder()
                .blueprintMaterialId(blueprintMaterialId)
                .itemId(itemId)
                .quantity(quantity)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public BlueprintMaterialRecord validate() {
        validateBlueprintMaterialId();
        validateBlueprintId();
        validateItemId();
        validateQuantity();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateBlueprintMaterialId() {
        if (!StringUtils.hasText(blueprintMaterialId)) {
            throw new DataRecordValidateException("蓝图物料ID不能为空");
        }
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

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new DataRecordValidateException("蓝图物料数量不能为 null 或小于 0，当前值为: " + quantity);
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
