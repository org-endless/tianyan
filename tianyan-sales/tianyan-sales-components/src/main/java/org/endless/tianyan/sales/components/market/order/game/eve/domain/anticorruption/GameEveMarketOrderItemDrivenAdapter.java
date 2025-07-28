package org.endless.tianyan.sales.components.market.order.game.eve.domain.anticorruption;

import org.endless.tianyan.sales.common.model.domain.anticorruption.TianyanSalesDrivenAdapter;

import java.util.Optional;

/**
 * GameEveMarketOrderItemDrivenAdapter
 * <p>
 * create 2025/07/26 03:39
 * <p>
 * update 2025/07/26 03:39
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenAdapter
 * @since 0.0.1
 */
public interface GameEveMarketOrderItemDrivenAdapter extends TianyanSalesDrivenAdapter {

    Optional<String> fetch(String code, String createUserID);
}
