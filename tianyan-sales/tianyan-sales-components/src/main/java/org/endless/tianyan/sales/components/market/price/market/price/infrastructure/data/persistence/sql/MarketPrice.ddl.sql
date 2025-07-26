DROP TABLE IF EXISTS market_price;
CREATE TABLE market_price (
    market_price_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '市场价格ID',
    item_id VARCHAR(255) NOT NULL COMMENT '资源项ID',
    buy_price DECIMAL(17, 2) NOT NULL COMMENT '买入价格(17, 2)',
    sell_price DECIMAL(17, 2) NOT NULL COMMENT '卖出价格(17, 2)',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场价格表';