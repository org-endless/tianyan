package org.endless.tianyan.finance.components.cost.type.infrastructure.data.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.finance.common.model.infrastructure.data.persistence.mapper.TianyanFinanceMapper;
import org.endless.tianyan.finance.components.cost.type.infrastructure.data.record.CostTypeRecord;
import org.springframework.context.annotation.Lazy;

/**
 * CostTypeMapper
 * <p>成本类型聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/28 20:09
 * <p>
 * update 2025/07/28 20:09
 *
 * @author Deng Haozhi
 * @see TianyanFinanceMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface CostTypeMapper extends TianyanFinanceMapper<CostTypeRecord> {

}
