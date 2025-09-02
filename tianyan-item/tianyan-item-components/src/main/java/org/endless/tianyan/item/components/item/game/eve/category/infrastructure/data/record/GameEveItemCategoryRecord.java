package org.endless.tianyan.item.components.item.game.eve.category.infrastructure.data.record;

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
import org.endless.tianyan.item.components.item.game.eve.category.domain.entity.GameEveItemCategoryAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveItemCategoryRecord
 * <p>游戏EVE资源项分类数据库记录实体
 * <p>
 * itemCreate 2025/07/21 14:46
 * <p>
 * update 2025/07/21 14:46
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
@TableName(value = "item_category_game_eve")
public class GameEveItemCategoryRecord implements TianyanItemRecord<GameEveItemCategoryAggregate> {

    /**
     * 游戏EVE资源项分类ID
     */
    @TableId
    @NotBlank(message = "游戏EVE资源项分类ID不能为空")
    private String gameEveItemCategoryId;

    /**
     * 资源项分类ID
     */
    @NotBlank(message = "资源项分类ID不能为空")
    private String itemCategoryId;

    /**
     * 游戏EVE资源项分类编码
     */
    @NotBlank(message = "游戏EVE资源项分类编码不能为空")
    private String code;

    /**
     * 游戏EVE资源项分类是否发布
     */
    @NotNull(message = "游戏EVE资源项分类是否发布不能为空")
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

    @NotNull(message = "游戏EVE资源项分类数据库记录实体不能为空")
    public static @Valid GameEveItemCategoryRecord from(
            @NotNull(message = "游戏EVE资源项分类聚合不能为空")
            @Valid GameEveItemCategoryAggregate aggregate) {
        return GameEveItemCategoryRecord.builder()
                .gameEveItemCategoryId(aggregate.getGameEveItemCategoryId())
                .itemCategoryId(aggregate.getItemCategoryId())
                .code(aggregate.getCode())
                .isPublished(aggregate.getIsPublished())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "游戏EVE资源项分类聚合不能为空")
    public GameEveItemCategoryAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return GameEveItemCategoryAggregate.builder()
                .gameEveItemCategoryId(gameEveItemCategoryId)
                .itemCategoryId(itemCategoryId)
                .code(code)
                .isPublished(isPublished)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveItemCategoryRecord validate() {
        return this;
    }
}
