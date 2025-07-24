package org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper.TianyanItemMapper;
import org.endless.tianyan.item.components.item.group.game.eve.infrastructure.data.record.GameEveItemGroupRecord;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 * GameEveItemGroupMapper
 * <p>游戏EVE资源项分组聚合 Mybatis-Plus 数据访问对象
 * <p>
 * create 2025/07/21 16:03
 * <p>
 * update 2025/07/21 16:03
 *
 * @author Deng Haozhi
 * @see TianyanItemMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveItemGroupMapper extends TianyanItemMapper<GameEveItemGroupRecord> {

    default Optional<String> findItemGroupIdByCode(String code) {
        QueryWrapper<GameEveItemGroupRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveItemGroupRecord::getItemGroupId)
                .eq(GameEveItemGroupRecord::getCode, code);
        return findFirstByWrapper(queryWrapper).map(GameEveItemGroupRecord::getItemGroupId);
    }
}
