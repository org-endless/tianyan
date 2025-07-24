package org.endless.tianyan.manufacturing.components.blueprint.blueprint.application.command.transfer;

import org.endless.tianyan.manufacturing.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.manufacturing.components.blueprint.blueprint.domain.type.*;
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
 * BlueprintSkillReqCTransfer
 * <p>蓝图技能命令请求传输对象
 * <p>
 * create 2025/07/24 10:44
 * <p>
 * update 2025/07/24 10:44
 *
 * @author Deng Haozhi
 * @see TianyanManufacturingCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "level"})
public class BlueprintSkillReqCTransfer implements TianyanManufacturingCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 蓝图技能等级
     */
    private final String level;

    @Override
    public BlueprintSkillReqCTransfer validate() {
        validateItemId();
        validateLevel();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateLevel() {
        if (!StringUtils.hasText(level)) {
            throw new CommandTransferValidateException("蓝图技能等级不能为空");
        }
    }
}
