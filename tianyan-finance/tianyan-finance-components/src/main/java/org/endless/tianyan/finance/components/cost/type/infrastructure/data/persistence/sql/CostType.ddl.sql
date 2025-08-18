DROP TABLE IF EXISTS cost_type;
CREATE TABLE cost_type
(
    cost_type_id   VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '成本类型ID',
    code           VARCHAR(255) NOT NULL COMMENT '成本类型编码',
    name_name_zh   VARCHAR(255) NOT NULL COMMENT '事件类型中文名称',
    name_name_en   VARCHAR(255) NULL COMMENT '事件类型英文名称',
    description    VARCHAR(255) NULL COMMENT '描述',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed     BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at      BIGINT       NOT NULL COMMENT '创建时间',
    modify_at      BIGINT       NOT NULL COMMENT '修改时间',
    remove_at      BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '成本类型表';
