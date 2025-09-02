package org.endless.tianyan.sales.components.market.group.infrastructure.data.manager;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.sales.common.model.infrastructure.data.manager.TianyanSalesAggregateDataManager;
import org.endless.tianyan.sales.components.market.group.application.query.anticorruption.MarketGroupQueryRepository;
import org.endless.tianyan.sales.components.market.group.domain.anticorruption.MarketGroupRepository;
import org.endless.tianyan.sales.components.market.group.domain.entity.MarketGroupAggregate;
import org.endless.tianyan.sales.components.market.group.infrastructure.data.persistence.mapper.MarketGroupMapper;
import org.endless.tianyan.sales.components.market.group.infrastructure.data.record.MarketGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MarketGroupDataManager
 * <p>市场分组聚合根数据管理器
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
    @Log(message = "保存市场分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(
            @NotNull(message = "保存市场分组聚合根不能为空")
            @Valid MarketGroupAggregate aggregate) {
        marketGroupMapper.save(MarketGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除市场分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(
            @NotNull(message = "删除市场分组聚合根不能为空")
            MarketGroupAggregate aggregate) {
        marketGroupMapper.remove(MarketGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改市场分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(
            @NotNull(message = "修改市场分组聚合根不能为空")
            @Valid MarketGroupAggregate aggregate) {
        marketGroupMapper.modify(MarketGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询市场分组聚合根数据", value = "#marketGroupId", level = LogLevel.TRACE)
    public Optional<MarketGroupAggregate> findById(
            @NotBlank(message = "市场分组ID不能为空") String marketGroupId) {
        return marketGroupMapper.findById(marketGroupId).map(MarketGroupRecord::to);
    }

    @Override
    public Optional<MarketGroupAggregate> findByIdForUpdate(String marketGroupId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据ID查询是否存在市场分组数据", value = "#parentId", level = LogLevel.TRACE)
    public Boolean existsById(
            @NotBlank(message = "父级市场分组ID不能为空") String parentId) {
        return marketGroupMapper.existsById(parentId);
    }
}
