package org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.transfer;

import com.alibaba.fastjson2.annotation.JSONType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.endless.ddd.starter.common.annotation.validate.ddd.Transfer;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.transfer.GameEveCommonDrivenRespTransfer;

/**
 * FindESIUniverseItemDRespTransfer
 * <p>获取ESI资源项被动响应传输对象
 * <p>
 * create 2025/07/28 07:09
 * <p>
 * update 2025/07/28 07:09
 *
 * @param group_id        游戏EVE资源项分组
 * @param market_group_id 游戏EVE市场分组编码
 * @param name            游戏EVE市场订单总数
 * @param published       游戏EVE市场订单剩余数量
 * @author Deng Haozhi
 * @see Record
 * @see GameEveCommonDrivenRespTransfer
 * @since 0.0.1
 */
@Builder
@Transfer
@JSONType(orders = {"group_id", "market_group_id", "name", "published"})
public record FindESIUniverseItemDRespTransfer(
        @NotBlank(message = "游戏EVE资源项分组编码不能为空") String group_id,
        String market_group_id,
        @NotBlank(message = "游戏EVE资源项名称不能为空") String name,
        @NotNull(message = "游戏EVE资源项是否发布不能为空") Boolean published
) implements GameEveCommonDrivenRespTransfer {

    @Override
    public FindESIUniverseItemDRespTransfer validate() {
        return this;
    }
}
