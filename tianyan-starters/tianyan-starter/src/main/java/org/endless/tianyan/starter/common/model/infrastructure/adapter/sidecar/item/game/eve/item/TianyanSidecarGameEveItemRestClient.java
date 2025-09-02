package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer.GameEveItemCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.item.transfer.GameEveItemFetchDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * TianyanCommonGameEveItemRestClient
 * <p>游戏EVE资源项REST客户端接口
 * <p>
 * create 2025/08/23 03:27
 * <p>
 * update 2025/08/23 03:28
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarGameEveItemRestClient extends TianyanCommonRestClient {

    /**
     * 游戏EVE资源项建命令
     *
     * @param command 游戏EVE资源项创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE资源项建命令请求传输对象不能为空")
            @Valid @RequestParam("command") GameEveItemCreateDReqTransfer command);

    /**
     * 游戏EVE资源项获取命令
     *
     * @param command 游戏EVE资源项获取命令被动请求传输对象
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> fetch(
            @NotNull(message = "游戏EVE资源项获取命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveItemFetchDReqTransfer command);

    /**
     * 根据游戏EVE资源项编码查询资源项ID
     *
     * @param gameEveItemCode 游戏EVE资源项编码
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> findItemIdByCode(
            @NotBlank(message = "游戏EVE资源项编码不能为空") String gameEveItemCode);

    /**
     * 根据游戏EVE资源项编码列表查询资源项ID列表
     *
     * @param gameEveItemCodes 游戏EVE资源项编码列表
     * @return {@link List }<{@link String }>
     */
    List<String> findItemIdsByCodes(
            @NotEmpty(message = "游戏EVE资源项编码列表不能为空") List<String> gameEveItemCodes);

    /**
     * 根据资源项ID查询游戏EVE资源项编码
     *
     * @param itemId 资源项ID
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> findCodeByItemId(
            @NotBlank(message = "资源项ID不能为空") String itemId);
}
