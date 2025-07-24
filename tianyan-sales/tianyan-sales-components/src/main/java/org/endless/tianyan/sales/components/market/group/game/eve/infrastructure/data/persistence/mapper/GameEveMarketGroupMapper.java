package org.endless.tianyan.sales.components.market.group.game.eve.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.group.game.eve.infrastructure.data.record.GameEveMarketGroupRecord;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 * GameEveMarketGroupMapper
 * <p>游戏EVE市场分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveMarketGroupMapper extends TianyanSalesMapper<GameEveMarketGroupRecord> {

    default Optional<String> findMarketGroupIdByCode(String code) {
        QueryWrapper<GameEveMarketGroupRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(GameEveMarketGroupRecord::getCode, code);
        return findFirstByWrapper(queryWrapper).map(GameEveMarketGroupRecord::getMarketGroupId);
    }
}
