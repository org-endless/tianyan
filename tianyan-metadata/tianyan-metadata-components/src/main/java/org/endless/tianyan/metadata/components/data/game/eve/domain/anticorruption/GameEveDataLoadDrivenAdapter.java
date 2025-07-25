package org.endless.tianyan.metadata.components.data.game.eve.domain.anticorruption;

import org.endless.tianyan.metadata.common.model.domain.anticorruption.TianyanMetadataDrivenAdapter;
import org.endless.tianyan.metadata.components.data.game.eve.domain.type.GameEveDataTypeEnum;

/**
 * GameEveDataLoadDrivenAdapter
 * <p>
 * create 2025/07/20 21:30
 * <p>
 * update 2025/07/20 21:31
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivenAdapter
 * @since 0.0.1
 */
public interface GameEveDataLoadDrivenAdapter extends TianyanMetadataDrivenAdapter {

    void load(GameEveDataTypeEnum dataType);
}
