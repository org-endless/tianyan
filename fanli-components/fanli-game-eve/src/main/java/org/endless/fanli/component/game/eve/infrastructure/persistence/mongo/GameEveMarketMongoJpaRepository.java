package org.endless.fanli.component.game.eve.infrastructure.persistence.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * GameEveMarketMongoJpaRepository
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 18:57
 * <p>update 2024/02/06 18:57
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface GameEveMarketMongoJpaRepository
        extends MongoRepository<GameEveMarketDocument, String> {
}
