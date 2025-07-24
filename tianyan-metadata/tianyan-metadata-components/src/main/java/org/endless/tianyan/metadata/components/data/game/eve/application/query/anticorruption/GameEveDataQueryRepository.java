package org.endless.tianyan.metadata.components.data.game.eve.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption.*;
import org.endless.tianyan.metadata.components.data.game.eve.domain.entity.*;

/**
 * GameEveDataQueryRepository
 * <p>游戏EVE数据聚合查询仓储接口
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see GameEveDataRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface GameEveDataQueryRepository extends GameEveDataRepository, TianyanMetadataQueryRepository<GameEveDataAggregate> {
}
