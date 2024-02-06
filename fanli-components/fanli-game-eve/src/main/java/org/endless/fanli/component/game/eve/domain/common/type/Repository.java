package org.endless.fanli.component.game.eve.domain.common.type;

/**
 * Repository
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 18:47
 * <p>update 2024/02/06 18:47
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface Repository<T extends Entity> {
    void save(T entity);
}
