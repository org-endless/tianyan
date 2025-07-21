package org.endless.tianyan.item.components.item.category.item.category.sidecar.rest;

import org.endless.tianyan.item.common.model.sidecar.rest.*;
import org.endless.tianyan.item.components.item.category.item.category.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemCategoryRestController
 * <p>物品分类领域Rest控制器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/item.category/item/category")
public class ItemCategoryRestController implements TianyanItemRestController {

    /**
     * 物品分类领域主动适配器
     */
    private final ItemCategoryDrivingAdapter itemCategoryDrivingAdapter;

    public ItemCategoryRestController(ItemCategoryDrivingAdapter itemCategoryDrivingAdapter) {
        this.itemCategoryDrivingAdapter = itemCategoryDrivingAdapter;
    }
}
