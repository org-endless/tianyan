package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer;

import org.endless.tianyan.metadata.common.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.*;
import org.endless.ddd.simplified.starter.common.utils.model.decimal.Decimal;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.*;
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
 * GameEveDataFileItemRespDTransfer
 * <p>游戏EVE数据文件资源项被动响应传输对象
 * <p>
 * create 2025/07/24 20:58
 * <p>
 * update 2025/07/24 20:58
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"name", "metaGroupID", "groupID", "marketGroupID", "basePrice", "published"})
public class GameEveDataFileItemRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 资源项名称
     */
    private final GameEveDataFileNameRespDTransfer name;

    /**
     * 元分组ID
     */
    private final String metaGroupID;

    /**
     * 资源项分组ID
     */
    private final String groupID;

    /**
     * 市场分组ID
     */
    private final String marketGroupID;

    /**
     * 基准价格
     */
    private final String basePrice;

    /**
     * 资源项是否发布
     */
    private final Boolean published;

    @Override
    public GameEveDataFileItemRespDTransfer validate() {
        validateName();
        validateGroupID();
        validatePublished();
        return this;
    }

    private void validateName() {
        if (name == null) {
            throw new DrivenTransferValidateException("资源项名称不能为 null ");
        }
    }

    private void validateGroupID() {
        if (!StringUtils.hasText(groupID)) {
            throw new DrivenTransferValidateException("资源项分组ID不能为空");
        }
    }

    private void validatePublished() {
        if (published == null) {
            throw new DrivenTransferValidateException("资源项是否发布不能为 null ");
        }
    }
}
