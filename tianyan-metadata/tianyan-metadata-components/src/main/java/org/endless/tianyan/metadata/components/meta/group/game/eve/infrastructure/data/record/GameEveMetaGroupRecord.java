package org.endless.tianyan.metadata.components.meta.group.game.eve.infrastructure.data.record;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.data.record.DataRecordValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.entity.GameEveMetaGroupAggregate;
import org.springframework.util.StringUtils;

/**
 * GameEveMetaGroupRecord
 * <p>游戏EVE元分组数据库记录实体
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRecord
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "meta_group_game_eve")
public class GameEveMetaGroupRecord implements TianyanMetadataRecord<GameEveMetaGroupAggregate> {

    /**
     * 游戏EVE元分组ID
     */
    @TableId
    private String gameEveMetaGroupId;

    /**
     * 元分组ID
     */
    private String metaGroupId;

    /**
     * 游戏EVE元分组编码
     */
    private String code;

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

    public static GameEveMetaGroupRecord from(GameEveMetaGroupAggregate aggregate) {
        String gameEveMetaGroupId = aggregate.getGameEveMetaGroupId();
        return GameEveMetaGroupRecord.builder()
                .gameEveMetaGroupId(gameEveMetaGroupId)
                .metaGroupId(aggregate.getMetaGroupId())
                .code(aggregate.getCode())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    public GameEveMetaGroupAggregate to() {
        validate();
        return GameEveMetaGroupAggregate.builder()
                .gameEveMetaGroupId(gameEveMetaGroupId)
                .metaGroupId(metaGroupId)
                .code(code)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMetaGroupRecord validate() {
        validateGameEveMetaGroupId();
        validateMetaGroupId();
        validateCode();
        validateCreateUserId();
        validateModifyUserId();
        validateIsRemoved();
        return this;
    }

    private void validateGameEveMetaGroupId() {
        if (!StringUtils.hasText(gameEveMetaGroupId)) {
            throw new DataRecordValidateException("游戏EVE元分组ID不能为空");
        }
    }

    private void validateMetaGroupId() {
        if (!StringUtils.hasText(metaGroupId)) {
            throw new DataRecordValidateException("元分组ID不能为空");
        }
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DataRecordValidateException("游戏EVE元分组编码不能为空");
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
