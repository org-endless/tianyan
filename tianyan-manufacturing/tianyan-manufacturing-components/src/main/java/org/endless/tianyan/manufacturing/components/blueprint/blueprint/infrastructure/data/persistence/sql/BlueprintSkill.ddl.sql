DROP TABLE IF EXISTS blueprint_skill;
CREATE TABLE blueprint_skill (
    blueprint_skill_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '蓝图技能ID',
    blueprint_id       VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    item_id            VARCHAR(255) NOT NULL COMMENT '资源项ID',
    level              VARCHAR(255) NOT NULL COMMENT '蓝图技能等级',
    create_user_id     VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id     VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed         BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at          BIGINT       NOT NULL COMMENT '创建时间',
    modify_at          BIGINT       NOT NULL COMMENT '修改时间',
    remove_at          BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图技能表';
CREATE INDEX idx_blueprint_skill_blueprint_id ON blueprint_skill (blueprint_id);
