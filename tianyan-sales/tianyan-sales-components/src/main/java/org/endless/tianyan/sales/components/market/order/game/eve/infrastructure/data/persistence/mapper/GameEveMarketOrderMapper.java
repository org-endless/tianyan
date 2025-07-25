package org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.order.game.eve.infrastructure.data.record.GameEveMarketOrderRecord;
import org.springframework.context.annotation.Lazy;

import java.util.List;

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

    default List<GameEveMarketOrderRecord> findAllByCode(String code) {
        QueryWrapper<GameEveMarketOrderRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(GameEveMarketOrderRecord::getCode, code)
                .orderByAsc(GameEveMarketOrderRecord::getGameEveMarketOrderId);
        return findAllByWrapper(queryWrapper);
    }
}
