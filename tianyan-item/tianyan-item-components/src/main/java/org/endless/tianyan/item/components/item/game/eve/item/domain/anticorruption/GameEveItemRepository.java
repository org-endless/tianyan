package org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.tianyan.item.common.model.domain.anticorruption.TianyanItemRepository;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;

import java.util.Optional;

/**
 * GameEveItemRepository
 * <p>游戏EVE资源项聚合仓储接口
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRepository
 * @since 0.0.1
 */
public interface GameEveItemRepository extends TianyanItemRepository<GameEveItemAggregate> {

    Optional<String> findItemIdByCode(
            @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode);
}
