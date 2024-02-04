package org.endless.fanli.component.game.eve.domain.group;

/**
 * GameEveGroupAggregate
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 21:41
 * <p>update 2024/2/4 21:41
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveGroupAggregate {


    void addGroup(String groupId);

    void getRemoteData();
}
