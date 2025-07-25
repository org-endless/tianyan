package org.endless.tianyan.item.components.item.item.sidecar.rest;

import org.endless.tianyan.item.common.model.sidecar.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.item.facade.adapter.ItemDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemRestController
 * <p>资源项领域Rest控制器
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item")
public class ItemRestController implements TianyanItemRestController {

    /**
     * 资源项领域主动适配器
     */
    private final ItemDrivingAdapter itemDrivingAdapter;

    public ItemRestController(ItemDrivingAdapter itemDrivingAdapter) {
        this.itemDrivingAdapter = itemDrivingAdapter;
    }
}
