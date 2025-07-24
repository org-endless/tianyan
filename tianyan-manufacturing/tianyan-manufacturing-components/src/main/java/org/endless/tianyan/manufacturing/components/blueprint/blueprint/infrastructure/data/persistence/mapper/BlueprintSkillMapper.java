package org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.persistence.mapper;

import org.endless.tianyan.manufacturing.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * BlueprintSkillMapper
 * <p>蓝图技能实体 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface BlueprintSkillMapper extends TianyanManufacturingMapper<BlueprintSkillRecord> {
}
