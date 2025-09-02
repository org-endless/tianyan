DROP TABLE IF EXISTS market_group;
CREATE TABLE market_group (
    market_group_id      VARCHAR(255) NOT NULL COMMENT '市场分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '市场分组中文全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '市场分组中文别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '市场分组中文简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '市场分组英文全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '市场分组英文别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '市场分组英文简称',
    parent_id            VARCHAR(255) NULL COMMENT '父市场分组ID',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_market_group (market_group_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场分组表';
CREATE INDEX idx_market_g_parent_id ON market_group (parent_id);
