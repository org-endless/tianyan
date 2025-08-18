package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenReqTransferValidateException;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.TianyanMetadataDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryCreateReqDTransfer
 * <p>游戏EVE资源项分类创建被动请求传输对象
 * <p>
 * create 2025/07/26 05:23
 * <p>
 * update 2025/07/26 05:23
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "fullNameZh", "fullNameEn", "isPublished", "createUserId"})
public class GameEveItemCategoryCreateReqDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 游戏EVE资源项分类编码
     */
    private final String code;

    /**
     * 资源项分类中文全称
     */
    private final String fullNameZh;

    /**
     * 资源项分类英文全称
     */
    private final String fullNameEn;

    /**
     * 游戏EVE资源项分类是否发布
     */
    private final Boolean isPublished;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveItemCategoryCreateReqDTransfer validate() {
        validateCode();
        validateFullNameZh();
        validateFullNameEn();
        validateIsPublished();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new DrivenReqTransferValidateException("游戏EVE资源项分类编码不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new DrivenReqTransferValidateException("资源项分类中文全称不能为空");
        }
    }

    private void validateFullNameEn() {
        if (!StringUtils.hasText(fullNameEn)) {
            throw new DrivenReqTransferValidateException("资源项分类英文全称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new DrivenReqTransferValidateException("游戏EVE资源项分类是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new DrivenReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
