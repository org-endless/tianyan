package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.persistence.mapper;

import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * GameEveMarketOrderMapper
 * <p>游戏EVE市场订单聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveMarketOrderMapper extends TianyanSalesMapper<GameEveMarketOrderRecord> {
}
