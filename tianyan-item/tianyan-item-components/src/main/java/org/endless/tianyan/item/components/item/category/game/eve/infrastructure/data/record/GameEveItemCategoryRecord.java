package org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.item.common.model.infrastructure.data.record.TianyanItemRecord;
import org.endless.tianyan.item.components.item.category.game.eve.domain.entity.GameEveItemCategoryAggregate;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryRecord
 * <p>游戏EVE资源项分类数据库记录实体
 * <p>
 * create 2025/07/21 14:46
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
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "item_category_game_eve")
public class GameEveItemCategoryRecord implements TianyanItemRecord<GameEveItemCategoryAggregate> {

    /**
     * 游戏EVE资源项分类ID
     */
    @TableId
    private String gameEveItemCategoryId;

    /**
     * 资源项分类ID
     */
    private String itemCategoryId;

    /**
     * 游戏EVE资源项分类编码
     */
    private String code;

    /**
     * 游戏EVE资源项分类是否发布
     */
    private Boolean isPublished;

    /**
     * 创建者ID
     */
    private String createUserId;

    /**
     * 修改者ID
     */
    private String modifyUserId;

    /**
     * 是否已删除
     */
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

    public static GameEveItemCategoryRecord from(GameEveItemCategoryAggregate aggregate) {
        String gameEveItemCategoryId = aggregate.getGameEveItemCategoryId();
        return GameEveItemCategoryRecord.builder()
                .gameEveItemCategoryId(gameEveItemCategoryId)
                .itemCategoryId(aggregate.getItemCategoryId())
                .code(aggregate.getCode())
                .isPublished(aggregate.getIsPublished())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveItemCategoryAggregate to() {
        validate();
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
        validateGameEveItemCategoryId();
        validateItemCategoryId();
        validateCode();
        validateIsPublished();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new DataRecordValidateException("游戏EVE资源项分类ID不能为空");
        }
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new DataRecordValidateException("资源项分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE资源项分类编码不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DataRecordValidateException("游戏EVE资源项分类是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DataRecordValidateException("创建者ID不能为空");
        }
    }

    private void validateModifyUserId() {
        if (!StringUtils.hasText(modifyUserId)) {
            throw new DataRecordValidateException("修改者ID不能为空");
        }
    }

    private void validateIsRemoved() {
        if (isRemoved == null) {
            throw new DataRecordValidateException("是否已删除不能为 null ");
        }
    }
}
