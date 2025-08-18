package org.endless.tianyan.item.components.item.category.item.category.sidecar.rest;

import org.endless.tianyan.item.common.model.facade.rest.TianyanItemRestController;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.ItemCategoryDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemCategoryRestController
 * <p>资源项分类领域Rest控制器
 * <p>
 * create 2025/07/21 15:11
 * <p>
 * update 2025/07/21 15:11
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item/category")
public class ItemCategoryRestController implements TianyanItemRestController {

    /**
     * 资源项分类领域主动适配器
     */
    private final ItemCategoryDrivingAdapter itemCategoryDrivingAdapter;

    public ItemCategoryRestController(ItemCategoryDrivingAdapter itemCategoryDrivingAdapter) {
        this.itemCategoryDrivingAdapter = itemCategoryDrivingAdapter;
    }
}
