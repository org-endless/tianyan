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
 * GameEveDataFileBlueprintRespDTransfer
 * <p>游戏EVE数据文件蓝图被动响应传输对象
 * <p>
 * create 2025/07/24 10:31
 * <p>
 * update 2025/07/24 10:31
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"activities", "maxProductionLimit"})
public class GameEveDataFileBlueprintRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 工序
     */
    private final GameEveDataFileBlueprintActivitiesRespDTransfer activities;

    /**
     * 最大生产次数
     */
    private final Integer maxProductionLimit;

    @Override
    public GameEveDataFileBlueprintRespDTransfer validate() {
        validateActivities();
        validateMaxProductionLimit();
        return this;
    }

    private void validateActivities() {
        if (activities == null) {
            throw new DrivenTransferValidateException("工序不能为 null ");
        }
    }

    private void validateMaxProductionLimit() {
        if (maxProductionLimit == null || maxProductionLimit < 0) {
            throw new DrivenTransferValidateException("最大生产次数不能为 null 或小于 0，当前值为: " + maxProductionLimit);
        }
    }
}
