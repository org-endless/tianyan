package org.endless.fanli.component.game.eve.domain.common.type;

/**
 * RemoteData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/04 16:31
 * <p>update 2024/02/04 16:32
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface RemoteData<T extends Entity> {
    T toEntity();
}
