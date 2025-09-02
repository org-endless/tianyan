package org.endless.tianyan.metadata.components.industry.industry.infrastructure.data.manager;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
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
 * <p>行业聚合根数据管理器
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
    @Log(message = "保存行业聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(
            @NotNull(message = "保存行业聚合根数据不能为空")
            @Valid IndustryAggregate aggregate) {
        industryMapper.save(IndustryRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除行业聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(
            @NotNull(message = "删除行业聚合根数据不能为空")
            IndustryAggregate aggregate) {
        industryMapper.remove(IndustryRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改行业聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(
            @NotNull(message = "修改行业聚合根数据不能为空")
            @Valid IndustryAggregate aggregate) {
        industryMapper.modify(IndustryRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询行业聚合根数据", value = "#industryId", level = LogLevel.TRACE)
    public Optional<IndustryAggregate> findById(
            @NotBlank(message = "行业聚合ID不能为空") String industryId) {
        return industryMapper.findById(industryId).map(IndustryRecord::to);
    }

    @Override
    public Optional<IndustryAggregate> findByIdForUpdate(String industryId) {
        return Optional.empty();
    }
}
