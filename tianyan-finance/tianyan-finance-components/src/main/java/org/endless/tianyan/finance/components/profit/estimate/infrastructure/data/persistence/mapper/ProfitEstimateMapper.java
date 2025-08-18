package org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.finance.common.model.infrastructure.data.persistence.mapper.TianyanFinanceMapper;
import org.endless.tianyan.finance.components.profit.estimate.infrastructure.data.record.ProfitEstimateRecord;
import org.springframework.context.annotation.Lazy;

/**
 * ProfitEstimateMapper
 * <p>预估利润聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/28 19:36
 * <p>
 * update 2025/07/28 19:36
 *
 * @author Deng Haozhi
 * @see TianyanFinanceMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface ProfitEstimateMapper extends TianyanFinanceMapper<ProfitEstimateRecord> {

}
