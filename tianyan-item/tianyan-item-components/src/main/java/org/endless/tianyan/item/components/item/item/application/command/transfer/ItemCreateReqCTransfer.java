package org.endless.tianyan.item.components.item.item.application.command.transfer;

import org.endless.tianyan.item.common.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.item.components.item.item.domain.value.*;
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
 * ItemCreateReqCTransfer
 * <p>资源项创建命令请求传输对象
 * <p>
 * create 2025/07/24 20:14
 * <p>
 * update 2025/07/24 20:14
 *
 * @author Deng Haozhi
 * @see TianyanItemCommandTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"metaGroupId", "itemGroupId", "marketGroupId", "fullNameZh", "fullNameEn", "description", "createUserId"})
public class ItemCreateReqCTransfer implements TianyanItemCommandTransfer {

    /**
     * 元分组ID
     */
    private final String metaGroupId;

    /**
     * 资源项分组ID
     */
    private final String itemGroupId;

    /**
     * 市场分组ID
     */
    private final String marketGroupId;

    /**
     * 资源项中文全称
     */
    private final String fullNameZh;

    /**
     * 资源项英文全称
     */
    private final String fullNameEn;

    /**
     * 资源项描述
     */
    private final String description;

    /**
     * 创建用户ID
     */
    private final String createUserId;

    @Override
    public ItemCreateReqCTransfer validate() {
        validateItemGroupId();
        validateFullNameZh();
        validateCreateUserId();
        return this;
    }

    private void validateItemGroupId() {
        if (!StringUtils.hasText(itemGroupId)) {
            throw new CommandTransferValidateException("资源项分组ID不能为空");
        }
    }

    private void validateFullNameZh() {
        if (!StringUtils.hasText(fullNameZh)) {
            throw new CommandTransferValidateException("资源项中文全称不能为空");
        }
    }

    private void validateCreateUserId() {
        if (!StringUtils.hasText(createUserId)) {
            throw new CommandTransferValidateException("创建用户ID不能为空");
        }
    }
}
