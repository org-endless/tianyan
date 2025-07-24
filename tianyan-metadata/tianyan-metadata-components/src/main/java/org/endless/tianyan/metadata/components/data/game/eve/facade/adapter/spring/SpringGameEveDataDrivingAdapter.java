package org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.spring;

import org.endless.tianyan.metadata.components.data.game.eve.facade.adapter.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.command.handler.*;
import org.endless.tianyan.metadata.components.data.game.eve.application.query.handler.*;
import org.endless.ddd.simplified.starter.common.exception.model.facade.adapter.*;

/**
 * SpringGameEveDataDrivingAdapter
 * <p>游戏EVE数据领域主动适配器Spring实现类
 * <p>
 * create 2025/07/24 08:49
 * <p>
 * update 2025/07/24 08:49
 *
 * @author Deng Haozhi
 * @see GameEveDataDrivingAdapter
 * @since 0.0.1
 */
public class SpringGameEveDataDrivingAdapter implements GameEveDataDrivingAdapter {

    /**
     * 游戏EVE数据领域命令处理器
     */
    private final GameEveDataCommandHandler gameEveDataCommandHandler;

    /**
     * 游戏EVE数据领域查询处理器
     */
    private final GameEveDataQueryHandler gameEveDataQueryHandler;

    public SpringGameEveDataDrivingAdapter(GameEveDataCommandHandler gameEveDataCommandHandler, GameEveDataQueryHandler gameEveDataQueryHandler) {
        this.gameEveDataCommandHandler = gameEveDataCommandHandler;
        this.gameEveDataQueryHandler = gameEveDataQueryHandler;
    }
}
