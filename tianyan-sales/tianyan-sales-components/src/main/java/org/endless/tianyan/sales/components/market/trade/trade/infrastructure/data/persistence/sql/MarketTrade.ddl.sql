DROP TABLE IF EXISTS market_trade;
CREATE TABLE market_trade (
    market_trade_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '市场交易ID',
    item_id VARCHAR(255) NOT NULL COMMENT '资源项ID',
    price DECIMAL(17, 2) NOT NULL COMMENT '成交价格(17, 2)',
    item_quantity VARCHAR(255) NOT NULL COMMENT '资源项交易数量(20, 5)',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场交易表';
