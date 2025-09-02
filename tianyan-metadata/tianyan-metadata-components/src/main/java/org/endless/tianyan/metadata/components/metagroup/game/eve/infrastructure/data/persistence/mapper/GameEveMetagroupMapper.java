package org.endless.tianyan.metadata.components.metagroup.game.eve.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.metadata.common.model.infrastructure.data.persistence.mapper.TianyanMetadataMapper;
import org.endless.tianyan.metadata.components.metagroup.game.eve.infrastructure.data.record.GameEveMetagroupRecord;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 * GameEveMetagroupMapper
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
public interface GameEveMetagroupMapper extends TianyanMetadataMapper<GameEveMetagroupRecord> {

    default Optional<String> findMetagroupIdByCode(String gameEveMetagroupCode) {
        QueryWrapper<GameEveMetagroupRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveMetagroupRecord::getMetagroupId)
                .eq(GameEveMetagroupRecord::getCode, gameEveMetagroupCode);
        return findFirstByWrapper(queryWrapper).map(GameEveMetagroupRecord::getMetagroupId);
    }
}
