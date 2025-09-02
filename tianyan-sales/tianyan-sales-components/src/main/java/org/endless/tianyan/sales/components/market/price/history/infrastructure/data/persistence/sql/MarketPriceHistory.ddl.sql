DROP TABLE IF EXISTS market_price_history;
CREATE TABLE market_price_history (
    market_price_history_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '市场价格历史ID',
    item_id VARCHAR(255) NOT NULL COMMENT '资源项ID',
    period_period_start_at BIGINT NOT NULL COMMENT '市场价格历史范围开始时间',
    period_period_end_at BIGINT NOT NULL COMMENT '市场价格历史范围结束时间',
    buy_price_average DECIMAL(17, 2) NOT NULL COMMENT '市场历史平均价格(17, 2)',
    buy_price_highest DECIMAL(17, 2) NOT NULL COMMENT '市场历史最高价格(17, 2)',
    buy_price_lowest DECIMAL(17, 2) NOT NULL COMMENT '市场历史最低价格(17, 2)',
    sell_price_average DECIMAL(17, 2) NOT NULL COMMENT '市场历史平均价格(17, 2)',
    sell_price_highest DECIMAL(17, 2) NOT NULL COMMENT '市场历史最高价格(17, 2)',
    sell_price_lowest DECIMAL(17, 2) NOT NULL COMMENT '市场历史最低价格(17, 2)',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场价格历史表';
