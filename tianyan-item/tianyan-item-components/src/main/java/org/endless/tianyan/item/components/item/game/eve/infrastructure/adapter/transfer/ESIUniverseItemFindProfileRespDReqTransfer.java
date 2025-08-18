package org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.transfer.DrivenRespTransferValidateException;
import org.endless.tianyan.item.common.model.infrastructure.adapter.transfer.TianyanItemDrivenReqTransfer;
import org.springframework.util.StringUtils;

/**
 * ESIUniverseItemFindProfileRespDReqTransfer
 * <p>ESI宇宙资源项信息查询被动响应传输对象
 * <p>
 * create 2025/07/28 05:22
 * <p>
 * update 2025/07/28 05:22
 *
 * @author Deng Haozhi
 * @see TianyanItemDrivenReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"meta_group_id", "group_id", "market_group_id", "name", "description", "published"})
public class ESIUniverseItemFindProfileRespDReqTransfer implements TianyanItemDrivenReqTransfer {

    /**
     * 元分组ID
     */
    private final String meta_group_id;

    /**
     * 资源项分组ID
     */
    private final String group_id;

    /**
     * 市场分组ID
     */
    private final String market_group_id;

    /**
     * 资源项中文全称
     */
    private final String name;

    /**
     * 资源项描述
     */
    private final String description;

    /**
     * 游戏EVE资源项是否发布
     */
    private final Boolean published;

    @Override
    public ESIUniverseItemFindProfileRespDReqTransfer validate() {
        validateGroup_id();
        validateName();
        validatePublished();
        return this;
    }

    private void validateGroup_id() {
        if (!StringUtils.hasText(group_id)) {
            throw new DrivenRespTransferValidateException("资源项分组ID不能为空");
        }
    }

    private void validateName() {
        if (!StringUtils.hasText(name)) {
            throw new DrivenRespTransferValidateException("资源项中文全称不能为空");
        }
    }

    private void validatePublished() {
        if (published == null) {
            throw new DrivenRespTransferValidateException("游戏EVE资源项是否发布不能为 null ");
        }
    }
}
