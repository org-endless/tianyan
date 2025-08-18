package org.endless.tianyan.item.components.item.game.eve.application.query.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.endless.ddd.starter.common.exception.ddd.application.query.transfer.QueryReqTransferValidateException;
import org.endless.tianyan.item.common.model.application.query.transfer.TianyanItemQueryReqTransfer;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * GameEveItemFindByCodesReqQReqTransfer
 * <p>游戏EVE资源项根据编码列表查询请求传输对象
 * <p>
 * create 2025/07/27 23:06
 * <p>
 * update 2025/07/27 23:06
 *
 * @author Deng Haozhi
 * @see TianyanItemQueryReqTransfer
 * @since 0.0.1
 */
@Getter
@ToString
@Builder
@JSONType(orders = {"gameEveItemCodes"})
public class GameEveItemFindByCodesReqQReqTransfer implements TianyanItemQueryReqTransfer {

    /**
     * 游戏EVE资源项编码列表
     */
    private final List<String> gameEveItemCodes;

    @Override
    public GameEveItemFindByCodesReqQReqTransfer validate() {
        validateGameEveItemCodes();
        return this;
    }

    private void validateGameEveItemCodes() {
        if (CollectionUtils.isEmpty(gameEveItemCodes)) {
            throw new QueryReqTransferValidateException("游戏EVE资源项编码列表不能为空");
        }
    }
}
