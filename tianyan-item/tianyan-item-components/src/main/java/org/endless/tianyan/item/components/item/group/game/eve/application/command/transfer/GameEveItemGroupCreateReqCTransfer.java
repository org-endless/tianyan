package org.endless.tianyan.item.components.item.group.game.eve.application.command.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandTransferValidateException;
import org.endless.tianyan.item.common.model.application.command.transfer.TianyanItemCommandTransfer;
import org.springframework.util.StringUtils;

/**
 * GameEveItemGroupCreateReqCTransfer
 * <p>游戏EVE资源项分组创建命令请求传输对象
 * <p>
 * create 2025/07/24 20:19
 * <p>
 * update 2025/07/24 20:19
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "itemCategoryId", "fullNameZh", "fullNameEn", "isPublished", "isUseBasePrice", "createUserId"})
public class GameEveItemGroupCreateReqCTransfer implements TianyanItemCommandTransfer {

    /**
     * 游戏EVE资源项分组编码
     */
    private final String code;

    /**
     * 资源项分类ID
     */
    private final String itemCategoryId;

    /**
     * 资源项分组中文全称
     */
    private final String fullNameZh;

    /**
     * 资源项分组英文全称
     */
    private final String fullNameEn;

    /**
     * 游戏EVE资源项分组是否发布
     */
    private final Boolean isPublished;

    /**
     * 游戏EVE资源项分组是否使用基准价格
     */
    private final Boolean isUseBasePrice;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveItemGroupCreateReqCTransfer validate() {
        validateCode();
        validateItemCategoryId();
        validateFullNameZh();
        validateIsPublished();
        validateIsUseBasePrice();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE资源项分组编码不能为空");
        }
    }

    private void validateItemCategoryId() {
        if (!StringUtils.hasText(itemCategoryId)) {
            throw new CommandTransferValidateException("资源项分类ID不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandTransferValidateException("资源项分组中文全称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new CommandTransferValidateException("游戏EVE资源项分组是否发布不能为 null ");
        }
    }

    private void validateIsUseBasePrice() {
        if (isUseBasePrice == null) {
            throw new CommandTransferValidateException("游戏EVE资源项分组是否使用基准价格不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
