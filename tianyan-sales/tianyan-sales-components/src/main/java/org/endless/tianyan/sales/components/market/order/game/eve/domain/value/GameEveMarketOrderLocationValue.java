package org.endless.tianyan.sales.components.market.order.game.eve.domain.value;

import org.endless.tianyan.sales.common.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.value.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * GameEveMarketOrderLocationValue
 * <p>游戏EVE市场订单空间站
 * <p>
 * create 2025/07/25 11:19
 * <p>
 * update 2025/07/25 11:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesValue
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveMarketOrderLocationValue implements TianyanSalesValue {

    /**
     * 游戏EVE市场订单空间站编码
     */
    private final String code;

    /**
     * 游戏EVE市场订单空间站中文名称
     */
    private final String nameZh;

    public static GameEveMarketOrderLocationValue create(GameEveMarketOrderLocationValueBuilder builder) {
        return builder
            .innerBuild()
            .validate();
    }

    @Override
    public GameEveMarketOrderLocationValue validate() {
        validateCode();
        validateNameZh();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new ValueValidateException("游戏EVE市场订单空间站编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new ValueValidateException("游戏EVE市场订单空间站中文名称不能为空");
        }
    }
}
