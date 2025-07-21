DROP TABLE IF EXISTS item_category_game_eve;
CREATE TABLE item_category_game_eve (
    game_eve_item_category_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE物品分类ID',
    item_category_id VARCHAR(255) NOT NULL COMMENT '物品分类ID',
    code VARCHAR(255) NOT NULL COMMENT '游戏EVE物品分类编码',
    is_published BOOLEAN NOT NULL COMMENT '游戏EVE物品分类是否发布',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE物品分类表';