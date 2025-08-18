package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;

import java.util.List;

/**
 * GameEveDataFileBlueprintActivityRespDTransfer
 * <p>游戏EVE数据文件蓝图工序被动响应传输对象
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
@JSONType(orders = {"time", "materials", "products", "skills"})
public class GameEveDataFileBlueprintActivityRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 工序耗时
     */
    private final Long time;

    /**
     * 工序物料列表
     */
    private final List<GameEveDataFileBlueprintMaterialRespDTransfer> materials;

    /**
     * 工序产品列表
     */
    private final List<GameEveDataFileBlueprintProductRespDTransfer> products;

    /**
     * 工序技能列表
     */
    private final List<GameEveDataFileBlueprintSkillRespDTransfer> skills;

    @Override
    public GameEveDataFileBlueprintActivityRespDTransfer validate() {
        validateTime();
        return this;
    }

    private void validateTime() {
        if (time == null || time < 0) {
            throw new DrivenRespTransferValidateException("工序耗时不能为 null 或小于 0，当前值为: " + time);
        }
    }
}
