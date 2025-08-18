package org.endless.tianyan.finance.components.cost.type.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.finance.common.model.application.command.transfer.TianyanFinanceCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * CostTypeCreateReqCTransfer
 * <p>成本类型创建命令请求传输对象
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see TianyanFinanceCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZh", "nameEn", "description", "createUserId"})
public class CostTypeCreateReqCTransfer implements TianyanFinanceCommandTransfer {

    /**
     * 成本类型编码
     */
    private final String code;

    /**
     * 成本类型中文名称
     */
    private final String nameZh;

    /**
     * 成本类型英文名称
     */
    private final String nameEn;

    /**
     * 成本类型描述
     */
    private final String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public CostTypeCreateReqCTransfer validate() {
        validateCode();
        validateNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandReqTransferValidateException("成本类型编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandReqTransferValidateException("成本类型中文名称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
