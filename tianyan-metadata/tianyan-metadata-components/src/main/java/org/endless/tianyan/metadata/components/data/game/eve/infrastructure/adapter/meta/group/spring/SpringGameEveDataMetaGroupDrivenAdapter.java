package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.meta.group.spring;

import org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.meta.group.GameEveDataMetaGroupDrivenAdapter;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindByCodeReqQTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.facade.adapter.GameEveMetaGroupDrivingAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * SpringGameEveDataMetaGroupDrivenAdapter
 * <p>
 * create 2025/07/24 11:52
 * <p>
 * update 2025/07/24 11:52
 *
 * @author Deng Haozhi
 * @since 0.0.1
 */
@Lazy
@Component
public class SpringGameEveDataMetaGroupDrivenAdapter implements GameEveDataMetaGroupDrivenAdapter {

    private final GameEveMetaGroupDrivingAdapter gameEveMetaGroupDrivingAdapter;

    public SpringGameEveDataMetaGroupDrivenAdapter(GameEveMetaGroupDrivingAdapter gameEveMetaGroupDrivingAdapter) {
        this.gameEveMetaGroupDrivingAdapter = gameEveMetaGroupDrivingAdapter;
    }

    @Override
    public void create(GameEveMetaGroupCreateReqCTransfer command) {
        gameEveMetaGroupDrivingAdapter.create(command);
    }

    @Override
    public String findMetaGroupIdByCode(GameEveMetaGroupFindByCodeReqQTransfer query) {
        return gameEveMetaGroupDrivingAdapter.findMetaGroupIdByCode(query).validate().getMetaGroupId();
    }

}
