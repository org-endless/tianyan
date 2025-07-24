package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.data.manager;

import org.endless.tianyan.metadata.common.model.infrastructure.data.manager.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.entity.*;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.manager.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * GameEveDataDataManager
 * <p>游戏EVE数据聚合数据管理器
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see GameEveDataRepository
 * @see GameEveDataQueryRepository
 * @see TianyanMetadataAggregateDataManager
 * @since 0.0.1
 */
@Lazy
@Component
public class GameEveDataDataManager implements GameEveDataRepository, GameEveDataQueryRepository, TianyanMetadataAggregateDataManager<GameEveDataRecord, GameEveDataAggregate> {

    /**
     * 游戏EVE数据聚合 Mybatis-Plus 数据访问对象
     */
    private final GameEveDataMapper gameEveDataMapper;

    public GameEveDataDataManager(GameEveDataMapper gameEveDataMapper) {
        this.gameEveDataMapper = gameEveDataMapper;
    }
}
