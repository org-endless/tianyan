package org.endless.tianyan.item.components.item.game.eve.item.infrastructure.data.record;

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
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemRecord
 * <p>游戏EVE资源项数据库记录实体
 * <p>
 * itemCreate 2025/07/24 16:27
 * <p>
 * update 2025/07/24 16:27
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
@TableName(value = "item_game_eve")
public class GameEveItemRecord implements TianyanItemRecord<GameEveItemAggregate> {

    /**
     * 游戏EVE资源项ID
     */
    @TableId
    @NotBlank(message = "游戏EVE资源项ID不能为空")
    private String gameEveItemId;

    /**
     * 资源项ID
     */
    @NotBlank(message = "资源项ID不能为空")
    private String itemId;

    /**
     * 游戏EVE资源项编码
     */
    @NotBlank(message = "游戏EVE资源项编码不能为空")
    private String code;

    /**
     * 游戏EVE资源项是否发布
     */
    @NotNull(message = "游戏EVE资源项是否发布不能为空")
    private Boolean isPublished;

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

    @NotNull(message = "游戏EVE资源项数据库记录实体不能为空")
    public static @Valid GameEveItemRecord from(
            @NotNull(message = "游戏EVE资源项聚合根不能为空")
            @Valid GameEveItemAggregate aggregate) {
        return GameEveItemRecord.builder()
                .gameEveItemId(aggregate.getGameEveItemId())
                .itemId(aggregate.getItemId())
                .code(aggregate.getCode())
                .isPublished(aggregate.getIsPublished())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build();
    }

    @NotNull(message = "游戏EVE资源项聚合根不能为空")
    public @Valid GameEveItemAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return GameEveItemAggregate.builder()
                .gameEveItemId(gameEveItemId)
                .itemId(itemId)
                .code(code)
                .isPublished(isPublished)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveItemRecord validate() {
        return this;
    }
}
