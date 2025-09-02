DROP TABLE IF EXISTS blueprint_product;
CREATE TABLE blueprint_product (
    blueprint_product_id VARCHAR(255)  NOT NULL COMMENT '蓝图产品ID',
    blueprint_id         VARCHAR(255)  NOT NULL COMMENT '蓝图ID',
    item_id              VARCHAR(255)  NOT NULL COMMENT '资源项ID',
    quantity             BIGINT        NOT NULL COMMENT '蓝图产品数量',
    success_rate         DECIMAL(8, 5) NOT NULL COMMENT '蓝图产品成功率(8, 5)',
    create_user_id       VARCHAR(255)  NOT NULL COMMENT '创建用户ID',
    modify_user_id       VARCHAR(255)  NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN       NOT NULL COMMENT '是否已删除',
    create_at            BIGINT        NOT NULL COMMENT '创建时间',
    modify_at            BIGINT        NOT NULL COMMENT '修改时间',
    remove_at            BIGINT        NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_blueprint_product (blueprint_product_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图产品表';
CREATE INDEX idx_blueprint_p_id ON blueprint_product (blueprint_id);
