package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveDataFileBlueprintRespDTransfer
 * <p>游戏EVE数据文件蓝图被动响应传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"activities", "blueprintTypeID", "maxProductionLimit"})
public class GameEveDataFileBlueprintRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 工序
     */
    private final GameEveDataFileBlueprintActivitiesRespDTransfer activities;

    /**
     * 蓝图编码
     */
    private final String blueprintTypeID;

    /**
     * 最大生产次数
     */
    private final Integer maxProductionLimit;

    @Override
    public GameEveDataFileBlueprintRespDTransfer validate() {
        validateActivities();
        validateBlueprintTypeID();
        validateMaxProductionLimit();
        return this;
    }

    private void validateActivities() {
        if (activities == null) {
            throw new DrivenRespTransferValidateException("工序不能为 null ");
        }
    }

    private void validateBlueprintTypeID() {
        if (!StringUtils.hasText(blueprintTypeID)) {
            throw new DrivenRespTransferValidateException("蓝图编码不能为空");
        }
    }

    private void validateMaxProductionLimit() {
        if (maxProductionLimit == null || maxProductionLimit < 0) {
            throw new DrivenRespTransferValidateException("最大生产次数不能为 null 或小于 0，当前值为: " + maxProductionLimit);
        }
    }
}
