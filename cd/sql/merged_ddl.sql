-- File: Tax.ddl.sql 
DROP TABLE IF EXISTS taxation_tax;
CREATE TABLE taxation_tax (
    tax_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '税务ID',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '税务表';
-- File: GameEveItemCategory.ddl.mysql.sql
DROP TABLE IF EXISTS item_category_game_eve;
CREATE TABLE item_category_game_eve (
    game_eve_item_category_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项分类ID',
    item_category_id          VARCHAR(255) NOT NULL COMMENT '资源项分类ID',
    code                      VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分类编码',
    is_published              BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分类是否发布',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed                BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                 BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                 BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                 BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE (item_category_id, remove_at),
    UNIQUE (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项分类表';

-- File: ItemCategory.ddl.mysql.sql
DROP TABLE IF EXISTS item_category;
CREATE TABLE item_category (
    item_category_id     VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '资源项分类ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项分类表';

-- File: GameEveItem.ddl.mysql.sql
DROP TABLE IF EXISTS item_game_eve;
CREATE TABLE item_game_eve (
    game_eve_item_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项ID',
    item_id          VARCHAR(255) NOT NULL COMMENT '资源项ID',
    code             VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项编码',
    is_published     BOOLEAN      NOT NULL COMMENT '游戏EVE资源项是否发布',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed       BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at        BIGINT       NOT NULL COMMENT '创建时间',
    modify_at        BIGINT       NOT NULL COMMENT '修改时间',
    remove_at        BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (item_id, remove_at),
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项表';

-- File: GameEveItemGroup.ddl.mysql.sql
DROP TABLE IF EXISTS item_group_game_eve;
CREATE TABLE item_group_game_eve (
    game_eve_item_group_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项分组ID',
    item_group_id          VARCHAR(255) NOT NULL COMMENT '资源项分组ID',
    item_category_id       VARCHAR(255) NOT NULL COMMENT '资源项分类ID',
    code                   VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分组编码',
    is_published           BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分组是否发布',
    is_use_base_price      BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分组是否使用基准价格',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed             BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at              BIGINT       NOT NULL COMMENT '创建时间',
    modify_at              BIGINT       NOT NULL COMMENT '修改时间',
    remove_at              BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (item_group_id, remove_at),
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项分组表';
CREATE INDEX idx_game_eve_item_category_id ON item_group_game_eve (item_category_id);

-- File: ItemGroup.ddl.mysql.sql
DROP TABLE IF EXISTS item_group;
CREATE TABLE item_group (
    item_group_id        VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '资源项分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项分组表';

-- File: Item.ddl.mysql.sql
DROP TABLE IF EXISTS item;
CREATE TABLE item (
    item_id              VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '资源项ID',
    meta_group_id        VARCHAR(255) NULL COMMENT '元分组ID',
    item_group_id        VARCHAR(255) NOT NULL COMMENT '资源项分组ID',
    market_group_id      VARCHAR(255) NULL COMMENT '市场分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    description          VARCHAR(255) NULL COMMENT '资源项描述',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项表';
CREATE INDEX idx_item_meta_group_id ON item (meta_group_id);
CREATE INDEX idx_item_item_group_id ON item (item_group_id);
CREATE INDEX idx_item_market_group_id ON item (market_group_id);

-- File: Blueprint.ddl.mysql.sql
DROP TABLE IF EXISTS blueprint;
CREATE TABLE blueprint (
    blueprint_id   VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '蓝图ID',
    item_id        VARCHAR(255) NOT NULL COMMENT '资源项ID',
    type           VARCHAR(255) NOT NULL COMMENT '蓝图类型',
    cycle          BIGINT       NOT NULL COMMENT '周期',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed     BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at      BIGINT       NOT NULL COMMENT '创建时间',
    modify_at      BIGINT       NOT NULL COMMENT '修改时间',
    remove_at      BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (item_id, type, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图表';

-- File: BlueprintMaterial.ddl.mysql.sql
DROP TABLE IF EXISTS blueprint_material;
CREATE TABLE blueprint_material (
    blueprint_material_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '蓝图物料ID',
    blueprint_id          VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    item_id               VARCHAR(255) NOT NULL COMMENT '资源项ID',
    quantity              BIGINT       NOT NULL COMMENT '蓝图物料数量',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed            BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at             BIGINT       NOT NULL COMMENT '创建时间',
    modify_at             BIGINT       NOT NULL COMMENT '修改时间',
    remove_at             BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图物料表';
CREATE INDEX idx_blueprint_material_blueprint_id ON blueprint_material (blueprint_id);

-- File: BlueprintProduct.ddl.mysql.sql
DROP TABLE IF EXISTS blueprint_product;
CREATE TABLE blueprint_product (
    blueprint_product_id VARCHAR(255)  NOT NULL PRIMARY KEY COMMENT '蓝图产品ID',
    blueprint_id         VARCHAR(255)  NOT NULL COMMENT '蓝图ID',
    item_id              VARCHAR(255)  NOT NULL COMMENT '资源项ID',
    quantity             BIGINT        NOT NULL COMMENT '蓝图产品数量',
    success_rate         DECIMAL(8, 5) NOT NULL COMMENT '蓝图产品成功率(8, 5)',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN       NOT NULL COMMENT '是否已删除',
    create_at            BIGINT        NOT NULL COMMENT '创建时间',
    modify_at            BIGINT        NOT NULL COMMENT '修改时间',
    remove_at            BIGINT        NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图产品表';
CREATE INDEX idx_blueprint_product_blueprint_id ON blueprint_product (blueprint_id);

-- File: BlueprintSkill.ddl.mysql.sql
DROP TABLE IF EXISTS blueprint_skill;
CREATE TABLE blueprint_skill (
    blueprint_skill_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '蓝图技能ID',
    blueprint_id       VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    item_id            VARCHAR(255) NOT NULL COMMENT '资源项ID',
    level              VARCHAR(255) NOT NULL COMMENT '蓝图技能等级',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed         BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at          BIGINT       NOT NULL COMMENT '创建时间',
    modify_at          BIGINT       NOT NULL COMMENT '修改时间',
    remove_at          BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '蓝图技能表';
CREATE INDEX idx_blueprint_skill_blueprint_id ON blueprint_skill (blueprint_id);

-- File: GameEveBlueprint.ddl.mysql.sql
DROP TABLE IF EXISTS blueprint_game_eve;
CREATE TABLE blueprint_game_eve (
    game_eve_blueprint_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE蓝图ID',
    blueprint_id          VARCHAR(255) NOT NULL COMMENT '蓝图ID',
    code                  VARCHAR(255) NOT NULL COMMENT '游戏EVE蓝图编码',
    type                  VARCHAR(255) NOT NULL COMMENT '游戏EVE蓝图类型',
    max_production_limit  INT          NULL COMMENT '游戏EVE蓝图最大生产次数',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed            BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at             BIGINT       NOT NULL COMMENT '创建时间',
    modify_at             BIGINT       NOT NULL COMMENT '修改时间',
    remove_at             BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (blueprint_id, remove_at),
    UNIQUE KEY (code, type, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE蓝图表';

-- File: GameEveMetagroup.ddl.mysql.sql
DROP TABLE IF EXISTS meta_group_game_eve;
CREATE TABLE meta_group_game_eve (
    game_eve_meta_group_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE元分组ID',
    meta_group_id          VARCHAR(255) NOT NULL COMMENT '元分组ID',
    code                   VARCHAR(255) NOT NULL COMMENT '游戏EVE元分组编码',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed             BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at              BIGINT       NOT NULL COMMENT '创建时间',
    modify_at              BIGINT       NOT NULL COMMENT '修改时间',
    remove_at              BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (meta_group_id, remove_at),
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE元分组表';

-- File: Metagroup.ddl.mysql.sql
DROP TABLE IF EXISTS meta_group;
CREATE TABLE meta_group (
    meta_group_id        VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '元分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '元分组表';

-- File: GameEveMarketGroup.ddl.mysql.sql
DROP TABLE IF EXISTS market_group_game_eve;
CREATE TABLE market_group_game_eve (
    game_eve_market_group_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE市场分组ID',
    market_group_id          VARCHAR(255) NOT NULL COMMENT '市场分组ID',
    code                     VARCHAR(255) NOT NULL COMMENT '游戏EVE市场分组编码',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed               BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE key (market_group_id, remove_at),
    UNIQUE key (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE市场分组表';

-- File: MarketGroup.ddl.mysql.sql
DROP TABLE IF EXISTS market_group;
CREATE TABLE market_group (
    market_group_id      VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '市场分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    parent_id            VARCHAR(255) NULL COMMENT '父市场分组ID',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建用户ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改用户ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场分组表';
CREATE INDEX idx_market_group_parent_id ON market_group (parent_id);
