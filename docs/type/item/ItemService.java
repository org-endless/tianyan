package org.endless.fanli.common.type.item;

/**
 * ItemService
 * <p>资源项/商品服务模板类
 * <p>The item service model.
 * <p>create 2023/05/13 21:36
 * <p>update 2023/05/28 00:19
 *
 * @author Deng Haozhi
 * @since 0.0.3
 */
public interface ItemService {

    /**
     * 加载
     *
     * @param argument 参数
     */
    default <T> void load(T argument) {
    }

    /**
     * 加载
     *
     * @param arguments 参数
     */
    default <T> void load(T[] arguments) {
    }
}
