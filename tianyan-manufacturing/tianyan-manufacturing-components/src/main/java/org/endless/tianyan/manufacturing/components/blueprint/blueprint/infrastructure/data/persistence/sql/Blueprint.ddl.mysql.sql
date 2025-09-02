DROP TABLE IF EXISTS blueprint;
CREATE TABLE blueprint (
    blueprint_id   VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    item_id        VARCHAR(255) NOT NULL COMMENT '资源项ID',
    type           VARCHAR(255) NOT NULL COMMENT '蓝图类型',
    cycle          BIGINT       NOT NULL COMMENT '周期',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed     BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at      BIGINT       NOT NULL COMMENT '创建时间',
    modify_at      BIGINT       NOT NULL COMMENT '修改时间',
    remove_at      BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_blueprint (blueprint_id),
    CONSTRAINT UNIQUE KEY uk_blueprint_item_id_type (item_id, type, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图表';
