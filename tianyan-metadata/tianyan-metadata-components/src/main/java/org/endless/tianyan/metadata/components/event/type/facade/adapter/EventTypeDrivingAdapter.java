package org.endless.tianyan.metadata.components.event.type.facade.adapter;

import org.endless.tianyan.metadata.common.model.facade.adapter.TianyanMetadataDrivingAdapter;
import org.endless.tianyan.metadata.components.event.type.application.command.transfer.EventTypeCreateReqCTransfer;

/**
 * EventTypeDrivingAdapter
 * <p>事件类型领域主动适配器
 * <p>
 * create 2025/07/28 18:41
 * <p>
 * update 2025/07/28 18:41
 *
 * @author Deng Haozhi
 * @see TianyanMetadataDrivingAdapter
 * @since 0.0.1
 */
public interface EventTypeDrivingAdapter extends TianyanMetadataDrivingAdapter {

    void create(EventTypeCreateReqCTransfer command);
}
