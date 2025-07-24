package org.endless.tianyan.manufacturing.components.blueprint.game.eve.application.command.transfer;

import org.endless.tianyan.manufacturing.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.manufacturing.components.blueprint.game.eve.domain.type.*;
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
 * GameEveBlueprintMaterialReqCTransfer
 * <p>游戏EVE蓝图物料命令请求传输对象
 * <p>
 * create 2025/07/24 09:48
 * <p>
 * update 2025/07/24 09:48
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "quantity"})
public class GameEveBlueprintMaterialReqCTransfer implements TianyanManufacturingCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图物料数量
     */
    private final Long quantity;

    @Override
    public GameEveBlueprintMaterialReqCTransfer validate() {
        validateItemId();
        validateQuantity();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new CommandTransferValidateException("蓝图物料数量不能为 null 或小于 0，当前值为: " + quantity);
        }
    }
}
