package org.endless.tianyan.metadata.components.industry.category.infrastructure.data.manager;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
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
 * <p>行业分类聚合根数据管理器
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
    @Log(message = "保存行业分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(
            @NotNull(message = "保存行业分类聚合根数据不能为空")
            @Valid IndustryCategoryAggregate aggregate) {
        industryCategoryMapper.save(IndustryCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除行业分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(
            @NotNull(message = "删除行业分类聚合根数据不能为空")
            IndustryCategoryAggregate aggregate) {
        industryCategoryMapper.remove(IndustryCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改行业分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(
            @NotNull(message = "修改行业分类聚合根数据不能为空")
            @Valid IndustryCategoryAggregate aggregate) {
        industryCategoryMapper.modify(IndustryCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询行业分类聚合根数据", value = "#industryCategoryId", level = LogLevel.TRACE)
    public Optional<IndustryCategoryAggregate> findById(
            @NotBlank(message = "行业分类聚合ID不能为空") String industryCategoryId) {
        return industryCategoryMapper.findById(industryCategoryId).map(IndustryCategoryRecord::to);
    }

    @Override
    public Optional<IndustryCategoryAggregate> findByIdForUpdate(String industryCategoryId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据ID查询行业分类聚合根数据是否存在", value = "#industryCategoryId", level = LogLevel.TRACE)
    public Boolean existsById(
            @NotBlank(message = "行业分类聚合ID不能为空") String industryCategoryId) {
        return industryCategoryMapper.existsById(industryCategoryId);
    }
}
