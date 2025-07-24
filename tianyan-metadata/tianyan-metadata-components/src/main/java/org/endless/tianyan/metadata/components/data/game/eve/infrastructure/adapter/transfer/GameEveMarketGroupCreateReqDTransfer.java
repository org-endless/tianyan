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
 * GameEveMarketGroupCreateReqDTransfer
 * <p>游戏EVE市场分组创建命令被动请求传输对象
 * <p>
 * create 2025/07/24 10:37
 * <p>
 * update 2025/07/24 10:37
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZhFullName", "nameEnFullName", "parentCode", "createUserId"})
public class GameEveMarketGroupCreateReqDTransfer implements TianyanMetadataDrivenTransfer {

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
    public GameEveMarketGroupCreateReqDTransfer validate() {
        validateCode();
        validateNameZhFullName();
        validateNameEnFullName();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenTransferValidateException("游戏EVE市场分组编码不能为空");
        }
    }

    private void validateNameZhFullName() {
        if (!StringUtils.hasText(nameZhFullName)) {
            throw new DrivenTransferValidateException("中文全称不能为空");
        }
    }

    private void validateNameEnFullName() {
        if (!StringUtils.hasText(nameEnFullName)) {
            throw new DrivenTransferValidateException("英文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenTransferValidateException("创建用户ID不能为空");
        }
    }
}
