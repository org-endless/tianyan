package org.endless.fanli.component.game.eve.infrastructure.persistence.mongo;

import org.endless.fanli.component.game.eve.domain.common.type.GameEveRepository;
import org.endless.fanli.component.game.eve.domain.market.GameEveMarketAggregate;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * GameEveMarketMongoRepository
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/06 18:55
 * <p>update 2024/02/06 18:55
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public class GameEveMarketMongoRepository
        implements GameEveRepository<GameEveMarketAggregate> {

    private final GameEveMarketMongoJpaRepository jpaRepository;

    private final MongoTemplate mongoTemplate;

    public GameEveMarketMongoRepository(GameEveMarketMongoJpaRepository jpaRepository, MongoTemplate mongoTemplate) {
        this.jpaRepository = jpaRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(GameEveMarketAggregate aggregate) {

        jpaRepository.save(GameEveMarketDocument.builder().build().fromEntity(aggregate));
    }
}
