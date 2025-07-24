package org.endless.tianyan.metadata.components.data.game.eve.infrastructure.adapter.meta.group;

import org.endless.tianyan.metadata.common.model.domain.anticorruption.TianyanMetadataDrivenAdapter;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.query.transfer.GameEveMetaGroupFindByCodeReqQTransfer;

/**
 * GameEveDataMetaGroupDrivenAdapter
 * <p>
 * create 2025/07/24 16:03
 * <p>
 * update 2025/07/24 16:04
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenAdapter
 * @since 2.0.0
 */
public interface GameEveDataMetaGroupDrivenAdapter extends TianyanMetadataDrivenAdapter {

    void create(GameEveMetaGroupCreateReqCTransfer command);

    String findMetaGroupIdByCode(GameEveMetaGroupFindByCodeReqQTransfer query);
}
