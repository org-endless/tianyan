package org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.group.game.eve.application.query.anticorruption.GameEveItemGroupQueryRepository;
import org.endless.tianyan.item.components.item.group.game.eve.domain.anticorruption.GameEveItemGroupRepository;
import org.endless.tianyan.item.components.item.group.game.eve.domain.entity.GameEveItemGroupAggregate;
import org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.persistence.mapper.GameEveItemGroupMapper;
import org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.record.GameEveItemGroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * GameEveItemGroupDataManager
 * <p>游戏EVE资源项分组聚合数据管理器
 * <p>
 * create 2025/07/21 16:03
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
public class GameEveItemGroupDataManager implements GameEveItemGroupRepository, GameEveItemGroupQueryRepository, TianyanItemAggregateDataManager<GameEveItemGroupRecord, GameEveItemGroupAggregate> {

    /**
     * 游戏EVE资源项分组聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemGroupMapper gameEveItemGroupMapper;

    public GameEveItemGroupDataManager(GameEveItemGroupMapper gameEveItemGroupMapper) {
        this.gameEveItemGroupMapper = gameEveItemGroupMapper;
    }

    @Override
    @Log(message = "保存游戏EVE资源项分组聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public GameEveItemGroupAggregate save(GameEveItemGroupAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(GameEveItemGroupAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存游戏EVE资源项分组聚合数据不能为空"));
        gameEveItemGroupMapper.save(GameEveItemGroupRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(GameEveItemGroupAggregate aggregate) {

    }

    @Override
    public GameEveItemGroupAggregate modify(GameEveItemGroupAggregate aggregate) {
        return null;
    }

    @Override
    public Optional<GameEveItemGroupAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveItemGroupAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据编码查询资源项分组ID数据", value = "#code", level = LogLevel.TRACE)
    public Optional<String> findItemGroupIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("游戏EVE资源项分组编码不能为空"));
        return gameEveItemGroupMapper.findItemGroupIdByCode(code);
    }
}
