package org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.item.spring;

import org.endless.tianyan.item.components.item.game.eve.domain.anticorruption.GameEveItemDrivenAdapter;
import org.endless.tianyan.item.components.item.game.eve.domain.entity.GameEveItemAggregate;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.esi.universe.GameEveItemESIUniverseRestClient;
import org.endless.tianyan.item.components.item.game.eve.infrastructure.adapter.transfer.ESIUniverseItemFindProfileRespDReqTransfer;
import org.endless.tianyan.item.components.item.item.application.command.transfer.ItemCreateCReqTransfer;
import org.endless.tianyan.item.components.item.item.facade.adapter.ItemDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * SpringGameEveItemDrivenAdapter
 * <p>
 * create 2025/07/28 04:49
 * <p>
 * update 2025/07/28 04:50
 *
 * @author Deng Haozhi
 * @see GameEveItemDrivenAdapter
 * @since 2.0.0
 */
@Lazy
@Component
public class SpringGameEveItemDrivenAdapter implements GameEveItemDrivenAdapter {

    private final GameEveItemESIUniverseRestClient gameEveItemESIUniverseRestClient;

    private final ItemDrivingAdapter itemDrivingAdapter;

    public SpringGameEveItemDrivenAdapter(GameEveItemESIUniverseRestClient gameEveItemESIUniverseRestClient, ItemDrivingAdapter itemDrivingAdapter) {
        this.gameEveItemESIUniverseRestClient = gameEveItemESIUniverseRestClient;
        this.itemDrivingAdapter = itemDrivingAdapter;
    }

    @Override
    public Optional<GameEveItemAggregate> fetch(String code, String createUserId) {
        ESIUniverseItemFindProfileRespDReqTransfer item = gameEveItemESIUniverseRestClient.fetchItem(code);
        String itemId = itemDrivingAdapter.create(ItemCreateCReqTransfer.builder()
                        .metaGroupId(item.getMeta_group_id())
                        .itemGroupId(item.getGroup_id())
                        .marketGroupId(item.getMarket_group_id())
                        .fullNameZh(item.getName())
                        .createUserId(createUserId).build().validate())
                .validate().getItemId();
        return Optional.ofNullable(GameEveItemAggregate.create(GameEveItemAggregate.builder()
                .itemId(itemId)
                .code(code)
                .isPublished(item.getPublished())
                .createUserId(createUserId)));
    }
}
