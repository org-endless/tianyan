package org.endless.tianyan.metadata.components.industry.industry.application.query.handler.impl;

import org.endless.tianyan.metadata.components.industry.industry.application.query.anticorruption.IndustryQueryRepository;
import org.endless.tianyan.metadata.components.industry.industry.application.query.handler.IndustryQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * IndustryQueryHandlerImpl
 * <p>行业领域查询处理器
 * <p>
 * create 2025/07/28 19:04
 * <p>
 * update 2025/07/28 19:04
 *
 * @author Deng Haozhi
 * @see IndustryQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class IndustryQueryHandlerImpl implements IndustryQueryHandler {

    /**
     * 行业聚合查询仓储接口
     */
    private final IndustryQueryRepository industryQueryRepository;

    public IndustryQueryHandlerImpl(IndustryQueryRepository industryQueryRepository) {
        this.industryQueryRepository = industryQueryRepository;
    }
}
