package org.endless.tianyan.metadata.components.industry.category.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.industry.category.application.query.anticorruption.IndustryCategoryQueryRepository;
import org.endless.tianyan.metadata.components.industry.category.domain.anticorruption.IndustryCategoryRepository;
import org.endless.tianyan.metadata.components.industry.category.domain.entity.IndustryCategoryAggregate;
import org.endless.tianyan.metadata.components.industry.category.infrastructure.data.persistence.mapper.IndustryCategoryMapper;
import org.endless.tianyan.metadata.components.industry.category.infrastructure.data.record.IndustryCategoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * IndustryCategoryDataManager
 * <p>行业分类聚合数据管理器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see IndustryCategoryRepository
 * @see IndustryCategoryQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class IndustryCategoryDataManager implements IndustryCategoryRepository, IndustryCategoryQueryRepository, TianyanMetadataAggregateDataManager<IndustryCategoryRecord, IndustryCategoryAggregate> {

    /**
     * 行业分类聚合 Mybatis-Plus 数据访问对象
     */
    private final IndustryCategoryMapper industryCategoryMapper;

    public IndustryCategoryDataManager(IndustryCategoryMapper industryCategoryMapper) {
        this.industryCategoryMapper = industryCategoryMapper;
    }

    @Override
    @Log(message = "保存行业分类聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public IndustryCategoryAggregate save(IndustryCategoryAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(IndustryCategoryAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存行业分类聚合数据不能为空"));
        industryCategoryMapper.save(IndustryCategoryRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(IndustryCategoryAggregate aggregate) {

    }

    @Override
    public IndustryCategoryAggregate modify(IndustryCategoryAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<IndustryCategoryAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<IndustryCategoryAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据ID查询行业分类聚合数据是否存在", value = "#aggregate", level = LogLevel.TRACE)
    public Boolean existsById(String industryCategoryId) {
        return industryCategoryMapper.existsById(industryCategoryId);
    }
}
