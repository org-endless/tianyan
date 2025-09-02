package org.endless.tianyan.item.components.item.game.eve.item.application.query.anticorruption;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption.GameEveItemRepository;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;

import java.util.List;
import java.util.Optional;

/**
 * GameEveItemQueryRepository
 * <p>游戏EVE资源项聚合查询仓储接口
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see GameEveItemRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemQueryRepository extends GameEveItemRepository, TianyanItemQueryRepository<GameEveItemAggregate> {


    List<String> findItemIdsByCodes(
            @NotEmpty(message = "游戏EVE资源项编码列表不能为空") List<String> gameEveItemCodes);

    Optional<String> findCodeByItemId(
            @NotBlank(message = "资源项ID不能为空") String itemId);
}
