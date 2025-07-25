package org.endless.tianyan.sales.common.model.infrastructure.adapter.rest.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenTransferValidateException;
import org.endless.tianyan.sales.common.model.infrastructure.adapter.transfer.TianyanSalesDrivenTransfer;
import org.springframework.util.StringUtils;

/**
 * TianyanSalesESIFindUniverseItemNameRespDTransfer
 * <p>游戏EVE市场订单信宇宙资源项信息查询被动响应传输对象
 * <p>
 * create 2025/07/25 15:19
 * <p>
 * update 2025/07/25 15:19
 *
 * @author Deng Haozhi
 * @see TianyanSalesDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"category", "id", "name"})
public class TianyanSalesESIFindUniverseItemNameRespDTransfer implements TianyanSalesDrivenTransfer {

    /**
     * 游戏EVE宇宙资源项分类名称
     */
    private final String category;

    /**
     * 游戏EVE宇宙资源项编码
     */
    private final String id;

    /**
     * 游戏EVE宇宙资源项名称
     */
    private final String name;

    @Override
    public TianyanSalesESIFindUniverseItemNameRespDTransfer validate() {
        validateCategory();
        validateId();
        validateName();
        return this;
    }

    private void validateCategory() {
        if (!StringUtils.hasText(category)) {
            throw new DrivenTransferValidateException("游戏EVE宇宙资源项分类名称不能为空");
        }
    }

    private void validateId() {
        if (!StringUtils.hasText(id)) {
            throw new DrivenTransferValidateException("游戏EVE宇宙资源项编码不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DrivenTransferValidateException("游戏EVE宇宙资源项名称不能为空");
        }
    }
}
