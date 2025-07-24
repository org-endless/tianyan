package org.endless.tianyan.item.components.item.category.game.eve.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer.GameEveItemCategoryCreateReqCTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindIdRespQTransfer;

/**
 * GameEveItemCategoryDrivingAdapter
 * <p>游戏EVE资源项分类领域主动适配器
 * <p>
 * create 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveItemCategoryDrivingAdapter extends TianyanItemDrivingAdapter {


    void create(GameEveItemCategoryCreateReqCTransfer command);

    GameEveItemCategoryFindIdRespQTransfer findItemCategoryIdByCode(GameEveItemCategoryFindByCodeReqQTransfer query);

}
