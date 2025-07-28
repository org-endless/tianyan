package org.endless.tianyan.item.components.item.game.eve.infrastructure.data.manager;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.DataManagerRequestNullException;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.data.persistence.mapper.GameEveItemMapper;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.data.record.GameEveItemRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * GameEveItemDataManager
 * <p>游戏EVE资源项聚合数据管理器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
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
     * 游戏EVE资源项聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemMapper gameEveItemMapper;

    public GameEveItemDataManager(GameEveItemMapper gameEveItemMapper) {
        this.gameEveItemMapper = gameEveItemMapper;
    }

    @Override
    @Log(message = "保存游戏EVE资源项聚合数据", value = "#aggregate", level = LogLevel.TRACE)
    public GameEveItemAggregate save(GameEveItemAggregate aggregate) {
        Optional.ofNullable(aggregate)
                .map(GameEveItemAggregate::validate)
                .orElseThrow(() -> new DataManagerRequestNullException("保存游戏EVE资源项聚合数据不能为空"));
        gameEveItemMapper.save(GameEveItemRecord.from(aggregate));
        return aggregate;
    }

    @Override
    public void remove(GameEveItemAggregate aggregate) {

    }

    @Override
    public GameEveItemAggregate modify(GameEveItemAggregate aggregate) {
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

    @Override
    @Log(message = "游戏EVE根据资源项编码查询资源项ID数据", value = "#code", level = LogLevel.TRACE)
    public Optional<String> findItemIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("资源项编码不能为空"));
        return gameEveItemMapper.findItemIdByCode(code);
    }

    @Override
    @Log(message = "游戏EVE根据资源项编码列表查询资源项ID列表数据", value = "#code", level = LogLevel.TRACE)
    public List<String> findItemIdsByCodes(List<String> codes) {
        Optional.ofNullable(codes)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new DataManagerRequestNullException("资源项编码列表不能为空"));
        return gameEveItemMapper.findItemIdsByCodes(codes);
    }

    @Override
    @Log(message = "游戏EVE根据资源项ID查询编码数据", value = "#itemId", level = LogLevel.TRACE)
    public Optional<String> findCodeByItemId(String itemId) {
        Optional.ofNullable(itemId)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DataManagerRequestNullException("资源项ID不能为空"));
        return gameEveItemMapper.findCodeByItemId(itemId);
    }
}
