package org.endless.fanli.component.game.eve.metadata.domain.model.group;

import org.springframework.stereotype.Component;

/**
 * GameEveGroupRemoteDataTask
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 22:08
 * <p>update 2024/2/4 22:08
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Component
public class GameEveGroupRemoteDataTask {

    private final GameEveGroupRemoteDataAdapter remoteData;
    private final GameEveGroupRepository repository;

    public GameEveGroupRemoteDataTask(GameEveGroupRemoteDataAdapter remoteData, GameEveGroupRepository repository) {
        this.remoteData = remoteData;
        this.repository = repository;
    }

    public void run(String groupId) {

        try {
            repository.save(remoteData.getGroupByGroupId(groupId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
