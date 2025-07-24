package org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.TianyanMetadataQueryRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.anticorruption.GameEveMetaGroupRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.entity.GameEveMetaGroupAggregate;

import java.util.Optional;

/**
 * GameEveMetaGroupQueryRepository
 * <p>游戏EVE元分组聚合查询仓储接口
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetaGroupRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface GameEveMetaGroupQueryRepository extends GameEveMetaGroupRepository, TianyanMetadataQueryRepository<GameEveMetaGroupAggregate> {

    Optional<String> findMetaGroupIdByCode(String code);
}
