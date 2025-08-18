package org.endless.tianyan.item.common.model.domain.anticorruption;

import org.endless.ddd.starter.common.ddd.domain.anticorruption.Repository;
import org.endless.tianyan.item.common.model.domain.entity.TianyanItemAggregate;

/**
 * TianyanItemRepository
 * <p>
 * create 2024/02/06 18:47
 * <p>
 * update 2024/08/30 09:06
 *
 * @author Deng Haozhi
 * @see Repository
 * @since 0.0.1
 */
public interface TianyanItemRepository<A extends TianyanItemAggregate> extends Repository<A> {

}
