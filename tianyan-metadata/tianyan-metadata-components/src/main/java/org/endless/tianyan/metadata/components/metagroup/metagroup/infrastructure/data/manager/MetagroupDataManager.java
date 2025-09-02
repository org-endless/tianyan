package org.endless.tianyan.metadata.components.metagroup.metagroup.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.query.anticorruption.MetagroupQueryRepository;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.anticorruption.MetagroupRepository;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.entity.MetagroupAggregate;
import org.endless.tianyan.metadata.components.metagroup.metagroup.infrastructure.data.persistence.mapper.MetagroupMapper;
import org.endless.tianyan.metadata.components.metagroup.metagroup.infrastructure.data.record.MetagroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * MetagroupDataManager
 * <p>元分组聚合根数据管理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see MetagroupRepository
 * @see MetagroupQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
@Validated
public class MetagroupDataManager implements MetagroupRepository, MetagroupQueryRepository, TianyanMetadataAggregateDataManager<MetagroupRecord, MetagroupAggregate> {

    /**
     * 元分组聚合 Mybatis-Plus 数据访问对象
     */
    private final MetagroupMapper metaGroupMapper;

    public MetagroupDataManager(MetagroupMapper metaGroupMapper) {
        this.metaGroupMapper = metaGroupMapper;
    }

    @Override
    @Log(message = "保存元分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(MetagroupAggregate aggregate) {
        metaGroupMapper.save(MetagroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除元分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(MetagroupAggregate aggregate) {
        metaGroupMapper.remove(MetagroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改元分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(MetagroupAggregate aggregate) {
        metaGroupMapper.modify(MetagroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询元分组聚合根数据", value = "#metagroupId", level = LogLevel.TRACE)
    public Optional<MetagroupAggregate> findById(String metagroupId) {
        return metaGroupMapper.findById(metagroupId).map(MetagroupRecord::to);
    }

    @Override
    public Optional<MetagroupAggregate> findByIdForUpdate(String metagroupId) {
        return Optional.empty();
    }
}
