package org.endless.fanli.component.game.eve.domain.group;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.endless.fanli.component.game.eve.domain.common.type.GameEveEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * GameEveGroupAggregateRoot
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 21:48
 * <p>update 2024/2/4 21:48
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Slf4j
@Getter
@Builder
@ToString
public class GameEveGroupAggregateRoot
        implements GameEveGroupAggregate, GameEveEntity {

    private List<String> gameEveGroups;

    private final GameEveGroupRemoteDataAdapter remoteDataAdapter;

    private final GameEveGroupRemoteDataTask remoteDataTask;

    public GameEveGroupAggregateRoot(List<String> gameEveGroups, GameEveGroupRemoteDataAdapter remoteDataAdapter, GameEveGroupRemoteDataTask remoteDataTask) {
        this.gameEveGroups = gameEveGroups;
        this.remoteDataAdapter = remoteDataAdapter;
        this.remoteDataTask = remoteDataTask;
    }

    @Override
    public void addGroup(String groupId) {

        if (gameEveGroups == null) {
            gameEveGroups = new ArrayList<>();
        }
        gameEveGroups.add(groupId);
    }

    @Override
    public void getRemoteData() {

        if (gameEveGroups == null) {
            log.error("");
        }

    }
}
