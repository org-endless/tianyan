package org.endless.tianyan.sales.components.market.group.game.eve.domain.entity;

import org.endless.tianyan.sales.common.model.domain.entity.*;
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
 * GameEveMarketGroupAggregate
 * <p>游戏EVE市场分组聚合根
 * <p>
 * create 2025/07/24 17:37
 * <p>
 * update 2025/07/24 17:37
 *
 * @author Deng Haozhi
 * @see TianyanSalesAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Builder(buildMethodName = "innerBuild")
public class GameEveMarketGroupAggregate implements TianyanSalesAggregate {

    /**
     * 游戏EVE市场分组ID
     */
    private final String gameEveMarketGroupId;

    /**
     * 市场分组ID
     */
    private String marketGroupId;

    /**
     * 游戏EVE市场分组编码
     */
    private String code;

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

    public static GameEveMarketGroupAggregate create(GameEveMarketGroupAggregateBuilder builder) {
        return builder
                .gameEveMarketGroupId(IdGenerator.of())
                .modifyUserId(builder.createUserId)
                .isRemoved(false)
            .innerBuild()
            .validate();
    }

    public GameEveMarketGroupAggregate remove(String modifyUserId) {
        if (this.isRemoved) {
            throw new AggregateRemoveException("已经被删除的聚合根<游戏EVE市场分组聚合根>不能再次删除, ID: " + gameEveMarketGroupId);
        }
        if (!canRemove()) {
            throw new AggregateRemoveException("聚合根<游戏EVE市场分组聚合根>处于不可删除状态, ID: " + gameEveMarketGroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    private boolean canRemove() {
        return true;
    }

    @Override
    public GameEveMarketGroupAggregate validate() {
        validateGameEveMarketGroupId();
        validateMarketGroupId();
        validateCode();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveMarketGroupId() {
        if (!StringUtils.hasText(gameEveMarketGroupId)) {
            throw new AggregateValidateException("游戏EVE市场分组ID不能为空");
        }
    }

    private void validateMarketGroupId() {
        if (!StringUtils.hasText(marketGroupId)) {
            throw new AggregateValidateException("市场分组ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new AggregateValidateException("游戏EVE市场分组编码不能为空");
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
