package org.endless.tianyan.metadata.components.event.type.application.command.transfer;

import org.endless.tianyan.metadata.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.event.type.domain.value.*;
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
 * EventTypeCreateReqCTransfer
 * <p>事件类型创建命令请求传输对象
 * <p>
 * create 2025/07/28 18:46
 * <p>
 * update 2025/07/28 18:46
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZh", "nameEn", "description", "createUserId"})
public class EventTypeCreateReqCTransfer implements TianyanMetadataCommandTransfer {

    /**
     * 事件类型编码
     */
    private final String code;

    /**
     * 事件类型中文名称
     */
    private final String nameZh;

    /**
     * 事件类型英文名称
     */
    private final String nameEn;

    /**
     * 事件类型描述
     */
    private final String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public EventTypeCreateReqCTransfer validate() {
        validateCode();
        validateNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("事件类型编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandTransferValidateException("事件类型中文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
