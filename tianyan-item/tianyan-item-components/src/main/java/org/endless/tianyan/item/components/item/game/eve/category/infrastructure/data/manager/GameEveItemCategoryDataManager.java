package org.endless.tianyan.item.components.item.game.eve.category.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.game.eve.category.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.category.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.game.eve.category.domain.entity.GameEveItemCategoryAggregate;
import org.endless.tianyan.item.components.item.game.eve.category.infrastructure.data.persistence.mapper.GameEveItemCategoryMapper;
import org.endless.tianyan.item.components.item.game.eve.category.infrastructure.data.record.GameEveItemCategoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * GameEveItemCategoryDataManager
 * <p>游戏EVE资源项分类聚合根数据管理器
 * <p>
 * itemCreate 2025/07/20 22:39
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
@Validated
public class GameEveItemCategoryDataManager implements GameEveItemCategoryRepository, GameEveItemCategoryQueryRepository, TianyanItemAggregateDataManager<GameEveItemCategoryRecord, GameEveItemCategoryAggregate> {

    /**
     * 游戏EVE资源项分类聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemCategoryMapper gameEveItemCategoryMapper;

    public GameEveItemCategoryDataManager(GameEveItemCategoryMapper gameEveItemCategoryMapper) {
        this.gameEveItemCategoryMapper = gameEveItemCategoryMapper;
    }

    @Override
    @Log(message = "保存游戏EVE资源项分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(GameEveItemCategoryAggregate aggregate) {
        gameEveItemCategoryMapper.save(GameEveItemCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除游戏EVE资源项分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(GameEveItemCategoryAggregate aggregate) {
        gameEveItemCategoryMapper.remove(GameEveItemCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改游戏EVE资源项分类聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(GameEveItemCategoryAggregate aggregate) {
        gameEveItemCategoryMapper.modify(GameEveItemCategoryRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询游戏EVE资源项分类聚合根数据", value = "#gameEveItemCategoryId", level = LogLevel.TRACE)
    public Optional<GameEveItemCategoryAggregate> findById(String gameEveItemCategoryId) {
        return gameEveItemCategoryMapper.findById(gameEveItemCategoryId).map(GameEveItemCategoryRecord::to);
    }

    @Override
    public Optional<GameEveItemCategoryAggregate> findByIdForUpdate(String gameEveItemCategoryId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据游戏EVE资源项分类编码查询资源项分类ID数据", value = "#gameEveItemCategoryCode", level = LogLevel.TRACE)
    public Optional<String> findItemCategoryIdByCode(String gameEveItemCategoryCode) {
        return gameEveItemCategoryMapper.findItemCategoryIdByCode(gameEveItemCategoryCode);
    }
}
