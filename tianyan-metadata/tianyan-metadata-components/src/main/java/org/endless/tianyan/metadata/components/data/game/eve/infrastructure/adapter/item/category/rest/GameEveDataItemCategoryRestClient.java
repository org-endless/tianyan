package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.item.category.rest;

import org.endless.ddd.simplified.starter.common.exception.model.infrastructure.adapter.transfer.DrivenReqTransferNullException;
import org.endless.ddd.simplified.starter.common.model.infrastructure.adapter.rest.RestClientAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.transfer.GameEveDataItemCategoryCreateReqDTransfer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Collections;
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
@Component
public class GameEveDataItemCategoryRestClient implements RestClientAdapter {

    private final RestClient restClient;

    public GameEveDataItemCategoryRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void create(GameEveDataItemCategoryCreateReqDTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveDataItemCategoryCreateReqDTransfer::validate)
                .orElseThrow(() -> new DrivenReqTransferNullException("游戏EVE物品分类创建请求参数不能为空"));
        post(
                restClient,
                "http://127.0.0.1:10003/item/category/game/eve/item/category/command/create",
                command,
                null,
                headers -> {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                });
    }
}
