DROP TABLE IF EXISTS meta_group;
CREATE TABLE meta_group (
    meta_group_id        VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '元分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '元分组表';
