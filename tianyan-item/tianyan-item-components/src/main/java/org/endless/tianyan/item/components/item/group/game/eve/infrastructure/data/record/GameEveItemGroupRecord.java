package org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.item.common.model.infrastructure.data.record.*;
import org.endless.tianyan.item.components.item.group.game.eve.domain.entity.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.*;
import org.endless.ddd.simplified.starter.common.config.utils.id.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import lombok.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GameEveItemGroupRecord
 * <p>游戏EVE资源项分组数据库记录实体
 * <p>
 * create 2025/07/24 20:20
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
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "item_group_game_eve")
public class GameEveItemGroupRecord implements TianyanItemRecord<GameEveItemGroupAggregate> {

    /**
     * 游戏EVE资源项分组ID
     */
    @TableId
    private String gameEveItemGroupId;

    /**
     * 资源项分组ID
     */
    private String itemGroupId;

    /**
     * 资源项分类ID
     */
    private String itemCategoryId;

    /**
     * 游戏EVE资源项分组编码
     */
    private String code;

    /**
     * 游戏EVE资源项分组是否发布
     */
    private Boolean isPublished;

    /**
     * 游戏EVE资源项分组是否使用基准价格
     */
    private Boolean isUseBasePrice;

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

    public static GameEveItemGroupRecord from(GameEveItemGroupAggregate aggregate) {
        String gameEveItemGroupId = aggregate.getGameEveItemGroupId();
        return GameEveItemGroupRecord.builder()
                .gameEveItemGroupId(gameEveItemGroupId)
                .itemGroupId(aggregate.getItemGroupId())
                .itemCategoryId(aggregate.getItemCategoryId())
                .code(aggregate.getCode())
                .isPublished(aggregate.getIsPublished())
                .isUseBasePrice(aggregate.getIsUseBasePrice())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveItemGroupAggregate to() {
        validate();
        return GameEveItemGroupAggregate.builder()
                .gameEveItemGroupId(gameEveItemGroupId)
                .itemGroupId(itemGroupId)
                .itemCategoryId(itemCategoryId)
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
        validateGameEveItemGroupId();
        validateItemGroupId();
        validateItemCategoryId();
        validateCode();
        validateIsPublished();
        validateIsUseBasePrice();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveItemGroupId() {
        if (!StringUtils.hasText(gameEveItemGroupId)) {
            throw new DataRecordValidateException("游戏EVE资源项分组ID不能为空");
        }
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new DataRecordValidateException("资源项分组ID不能为空");
        }
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new DataRecordValidateException("资源项分类ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE资源项分组编码不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DataRecordValidateException("游戏EVE资源项分组是否发布不能为 null ");
        }
    }

    private void validateIsUseBasePrice() {
        if (isUseBasePrice == null) {
            throw new DataRecordValidateException("游戏EVE资源项分组是否使用基准价格不能为 null ");
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
