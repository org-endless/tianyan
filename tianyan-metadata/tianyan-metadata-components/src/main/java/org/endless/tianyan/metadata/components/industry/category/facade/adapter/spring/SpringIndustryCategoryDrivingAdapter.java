package org.endless.tianyan.metadata.components.industry.category.facade.adapter.spring;

import org.endless.tianyan.metadata.components.industry.category.application.command.handler.IndustryCategoryCommandHandler;
import org.endless.tianyan.metadata.components.industry.category.application.command.transfer.IndustryCategoryCreateReqCTransfer;
import org.endless.tianyan.metadata.components.industry.category.application.query.handler.IndustryCategoryQueryHandler;
import org.endless.tianyan.metadata.components.industry.category.application.query.transfer.IndustryCategoryFindByIdReqQTransfer;
import org.endless.tianyan.metadata.components.industry.category.facade.adapter.IndustryCategoryDrivingAdapter;

/**
 * SpringIndustryCategoryDrivingAdapter
 * <p>行业分类领域主动适配器Spring实现类
 * <p>
 * create 2025/07/28 18:57
 * <p>
 * update 2025/07/28 18:57
 *
 * @author Deng Haozhi
 * @see IndustryCategoryDrivingAdapter
 * @since 0.0.1
 */
public class SpringIndustryCategoryDrivingAdapter implements IndustryCategoryDrivingAdapter {

    /**
     * 行业分类领域命令处理器
     */
    private final IndustryCategoryCommandHandler industryCategoryCommandHandler;

    /**
     * 行业分类领域查询处理器
     */
    private final IndustryCategoryQueryHandler industryCategoryQueryHandler;

    public SpringIndustryCategoryDrivingAdapter(IndustryCategoryCommandHandler industryCategoryCommandHandler, IndustryCategoryQueryHandler industryCategoryQueryHandler) {
        this.industryCategoryCommandHandler = industryCategoryCommandHandler;
        this.industryCategoryQueryHandler = industryCategoryQueryHandler;
    }

    @Override
    public void create(IndustryCategoryCreateReqCTransfer command) {
        industryCategoryCommandHandler.create(command);
    }

    @Override
    public void existsById(IndustryCategoryFindByIdReqQTransfer query) {
        industryCategoryQueryHandler.existsById(query);
    }
}
