package org.endless.tianyan.sales.components.market.group.game.eve.application.command.transfer;

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
 * create 2025/07/24 20:33
 * <p>
 * update 2025/07/24 20:33
 *
 * @author Deng Haozhi
 * @see TianyanSalesCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "fullNameZh", "fullNameEn", "parentCode", "createUserId"})
public class GameEveMarketGroupCreateReqCTransfer implements TianyanSalesCommandTransfer {

    /**
     * 游戏EVE市场分组编码
     */
    private final String code;

    /**
     * 市场分组中文全称
     */
    private final String fullNameZh;

    /**
     * 市场分组英文全称
     */
    private final String fullNameEn;

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
        validateFullNameZh();
        validateFullNameEn();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE市场分组编码不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandTransferValidateException("市场分组中文全称不能为空");
        }
    }

    private void validateFullNameEn() {
        if (!StringUtils.hasText(fullNameEn)) {
            throw new CommandTransferValidateException("市场分组英文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
