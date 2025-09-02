package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.transfer.GameEveMarketGroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveMarketGroupRestClient
 * <p> 游戏EVE市场分组REST客户端接口
 * <p>
 * create 2025/08/24 05:26
 * <p>
 * update 2025/08/24 05:36
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarGameEveMarketGroupRestClient extends TianyanCommonRestClient {

    /**
     * 游戏EVE市场分组创建命令
     *
     * @param command 游戏EVE市场分组创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE市场分组创建命令被动请求传输对象不能为空")
            @Valid GameEveMarketGroupCreateDReqTransfer command);

    /**
     * 根据游戏EVE市场分组编码查询市场分组ID
     *
     * @param gameEveMarketGroupCode 游戏EVE市场分组编码
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> findMarketGroupIdByCode(
            @NotBlank(message = "游戏EVE市场分组编码不能为空") String gameEveMarketGroupCode);
}
