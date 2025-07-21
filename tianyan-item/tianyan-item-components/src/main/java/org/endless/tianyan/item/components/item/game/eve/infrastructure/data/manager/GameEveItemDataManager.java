package org.endless.tianyan.item.components.item.game.eve.infrastructure.data.manager;

import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.data.persistence.mapper.GameEveItemMapper;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.data.record.GameEveItemRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * GameEveItemDataManager
 * <p>游戏EVE物品聚合数据管理器
 * <p>
 * create 2025/07/19 09:28
 * <p>
 * update 2025/07/19 09:28
 *
 * @author Deng Haozhi
 * @see GameEveItemRepository
 * @see GameEveItemQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveItemDataManager implements GameEveItemRepository, GameEveItemQueryRepository, TianyanItemAggregateDataManager<GameEveItemRecord, GameEveItemAggregate> {

    /**
     * 游戏EVE物品聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemMapper gameEveItemMapper;

    public GameEveItemDataManager(GameEveItemMapper gameEveItemMapper) {
        this.gameEveItemMapper = gameEveItemMapper;
    }

    @Override
    public GameEveItemAggregate save(GameEveItemAggregate gameEveItemAggregate) {
        return null;
    }

    @Override
    public void remove(GameEveItemAggregate gameEveItemAggregate) {

    }

    @Override
    public GameEveItemAggregate modify(GameEveItemAggregate gameEveItemAggregate) {
        return null;
    }

    @Override
    public Optional<GameEveItemAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveItemAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
