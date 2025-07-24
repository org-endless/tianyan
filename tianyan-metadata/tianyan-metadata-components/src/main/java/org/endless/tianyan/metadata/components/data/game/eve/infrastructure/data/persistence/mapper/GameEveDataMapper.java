package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.data.persistence.mapper;

import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveDataMapper
 * <p>游戏EVE数据聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see TianyanMetadataMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveDataMapper extends TianyanMetadataMapper<GameEveDataRecord> {
}
