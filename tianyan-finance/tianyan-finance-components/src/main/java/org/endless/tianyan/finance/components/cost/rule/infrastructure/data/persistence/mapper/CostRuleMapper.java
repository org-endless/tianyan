package org.endless.tianyan.finance.components.cost.rule.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.finance.common.model.infrastructure.data.persistence.mapper.TianyanFinanceMapper;
import org.endless.tianyan.finance.components.cost.rule.infrastructure.data.record.CostRuleRecord;
import org.springframework.context.annotation.Lazy;

/**
 * CostRuleMapper
 * <p>成本规则聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/28 20:10
 * <p>
 * update 2025/07/28 20:10
 *
 * @author Deng Haozhi
 * @see TianyanFinanceMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface CostRuleMapper extends TianyanFinanceMapper<CostRuleRecord> {

}
