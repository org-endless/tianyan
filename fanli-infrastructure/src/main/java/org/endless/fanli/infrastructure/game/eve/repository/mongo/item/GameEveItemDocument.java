package org.endless.fanli.infrastructure.game.eve.repository.mongo.item;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.endless.fanli.common.constant.Regular;
import org.endless.fanli.common.type.ddd.cast.Cost;
import org.endless.fanli.common.type.ddd.name.Name;
import org.endless.fanli.common.type.ddd.price.Price;
import org.endless.fanli.common.type.ddd.profit.Profit;
import org.endless.fanli.common.type.ddd.sales.Sales;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

/**
 * GameEveItem
 * <p>游戏EVE物品/商品文档类，映射数据文档game.eve.item
 * <p>Game EVE item class mapping the data document named game.eve.item.
 * <p>
 * <p>create 2023/03/07 1:28
 * <p>update 2023/05/28 00:35
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Document("game.eve.item")
public class GameEveItemDocument {
    
    /**
     * 编号：应用程序编号+"_"+物品/商品编号
     * <p>id: applicationId + "_" + itemId
     */
    @NotEmpty
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String id;

    /**
     * 物品/商品编号
     */
    @NotEmpty
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String itemId;

    /**
     * 应用程序编号
     */
    @NotEmpty
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String applicationId;

    /**
     * 行业编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String industryId;

    /**
     * 名称
     */
    private Name name;

    /**
     * 价格
     */
    private Price price;

    /**
     * 市场价格
     */
    private Price marketPrice;

    /**
     * 成本
     */
    private Cost cost;

    /**
     * 利润
     */
    private Profit profit;

    /**
     * 销量
     */
    private Sales sales;

    /**
     * 质量/重量
     */
    private BigDecimal mass;

    /**
     * 体积
     */
    private BigDecimal volume;

    /**
     * 是否发布
     */
    private boolean published;

    /**
     * 版本，乐观锁
     */
    private Long version;

    /**
     * 更新时间
     */
    private String updateDateTime;

    /**
     * 更新时间戳
     */
    private long updateTimeStamp;

    /**
     * EVE分组编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String eveGroupId;

    /**
     * EVE市场分组编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String eveMarketGroupId;

    /**
     * EVE类型分组编号
     */
    @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
    private String eveMetaGroupId;
}
