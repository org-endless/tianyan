package org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.manufacturing.common.model.infrastructure.data.persistence.mapper.TianyanManufacturingMapper;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.infrastructure.data.record.GameEveBlueprintRecord;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveBlueprintMapper
 * <p>游戏EVE蓝图聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/24 09:18
 * <p>
 * update 2025/07/24 09:18
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveBlueprintMapper extends TianyanManufacturingMapper<GameEveBlueprintRecord> {

}
