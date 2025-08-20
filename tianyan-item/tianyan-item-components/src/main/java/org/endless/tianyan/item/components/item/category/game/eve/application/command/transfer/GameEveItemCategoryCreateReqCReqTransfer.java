package org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.command.transfer.CommandReqTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandReqTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemCategoryCreateReqCReqTransfer
 * <p>游戏EVE资源项分类创建命令请求传输对象
 * <p>
 * itemCreate 2025/07/24 20:17
 * <p>
 * update 2025/07/24 20:17
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "fullNameZh", "fullNameEn", "isPublished", "createUserId"})
public class GameEveItemCategoryCreateReqCReqTransfer implements TianyanItemCommandReqTransfer {

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
    public GameEveItemCategoryCreateReqCReqTransfer validate() {
        validateCode();
        validateFullNameZh();
        validateFullNameEn();
        validateIsPublished();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandReqTransferValidateException("游戏EVE资源项分类编码不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandReqTransferValidateException("资源项分类中文全称不能为空");
        }
    }

    private void validateFullNameEn() {
        if (!StringUtils.hasText(fullNameEn)) {
            throw new CommandReqTransferValidateException("资源项分类英文全称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new CommandReqTransferValidateException("游戏EVE资源项分类是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandReqTransferValidateException("创建用户ID不能为空");
        }
    }
}
