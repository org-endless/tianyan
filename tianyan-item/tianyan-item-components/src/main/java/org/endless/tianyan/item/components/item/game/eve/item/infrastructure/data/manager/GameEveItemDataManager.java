package org.endless.tianyan.item.components.item.game.eve.item.infrastructure.data.manager;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.item.common.model.infrastructure.data.manager.TianyanItemAggregateDataManager;
import org.endless.tianyan.item.components.item.game.eve.item.application.query.anticorruption.GameEveItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;
import org.endless.tianyan.item.components.item.game.eve.item.infrastructure.data.persistence.mapper.GameEveItemMapper;
import org.endless.tianyan.item.components.item.game.eve.item.infrastructure.data.record.GameEveItemRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

/**
 * GameEveItemDataManager
 * <p>游戏EVE资源项聚合根数据管理器
 * <p>
 * itemCreate 2025/07/23 01:04
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
@Validated
public class GameEveItemDataManager implements GameEveItemRepository, GameEveItemQueryRepository, TianyanItemAggregateDataManager<GameEveItemRecord, GameEveItemAggregate> {

    /**
     * 游戏EVE资源项聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveItemMapper gameEveItemMapper;

    public GameEveItemDataManager(GameEveItemMapper gameEveItemMapper) {
        this.gameEveItemMapper = gameEveItemMapper;
    }

    @Override
    @Log(message = "保存游戏EVE资源项聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(GameEveItemAggregate aggregate) {
        gameEveItemMapper.save(GameEveItemRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除游戏EVE资源项聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(GameEveItemAggregate aggregate) {
        gameEveItemMapper.remove(GameEveItemRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改游戏EVE资源项聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(GameEveItemAggregate aggregate) {
        gameEveItemMapper.modify(GameEveItemRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询游戏EVE资源项聚合根数据", value = "#gameEveItemId", level = LogLevel.TRACE)
    public Optional<GameEveItemAggregate> findById(String gameEveItemId) {
        return gameEveItemMapper.findById(gameEveItemId).map(GameEveItemRecord::to);
    }

    @Override
    public Optional<GameEveItemAggregate> findByIdForUpdate(String gameEveItemId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据游戏EVE资源项编码查询资源项ID数据", value = "#gameEveItemCode", level = LogLevel.TRACE)
    public Optional<String> findItemIdByCode(String gameEveItemCode) {
        return gameEveItemMapper.findItemIdByCode(gameEveItemCode);
    }

    @Override
    @Log(message = "根据游戏EVE资源项编码列表查询资源项ID列表数据", value = "#gameEveItemCodes", level = LogLevel.TRACE)
    public List<String> findItemIdsByCodes(List<String> gameEveItemCodes) {
        return gameEveItemMapper.findItemIdsByCodes(gameEveItemCodes);
    }

    @Override
    @Log(message = "根据资源项ID查询游戏EVE资源项编码数据", value = "#itemId", level = LogLevel.TRACE)
    public Optional<String> findCodeByItemId(String itemId) {
        return gameEveItemMapper.findCodeByItemId(itemId);
    }
}
