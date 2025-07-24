package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.manager.DrivenAdapterManagerException;
import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.metadata.common.model.infrastructure.adapter.rest.TianyanMetadataItemRestClient;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemCategoryCreateReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemCategoryFindByCodeReqDTransfer;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveItemCategoryFindIdRespDTransfer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;

import java.util.Optional;

/**
 * GameEveDataItemCategoryRestClient
 * <p>
 * create 2025/07/20 23:12
 * <p>
 * update 2025/07/20 23:24
 *
 * @author Deng Haozhi
 * @see RestClientAdapter
 * @since 2.0.0
 */
@Lazy
@Component
public class GameEveDataItemCategoryRestClient implements TianyanMetadataItemRestClient {

    private final RestClient restClient;

    public GameEveDataItemCategoryRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void create(GameEveItemCategoryCreateReqDTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveItemCategoryCreateReqDTransfer::validate)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项分类创建请求参数不能为空"));
        post(restClient, "/item/category/game/eve/command/create", command, null);
    }

    public Optional<String> findItemCategoryIdByCode(String code) {
        Optional.ofNullable(code)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE资源项分类编码不能为空"));
        return Optional.ofNullable(post(
                restClient,
                "/item/category/game/eve/query/find_item_category_id_by_code",
                GameEveItemCategoryFindByCodeReqDTransfer.builder()
                        .code(code).build().validate(),
                GameEveItemCategoryFindIdRespDTransfer.class)
                .orElseThrow(() -> new DrivenAdapterManagerException("游戏EVE资源项分类根据编码查询ID响应数据为空"))
                .validate()
                .getItemCategoryId());
    }
}
