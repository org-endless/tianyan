DROP TABLE IF EXISTS blueprint_material;
CREATE TABLE blueprint_material (
    blueprint_material_id VARCHAR(255) NOT NULL COMMENT '蓝图物料ID',
    blueprint_id          VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    item_id               VARCHAR(255) NOT NULL COMMENT '资源项ID',
    quantity              BIGINT       NOT NULL COMMENT '蓝图物料数量',
    create_user_id        VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id        VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed            BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at             BIGINT       NOT NULL COMMENT '创建时间',
    modify_at             BIGINT       NOT NULL COMMENT '修改时间',
    remove_at             BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    CONSTRAINT PRIMARY KEY pk_blueprint_material (blueprint_material_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图物料表';
CREATE INDEX idx_blueprint_m_id ON blueprint_material (blueprint_id);
