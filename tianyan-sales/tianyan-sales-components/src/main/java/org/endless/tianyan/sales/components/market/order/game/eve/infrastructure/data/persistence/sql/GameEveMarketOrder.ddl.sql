DROP TABLE IF EXISTS market_order_game_eve;
CREATE TABLE market_order_game_eve (
    game_eve_market_order_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE市场订单ID',
    market_order_id          VARCHAR(255) NOT NULL COMMENT '市场订单ID',
    code                     VARCHAR(255) NOT NULL COMMENT '游戏EVE市场订单编号',
    `range`                  VARCHAR(255) NOT NULL COMMENT '游戏EVE市场订单范围',
    system_id                VARCHAR(255) NOT NULL COMMENT '游戏EVE市场订单星系ID',
    station_id               VARCHAR(255) NOT NULL COMMENT '游戏EVE市场订单空间站ID',
    create_user_id           VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id           VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed               BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE市场订单表';
CREATE INDEX idx_game_eve_market_order_code ON market_order_game_eve (code);
