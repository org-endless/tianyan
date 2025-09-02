package org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.exchange;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.ddd.starter.common.ddd.infrastructure.adapter.rest.exchange.RestExchange;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.FindByGameEveItemCategoryCodeDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.FindItemCategoryIdDRespTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.category.transfer.GameEveItemCategoryCreateDReqTransfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * TianyanCommonGameEveItemCategoryRestExchange
 * <p>
 * 游戏EVE资源项分类REST-EXCHANGE接口
 * <p>
 * create 2025/08/23 03:22
 * <p>
 * update 2025/08/24 20:05
 *
 * @author Deng Haozhi
 * @see RestExchange
 * @since 1.0.0
 */
@HttpExchange(url = "http://127.0.0.1:10101/item/game-eve-item-category", contentType = "application/json;charset=UTF-8", accept = "application/json")
public interface TianyanSidecarGameEveItemCategoryRestExchange extends RestExchange {

    @Valid
    @NotNull(message = "游戏EVE资源项分类创建命令响应体不能为空")
    @PostExchange("/command/create")
    RestResponse<Void> create(
            @NotNull(message = "游戏EVE资源项分类创建命令被动请求传输对象不能为空")
            @Valid @RequestBody GameEveItemCategoryCreateDReqTransfer command);

    @Valid
    @NotNull(message = "根据游戏EVE资源项分类编码查询资源项分类ID响应体不能为空")
    @PostExchange("/query/find-item-category-id-by-code")
    RestResponse<FindItemCategoryIdDRespTransfer> findItemCategoryIdByCode(
            @NotNull(message = "根据游戏EVE资源项分类编码查询被动请求传输对象不能为空")
            @Valid @RequestBody FindByGameEveItemCategoryCodeDReqTransfer query);
}
