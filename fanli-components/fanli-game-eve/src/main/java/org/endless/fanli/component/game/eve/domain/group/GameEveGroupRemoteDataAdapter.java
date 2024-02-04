package org.endless.fanli.component.game.eve.domain.group;

import java.util.List;

/**
 * GameEveGroupRemoteDataAdapter
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 18:17
 * <p>update 2024/2/4 18:17
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveGroupRemoteDataAdapter {
    List<String> getGroupIds(Integer page);

    GameEveGroup getGroupByGroupId(String groupId);
}
