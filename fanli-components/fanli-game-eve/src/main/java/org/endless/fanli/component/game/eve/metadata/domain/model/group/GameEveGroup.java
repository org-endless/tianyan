package org.endless.fanli.component.game.eve.metadata.domain.model.group;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.fanli.component.game.eve.domain.common.type.GameEveEntity;

import java.util.List;

/**
 * GameEveGroup
 * <p>
 * <p>
 * <p>
 * <p>create 2024/2/4 18:10
 * <p>update 2024/2/4 18:10
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Getter
@Builder
@ToString
public class GameEveGroup implements GameEveEntity {

    private String groupId;
    private String categoryId;
    private String groupName;
    private boolean published;
    private List<String> items;
}
