DROP TABLE IF EXISTS data_game_eve;
CREATE TABLE data_game_eve (
    game_eve_data_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项ID',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE数据表';