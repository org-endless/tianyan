DROP TABLE IF EXISTS meta_group_game_eve;
CREATE TABLE meta_group_game_eve (
    game_eve_meta_group_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE元分组ID',
    meta_group_id          VARCHAR(255) NOT NULL COMMENT '元分组ID',
    code                   VARCHAR(255) NOT NULL COMMENT '游戏EVE元分组编码',
    create_user_id         VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id         VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed             BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at              BIGINT       NOT NULL COMMENT '创建时间',
    modify_at              BIGINT       NOT NULL COMMENT '修改时间',
    remove_at              BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (meta_group_id, remove_at),
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE元分组表';
