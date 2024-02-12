package org.endless.fanli.common.infrastructure.adapter;

import org.endless.fanli.common.domain.model.Value;

/**
 * AdaptationBoundary
 * <p>
 * <p>
 * <p>
 * <p>create 2024/02/04 16:31
 * <p>update 2024/02/04 16:32
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
public interface AdaptationBoundary<T extends Value> {
    T toEntity();
}
