package org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.order.market.order.application.query.anticorruption.MarketOrderQueryRepository;
import org.endless.tianyan.sales.components.market.order.market.order.domain.anticorruption.MarketOrderRepository;
import org.endless.tianyan.sales.components.market.order.market.order.domain.entity.MarketOrderAggregate;
import org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.persistence.mapper.MarketOrderMapper;
import org.endless.tianyan.sales.components.market.order.market.order.infrastructure.data.record.MarketOrderRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * MarketOrderDataManager
 * <p>市场订单聚合数据管理器
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
    @Log(message = "保存市场订单聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public MarketOrderAggregate save(MarketOrderAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(MarketOrderAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存市场订单聚合数据不能为空"));
        marketOrderMapper.save(MarketOrderRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "删除市场订单聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(MarketOrderAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .orElseThrow(() -> new DataManagerRequestNullException("删除市场订单聚合数据不能为空"));
        marketOrderMapper.remove(MarketOrderRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改市场订单聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public MarketOrderAggregate modify(MarketOrderAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(MarketOrderAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存市场订单聚合数据不能为空"));
        marketOrderMapper.modify(MarketOrderRecord.from(aggregate));
        return aggregate;
    }

    @Override
    @Log(message = "根据ID查询市场订单聚合数据", value = "#id", level = LogLevel.TRACE)
    public Optional<MarketOrderAggregate> findById(String id) {
        Optional.ofNullable(id)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("市场订单ID不能为空"));
        return marketOrderMapper.findById(id).map(MarketOrderRecord::to);
    }

    @Override
    public Optional<MarketOrderAggregate> findByIdForUpdate(String id) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据资源项ID查询市场订单数据列表", value = "#itemId", level = LogLevel.TRACE)
    public List<MarketOrderAggregate> findAllByItemId(String itemId) {
        Optional.ofNullable(itemId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("资源项ID不能为空"));
        return marketOrderMapper.findAllByItemId(itemId).stream().map(MarketOrderRecord::to).toList();
    }

    @Override
    @Log(message = "根据资源项ID查询市场订单ID数据列表", value = "#itemId", level = LogLevel.TRACE)
    public List<String> findIdsByItemId(String itemId) {
        Optional.ofNullable(itemId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("资源项ID不能为空"));
        return marketOrderMapper.findIdsByItemId(itemId);
    }


}
