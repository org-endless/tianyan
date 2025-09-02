DROP TABLE IF EXISTS profit_estimate;
CREATE TABLE profit_estimate (
    profit_estimate_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '预估利润ID',
    item_id VARCHAR(255) NOT NULL COMMENT '资源项ID',
    industry_id VARCHAR(255) NOT NULL COMMENT '行业ID',
    event_type_id VARCHAR(255) NOT NULL COMMENT '事件类型ID',
    cost_estimate_id VARCHAR(255) NOT NULL COMMENT '预估成本ID',
    revenue_estimate_id VARCHAR(255) NOT NULL COMMENT '预估收入ID',
    tax_estimate_id VARCHAR(255) NOT NULL COMMENT '预估税务ID',
    fee_estimate_id VARCHAR(255) NOT NULL COMMENT '预估费用ID',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '预估利润表';
