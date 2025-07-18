package org.endless.fanli.component.game.eve.market.infrastructure.persistence.market;

import org.endless.fanli.component.game.eve.domain.common.type.GameEveRepository;
import org.endless.fanli.component.game.eve.market.domain.model.order.Market;
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
        implements GameEveRepository<Market> {

    private final GameEveMarketMongoJpaRepository jpaRepository;

    private final MongoTemplate mongoTemplate;

    public GameEveMarketMongoRepository(GameEveMarketMongoJpaRepository jpaRepository, MongoTemplate mongoTemplate) {
        this.jpaRepository = jpaRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Market entity) {
        jpaRepository.save(GameEveMarketDocument.builder().build().fromEntity(entity));
    }
}
