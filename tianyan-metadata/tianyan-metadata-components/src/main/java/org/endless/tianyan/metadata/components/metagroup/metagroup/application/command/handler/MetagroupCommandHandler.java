package org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.handler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.tianyan.metadata.common.model.application.command.handler.TianyanMetadataCommandHandler;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer.MetagroupCreateCReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer.MetagroupCreateCRespTransfer;
import org.endless.tianyan.metadata.components.metagroup.metagroup.domain.entity.MetagroupAggregate;

/**
 * MetagroupCommandHandler
 * <p>元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/08/23 23:05
 *
 * @author Deng Haozhi
 * @see TianyanMetadataCommandHandler
 * @since 0.0.1
 */
public interface MetagroupCommandHandler extends TianyanMetadataCommandHandler<MetagroupAggregate> {

    /**
     * 元分组创建命令
     *
     * @param command 元分组创建命令请求传输对象
     * @return {@link MetagroupCreateCRespTransfer }
     */
    @Valid
    @NotNull(message = "元分组创建命令响应传输对象不能为空")
    MetagroupCreateCRespTransfer create(
            @NotNull(message = "元分组创建命令请求传输对象不能为空")
            @Valid MetagroupCreateCReqTransfer command);

}
