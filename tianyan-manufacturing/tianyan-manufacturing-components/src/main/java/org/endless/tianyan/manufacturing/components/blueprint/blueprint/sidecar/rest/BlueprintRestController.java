package org.endless.tianyan.manufacturing.components.blueprint.blueprint.sidecar.rest;

import org.endless.tianyan.manufacturing.common.model.sidecar.rest.*;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BlueprintRestController
 * <p>蓝图领域Rest控制器
 * <p>
 * create 2025/07/23 17:17
 * <p>
 * update 2025/07/23 17:17
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/blueprint")
public class BlueprintRestController implements TianyanManufacturingRestController {

    /**
     * 蓝图领域主动适配器
     */
    private final BlueprintDrivingAdapter blueprintDrivingAdapter;

    public BlueprintRestController(BlueprintDrivingAdapter blueprintDrivingAdapter) {
        this.blueprintDrivingAdapter = blueprintDrivingAdapter;
    }
}
