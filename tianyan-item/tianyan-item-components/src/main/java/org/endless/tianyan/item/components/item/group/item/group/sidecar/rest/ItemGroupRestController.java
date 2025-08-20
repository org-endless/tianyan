package org.endless.tianyan.item.components.item.group.item.group.sidecar.rest;

import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.group.item.group.facade.adapter.ItemGroupDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemGroupRestController
 * <p>资源项分组领域Rest控制器
 * <p>
 * itemCreate 2025/07/21 16:04
 * <p>
 * update 2025/07/21 16:04
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/group")
public class ItemGroupRestController implements TianyanItemRestController {

    /**
     * 资源项分组领域主动适配器
     */
    private final ItemGroupDrivingAdapter itemGroupDrivingAdapter;

    public ItemGroupRestController(ItemGroupDrivingAdapter itemGroupDrivingAdapter) {
        this.itemGroupDrivingAdapter = itemGroupDrivingAdapter;
    }
}
