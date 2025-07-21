package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveDataItemCategoryCreateReqDTransfer
 * <p>游戏EVE数据物品分类创建被动请求传输对象
 * <p>
 * create 2025/07/21 13:04
 * <p>
 * update 2025/07/21 13:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZh", "nameEn", "isPublished", "createUserId"})
public class GameEveDataItemCategoryCreateReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE物品分类编码
     */
    private final String code;

    /**
     * 游戏EVE物品分类中文名称
     */
    private final String nameZh;

    /**
     * 游戏EVE物品分类英文名称
     */
    private final String nameEn;

    /**
     * 游戏EVE物品分类是否发布
     */
    private final Boolean isPublished;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveDataItemCategoryCreateReqDTransfer validate() {
        validateCode();
        validateNameZh();
        validateNameEn();
        validateIsPublished();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenTransferValidateException("游戏EVE物品分类编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new DrivenTransferValidateException("游戏EVE物品分类中文名称不能为空");
        }
    }

    private void validateNameEn() {
        if (!StringUtils.hasText(nameEn)) {
            throw new DrivenTransferValidateException("游戏EVE物品分类英文名称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DrivenTransferValidateException("游戏EVE物品分类是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenTransferValidateException("创建用户ID不能为空");
        }
    }
}
