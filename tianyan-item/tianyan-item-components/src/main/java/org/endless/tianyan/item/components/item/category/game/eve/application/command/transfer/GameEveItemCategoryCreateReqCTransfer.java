package org.endless.tianyan.item.components.item.category.game.eve.application.command.transfer;

import org.endless.tianyan.item.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.item.components.item.category.game.eve.domain.type.*;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GameEveItemCategoryCreateReqCTransfer
 * <p>游戏EVE物品分类创建命令请求传输对象
 * <p>
 * create 2025/07/21 16:08
 * <p>
 * update 2025/07/21 16:08
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"code", "nameZh", "nameEn", "isPublished", "createUserId"})
public class GameEveItemCategoryCreateReqCTransfer implements TianyanItemCommandTransfer {

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
    public GameEveItemCategoryCreateReqCTransfer validate() {
        validateCode();
        validateNameZh();
        validateNameEn();
        validateIsPublished();
        validateCreateUserId();
        return this;
    }

    private void validateCode() {
        if (!StringUtils.hasText(code)) {
            throw new CommandTransferValidateException("游戏EVE物品分类编码不能为空");
        }
    }

    private void validateNameZh() {
        if (!StringUtils.hasText(nameZh)) {
            throw new CommandTransferValidateException("游戏EVE物品分类中文名称不能为空");
        }
    }

    private void validateNameEn() {
        if (!StringUtils.hasText(nameEn)) {
            throw new CommandTransferValidateException("游戏EVE物品分类英文名称不能为空");
        }
    }

    private void validateIsPublished() {
        if (isPublished == null) {
            throw new CommandTransferValidateException("游戏EVE物品分类是否发布不能为 null ");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
