package org.endless.tianyan.item.components.item.group.item.group.application.command.transfer;

import org.endless.tianyan.item.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.item.components.item.group.item.group.domain.value.*;
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
 * ItemGroupCreateReqCTransfer
 * <p>资源项分组创建命令请求传输对象
 * <p>
 * create 2025/07/21 16:19
 * <p>
 * update 2025/07/21 16:19
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"nameZh", "nameEn", "createUserId"})
public class ItemGroupCreateReqCTransfer implements TianyanItemCommandTransfer {

    /**
     * 中文名称
     */
    private final String nameZh;

    /**
     * 英文名称
     */
    private final String nameEn;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public ItemGroupCreateReqCTransfer validate() {
        validateNameZh();
        validateNameEn();
        validateCreateUserId();
        return this;
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandTransferValidateException("中文名称不能为空");
        }
    }

    private void validateNameEn() {
        if (!StringUtils.hasText(nameEn)) {
            throw new CommandTransferValidateException("英文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
