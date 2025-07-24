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
 * GameEveDataFileMetaGroupRespDTransfer
 * <p>游戏EVE数据文件元分组被动响应传输对象
 * <p>
 * create 2025/07/24 19:53
 * <p>
 * update 2025/07/24 19:53
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"name"})
public class GameEveDataFileMetaGroupRespDTransfer implements TianyanMetadataDrivenTransfer {

    /**
     * 元分组名称
     */
    private final GameEveDataFileNameRespDTransfer name;

    @Override
    public GameEveDataFileMetaGroupRespDTransfer validate() {
        validateName();
        return this;
    }

    private void validateName() {
        if (name == null) {
            throw new DrivenTransferValidateException("元分组名称不能为 null ");
        }
    }
}
