package org.endless.tianyan.metadata.components.metagroup.game.eve.infrastructure.data.manager;

import jakarta.validation.constraints.NotBlank;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.TianyanMetadataAggregateDataManager;
import org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.anticorruption.GameEveMetagroupQueryRepository;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.anticorruption.GameEveMetagroupRepository;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.entity.GameEveMetagroupAggregate;
import org.endless.tianyan.metadata.components.metagroup.game.eve.infrastructure.data.persistence.mapper.GameEveMetagroupMapper;
import org.endless.tianyan.metadata.components.metagroup.game.eve.infrastructure.data.record.GameEveMetagroupRecord;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * GameEveMetagroupDataManager
 * <p>游戏EVE元分组聚合根数据管理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetagroupRepository
 * @see GameEveMetagroupQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveMetagroupDataManager implements GameEveMetagroupRepository, GameEveMetagroupQueryRepository, TianyanMetadataAggregateDataManager<GameEveMetagroupRecord, GameEveMetagroupAggregate> {

    /**
     * 游戏EVE元分组聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveMetagroupMapper gameEveMetagroupMapper;

    public GameEveMetagroupDataManager(GameEveMetagroupMapper gameEveMetagroupMapper) {
        this.gameEveMetagroupMapper = gameEveMetagroupMapper;
    }

    @Override
    @Log(message = "保存游戏EVE元分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void save(GameEveMetagroupAggregate aggregate) {
        gameEveMetagroupMapper.save(GameEveMetagroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "删除游戏EVE元分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void remove(GameEveMetagroupAggregate aggregate) {
        gameEveMetagroupMapper.remove(GameEveMetagroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "修改游戏EVE元分组聚合根数据", value = "#aggregate", level = LogLevel.TRACE)
    public void modify(GameEveMetagroupAggregate aggregate) {
        gameEveMetagroupMapper.modify(GameEveMetagroupRecord.from(aggregate));
    }

    @Override
    @Log(message = "根据ID查询游戏EVE元分组聚合根数据", value = "#gameEveMetagroupId", level = LogLevel.TRACE)
    public Optional<GameEveMetagroupAggregate> findById(String gameEveMetagroupId) {
        return gameEveMetagroupMapper.findById(gameEveMetagroupId).map(GameEveMetagroupRecord::to);
    }

    @Override
    public Optional<GameEveMetagroupAggregate> findByIdForUpdate(String gameEveMetagroupId) {
        return Optional.empty();
    }

    @Override
    @Log(message = "根据游戏EVE元分组编码查询元分组ID数据", value = "#gameEveMetagroupCode", level = LogLevel.TRACE)
    public Optional<String> findMetagroupIdByCode(
            @NotBlank(message = "游戏EVE元分组编码不能为空") String gameEveMetagroupCode) {
        return gameEveMetagroupMapper.findMetagroupIdByCode(gameEveMetagroupCode);
    }
}
