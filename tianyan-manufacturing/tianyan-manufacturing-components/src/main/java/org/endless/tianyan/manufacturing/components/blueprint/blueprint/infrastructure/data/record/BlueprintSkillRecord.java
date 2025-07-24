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
 * BlueprintSkillRecord
 * <p>蓝图技能数据库记录实体
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
@TableName(value = "blueprint_skill")
public class BlueprintSkillRecord implements TianyanManufacturingRecord<BlueprintSkillEntity> {

    /**
     * 蓝图技能ID
     */
    @TableId
    private String blueprintSkillId;

    /**
     * 蓝图ID
     */
    private String blueprintId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 蓝图技能等级
     */
    private String level;

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

    public static BlueprintSkillRecord from(BlueprintSkillEntity entity, String blueprintId) {
        return BlueprintSkillRecord.builder()
                .blueprintSkillId(entity.getBlueprintSkillId())
                .blueprintId(blueprintId)
                .itemId(entity.getItemId())
                .level(entity.getLevel())
                .createUserId(entity.getCreateUserId())
                .modifyUserId(entity.getModifyUserId())
                .isRemoved(entity.getIsRemoved())
                .build()
                .validate();
    }

    protected BlueprintSkillEntity to() {
        validate();
        return BlueprintSkillEntity.builder()
                .blueprintSkillId(blueprintSkillId)
                .itemId(itemId)
                .level(level)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public BlueprintSkillRecord validate() {
        validateBlueprintSkillId();
        validateBlueprintId();
        validateItemId();
        validateLevel();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateBlueprintSkillId() {
        if (!StringUtils.hasText(blueprintSkillId)) {
            throw new DataRecordValidateException("蓝图技能ID不能为空");
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

    private void validateLevel() {
        if (!StringUtils.hasText(level)) {
            throw new DataRecordValidateException("蓝图技能等级不能为空");
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
