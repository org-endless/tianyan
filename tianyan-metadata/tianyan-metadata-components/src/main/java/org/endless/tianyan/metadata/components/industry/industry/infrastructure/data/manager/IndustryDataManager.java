package org.endless.tianyan.metadata.components.industry.industry.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.industry.industry.application.query.anticorruption.IndustryQueryRepository;
import org.endless.tianyan.metadata.components.industry.industry.domain.anticorruption.IndustryRepository;
import org.endless.tianyan.metadata.components.industry.industry.domain.entity.IndustryAggregate;
import org.endless.tianyan.metadata.components.industry.industry.infrastructure.data.persistence.mapper.IndustryMapper;
import org.endless.tianyan.metadata.components.industry.industry.infrastructure.data.record.IndustryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * IndustryDataManager
 * <p>行业聚合数据管理器
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see IndustryRepository
 * @see IndustryQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class IndustryDataManager implements IndustryRepository, IndustryQueryRepository, TianyanMetadataAggregateDataManager<IndustryRecord, IndustryAggregate> {

    /**
     * 行业聚合 Mybatis-Plus 数据访问对象
     */
    private final IndustryMapper industryMapper;

    public IndustryDataManager(IndustryMapper industryMapper) {
        this.industryMapper = industryMapper;
    }

    @Override
    @Log(message = "保存行业聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public IndustryAggregate save(IndustryAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(IndustryAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存行业聚合数据不能为空"));
        industryMapper.save(IndustryRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(IndustryAggregate aggregate) {

    }

    @Override
    public IndustryAggregate modify(IndustryAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<IndustryAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<IndustryAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
