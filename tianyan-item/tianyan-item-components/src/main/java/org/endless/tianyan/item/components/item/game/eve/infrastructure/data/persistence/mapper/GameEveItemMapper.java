package org.endless.tianyan.item.components.item.game.eve.infrastructure.data.persistence.mapper;

import org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveItemMapper
 * <p>游戏EVE物品聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see TianyanItemMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveItemMapper extends TianyanItemMapper<GameEveItemRecord> {
}
