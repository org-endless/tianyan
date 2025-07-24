package org.endless.tianyan.sales.components.market.group.application.command.transfer;

import org.endless.tianyan.sales.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.sales.components.market.group.domain.value.*;
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
 * MarketGroupCreateReqCTransfer
 * <p>市场分组创建命令请求传输对象
 * <p>
 * create 2025/07/22 16:09
 * <p>
 * update 2025/07/22 16:09
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"nameZhFullName", "nameEnFullName", "parentId", "createUserId"})
public class MarketGroupCreateReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 中文全称
     */
    private final String nameZhFullName;

    /**
     * 英文全称
     */
    private final String nameEnFullName;

    /**
     * 父市场分组ID
     */
    private final String parentId;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public MarketGroupCreateReqCTransfer validate() {
        validateNameZhFullName();
        validateNameEnFullName();
        validateCreateUserId();
        return this;
    }

    private void validateNameZhFullName() {
        if (!StringUtils.hasText(nameZhFullName)) {
            throw new CommandTransferValidateException("中文全称不能为空");
        }
    }

    private void validateNameEnFullName() {
        if (!StringUtils.hasText(nameEnFullName)) {
            throw new CommandTransferValidateException("英文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
