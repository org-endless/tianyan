DROP TABLE IF EXISTS market_trade_history;
CREATE TABLE market_trade_history (
    market_trade_history_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '市场交易历史ID',
    item_id VARCHAR(255) NOT NULL COMMENT '资源项ID',
    period_period_start_at BIGINT NOT NULL COMMENT '市场交易历史范围开始时间',
    period_period_end_at BIGINT NOT NULL COMMENT '市场交易历史范围结束时间',
    price_average DECIMAL(17, 2) NOT NULL COMMENT '市场交易历史平均成交价格(17, 2)',
    price_highest DECIMAL(17, 2) NOT NULL COMMENT '市场交易历史最高成交价格(17, 2)',
    price_lowest DECIMAL(17, 2) NOT NULL COMMENT '市场交易历史最低成交价格(17, 2)',
    order_count DECIMAL(15, 0) NOT NULL COMMENT '市场交易历史订单数量(15, 0)',
    item_quantity DECIMAL(20, 5) NOT NULL COMMENT '市场交易历史资源项交易数量(20, 5)',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场交易历史表';
