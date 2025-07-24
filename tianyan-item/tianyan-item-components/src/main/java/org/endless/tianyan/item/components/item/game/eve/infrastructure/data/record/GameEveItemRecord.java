package org.endless.tianyan.item.components.item.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.endless.tianyan.item.common.model.infrastructure.data.record.*;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.*;
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
 * GameEveItemRecord
 * <p>游戏EVE资源项数据库记录实体
 * <p>
 * create 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
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
@TableName(value = "item_game_eve")
public class GameEveItemRecord implements TianyanItemRecord<GameEveItemAggregate> {

    /**
     * 游戏EVE资源项ID
     */
    @TableId
    private String gameEveItemId;

    /**
     * 资源项ID
     */
    private String itemId;

    /**
     * 游戏EVE资源项编码
     */
    private String code;

    /**
     * 游戏EVE资源项是否发布
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

    public static GameEveItemRecord from(GameEveItemAggregate aggregate) {
        String gameEveItemId = aggregate.getGameEveItemId();
        return GameEveItemRecord.builder()
                .gameEveItemId(gameEveItemId)
                .itemId(aggregate.getItemId())
                .code(aggregate.getCode())
                .isPublished(aggregate.getIsPublished())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveItemAggregate to() {
        validate();
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
        validateGameEveItemId();
        validateItemId();
        validateCode();
        validateIsPublished();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveItemId() {
        if (!StringUtils.hasText(gameEveItemId)) {
            throw new DataRecordValidateException("游戏EVE资源项ID不能为空");
        }
    }

    private void validateItemId() {
        if (!StringUtils.hasText(itemId)) {
            throw new DataRecordValidateException("资源项ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE资源项编码不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DataRecordValidateException("游戏EVE资源项是否发布不能为 null ");
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
