package org.endless.tianyan.sales.components.market.game.eve.group.application.command.transfer;

import org.endless.tianyan.sales.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
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
 * GameEveMarketGroupCreateReqCTransfer
 * <p>游戏EVE市场分组创建命令请求传输对象
 * <p>
 * create 2025/07/22 16:36
 * <p>
 * update 2025/07/22 16:36
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZhFullName", "nameEnFullName", "parentCode", "createUserId"})
public class GameEveMarketGroupCreateReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 游戏EVE市场分组编码
     */
    private final String code;

    /**
     * 中文全称
     */
    private final String nameZhFullName;

    /**
     * 英文全称
     */
    private final String nameEnFullName;

    /**
     * 父市场分组编码
     */
    private final String parentCode;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveMarketGroupCreateReqCTransfer validate() {
        validateCode();
        validateNameZhFullName();
        validateNameEnFullName();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE市场分组编码不能为空");
        }
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
