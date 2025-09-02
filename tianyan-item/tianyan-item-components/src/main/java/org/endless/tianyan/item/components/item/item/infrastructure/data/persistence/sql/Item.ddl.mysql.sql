DROP TABLE IF EXISTS item;
CREATE TABLE item (
    item_id              VARCHAR(255) NOT NULL COMMENT '资源项ID',
    item_group_id        VARCHAR(255) NOT NULL COMMENT '资源项分组ID',
    metagroup_id         VARCHAR(255) NULL COMMENT '元分组ID',
    market_group_id      VARCHAR(255) NULL COMMENT '市场分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '资源项中文全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '资源项中文别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '资源项中文简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '资源项英文全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '资源项英文别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '资源项英文简称',
    description          VARCHAR(255) NULL COMMENT '资源项描述',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT pk_item PRIMARY KEY (item_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项表';
CREATE INDEX idx_item_group_id ON item (item_group_id);
CREATE INDEX idx_item_metagroup_id ON item (metagroup_id);
CREATE INDEX idx_item_market_group_id ON item (market_group_id);
