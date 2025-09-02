package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.rest.TianyanCommonRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.GameEveItemCategoryCreateDReqTransfer;

import java.util.Optional;

/**
 * TianyanCommonGameEveItemCategoryRestClient
 * <p>
 * 游戏EVE资源项分类REST客户端接口
 * <p>
 * create 2025/08/23 03:27
 * <p>
 * update 2025/08/24 20:08
 *
 * @author Deng Haozhi
 * @see TianyanCommonRestClient
 * @since 1.0.0
 */
public interface TianyanSidecarGameEveItemCategoryRestClient extends TianyanCommonRestClient {

    /**
     * 游戏EVE资源项分类建命令
     *
     * @param command 游戏EVE资源项分类创建命令被动请求传输对象
     */
    void create(
            @NotNull(message = "游戏EVE资源项分类创建命令被动请求传输对象不能为空")
            @Valid GameEveItemCategoryCreateDReqTransfer command);

    /**
     * 根据游戏EVE资源项分类编码查询资源项分类ID
     *
     * @param gameEveItemCategoryCode 游戏EVE资源项分类编码
     * @return {@link Optional }<{@link String }>
     */
    Optional<String> findItemCategoryIdByCode(
            @NotBlank(message = "游戏EVE资源项分类编码不能为空") String gameEveItemCategoryCode);
}
