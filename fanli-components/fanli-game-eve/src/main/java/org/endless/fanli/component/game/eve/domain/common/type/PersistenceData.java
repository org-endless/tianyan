package org.endless.fanli.component.game.eve.domain.common.type;

/**
 * PersistenceData
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 19:16
 * <p>update 2024/02/06 19:16
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface PersistenceData<T extends Entity> {
    T toEntity();

    PersistenceData<T> fromEntity(T entity);
}
