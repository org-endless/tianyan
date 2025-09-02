DROP TABLE IF EXISTS item_game_eve;
CREATE TABLE item_game_eve (
    game_eve_item_id VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项ID',
    item_id          VARCHAR(255) NOT NULL COMMENT '资源项ID',
    code             VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项编码',
    is_published     BOOLEAN      NOT NULL COMMENT '游戏EVE资源项是否发布',
    create_user_id   VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id   VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed       BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at        BIGINT       NOT NULL COMMENT '创建时间',
    modify_at        BIGINT       NOT NULL COMMENT '修改时间',
    remove_at        BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_item_game_eve (game_eve_item_id),
    CONSTRAINT UNIQUE KEY uk_item_ge_id (item_id, remove_at),
    CONSTRAINT UNIQUE KEY uk_item_ge_code (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项表';
