package org.endless.fanli.component.game.eve.metadata.domain.model.group;


import org.endless.fanli.component.game.eve.common.domain.model.GameEveRepository;

/**
 * GameEveGroupRepository
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 22:20
 * <p>update 2024/2/4 22:20
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveGroupRepository extends GameEveRepository<GameEveGroup> {
    void save(GameEveGroup groupByGroupId);
}
