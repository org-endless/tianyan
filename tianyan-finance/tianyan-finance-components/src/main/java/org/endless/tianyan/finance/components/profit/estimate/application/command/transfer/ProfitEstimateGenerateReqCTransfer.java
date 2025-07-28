package org.endless.tianyan.finance.components.profit.estimate.application.command.transfer;

import org.endless.tianyan.finance.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.finance.components.profit.estimate.domain.type.*;
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
 * ProfitEstimateGenerateReqCTransfer
 * <p>预估利润生成命令请求传输对象
 * <p>
 * create 2025/07/28 19:37
 * <p>
 * update 2025/07/28 19:37
 *
 * @author Deng Haozhi
 * @see TianyanFinanceCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"itemId", "industryId", "eventTypeId"})
public class ProfitEstimateGenerateReqCTransfer implements TianyanFinanceCommandTransfer {

    /**
     * 资源项ID
     */
    private final String itemId;

    /**
     * 行业ID
     */
    private final String industryId;

    /**
     * 事件类型ID
     */
    private final String eventTypeId;

    @Override
    public ProfitEstimateGenerateReqCTransfer validate() {
        validateItemId();
        validateIndustryId();
        validateEventTypeId();
        return this;
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new CommandTransferValidateException("资源项ID不能为空");
        }
    }

    private void validateIndustryId() {
        if (!StringUtils.hasText(industryId)) {
            throw new CommandTransferValidateException("行业ID不能为空");
        }
    }

    private void validateEventTypeId() {
        if (!StringUtils.hasText(eventTypeId)) {
            throw new CommandTransferValidateException("事件类型ID不能为空");
        }
    }
}
