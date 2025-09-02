DROP TABLE IF EXISTS item_category;
CREATE TABLE item_category (
    item_category_id     VARCHAR(255) NOT NULL COMMENT '资源项分类ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '资源项分类中文全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '资源项分类中文别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '资源项分类中文简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '资源项分类英文全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '资源项分类英文别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '资源项分类英文简称',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_item_category (item_category_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项分类表';
