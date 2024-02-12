package org.endless.fanli.common.infrastructure.persistence;

import org.endless.fanli.common.domain.model.Entity;

/**
 * PersistenceBoundary
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 19:16
 * <p>update 2024/02/06 19:16
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface PersistenceBoundary<T extends Entity> {
    T toEntity();

    PersistenceBoundary<T> fromEntity(T entity);
}
