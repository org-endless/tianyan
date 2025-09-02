package org.endless.tianyan.sales.components.market.game.eve.order.domain.anticorruption;

import jakarta.validation.constraints.NotBlank;
import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesDrivenAdapter;
import org.endless.tianyan.sales.components.market.game.eve.order.domain.entity.GameEveMarketOrderAggregate;

import java.util.List;

/**
 * GameEveMarketOrderDrivenAdapter
 * <p>
 * create 2025/07/25 12:15
 * <p>
 * update 2025/07/25 12:16
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenAdapter
 * @since 0.0.1
 */
public interface GameEveMarketOrderDrivenAdapter extends TianyanSalesDrivenAdapter {

    /**
     * 获取游戏EVE市场订单列表
     *
     * @param gameEveItemCode 游戏EVE资源项编码
     * @param createUserId    创建用户ID
     * @return {@link List }<{@link GameEveMarketOrderAggregate }>
     */
    List<GameEveMarketOrderAggregate> fetch(
            @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
            @NotBlank(message = "创建用户ID不能为空") String createUserId);

    /**
     * 游戏EVE市场订单生成价格
     *
     * @param gameEveItemCode 游戏EVE资源项编码
     * @param createUserId    创建用户ID
     * @return {@link List }<{@link GameEveMarketOrderAggregate }>
     */
    void generatePrice(
            @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode,
            @NotBlank(message = "创建用户ID不能为空") String createUserId);
}
