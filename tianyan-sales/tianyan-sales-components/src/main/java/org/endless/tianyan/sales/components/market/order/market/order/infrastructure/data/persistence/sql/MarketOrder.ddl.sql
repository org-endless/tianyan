DROP TABLE IF EXISTS market_order;
CREATE TABLE market_order (
    market_order_id VARCHAR(255)   NOT NULL PRIMARY KEY COMMENT '市场订单ID',
    type            VARCHAR(255)   NOT NULL COMMENT '市场订单类型',
    quantity_total  DECIMAL(20, 5) NOT NULL COMMENT '市场订单总数(20, 5)',
    quantity_remain DECIMAL(20, 5) NOT NULL COMMENT '市场订单剩余数量(20, 5)',
    quantity_min    DECIMAL(20, 5) NOT NULL COMMENT '市场订单最小交易数量(20, 5)',
    price           DECIMAL(17, 2) NOT NULL COMMENT '市场订单价格(17, 2)',
    issued_at       BIGINT         NOT NULL COMMENT '市场订单创建时间',
    expire_at       BIGINT         NULL COMMENT '市场订单过期时间',
    create_user_id  VARCHAR(255)   NOT NULL COMMENT '创建者ID',
    modify_user_id  VARCHAR(255)   NOT NULL COMMENT '修改者ID',
    is_removed      BOOLEAN        NOT NULL COMMENT '是否已删除',
    create_at       BIGINT         NOT NULL COMMENT '创建时间',
    modify_at       BIGINT         NOT NULL COMMENT '修改时间',
    remove_at       BIGINT         NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场订单表';
