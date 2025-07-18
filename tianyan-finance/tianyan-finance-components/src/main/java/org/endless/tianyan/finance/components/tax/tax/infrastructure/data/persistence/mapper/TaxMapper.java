package org.endless.tianyan.finance.components.tax.tax.infrastructure.data.persistence.mapper;

import org.endless.tianyan.finance.common.model.infrastructure.data.persistence.mapper.*;
import org.endless.tianyan.finance.components.tax.tax.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.persistence.mapper.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

/**
 * TaxMapper
 * <p>税务聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/19 05:08
 * <p>
 * update 2025/07/19 05:08
 *
 * @author Deng Haozhi
 * @see TianyanFinanceMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface TaxMapper extends TianyanFinanceMapper<TaxRecord> {
}
