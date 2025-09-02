package org.endless.tianyan.item.components.item.game.eve.item.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper.TianyanItemMapper;
import org.endless.tianyan.item.components.item.game.eve.item.infrastructure.data.record.GameEveItemRecord;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;

/**
 * GameEveItemMapper
 * <p>游戏EVE资源项聚合 Mybatis-Plus 数据访问对象
 * <p>
 * itemCreate 2025/07/23 01:04
 * <p>
 * update 2025/07/23 01:04
 *
 * @author Deng Haozhi
 * @see TianyanItemMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveItemMapper extends TianyanItemMapper<GameEveItemRecord> {

    default Optional<String> findItemIdByCode(String code) {
        QueryWrapper<GameEveItemRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveItemRecord::getItemId)
                .eq(GameEveItemRecord::getCode, code);
        return findFirstByWrapper(queryWrapper).map(GameEveItemRecord::getItemId);
    }

    default List<String> findItemIdsByCodes(List<String> codes) {
        QueryWrapper<GameEveItemRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveItemRecord::getItemId)
                .in(GameEveItemRecord::getCode, codes)
                .orderByAsc(GameEveItemRecord::getItemId);
        return findAllByWrapper(queryWrapper).stream().map(GameEveItemRecord::getItemId).toList();
    }

    default Optional<String> findCodeByItemId(String itemId) {
        QueryWrapper<GameEveItemRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveItemRecord::getCode)
                .eq(GameEveItemRecord::getItemId, itemId);
        return findFirstByWrapper(queryWrapper).map(GameEveItemRecord::getCode);
    }
}
