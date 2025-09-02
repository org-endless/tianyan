package org.endless.tianyan.item.components.item.game.eve.group.application.query.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.group.domain.anticorruption.GameEveItemGroupRepository;
import org.endless.tianyan.item.components.item.game.eve.group.domain.entity.GameEveItemGroupAggregate;

import java.util.Optional;

/**
 * GameEveItemGroupQueryRepository
 * <p>游戏EVE资源项分组聚合查询仓储接口
 * <p>
 * itemCreate 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see GameEveItemGroupRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemGroupQueryRepository extends GameEveItemGroupRepository, TianyanItemQueryRepository<GameEveItemGroupAggregate> {

    Optional<String> findItemGroupIdByCode(
            @NotBlank(message = "游戏EVE资源项分组编码不能为空") String gameEveItemGroupCode);
}
