package org.endless.tianyan.item.components.item.category.game.eve.facade.adapter;

import org.endless.tianyan.item.common.model.facade.adapter.TianyanItemDrivingAdapter;
import org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer.GameEveItemCategoryCreateReqCReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindByCodeReqQReqTransfer;
import org.endless.tianyan.item.components.item.category.game.eve.application.query.transfer.GameEveItemCategoryFindIdRespQReqTransfer;

/**
 * GameEveItemCategoryDrivingAdapter
 * <p>游戏EVE资源项分类领域主动适配器
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveItemCategoryDrivingAdapter extends TianyanItemDrivingAdapter {


    void create(GameEveItemCategoryCreateReqCReqTransfer command);

    GameEveItemCategoryFindIdRespQReqTransfer findItemCategoryIdByCode(GameEveItemCategoryFindByCodeReqQReqTransfer query);

}
