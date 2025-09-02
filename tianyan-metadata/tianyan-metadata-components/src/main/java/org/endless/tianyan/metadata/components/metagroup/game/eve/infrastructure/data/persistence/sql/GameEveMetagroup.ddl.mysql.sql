DROP TABLE IF EXISTS metagroup_game_eve;
CREATE TABLE metagroup_game_eve (
    game_eve_metagroup_id VARCHAR(255) NOT NULL COMMENT '游戏EVE元分组ID',
    metagroup_id          VARCHAR(255) NOT NULL COMMENT '元分组ID',
    code                  VARCHAR(255) NOT NULL COMMENT '游戏EVE元分组编码',
    create_user_id        VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id        VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed            BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at             BIGINT       NOT NULL COMMENT '创建时间',
    modify_at             BIGINT       NOT NULL COMMENT '修改时间',
    remove_at             BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_game_eve_metagroup (game_eve_metagroup_id),
    CONSTRAINT UNIQUE KEY uk_metagroup_ge_id (metagroup_id, remove_at),
    CONSTRAINT UNIQUE KEY uk_metagroup_ge_code (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE元分组表';
