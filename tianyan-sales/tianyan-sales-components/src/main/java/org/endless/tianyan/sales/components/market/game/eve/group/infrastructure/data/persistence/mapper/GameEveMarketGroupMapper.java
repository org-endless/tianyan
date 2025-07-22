package org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.persistence.mapper;

import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.game.eve.group.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveMarketGroupMapper
 * <p>游戏EVE市场分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveMarketGroupMapper extends TianyanSalesMapper<GameEveMarketGroupRecord> {
}
