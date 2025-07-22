package org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.persistence.mapper;

import org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveItemGroupMapper
 * <p>游戏EVE物品分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveItemGroupMapper extends TianyanItemMapper<GameEveItemGroupRecord> {
}
