package org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.EntityRemoveException;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.EntityValidateException;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingEntity;
import org.springframework.util.StringUtils;

/**
 * BlueprintSkillEntity
 * <p>蓝图技能实体
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
public class BlueprintSkillEntity implements TianyanManufacturingEntity {

    /**
     * 蓝图技能ID
     */
    private final String blueprintSkillId;

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
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static BlueprintSkillEntity create(BlueprintSkillEntityBuilder builder) {
        return builder
                .blueprintSkillId(IdGenerator.of())
                .itemId(builder.itemId)
                .level(builder.level)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
                .innerBuild()
                .validate();
    }

    protected BlueprintSkillEntity remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new EntityRemoveException("已经被删除的实体<蓝图技能实体>不能再次删除, ID: " + blueprintSkillId);
        }
        if (!canRemove()) {
            throw new EntityRemoveException("实体<蓝图技能实体>处于不可删除状态, ID: " + blueprintSkillId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public BlueprintSkillEntity validate() {
        validateBlueprintSkillId();
        validateItemId();
        validateLevel();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateBlueprintSkillId() {
        if (!StringUtils.hasText(blueprintSkillId)) {
            throw new EntityValidateException("蓝图技能ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new EntityValidateException("资源项ID不能为空");
        }
    }

    private void validateLevel() {
        if (!StringUtils.hasText(level)) {
            throw new EntityValidateException("蓝图技能等级不能为空");
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
