package org.endless.tianyan.metadata.components.metagroup.game.eve.application.query.anticorruption;

import org.endless.tianyan.metadata.common.model.application.query.anticorruption.TianyanMetadataQueryRepository;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.anticorruption.GameEveMetagroupRepository;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.entity.GameEveMetagroupAggregate;

import java.util.Optional;

/**
 * GameEveMetagroupQueryRepository
 * <p>游戏EVE元分组聚合查询仓储接口
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetagroupRepository
 * @see TianyanMetadataQueryRepository
 * @since 0.0.1
 */
public interface GameEveMetagroupQueryRepository extends GameEveMetagroupRepository, TianyanMetadataQueryRepository<GameEveMetagroupAggregate> {

    Optional<String> findMetagroupIdByCode(String gameEveMetagroupCode);
}
