package org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Entity;
import org.endless.ddd.starter.common.config.utils.id.IdGenerator;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.entity.EntityRemoveException;
import org.endless.tianyan.manufacturing.common.model.domain.entity.TianyanManufacturingEntity;
import org.springframework.validation.annotation.Validated;

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
@Entity
@Validated
@Builder(buildMethodName = "innerBuild")
public class BlueprintSkillEntity implements TianyanManufacturingEntity {

    /**
     * 蓝图技能ID
     */
    @NotBlank(message = "蓝图技能ID不能为空")
    private final String blueprintSkillId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 蓝图技能等级
     */
    @NotBlank(message = "蓝图技能等级不能为空")
    private String level;

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

    @Override
    public BlueprintSkillEntity validate() {
        return this;
    }

    protected BlueprintSkillEntity remove(String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new EntityRemoveException("已经被删除的实体<蓝图技能实体>不能再次删除, ID: " + blueprintSkillId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }
}
