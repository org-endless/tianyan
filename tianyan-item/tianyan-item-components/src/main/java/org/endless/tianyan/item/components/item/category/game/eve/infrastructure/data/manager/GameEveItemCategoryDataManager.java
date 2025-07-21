package org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.manager;

import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.domain.entity.GameEveItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.persistence.mapper.GameEveItemCategoryMapper;
import org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.record.GameEveItemCategoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * GameEveItemCategoryDataManager
 * <p>游戏EVE物品分类聚合数据管理器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryRepository
 * @see GameEveItemCategoryQueryRepository
 * @see TianyanItemAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveItemCategoryDataManager implements GameEveItemCategoryRepository, GameEveItemCategoryQueryRepository, TianyanItemAggregateDataManager<GameEveItemCategoryRecord, GameEveItemCategoryAggregate> {

    /**
     * 游戏EVE物品分类聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemCategoryMapper gameEveItemCategoryMapper;

    public GameEveItemCategoryDataManager(GameEveItemCategoryMapper gameEveItemCategoryMapper) {
        this.gameEveItemCategoryMapper = gameEveItemCategoryMapper;
    }

    @Override
    public GameEveItemCategoryAggregate save(GameEveItemCategoryAggregate gameEveItemCategoryAggregate) {
        return null;
    }

    @Override
    public void remove(GameEveItemCategoryAggregate gameEveItemCategoryAggregate) {

    }

    @Override
    public GameEveItemCategoryAggregate modify(GameEveItemCategoryAggregate gameEveItemCategoryAggregate) {
        return null;
    }

    @Override
    public Optional<GameEveItemCategoryAggregate> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<GameEveItemCategoryAggregate> findByIdForUpdate(String s) {
        return Optional.empty();
    }
}
