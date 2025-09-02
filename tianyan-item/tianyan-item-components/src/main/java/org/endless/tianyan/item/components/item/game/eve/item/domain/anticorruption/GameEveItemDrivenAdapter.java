package org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.tianyan.item.common.model.domain.anticorruption.TianyanItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;

import java.util.Optional;

/**
 * GameEveItemDrivenAdapter
 * <p>
 * create 2025/08/27 22:12
 * <p>
 * update 2025/08/27 22:12
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivenAdapter
 * @since 1.0.0
 */
public interface GameEveItemDrivenAdapter extends TianyanItemDrivenAdapter {

    Optional<GameEveItemAggregate> fetch(
            @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
            @NotBlank(message = "创建用户ID不能为空") String createUserId);
}
