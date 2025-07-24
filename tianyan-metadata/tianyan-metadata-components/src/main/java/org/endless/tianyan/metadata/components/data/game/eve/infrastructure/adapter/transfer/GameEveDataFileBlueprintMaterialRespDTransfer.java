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
 * GameEveDataFileBlueprintMaterialRespDTransfer
 * <p>游戏EVE数据文件蓝图物料被动响应传输对象
 * <p>
 * create 2025/07/24 19:53
 * <p>
 * update 2025/07/24 19:53
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"quantity", "typeID"})
public class GameEveDataFileBlueprintMaterialRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 蓝图物料数量
     */
    private final Long quantity;

    /**
     * 资源项编码
     */
    private final String typeID;

    @Override
    public GameEveDataFileBlueprintMaterialRespDTransfer validate() {
        validateQuantity();
        validateTypeID();
        return this;
    }

    private void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new DrivenTransferValidateException("蓝图物料数量不能为 null 或小于 0，当前值为: " + quantity);
        }
    }

    private void validateTypeID() {
        if (!StringUtils.hasText(typeID)) {
            throw new DrivenTransferValidateException("资源项编码不能为空");
        }
    }
}
