package org.endless.tianyan.metadata.components.meta.group.meta.group.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.query.anticorruption.MetaGroupQueryRepository;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.anticorruption.MetaGroupRepository;
import org.endless.tianyan.metadata.components.meta.group.meta.group.domain.entity.MetaGroupAggregate;
import org.endless.tianyan.metadata.components.meta.group.meta.group.infrastructure.data.persistence.mapper.MetaGroupMapper;
import org.endless.tianyan.metadata.components.meta.group.meta.group.infrastructure.data.record.MetaGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * MetaGroupDataManager
 * <p>元分组聚合数据管理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetaGroupRepository
 * @see MetaGroupQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class MetaGroupDataManager implements MetaGroupRepository, MetaGroupQueryRepository, TianyanMetadataAggregateDataManager<MetaGroupRecord, MetaGroupAggregate> {

    /**
     * 元分组聚合 Mybatis-Plus 数据访问对象
     */
    private final MetaGroupMapper metaGroupMapper;

    public MetaGroupDataManager(MetaGroupMapper metaGroupMapper) {
        this.metaGroupMapper = metaGroupMapper;
    }

    @Override
    @Log(message = "保存元分组聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public MetaGroupAggregate save(MetaGroupAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(MetaGroupAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存元分组聚合数据不能为空"));
        metaGroupMapper.save(MetaGroupRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(MetaGroupAggregate aggregate) {

    }

    @Override
    public MetaGroupAggregate modify(MetaGroupAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<MetaGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<MetaGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
