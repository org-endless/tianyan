package org.endless.tianyan.metadata.components.metagroup.metagroup.facade.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.endless.ddd.starter.common.annotation.log.Log;
import org.endless.ddd.starter.common.config.rest.response.RestResponse;
import org.endless.tianyan.metadata.common.model.facade.rest.TianyanMetadataRestController;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.handler.MetagroupCommandHandler;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer.MetagroupCreateCReqTransfer;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.command.transfer.MetagroupCreateCRespTransfer;
import org.endless.tianyan.metadata.components.metagroup.metagroup.application.query.handler.MetagroupQueryHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MetagroupRestController
 * <p>元分组领域REST控制器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataRestController
 * @since 0.0.1
 */
@Lazy
@RestController
@RequestMapping("/metagroup/metagroup")
public class MetagroupRestController implements TianyanMetadataRestController {

    /**
     * 元分组领域命令处理器
     */
    private final MetagroupCommandHandler metagroupCommandHandler;

    /**
     * 元分组领域查询处理器
     */
    private final MetagroupQueryHandler metagroupQueryHandler;

    public MetagroupRestController(MetagroupCommandHandler metagroupCommandHandler, MetagroupQueryHandler metagroupQueryHandler) {
        this.metagroupCommandHandler = metagroupCommandHandler;
        this.metagroupQueryHandler = metagroupQueryHandler;
    }

    @PostMapping("/command/create")
    @Log(message = "元分组创建命令", value = "#command")
    public ResponseEntity<RestResponse<MetagroupCreateCRespTransfer>> create(
            @NotNull(message = "元分组创建命令请求传输对象不能为空")
            @Valid @RequestBody MetagroupCreateCReqTransfer command) {
        return response(metagroupCommandHandler.create(command)).success("元分组创建成功");
    }

    @Override
    public String domainDescription() {
        return "元分组领域";
    }
}
