DROP TABLE IF EXISTS industry;
CREATE TABLE industry (
    industry_id          VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '行业ID',
    industry_category_id VARCHAR(255) NOT NULL COMMENT '行业分类ID',
    code                 VARCHAR(255) NOT NULL COMMENT '行业编码',
    name_name_zh         VARCHAR(255) NOT NULL COMMENT '行业中文名称',
    name_name_en         VARCHAR(255) NULL COMMENT '行业英文名称',
    description          VARCHAR(255) NULL COMMENT '行业描述',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '行业表';
CREATE INDEX idx_industry_category_id ON industry (industry_category_id);
