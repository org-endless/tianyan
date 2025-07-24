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
 * GameEveDataFileBlueprintSkillRespDTransfer
 * <p>游戏EVE数据文件蓝图技能被动响应传输对象
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
@JSONType(orders = {"level", "typeID"})
public class GameEveDataFileBlueprintSkillRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 技能等级
     */
    private final String level;

    /**
     * 技能资源项编码
     */
    private final String typeID;

    @Override
    public GameEveDataFileBlueprintSkillRespDTransfer validate() {
        validateLevel();
        validateTypeID();
        return this;
    }

    private void validateLevel() {
        if (!StringUtils.hasText(level)) {
            throw new DrivenTransferValidateException("技能等级不能为空");
        }
    }

    private void validateTypeID() {
        if (!StringUtils.hasText(typeID)) {
            throw new DrivenTransferValidateException("技能资源项编码不能为空");
        }
    }
}
