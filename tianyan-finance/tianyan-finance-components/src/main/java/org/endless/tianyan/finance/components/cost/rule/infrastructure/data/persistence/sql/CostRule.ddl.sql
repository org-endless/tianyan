DROP TABLE IF EXISTS cost_rule;
CREATE TABLE cost_rule
(
    cost_rule_id    VARCHAR(255)   NOT NULL PRIMARY KEY COMMENT '成本规则ID',
    industry_id     VARCHAR(255)   NOT NULL COMMENT '行业ID',
    event_type_id   VARCHAR(255)   NOT NULL COMMENT '事件ID',
    cost_type_id    VARCHAR(255)   NOT NULL COMMENT '成本类型ID',
    min_base_amount DECIMAL(17, 2) NOT NULL COMMENT '成本规则最小基准金额(17, 2)',
    max_base_amount DECIMAL(17, 2) NOT NULL COMMENT '成本规则最大基准金额(17, 2)',
    percentage      DECIMAL(5, 2)  NOT NULL COMMENT '成本规则比例(5, 2)',
    description     VARCHAR(255) NULL COMMENT '成本规则描述',
    create_user_id  VARCHAR(255)   NOT NULL COMMENT '创建者ID',
    modify_user_id  VARCHAR(255)   NOT NULL COMMENT '修改者ID',
    is_removed      BOOLEAN        NOT NULL COMMENT '是否已删除',
    create_at       BIGINT         NOT NULL COMMENT '创建时间',
    modify_at       BIGINT         NOT NULL COMMENT '修改时间',
    remove_at       BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '成本规则表';
