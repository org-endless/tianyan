package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.metagroup.game.eve.transfer.GameEveMetagroupCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveMetagroupRestClient
 * <p>游戏EVE元分组REST客户端接口
 * <p>
 * create 2025/08/23 22:56
 * <p>
 * update 2025/08/23 23:02
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarGameEveMetagroupRestClient extends TianyanCommonRestClient {

    /**
     * 游戏EVE元分组创建命令
     *
     * @param command 游戏EVE元分组创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE元分组创建命令被动请求传输对象不能为空")
            @Valid GameEveMetagroupCreateDReqTransfer command);

    /**
     * 根据游戏EVE元分组编码查询元分组ID
     *
     * @param gameEveMetagroupCode 游戏EVE元分组编码
     * @return {@link Optional }<{@link String }>
     */
    @Valid
    Optional<String> findMetagroupIdByCode(
            @NotBlank(message = "游戏EVE元分组编码不能为空") String gameEveMetagroupCode);
}
