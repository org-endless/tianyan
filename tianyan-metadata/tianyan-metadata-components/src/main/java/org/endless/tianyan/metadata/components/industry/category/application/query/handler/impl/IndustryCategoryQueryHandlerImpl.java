package org.endless.tianyan.metadata.components.industry.category.application.query.handler.impl;

import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.aspect.log.type.LogLevel;
import org.endless.ddd.starter.common.exception.ddd.application.query.handler.QueryNotFoundException;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferNullException;
import org.endless.tianyan.metadata.components.industry.category.application.query.anticorruption.IndustryCategoryQueryRepository;
import org.endless.tianyan.metadata.components.industry.category.application.query.handler.IndustryCategoryQueryHandler;
import org.endless.tianyan.metadata.components.industry.category.application.query.transfer.IndustryCategoryFindByIdReqQReqTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * IndustryCategoryQueryHandlerImpl
 * <p>行业分类领域查询处理器
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see IndustryCategoryQueryHandler
 * @since 0.0.1
 */
@Lazy
@Service
@Validated
public class IndustryCategoryQueryHandlerImpl implements IndustryCategoryQueryHandler {

    /**
     * 行业分类聚合查询仓储接口
     */
    private final IndustryCategoryQueryRepository industryCategoryQueryRepository;

    public IndustryCategoryQueryHandlerImpl(IndustryCategoryQueryRepository industryCategoryQueryRepository) {
        this.industryCategoryQueryRepository = industryCategoryQueryRepository;
    }

    @Override
    @Log(message = "行业分类根据ID查询是否存在", value = "#command", level = LogLevel.TRACE)
    public void existsById(IndustryCategoryFindByIdReqQReqTransfer query) {
        Optional.ofNullable(query)
                .map(IndustryCategoryFindByIdReqQReqTransfer::validate)
                .orElseThrow(() -> new QueryReqTransferNullException("行业分类根据ID查询是否存在参数不能为空"));
        if (!industryCategoryQueryRepository.existsById(query.getIndustryCategoryId())) {
            throw new QueryNotFoundException("行业分类不存在");
        }
    }
}
