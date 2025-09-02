package org.endless.tianyan.item.components.item.game.eve.category.application.query.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.tianyan.item.common.model.application.query.anticorruption.TianyanItemQueryRepository;
import org.endless.tianyan.item.components.item.game.eve.category.domain.anticorruption.GameEveItemCategoryRepository;
import org.endless.tianyan.item.components.item.game.eve.category.domain.entity.GameEveItemCategoryAggregate;

import java.util.Optional;

/**
 * GameEveItemCategoryQueryRepository
 * <p>游戏EVE资源项分类聚合查询仓储接口
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see GameEveItemCategoryRepository
 * @see TianyanItemQueryRepository
 * @since 0.0.1
 */
public interface GameEveItemCategoryQueryRepository extends GameEveItemCategoryRepository, TianyanItemQueryRepository<GameEveItemCategoryAggregate> {

    Optional<String> findItemCategoryIdByCode(
            @NotBlank(message = "游戏EVE资源项分类编码不能为空") String gameEveItemCategoryCode);
}
