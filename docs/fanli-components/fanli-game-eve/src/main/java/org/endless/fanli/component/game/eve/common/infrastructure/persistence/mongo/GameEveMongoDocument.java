package org.endless.fanli.component.game.eve.common.infrastructure.persistence.mongo;

import org.endless.fanli.component.game.eve.common.domain.model.GameEveEntity;
import org.endless.fanli.component.game.eve.common.infrastructure.persistence.GameEvePersistenceBoundary;

/**
 * GameEveMongoDocument
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/11 22:33
 * <p>update 2024/02/11 22:34
 *
 * @author Deng Haozhi
 * @see GameEvePersistenceBoundary
 * @since 0.0.6
 */
public interface GameEveMongoDocument<T extends GameEveEntity> extends GameEvePersistenceBoundary<T> {
}
