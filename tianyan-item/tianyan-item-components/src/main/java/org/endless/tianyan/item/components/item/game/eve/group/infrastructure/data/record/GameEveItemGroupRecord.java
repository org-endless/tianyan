package org.endless.tianyan.item.components.item.game.eve.group.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.endless.ddd.starter.common.annotation.validate.ddd.DataRecord;
import org.endless.ddd.starter.common.utils.model.object.ObjectTools;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;
import org.endless.tianyan.item.components.item.game.eve.group.domain.entity.GameEveItemGroupAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemGroupRecord
 * <p>游戏EVE资源项分组数据库记录实体
 * <p>
 * itemCreate 2025/07/24 20:20
 * <p>
 * update 2025/07/24 20:20
 *
 * @author Deng Haozhi
 * @see TianyanItemRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "item_group_game_eve")
public class GameEveItemGroupRecord implements TianyanItemRecord<GameEveItemGroupAggregate> {

    /**
     * 游戏EVE资源项分组ID
     */
    @TableId
    @NotBlank(message = "游戏EVE资源项分组ID不能为空")
    private String gameEveItemGroupId;

    /**
     * 资源项分组ID
     */
    @NotBlank(message = "资源项分组ID不能为空")
    private String itemGroupId;

    /**
     * 游戏EVE资源项分组编码
     */
    @NotBlank(message = "游戏EVE资源项分组编码不能为空")
    private String code;

    /**
     * 游戏EVE资源项分组是否发布
     */
    @NotNull(message = "游戏EVE资源项分组是否发布不能为空")
    private Boolean isPublished;

    /**
     * 游戏EVE资源项分组是否使用基准价格
     */
    private Boolean isUseBasePrice;

    /**
     * 创建用户ID
     */
    @NotBlank(message = "创建用户ID不能为空")
    private String createUserId;

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

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long modifyAt;

    /**
     * 删除时间
     */
    private Long removeAt;

    @NotNull(message = "游戏EVE资源项分组数据库记录实体不能为空")
    public static @Valid GameEveItemGroupRecord from(
            @NotNull(message = "游戏EVE资源项分组聚合根不能为空")
            @Valid GameEveItemGroupAggregate aggregate) {
        return GameEveItemGroupRecord.builder()
                .gameEveItemGroupId(aggregate.getGameEveItemGroupId())
                .itemGroupId(aggregate.getItemGroupId())
                .code(aggregate.getCode())
                .isPublished(aggregate.getIsPublished())
                .isUseBasePrice(aggregate.getIsUseBasePrice())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    @NotNull(message = "游戏EVE资源项分组聚合根不能为空")
    public GameEveItemGroupAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return GameEveItemGroupAggregate.builder()
                .gameEveItemGroupId(gameEveItemGroupId)
                .itemGroupId(itemGroupId)
                .code(code)
                .isPublished(isPublished)
                .isUseBasePrice(isUseBasePrice)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveItemGroupRecord validate() {
        return this;
    }
}
