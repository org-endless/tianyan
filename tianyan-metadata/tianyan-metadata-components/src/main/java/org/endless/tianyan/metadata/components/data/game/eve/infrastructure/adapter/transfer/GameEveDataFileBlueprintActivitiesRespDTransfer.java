package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;

/**
 * GameEveDataFileBlueprintActivitiesRespDTransfer
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
@JSONType(orders = {"copying", "invention", "manufacturing", "research_material", "research_time"})
public class GameEveDataFileBlueprintActivitiesRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 复制工序
     */
    private final GameEveDataFileBlueprintActivityRespDTransfer copying;

    /**
     * 研发工艺
     */
    private final GameEveDataFileBlueprintActivityRespDTransfer invention;

    /**
     * 生产工序
     */
    private final GameEveDataFileBlueprintActivityRespDTransfer manufacturing;

    /**
     * 物流研究工序
     */
    private final GameEveDataFileBlueprintActivityRespDTransfer research_material;

    /**
     * 周期研究工序
     */
    private final GameEveDataFileBlueprintActivityRespDTransfer research_time;

    @Override
    public GameEveDataFileBlueprintActivitiesRespDTransfer validate() {
        validateCopying();
        validateInvention();
        validateManufacturing();
        validateResearch_material();
        validateResearch_time();
        return this;
    }

    private void validateCopying() {
        if (copying == null) {
            throw new DrivenRespTransferValidateException("复制工序不能为 null ");
        }
    }

    private void validateInvention() {
        if (invention == null) {
            throw new DrivenRespTransferValidateException("研发工艺不能为 null ");
        }
    }

    private void validateManufacturing() {
        if (manufacturing == null) {
            throw new DrivenRespTransferValidateException("生产工序不能为 null ");
        }
    }

    private void validateResearch_material() {
        if (research_material == null) {
            throw new DrivenRespTransferValidateException("物流研究工序不能为 null ");
        }
    }

    private void validateResearch_time() {
        if (research_time == null) {
            throw new DrivenRespTransferValidateException("周期研究工序不能为 null ");
        }
    }
}
