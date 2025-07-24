package org.endless.tianyan.sales.components.market.game.eve.group.domain.anticorruption;

import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesRepository;
import org.endless.tianyan.sales.components.market.game.eve.group.domain.entity.GameEveMarketGroupAggregate;

import java.util.Optional;

/**
 * GameEveMarketGroupRepository
 * <p>游戏EVE市场分组聚合仓储接口
 * <p>
 * create 2025/07/22 09:09
 * <p>
 * update 2025/07/22 09:09
 *
 * @author Deng Haozhi
 * @see TianyanSalesRepository
 * @since 0.0.1
 */
public interface GameEveMarketGroupRepository extends TianyanSalesRepository<GameEveMarketGroupAggregate> {

    Optional<String> findMarketGroupIdByCode(String code);
}
