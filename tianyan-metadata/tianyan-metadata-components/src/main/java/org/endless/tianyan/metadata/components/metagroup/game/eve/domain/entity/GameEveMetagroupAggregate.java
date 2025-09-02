package org.endless.tianyan.metadata.components.metagroup.game.eve.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.annotation.validate.ddd.Aggregate;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.exception.ddd.domain.entity.aggregate.AggregateRemoveException;
import org.endless.tianyan.metadata.common.model.domain.entity.TianyanMetadataAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMetagroupAggregate
 * <p>游戏EVE元分组聚合根
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataAggregate
 * @since 0.0.1
 */
@Getter
@ToString
@Aggregate
@Validated
@Builder(buildMethodName = "innerBuild")
public class GameEveMetagroupAggregate implements TianyanMetadataAggregate {

    /**
     * 游戏EVE元分组ID
     */
    @NotBlank(message = "游戏EVE元分组ID不能为空")
    private final String gameEveMetagroupId;

    /**
     * 元分组ID
     */
    @NotBlank(message = "元分组ID不能为空")
    private String metagroupId;

    /**
     * 游戏EVE元分组编码
     */
    @NotBlank(message = "游戏EVE元分组编码不能为空")
    private String code;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private final String createUserId;

    /**
     * 修改用户ID
     */
    @NotBlank(message = "修改用户ID不能为空")
    private String modifyUserId;

    /**
     * 是否已删除
     */
    @NotNull(message = "是否已删除不能为空")
    private Boolean isRemoved;

    @NotNull(message = "游戏EVE元分组聚合根创建方法返回对象不能为空")
    public static @Valid GameEveMetagroupAggregate create(
            @NotNull(message = "游戏EVE元分组聚合根构造器不能为空") GameEveMetagroupAggregateBuilder builder) {
        return Entity.create(builder, GameEveMetagroupAggregateBuilder::innerBuild).validate();
    }

    @NotNull(message = "游戏EVE元分组聚合根根删除方法返回对象不能为空")
    public GameEveMetagroupAggregate remove(
            @NotBlank(message = "修改用户ID不能为空") String modifyUserId) {
        if (Boolean.TRUE.equals(this.isRemoved)) {
            throw new AggregateRemoveException("已经被删除的游戏EVE元分组聚合根不能再次删除, ID: " + gameEveMetagroupId);
        }
        this.isRemoved = true;
        this.modifyUserId = modifyUserId;
        return this;
    }

    @Override
    public GameEveMetagroupAggregate validate() {
        return this;
    }
}
