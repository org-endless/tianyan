package org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.endless.tianyan.item.common.model.infrastructure.data.persistence.mapper.TianyanItemMapper;
import org.endless.tianyan.item.components.item.category.game.eve.infrastructure.data.record.GameEveItemCategoryRecord;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 * GameEveItemCategoryMapper
 * <p>游戏EVE资源项分类聚合 Mybatis-Plus 数据访问对象
 * <p>
 * itemCreate 2025/07/20 22:39
 * <p>
 * update 2025/07/20 22:39
 *
 * @author Deng Haozhi
 * @see TianyanItemMapper
 * @since 0.0.1
 */
@Lazy
@Mapper
public interface GameEveItemCategoryMapper extends TianyanItemMapper<GameEveItemCategoryRecord> {

    default Optional<String> findItemCategoryIdByCode(String code) {
        QueryWrapper<GameEveItemCategoryRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GameEveItemCategoryRecord::getItemCategoryId)
                .eq(GameEveItemCategoryRecord::getCode, code);
        return findFirstByWrapper(queryWrapper).map(GameEveItemCategoryRecord::getItemCategoryId);
    }
}
