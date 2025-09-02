package org.endless.tianyan.item.components.item.game.eve.item.infrastructure.adapter.game.eve.item;

import org.endless.ddd.starter.common.exception.ddd.infrastructure.adapter.DrivenAdapterFailedException;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.GameEveESIUniverseRestClient;
import org.endless.tianyan.game.eve.starter.common.model.infrastructure.adapter.rest.esi.universe.transfer.FindESIUniverseItemDRespTransfer;
import org.endless.tianyan.item.components.item.game.eve.item.domain.anticorruption.GameEveItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.item.domain.entity.GameEveItemAggregate;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.game.eve.group.TianyanSidecarGameEveItemGroupRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.TianyanSidecarItemRestClient;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.item.item.transfer.ItemCreateDReqTransfer;
import org.endless.tianyan.starter.common.model.infrastructure.adapter.sidecar.market.game.eve.group.TianyanSidecarGameEveMarketGroupRestClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * GameEveItemDrivenAdapterImpl
 * <p>
 * create 2025/08/27 22:16
 * <p>
 * update 2025/08/27 22:23
 *
 * @author Deng Haozhi
 * @see GameEveItemDrivenAdapter
 * @since 1.0.0
 */
@Lazy
@Validated
@Component
public class GameEveItemDrivenAdapterImpl implements GameEveItemDrivenAdapter {

    private final GameEveESIUniverseRestClient gameEveESIUniverseRestClient;

    private final TianyanSidecarItemRestClient itemRestClient;

    private final TianyanSidecarGameEveItemGroupRestClient gameEveItemGroupRestClient;

    private final TianyanSidecarGameEveMarketGroupRestClient gameEveMarketGroupRestClient;

    public GameEveItemDrivenAdapterImpl(
            GameEveESIUniverseRestClient gameEveESIUniverseRestClient,
            TianyanSidecarItemRestClient itemRestClient,
            TianyanSidecarGameEveItemGroupRestClient gameEveItemGroupRestClient,
            TianyanSidecarGameEveMarketGroupRestClient gameEveMarketGroupRestClient) {
        this.gameEveESIUniverseRestClient = gameEveESIUniverseRestClient;
        this.itemRestClient = itemRestClient;
        this.gameEveItemGroupRestClient = gameEveItemGroupRestClient;
        this.gameEveMarketGroupRestClient = gameEveMarketGroupRestClient;
    }

    @Override
    public Optional<GameEveItemAggregate> fetch(String gameEveItemCode, String createUserId) {
        FindESIUniverseItemDRespTransfer item = gameEveESIUniverseRestClient.fetchItem(gameEveItemCode);
        String itemId = itemRestClient.create(ItemCreateDReqTransfer.builder()
                        .itemGroupId(gameEveItemGroupRestClient.findItemGroupIdByCode(item.group_id())
                                .orElseThrow(() -> new DrivenAdapterFailedException("资源项分类ID不存在，无法创建资源项数据")))
                        .marketGroupId(StringUtils.hasText(item.market_group_id())
                                ? gameEveMarketGroupRestClient.findMarketGroupIdByCode(item.market_group_id())
                                .orElseThrow(() -> new DrivenAdapterFailedException("市场分组ID不存在，无法创建资源项数据"))
                                : null)
                        .fullNameZh(item.name())
                        .createUserId(createUserId)
                        .build())
                .orElseThrow(() -> new DrivenAdapterFailedException("创建资源项失败"));
        return Optional.ofNullable(GameEveItemAggregate.create(GameEveItemAggregate.builder()
                .itemId(itemId)
                .code(gameEveItemCode)
                .isPublished(item.published())
                .createUserId(createUserId)
        ));
    }
}
