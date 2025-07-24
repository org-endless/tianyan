DROP TABLE IF EXISTS market_game_eve_group;
CREATE TABLE market_game_eve_group (
    game_eve_market_group_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE市场分组ID',
    market_group_id          VARCHAR(255) NOT NULL COMMENT '市场分组ID',
    code                     VARCHAR(255) NOT NULL COMMENT '游戏EVE市场分组编码',
    create_user_id           VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id           VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed               BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE key (market_group_id, remove_at),
    UNIQUE key (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE市场分组表';
