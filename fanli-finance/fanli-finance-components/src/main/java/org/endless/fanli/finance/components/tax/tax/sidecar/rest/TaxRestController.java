package org.endless.fanli.finance.components.tax.tax.sidecar.rest;

import org.endless.fanli.finance.common.model.sidecar.rest.*;
import org.endless.fanli.finance.components.tax.tax.facade.adapter.*;
import org.endless.ddd.simplified.starter.common.exception.model.sidecar.rest.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaxRestController
 * <p>税务领域Rest控制器
 * <p>
 * create 2025/07/19 04:31
 * <p>
 * update 2025/07/19 04:31
 *
 * @author Deng Haozhi
 * @see FanliFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/tax/tax")
public class TaxRestController implements FanliFinanceRestController {

    /**
     * 税务领域主动适配器
     */
    private final TaxDrivingAdapter taxDrivingAdapter;

    public TaxRestController(TaxDrivingAdapter taxDrivingAdapter) {
        this.taxDrivingAdapter = taxDrivingAdapter;
    }
}
