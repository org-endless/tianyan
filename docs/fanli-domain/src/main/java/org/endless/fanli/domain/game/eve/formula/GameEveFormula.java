package org.endless.erp.game.eve.formula;

import lombok.*;
import org.endless.fanli.common.type.ddd.formula.Formula;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 * GameEveFormula
 * <p>游戏EVE配方类，映射数据文档game.eve.formula
 * <p>Game EVE formula class mapping the data document named game.eve.formula.
 * <p>
 * <p>create 2023/4/11 16:51
 * <p>update 2023/8/15 18:41
 *
 * @author Deng Haozhi
 * @see Formula
 * @since 0.0.2
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Document("game.eve.formula")
public class GameEveFormula extends Formula {

    /**
     * 配方类别
     */
    private Categories categories;

    @Getter
    public enum Categories {

        manufacturing("0", "producing", "制造"),
        invention("1", "invention", "发明"),
        copying("2", "copying", "拷贝"),
        researchMaterial("3", "researchMaterial", "材料成本研究"),
        researchTime("4", "researchTime", "时间成本研究"),
        planet("5", "planet", "行星工业");

        private final String categoriesId;
        private final String enInstruction;
        private final String zhInstruction;

        Categories(String categoriesId, String enInstruction, String zhInstruction) {
            this.categoriesId = categoriesId;
            this.enInstruction = enInstruction;
            this.zhInstruction = zhInstruction;
        }
    }
}
