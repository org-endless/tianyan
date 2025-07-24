package org.endless.tianyan.sales.components.market.group.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.group.infrastructure.data.record.MarketGroupRecord;
import org.springframework.context.annotation.Lazy;

/**
 * MarketGroupMapper
 * <p>市场分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/22 16:05
 * <p>
 * update 2025/07/22 16:05
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MarketGroupMapper extends TianyanSalesMapper<MarketGroupRecord> {

    default Boolean existsById(String marketGroupId) {
        QueryWrapper<MarketGroupRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(MarketGroupRecord::getMarketGroupId, marketGroupId);
        return existsByWrapper(queryWrapper);
    }
}
