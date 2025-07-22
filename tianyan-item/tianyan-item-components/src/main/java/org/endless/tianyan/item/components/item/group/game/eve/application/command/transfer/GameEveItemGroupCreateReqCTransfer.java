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
 * <p>游戏EVE物品分组创建命令请求传输对象
 * <p>
 * create 2025/07/21 16:14
 * <p>
 * update 2025/07/21 16:14
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "gameEveItemCategoryId", "nameZh", "nameEn", "isPublished", "isUseBasePrice", "createUserId"})
public class GameEveItemGroupCreateReqCTransfer implements TianyanItemCommandTransfer {

    /**
     * 游戏EVE物品分组编码
     */
    private final String code;

    /**
     * 游戏EVE物品分类ID
     */
    private final String gameEveItemCategoryId;

    /**
     * 游戏EVE物品分组中文名称
     */
    private final String nameZh;

    /**
     * 游戏EVE物品分组英文名称
     */
    private final String nameEn;

    /**
     * 游戏EVE物品分组是否发布
     */
    private final Boolean isPublished;

    /**
     * 游戏EVE物品分组是否使用基准价格
     */
    private final Boolean isUseBasePrice;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public GameEveItemGroupCreateReqCTransfer validate() {
        validateCode();
        validateGameEveItemCategoryId();
        validateNameZh();
        validateNameEn();
        validateIsPublished();
        validateIsUseBasePrice();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE物品分组编码不能为空");
        }
    }

    private void validateGameEveItemCategoryId() {
        if (!StringUtils.hasText(gameEveItemCategoryId)) {
            throw new CommandTransferValidateException("游戏EVE物品分类ID不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandTransferValidateException("游戏EVE物品分组中文名称不能为空");
        }
    }

    private void validateNameEn() {
        if (!StringUtils.hasText(nameEn)) {
            throw new CommandTransferValidateException("游戏EVE物品分组英文名称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new CommandTransferValidateException("游戏EVE物品分组是否发布不能为 null ");
        }
    }

    private void validateIsUseBasePrice() {
        if (isUseBasePrice == null) {
            throw new CommandTransferValidateException("游戏EVE物品分组是否使用基准价格不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
