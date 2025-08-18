package org.endless.tianyan.finance.components.profit.estimate.sidecar.rest;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.finance.common.model.sidecar.rest.TianyanFinanceRestController;
import org.endless.tianyan.finance.components.profit.estimate.application.command.transfer.ProfitEstimateGenerateReqCTransfer;
import org.endless.tianyan.finance.components.profit.estimate.facade.adapter.ProfitEstimateDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * ProfitEstimateRestController
 * <p>预估利润领域Rest控制器
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/profit/estimate")
public class ProfitEstimateRestController implements TianyanFinanceRestController {

    /**
     * 预估利润领域主动适配器
     */
    private final ProfitEstimateDrivingAdapter profitEstimateDrivingAdapter;

    public ProfitEstimateRestController(ProfitEstimateDrivingAdapter profitEstimateDrivingAdapter) {
        this.profitEstimateDrivingAdapter = profitEstimateDrivingAdapter;
    }

    @PostMapping("/command/generate")
    @Log(message = "预估利润生成", value = "#command")
    public ResponseEntity<RestResponse> generate(@RequestBody ProfitEstimateGenerateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(ProfitEstimateGenerateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("预估利润生成参数不能为空"));
        profitEstimateDrivingAdapter.generate(command);
        return response().success("预估利润生成成功");
    }
}
