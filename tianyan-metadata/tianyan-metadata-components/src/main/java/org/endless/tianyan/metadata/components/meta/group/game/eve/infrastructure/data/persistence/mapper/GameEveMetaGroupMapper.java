package org.endless.tianyan.metadata.components.meta.group.game.eve.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.TianyanMetadataMapper;
import org.endless.tianyan.metadata.components.meta.group.game.eve.infrastructure.data.record.GameEveMetaGroupRecord;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 * GameEveMetaGroupMapper
 * <p>游戏EVE元分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/24 11:25
 * <p>
 * update 2025/07/24 11:25
 *
 * @author Deng Haozhi
 * @see TianyanMetadataMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveMetaGroupMapper extends TianyanMetadataMapper<GameEveMetaGroupRecord> {

    default Optional<String> findMetaGroupIdByCode(String code) {
        QueryWrapper<GameEveMetaGroupRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveMetaGroupRecord::getMetaGroupId)
                .eq(GameEveMetaGroupRecord::getCode, code);
        return findFirstByWrapper(queryWrapper).map(GameEveMetaGroupRecord::getMetaGroupId);
    }
}
