package org.endless.tianyan.item.components.item.item.sidecar.rest;

import org.endless.tianyan.item.common.model.sidecar.rest.*;
import org.endless.tianyan.item.components.item.item.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemRestController
 * <p>物品领域Rest控制器
 * <p>
 * create 2025/07/19 07:15
 * <p>
 * update 2025/07/19 07:15
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/item")
public class ItemRestController implements TianyanItemRestController {

    /**
     * 物品领域主动适配器
     */
    private final ItemDrivingAdapter itemDrivingAdapter;

    public ItemRestController(ItemDrivingAdapter itemDrivingAdapter) {
        this.itemDrivingAdapter = itemDrivingAdapter;
    }
}
