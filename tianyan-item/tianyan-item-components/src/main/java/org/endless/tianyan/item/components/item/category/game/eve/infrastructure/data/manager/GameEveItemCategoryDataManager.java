package org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.anticorruption.GameEveItemCategoryQueryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.category.game.eve.domain.entity.GameEveItemCategoryAggregate;
import org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.persistence.mapper.GameEveItemCategoryMapper;
import org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.record.GameEveItemCategoryRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * GameEveItemCategoryDataManager
 * <p>游戏EVE资源项分类聚合数据管理器
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
public class GameEveItemCategoryDataManager implements GameEveItemCategoryRepository, GameEveItemCategoryQueryRepository, TianyanItemAggregateDataManager<GameEveItemCategoryRecord, GameEveItemCategoryAggregate> {

    /**
     * 游戏EVE资源项分类聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemCategoryMapper gameEveItemCategoryMapper;

    public GameEveItemCategoryDataManager(GameEveItemCategoryMapper gameEveItemCategoryMapper) {
        this.gameEveItemCategoryMapper = gameEveItemCategoryMapper;
    }

    @Override
    @Log(message = "保存游戏EVE资源项分类聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public GameEveItemCategoryAggregate save(GameEveItemCategoryAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(GameEveItemCategoryAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存游戏EVE资源项分类聚合数据不能为空"));
        gameEveItemCategoryMapper.save(GameEveItemCategoryRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(GameEveItemCategoryAggregate aggregate) {

    }

    @Override
    public GameEveItemCategoryAggregate modify(GameEveItemCategoryAggregate aggregate) {
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

    @Override
    @Log(message = "游戏EVE资源项分类根据编码查询ID数据", value = "#aggregate", level = LogLevel.TRACE)
    public Optional<String> findItemCategoryIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("游戏EVE资源项分类编码不能为空"));
        return gameEveItemCategoryMapper.findItemCategoryIdByCode(code);
    }
}
