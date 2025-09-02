DROP TABLE IF EXISTS taxation_tax_rule;
CREATE TABLE taxation_tax_rule (
    tax_rule_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '税务规则ID',
    industry_id VARCHAR(255) NOT NULL COMMENT '行业ID',
    type VARCHAR(255) NOT NULL COMMENT '税务规则类型',
    code VARCHAR(255) NOT NULL COMMENT '税务规则编码',
    name_name_zh VARCHAR(255) NOT NULL COMMENT '税务规则中文名称',
    name_name_en VARCHAR(255) NULL COMMENT '税务规则英文名称',
    min_base_amount DECIMAL(17, 2) NOT NULL COMMENT '税务规则最小基准金额(17, 2)',
    max_base_amount DECIMAL(17, 2) NOT NULL COMMENT '税务规则最大基准金额(17, 2)',
    percentage DECIMAL(5, 2) NOT NULL COMMENT '税务规则比例(5, 2)',
    description VARCHAR(255) NULL COMMENT '税务规则描述',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '税务规则表';
