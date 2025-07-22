package org.endless.tianyan.sales.components.market.group.domain.entity;

import org.endless.tianyan.sales.common.model.domain.entity.*;
import org.endless.tianyan.sales.components.market.group.domain.value.*;
import org.endless.ddd.simplified.starter.common.exception.model.domain.entity.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MarketGroupAggregate
 * <p>市场分组聚合根
 * <p>
 * create 2025/07/22 09:08
 * <p>
 * update 2025/07/22 09:08
 *
 * @author Deng Haozhi
 * @see TianyanSalesAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class MarketGroupAggregate implements TianyanSalesAggregate {

    /**
     * 市场分组ID
     */
    private final String marketGroupId;

    /**
     * 中文名称
     */
    private NameValue nameZh;

    /**
     * 英文名称
     */
    private NameValue nameEn;

    /**
     * 父市场分组ID
     */
    private String parentId;

    /**
     * 创建者ID
     */
    private final String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
    private Boolean isRemoved;

    public static MarketGroupAggregate create(MarketGroupAggregateBuilder builder) {
        return builder
                .marketGroupId(IdGenerator.of())
                .nameZh(builder.nameZh)
                .nameEn(builder.nameEn)
                .createUserId(builder.createUserId)
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public MarketGroupAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<市场分组聚合根>不能再次删除, ID: " + marketGroupId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<市场分组聚合根>处于不可删除状态, ID: " + marketGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public MarketGroupAggregate validate() {
        validateMarketGroupId();
        validateNameZh();
        validateNameEn();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new AggregateValidateException("市场分组ID不能为空");
        }
    }

    private void validateNameZh() {
        if (nameZh == null) {
            throw new AggregateValidateException("中文名称不能为 null ");
        }
    }

    private void validateNameEn() {
        if (nameEn == null) {
            throw new AggregateValidateException("英文名称不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new AggregateValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new AggregateValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new AggregateValidateException("是否已删除不能为 null ");
        }
    }
}
