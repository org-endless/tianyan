package org.endless.tianyan.finance.components.taxation.tax.sidecar.rest;

import org.endless.tianyan.finance.common.model.sidecar.rest.TianyanFinanceRestController;
import org.endless.tianyan.finance.components.taxation.tax.facade.adapter.TaxDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaxRestController
 * <p>税务领域Rest控制器
 * <p>
 * create 2025/07/19 08:27
 * <p>
 * update 2025/07/19 08:27
 *
 * @author Deng Haozhi
 * @see TianyanFinanceRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/taxation/tax")
public class TaxRestController implements TianyanFinanceRestController {

    /**
     * 税务领域主动适配器
     */
    private final TaxDrivingAdapter taxDrivingAdapter;

    public TaxRestController(TaxDrivingAdapter taxDrivingAdapter) {
        this.taxDrivingAdapter = taxDrivingAdapter;
    }
}
