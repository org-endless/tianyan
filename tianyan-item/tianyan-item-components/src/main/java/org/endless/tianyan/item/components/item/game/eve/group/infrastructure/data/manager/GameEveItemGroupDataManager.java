package org.endless.tianyan.item.components.item.game.eve.group.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.game.eve.group.application.query.anticorruption.GameEveItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.group.domain.anticorruption.GameEveItemGroupRepository;
import org.endless.tianyan.item.components.item.game.eve.group.domain.entity.GameEveItemGroupAggregate;
import org.endless.tianyan.item.components.item.game.eve.group.infrastructure.data.persistence.mapper.GameEveItemGroupMapper;
import org.endless.tianyan.item.components.item.game.eve.group.infrastructure.data.record.GameEveItemGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * GameEveItemGroupDataManager
 * <p>游戏EVE资源项分组聚合根数据管理器
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupRepository
 * @see GameEveItemGroupQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
@Validated
public class GameEveItemGroupDataManager implements GameEveItemGroupRepository, GameEveItemGroupQueryRepository, TianyanItemAggregateDataManager<GameEveItemGroupRecord, GameEveItemGroupAggregate> {

    /**
     * 游戏EVE资源项分组聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemGroupMapper gameEveItemGroupMapper;

    public GameEveItemGroupDataManager(GameEveItemGroupMapper gameEveItemGroupMapper) {
        this.gameEveItemGroupMapper = gameEveItemGroupMapper;
    }

    @Override
    @Log(message = "保存游戏EVE资源项分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(GameEveItemGroupAggregate aggregate) {
        gameEveItemGroupMapper.save(GameEveItemGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除游戏EVE资源项分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(GameEveItemGroupAggregate aggregate) {
        gameEveItemGroupMapper.remove(GameEveItemGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改游戏EVE资源项分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(GameEveItemGroupAggregate aggregate) {
        gameEveItemGroupMapper.modify(GameEveItemGroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询游戏EVE资源项分组聚合根数据", value = "#gameEveItemGroupId", level = LogLevel.TRACE)
    public Optional<GameEveItemGroupAggregate> findById(String gameEveItemGroupId) {
        return gameEveItemGroupMapper.findById(gameEveItemGroupId).map(GameEveItemGroupRecord::to);
    }

    @Override
    public Optional<GameEveItemGroupAggregate> findByIdForUpdate(String gameEveItemGroupId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据游戏EVE资源项分组编码查询资源项分组ID数据", value = "#gameEveItemGroupCode", level = LogLevel.TRACE)
    public Optional<String> findItemGroupIdByCode(String gameEveItemGroupCode) {
        return gameEveItemGroupMapper.findItemGroupIdByCode(gameEveItemGroupCode);
    }
}
