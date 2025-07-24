package org.endless.tianyan.sales.components.market.group.game.eve.facade.adapter;

import org.endless.tianyan.sales.common.model.facade.adapter.TianyanSalesDrivingAdapter;
import org.endless.tianyan.sales.components.market.group.game.eve.application.command.transfer.GameEveMarketGroupCreateReqCTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindByCodeReqQTransfer;
import org.endless.tianyan.sales.components.market.group.game.eve.application.query.transfer.GameEveMarketGroupFindIdRespQTransfer;

/**
 * GameEveMarketGroupDrivingAdapter
 * <p>游戏EVE市场分组领域主动适配器
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivingAdapter
 * @since 0.0.1
 */
public interface GameEveMarketGroupDrivingAdapter extends TianyanSalesDrivingAdapter {

    void create(GameEveMarketGroupCreateReqCTransfer command);

    GameEveMarketGroupFindIdRespQTransfer findMarketGroupIdByCode(GameEveMarketGroupFindByCodeReqQTransfer query);
}
