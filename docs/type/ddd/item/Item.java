// package org.endless.fanli.common.type.ddd.item;

// import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.Pattern;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import org.endless.fanli.common.constant.Regular;
// import org.endless.fanli.common.type.ddd.cast.Cost;
// import org.endless.fanli.common.type.ddd.name.Name;
// import org.endless.fanli.common.type.ddd.price.Price;
// import org.endless.fanli.common.type.ddd.profit.Profit;
// import org.endless.fanli.common.type.ddd.sales.Sales;
// import org.springframework.data.annotation.Id;
// import org.springframework.data.annotation.Version;
// import org.springframework.data.mongodb.core.index.Indexed;
// import org.springframework.util.StringUtils;
// import org.springframework.validation.annotation.Validated;

// import java.math.BigDecimal;

// /**
//  * Item
//  * <p>资源项/商品模板
//  * <p>The item model.
//  * <p>
//  * <p>create 2023/05/26 16:28
//  *
//  * @author Deng Haozhi
//  * @since 0.0.3
//  */
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Validated
// public class Item {

//     /**
//      * 复合编号：行业编号+"_"+资源项/商品编号
//      */
//     @Id
//     @NotEmpty
//     @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
//     private String id;

//     /**
//      * 资源项/商品编号
//      */
//     @Indexed
//     @NotEmpty
//     @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
//     private String itemId;

//     /**
//      * 行业编号
//      */
//     @Indexed
//     @NotEmpty
//     @Pattern(regexp = Regular.ID, message = Regular.ID_MESSAGE)
//     private String industryId;

//     /**
//      * 名称
//      */
//     private Name name;

//     /**
//      * 价格
//      */
//     private Price price;

//     /**
//      * 市场价格
//      */
//     private Price marketPrice;

//     /**
//      * 成本
//      */
//     private Cost cost;

//     /**
//      * 利润
//      */
//     private Profit profit;

//     /**
//      * 销量
//      */
//     private Sales sales;

//     /**
//      * 质量/重量
//      */
//     private BigDecimal mass;

//     /**
//      * 体积
//      */
//     private BigDecimal volume;

//     /**
//      * 是否发布
//      */
//     @Indexed
//     private boolean published;

//     /**
//      * 版本，乐观锁
//      */
//     @Version
//     private Long version;

//     /**
//      * 更新时间
//      */
//     private String updateDateTime;

//     /**
//      * 更新时间戳
//      */
//     private long updateTimeStamp;

//     /**
//      * 根据复合编号获取商品/资源项编号
//      * <p>Gets the item id based on the composite id.
//      *
//      * @param id id
//      * @return {@link String}
//      */
//     public static String getItemIdById(String id) {
//         if (!StringUtils.hasLength(id)) {
//             return null;
//         }
//         var split = id.split("_");
//         return split[split.length - 1];
//     }

//     /**
//      * 根据复合编号获取行业编号
//      * <p>Gets the industry id based on the composite id.
//      *
//      * @param id id
//      * @return {@link String}
//      */
//     public static String getIndustryIdById(String id) {
//         if (!StringUtils.hasLength(id)) {
//             return null;
//         }
//         var split = id.split("_");
//         return split[split.length - 2];
//     }

//     /**
//      * 获取符合编号
//      * <p>Gets the composite id.
//      *
//      * @param itemId     商品/资源项编号
//      * @param industryId 行业编号
//      * @return {@link String}
//      */
//     public static String getId(String itemId, String industryId) {
//         return industryId + "_" + itemId;
//     }
// }
