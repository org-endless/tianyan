package org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.sales.common.model.infrastructure.data.persistence.mapper.TianyanSalesMapper;
import org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.record.MarketOrderRecord;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * MarketOrderMapper
 * <p>市场订单聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see TianyanSalesMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface MarketOrderMapper extends TianyanSalesMapper<MarketOrderRecord> {

    default List<String> findIdsByItemId(String itemId) {
        QueryWrapper<MarketOrderRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(MarketOrderRecord::getMarketOrderId)
                .eq(MarketOrderRecord::getItemId, itemId)
                .orderByAsc(MarketOrderRecord::getMarketOrderId);
        return findAllByWrapper(queryWrapper).stream()
                .map(MarketOrderRecord::getMarketOrderId).toList();
    }
}
