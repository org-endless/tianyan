package org.endless.tianyan.metadata.components.meta.group.game.eve.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.anticorruption.GameEveMetaGroupQueryRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.anticorruption.GameEveMetaGroupRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.entity.GameEveMetaGroupAggregate;
import org.endless.tianyan.metadata.components.meta.group.game.eve.infrastructure.data.persistence.mapper.GameEveMetaGroupMapper;
import org.endless.tianyan.metadata.components.meta.group.game.eve.infrastructure.data.record.GameEveMetaGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * GameEveMetaGroupDataManager
 * <p>游戏EVE元分组聚合数据管理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetaGroupRepository
 * @see GameEveMetaGroupQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveMetaGroupDataManager implements GameEveMetaGroupRepository, GameEveMetaGroupQueryRepository, TianyanMetadataAggregateDataManager<GameEveMetaGroupRecord, GameEveMetaGroupAggregate> {

    /**
     * 游戏EVE元分组聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveMetaGroupMapper gameEveMetaGroupMapper;

    public GameEveMetaGroupDataManager(GameEveMetaGroupMapper gameEveMetaGroupMapper) {
        this.gameEveMetaGroupMapper = gameEveMetaGroupMapper;
    }

    @Override
    @Log(message = "保存游戏EVE元分组聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public GameEveMetaGroupAggregate save(GameEveMetaGroupAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(GameEveMetaGroupAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存游戏EVE元分组聚合数据不能为空"));
        gameEveMetaGroupMapper.save(GameEveMetaGroupRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(GameEveMetaGroupAggregate aggregate) {

    }

    @Override
    public GameEveMetaGroupAggregate modify(GameEveMetaGroupAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<GameEveMetaGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveMetaGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }

    @Override
    @Log(message = "游戏EVE元分组根据编码查询元分组ID数据", value = "#aggregate", level = LogLevel.TRACE)
    public Optional<String> findMetaGroupIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("游戏EVE元分组编码不能为空"));
        return gameEveMetaGroupMapper.findMetaGroupIdByCode(code);
    }
}
