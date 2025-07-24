DROP TABLE IF EXISTS item_group_game_eve;
CREATE TABLE item_group_game_eve (
    game_eve_item_group_id    VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项分组ID',
    item_group_id             VARCHAR(255) NOT NULL COMMENT '资源项分组ID',
    code                      VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分组编码',
    game_eve_item_category_id VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分类ID',
    is_published              BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分组是否发布',
    is_use_base_price         BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分组是否使用基准价格',
    create_user_id            VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id            VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed                BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                 BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                 BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                 BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (item_group_id, remove_at),
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项分组表';
CREATE INDEX idx_game_eve_item_category_id ON item_group_game_eve (game_eve_item_category_id);
