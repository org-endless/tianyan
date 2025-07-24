DROP TABLE IF EXISTS item;
CREATE TABLE item (
    item_id              VARCHAR(255)   NOT NULL PRIMARY KEY COMMENT '资源项ID',
    item_group_id        VARCHAR(255)   NOT NULL COMMENT '资源项分组ID',
    market_group_id      VARCHAR(255)   NULL COMMENT '市场分组ID',
    name_zh_full_name    VARCHAR(255)   NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255)   NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255)   NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255)   NULL COMMENT '全称',
    name_en_alias        VARCHAR(255)   NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255)   NULL COMMENT '简称',
    mass_is_scientific   BOOLEAN        NULL COMMENT '质量数量是否科学计数',
    mass_quantity        DECIMAL(20, 5) NULL COMMENT '质量数量(20, 5)',
    mass_scientific      VARCHAR(255)   NULL COMMENT '质量数量科学计数',
    mass_unit            VARCHAR(255)   NULL COMMENT '质量单位',
    volume_is_scientific BOOLEAN        NULL COMMENT '体积数量是否科学计数',
    volume_quantity      DECIMAL(20, 5) NULL COMMENT '体积数量(20, 5)',
    volume_scientific    VARCHAR(255)   NULL COMMENT '体积数量科学计数',
    volume_unit          VARCHAR(255)   NULL COMMENT '体积单位',
    description          VARCHAR(255)   NULL COMMENT '描述',
    create_user_id       VARCHAR(255)   NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255)   NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN        NOT NULL COMMENT '是否已删除',
    create_at            BIGINT         NOT NULL COMMENT '创建时间',
    modify_at            BIGINT         NOT NULL COMMENT '修改时间',
    remove_at            BIGINT         NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项表';
CREATE INDEX idx_item_group_id ON item (item_group_id);
CREATE INDEX idx_market_group_id ON item (market_group_id);
