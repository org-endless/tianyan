DROP TABLE IF EXISTS blueprint_game_eve;
CREATE TABLE blueprint_game_eve (
    game_eve_blueprint_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE蓝图ID',
    blueprint_id          VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    code                  VARCHAR(255) NOT NULL COMMENT '游戏EVE蓝图编码',
    type                  VARCHAR(255) NOT NULL COMMENT '游戏EVE蓝图类型',
    max_production_limit  INT          NOT NULL COMMENT '游戏EVE蓝图最大生产次数',
    create_user_id        VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id        VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed            BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at             BIGINT       NOT NULL COMMENT '创建时间',
    modify_at             BIGINT       NOT NULL COMMENT '修改时间',
    remove_at             BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (blueprint_id, remove_at),
    UNIQUE KEY (code, type, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE蓝图表';
