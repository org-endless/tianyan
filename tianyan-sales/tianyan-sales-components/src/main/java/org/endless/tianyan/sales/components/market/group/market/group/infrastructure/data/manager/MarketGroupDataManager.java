package org.endless.tianyan.sales.components.market.group.market.group.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.group.market.group.application.query.anticorruption.MarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.market.group.infrastructure.data.persistence.mapper.MarketGroupMapper;
import org.endless.tianyan.sales.components.market.group.market.group.infrastructure.data.record.MarketGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * MarketGroupDataManager
 * <p>市场分组聚合数据管理器
 * <p>
 * create 2025/07/24 17:36
 * <p>
 * update 2025/07/24 17:36
 *
 * @author Deng Haozhi
 * @see MarketGroupRepository
 * @see MarketGroupQueryRepository
 * @see TianyanSalesAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MarketGroupDataManager implements MarketGroupRepository, MarketGroupQueryRepository, TianyanSalesAggregateDataManager<MarketGroupRecord, MarketGroupAggregate> {

    /**
     * 市场分组聚合 Mybatis-Plus 数据访问对象
     */
    private final MarketGroupMapper marketGroupMapper;

    public MarketGroupDataManager(MarketGroupMapper marketGroupMapper) {
        this.marketGroupMapper = marketGroupMapper;
    }

    @Override
    @Log(message = "保存市场分组聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public MarketGroupAggregate save(MarketGroupAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(MarketGroupAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存市场分组聚合数据不能为空"));
        marketGroupMapper.save(MarketGroupRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(MarketGroupAggregate aggregate) {

    }

    @Override
    public MarketGroupAggregate modify(MarketGroupAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<MarketGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MarketGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据ID查询是否存在市场分组数据", value = "#parentId", level = LogLevel.TRACE)
    public Boolean existsById(String parentId) {
        Optional.ofNullable(parentId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("根据ID查询是否存在市场分组数据不能为空"));
        return marketGroupMapper.existsById(parentId);
    }
}
