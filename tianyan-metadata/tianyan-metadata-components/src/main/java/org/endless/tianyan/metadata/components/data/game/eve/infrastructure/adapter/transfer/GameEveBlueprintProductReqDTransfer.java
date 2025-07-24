package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GameEveBlueprintProductReqDTransfer
 * <p>游戏EVE蓝图产品命令被动请求传输对象
 * <p>
 * create 2025/07/24 17:12
 * <p>
 * update 2025/07/24 17:12
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "quantity", "successRate"})
public class GameEveBlueprintProductReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图产品数量
     */
    private final Long quantity;

    /**
     * 产品成功率(8, 5)
     */
    private final String successRate;

    @Override
    public GameEveBlueprintProductReqDTransfer validate() {
        validateItemId();
        validateQuantity();
        validateSuccessRate();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DrivenTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new DrivenTransferValidateException("蓝图产品数量不能为 null 或小于 0，当前值为: " + quantity);
        }
    }

    private void validateSuccessRate() {
        if (successRate != null) {
            Decimal.validateRate(successRate);
        }
    }
}
