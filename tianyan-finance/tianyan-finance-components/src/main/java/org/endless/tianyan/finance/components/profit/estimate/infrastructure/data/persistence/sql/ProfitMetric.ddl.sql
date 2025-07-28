DROP TABLE IF EXISTS profit_metric;
CREATE TABLE profit_metric (
    profit_metric_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '利润指标ID',
    profit_estimate_id VARCHAR(255) NOT NULL COMMENT '预估利润ID',
    type VARCHAR(255) NOT NULL COMMENT '利润指标类型',
    amount DECIMAL(17, 2) NOT NULL COMMENT '利润金额(17, 2)',
    margin_percentage DECIMAL(5, 2) NOT NULL COMMENT '利润率百分比(5, 2)',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '利润指标表';