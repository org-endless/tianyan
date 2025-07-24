package org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.handler.impl;

import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.config.log.type.LogLevel;
import org.endless.ddd.simplified.starter.common.exception.model.application.command.transfer.CommandReqTransferNullException;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.handler.GameEveMetaGroupCommandHandler;
import org.endless.tianyan.metadata.components.meta.group.game.eve.application.command.transfer.GameEveMetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.anticorruption.GameEveMetaGroupRepository;
import org.endless.tianyan.metadata.components.meta.group.game.eve.domain.entity.GameEveMetaGroupAggregate;
import org.endless.tianyan.metadata.components.meta.group.meta.group.application.command.transfer.MetaGroupCreateReqCTransfer;
import org.endless.tianyan.metadata.components.meta.group.meta.group.facade.adapter.MetaGroupDrivingAdapter;

import java.util.Optional;

/**
 * GameEveMetaGroupCommandHandlerImpl
 * <p>游戏EVE元分组领域命令处理器
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see GameEveMetaGroupCommandHandler
 * @since 0.0.1
 */
public class GameEveMetaGroupCommandHandlerImpl implements GameEveMetaGroupCommandHandler {

    /**
     * 游戏EVE元分组聚合仓储接口
     */
    private final GameEveMetaGroupRepository gameEveMetaGroupRepository;

    /**
     * 元分组主动适配器接口
     */
    private final MetaGroupDrivingAdapter metaGroupDrivingAdapter;

    public GameEveMetaGroupCommandHandlerImpl(GameEveMetaGroupRepository gameEveMetaGroupRepository, MetaGroupDrivingAdapter metaGroupDrivingAdapter) {
        this.gameEveMetaGroupRepository = gameEveMetaGroupRepository;
        this.metaGroupDrivingAdapter = metaGroupDrivingAdapter;
    }

    @Override
    @Log(message = "游戏EVE元分组创建命令", value = "#command", level = LogLevel.TRACE)
    public void create(GameEveMetaGroupCreateReqCTransfer command) {
        Optional.ofNullable(command)
                .map(GameEveMetaGroupCreateReqCTransfer::validate)
                .orElseThrow(() -> new CommandReqTransferNullException("游戏EVE元分组创建命令参数不能为空"));
        String metaGroupId = metaGroupDrivingAdapter.create(MetaGroupCreateReqCTransfer.builder()
                        .fullNameZh(command.getFullNameZh())
                        .fullNameEn(command.getFullNameEn())
                        .createUserId(command.getCreateUserId())
                        .build().validate())
                .validate().getMetaGroupId();
        GameEveMetaGroupAggregate aggregate = GameEveMetaGroupAggregate.create(GameEveMetaGroupAggregate.builder()
                .metaGroupId(metaGroupId)
                .code(command.getCode())
                .createUserId(command.getCreateUserId()));
        gameEveMetaGroupRepository.save(aggregate);
    }
}
