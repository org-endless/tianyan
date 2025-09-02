package org.endless.tianyan.metadata.components.metagroup.game.eve.infrastructure.data.record;

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
import org.endless.tianyan.metadata.common.model.infrastructure.data.record.TianyanMetadataRecord;
import org.endless.tianyan.metadata.components.metagroup.game.eve.domain.entity.GameEveMetagroupAggregate;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveMetagroupRecord
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
@DataRecord
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@TableName(value = "metagroup_game_eve")
public class GameEveMetagroupRecord implements TianyanMetadataRecord<GameEveMetagroupAggregate> {

    /**
     * 游戏EVE元分组ID
     */
    @TableId
    @NotBlank(message = "游戏EVE元分组ID不能为空")
    private String gameEveMetagroupId;

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

    @NotNull(message = "游戏EVE元分组数据记录实体不能为空")
    public static @Valid GameEveMetagroupRecord from(
            @NotNull(message = "游戏EVE元分组聚合根不能为空")
            @Valid GameEveMetagroupAggregate aggregate) {
        return GameEveMetagroupRecord.builder()
                .gameEveMetagroupId(aggregate.getGameEveMetagroupId())
                .metagroupId(aggregate.getMetagroupId())
                .code(aggregate.getCode())
                .createUserId(aggregate.getCreateUserId())
                .modifyUserId(aggregate.getModifyUserId())
                .isRemoved(aggregate.getIsRemoved())
                .build()
                .validate();
    }

    @NotNull(message = "游戏EVE元分组聚合根不能为空")
    public GameEveMetagroupAggregate to() {
        ObjectTools.jsrValidate(this).validate();
        return GameEveMetagroupAggregate.builder()
                .gameEveMetagroupId(gameEveMetagroupId)
                .metagroupId(metagroupId)
                .code(code)
                .createUserId(createUserId)
                .modifyUserId(modifyUserId)
                .isRemoved(isRemoved)
                .innerBuild();
    }

    @Override
    public GameEveMetagroupRecord validate() {
        return this;
    }
}
