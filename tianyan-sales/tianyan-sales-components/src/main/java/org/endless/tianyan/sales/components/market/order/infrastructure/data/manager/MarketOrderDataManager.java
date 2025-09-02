package org.endless.tianyan.sales.components.market.order.infrastructure.data.manager;

import jakarta.validation.constraints.NotBlank;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.order.application.query.anticorruption.MarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.infrastructure.data.persistence.mapper.MarketOrderMapper;
import org.endless.tianyan.sales.components.market.order.infrastructure.data.record.MarketOrderRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * MarketOrderDataManager
 * <p>市场订单聚合根数据管理器
 * <p>
 * create 2025/07/25 13:11
 * <p>
 * update 2025/07/25 13:11
 *
 * @author Deng Haozhi
 * @see MarketOrderRepository
 * @see MarketOrderQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketOrderDataManager implements MarketOrderRepository, MarketOrderQueryRepository, TianyanSalesAggregateDataManager<MarketOrderRecord, MarketOrderAggregate> {

    /**
     * 市场订单聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketOrderMapper marketOrderMapper;

    public MarketOrderDataManager(MarketOrderMapper marketOrderMapper) {
        this.marketOrderMapper = marketOrderMapper;
    }

    @Override
    @Log(message = "保存市场订单聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(MarketOrderAggregate aggregate) {
        marketOrderMapper.save(MarketOrderRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除市场订单聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(MarketOrderAggregate aggregate) {
        marketOrderMapper.remove(MarketOrderRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改市场订单聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(MarketOrderAggregate aggregate) {
        marketOrderMapper.modify(MarketOrderRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询市场订单聚合根数据", value = "#marketOrderId", level = LogLevel.TRACE)
    public Optional<MarketOrderAggregate> findById(String marketOrderId) {
        return marketOrderMapper.findById(marketOrderId).map(MarketOrderRecord::to);
    }

    @Override
    public Optional<MarketOrderAggregate> findByIdForUpdate(String marketOrderId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据资源项ID查询市场订单数据列表", value = "#itemId", level = LogLevel.TRACE)
    public List<MarketOrderAggregate> findAllByItemId(
            @NotBlank(message = "资源项ID不能为空") String itemId) {
        return marketOrderMapper.findAllByItemId(itemId).stream().map(MarketOrderRecord::to).toList();
    }

    @Override
    @Log(message = "根据资源项ID查询市场订单ID数据列表", value = "#itemId", level = LogLevel.TRACE)
    public List<String> findIdsByItemId(
            @NotBlank(message = "资源项ID不能为空") String itemId) {
        return marketOrderMapper.findIdsByItemId(itemId);
    }
}
