package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar;

import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.blueprint.TianyanSidecarBlueprintConfiguration;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.TianyanSidecarItemConfiguration;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.TianyanSidecarMarketConfiguration;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.TianyanSidecarMetagroupConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * TianyanCommonSidecarAutoConfiguration
 * <p>
 * create 2025/08/24 18:59
 * <p>
 * update 2025/08/24 18:59
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@AutoConfiguration
@Import({
        TianyanSidecarBlueprintConfiguration.class,
        TianyanSidecarItemConfiguration.class,
        TianyanSidecarMarketConfiguration.class,
        TianyanSidecarMetagroupConfiguration.class,
})
public class TianyanSidecarAutoConfiguration {

}
