package org.endless.tianyan.item.components.item.game.eve.domain.anticorruption;

import org.endless.tianyan.item.common.model.domain.anticorruption.TianyanItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;

import java.util.Optional;

/**
 * GameEveItemDrivenAdapter
 * <p>
 * create 2025/07/28 04:44
 * <p>
 * update 2025/07/28 04:44
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivenAdapter
 * @since 2.0.0
 */
public interface GameEveItemDrivenAdapter extends TianyanItemDrivenAdapter {

    Optional<GameEveItemAggregate> fetch(String code, String createUserId);
}
