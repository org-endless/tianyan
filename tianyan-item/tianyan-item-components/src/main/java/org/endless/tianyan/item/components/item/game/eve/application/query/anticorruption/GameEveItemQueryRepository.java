package org.endless.tianyan.item.components.item.game.eve.application.query.anticorruption;

import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;

import java.util.List;
import java.util.Optional;

/**
 * GameEveItemQueryRepository
 * <p>游戏EVE资源项聚合查询仓储接口
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see GameEveItemRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemQueryRepository extends GameEveItemRepository, TianyanItemQueryRepository<GameEveItemAggregate> {


    List<String> findItemIdsByCodes(List<String> codes);

    Optional<String> findCodeByItemId(String itemId);
}
