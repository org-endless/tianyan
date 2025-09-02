package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.transfer.GameEveItemGroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveItemGroupRestClient
 * <p>
 * 游戏EVE资源项分组REST客户端接口
 * <p>
 * create 2025/08/23 03:27
 * <p>
 * update 2025/08/24 20:09
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarGameEveItemGroupRestClient extends TianyanCommonRestClient {

    /**
     * 游戏EVE资源项分组建命令
     *
     * @param command 游戏EVE资源项分组创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE资源项分组创建命令被动请求传输对象不能为空")
            @Valid GameEveItemGroupCreateDReqTransfer command);

    /**
     * 根据编码游戏EVE资源项分组查询资源项分组ID
     *
     * @param gameEveItemGroupCode 游戏EVE资源项分组编码
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> findItemGroupIdByCode(
            @NotBlank(message = "游戏EVE资源项分组编码不能为空") String gameEveItemGroupCode);
}
