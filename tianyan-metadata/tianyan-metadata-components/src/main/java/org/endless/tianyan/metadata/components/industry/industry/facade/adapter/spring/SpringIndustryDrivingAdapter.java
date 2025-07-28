package org.endless.tianyan.metadata.components.industry.industry.facade.adapter.spring;

import org.endless.tianyan.metadata.components.industry.industry.application.command.handler.IndustryCommandHandler;
import org.endless.tianyan.metadata.components.industry.industry.application.command.transfer.IndustryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.industry.application.query.handler.IndustryQueryHandler;
import org.endless.tianyan.metadata.components.industry.industry.facade.adapter.IndustryDrivingAdapter;

/**
 * SpringIndustryDrivingAdapter
 * <p>行业领域主动适配器Spring实现类
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see IndustryDrivingAdapter
 * @since 0.0.1
 */
public class SpringIndustryDrivingAdapter implements IndustryDrivingAdapter {

    /**
     * 行业领域命令处理器
     */
    private final IndustryCommandHandler industryCommandHandler;

    /**
     * 行业领域查询处理器
     */
    private final IndustryQueryHandler industryQueryHandler;

    public SpringIndustryDrivingAdapter(IndustryCommandHandler industryCommandHandler, IndustryQueryHandler industryQueryHandler) {
        this.industryCommandHandler = industryCommandHandler;
        this.industryQueryHandler = industryQueryHandler;
    }

    @Override
    public void create(IndustryCreateReqCTransfer command) {
        industryCommandHandler.create(command);
    }
}
