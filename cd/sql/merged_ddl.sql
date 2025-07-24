-- File: Tax.ddl.sql 
DROP TABLE IF EXISTS taxation_tax;
CREATE TABLE taxation_tax (
    tax_id         VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '税务ID',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed     BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at      BIGINT       NOT NULL COMMENT '创建时间',
    modify_at      BIGINT       NOT NULL COMMENT '修改时间',
    remove_at      BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '税务表';
-- File: GameEveItemCategory.ddl.sql 
DROP TABLE IF EXISTS item_category_game_eve;
CREATE TABLE item_category_game_eve (
    game_eve_item_category_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项分类ID',
    item_category_id          VARCHAR(255) NOT NULL COMMENT '资源项分类ID',
    code                      VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分类编码',
    is_published              BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分类是否发布',
    create_user_id            VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id            VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed                BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                 BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                 BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                 BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE (item_category_id, remove_at),
    UNIQUE (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项分类表';

-- File: ItemCategory.ddl.sql 
DROP TABLE IF EXISTS item_category;
CREATE TABLE item_category (
    item_category_id     VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '资源项分类ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项分类表';

-- File: GameEveItem.ddl.sql 
DROP TABLE IF EXISTS item_game_eve;
CREATE TABLE item_game_eve (
    game_eve_item_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项ID',
    item_id          VARCHAR(255) NOT NULL COMMENT '资源项ID',
    code             VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项编码',
    create_user_id   VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id   VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed       BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at        BIGINT       NOT NULL COMMENT '创建时间',
    modify_at        BIGINT       NOT NULL COMMENT '修改时间',
    remove_at        BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项表';
-- File: GameEveItemGroup.ddl.sql 
DROP TABLE IF EXISTS item_group_game_eve;
CREATE TABLE item_group_game_eve (
    game_eve_item_group_id    VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE资源项分组ID',
    item_group_id             VARCHAR(255) NOT NULL COMMENT '资源项分组ID',
    code                      VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分组编码',
    game_eve_item_category_id VARCHAR(255) NOT NULL COMMENT '游戏EVE资源项分类ID',
    is_published              BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分组是否发布',
    is_use_base_price         BOOLEAN      NOT NULL COMMENT '游戏EVE资源项分组是否使用基准价格',
    create_user_id            VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id            VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed                BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                 BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                 BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                 BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE KEY (item_group_id, remove_at),
    UNIQUE KEY (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE资源项分组表';
CREATE INDEX idx_game_eve_item_category_id ON item_group_game_eve (game_eve_item_category_id);

-- File: ItemGroup.ddl.sql 
DROP TABLE IF EXISTS item_group;
CREATE TABLE item_group (
    item_group_id        VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '资源项分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项分组表';

-- File: Item.ddl.sql 
DROP TABLE IF EXISTS item;
CREATE TABLE item (
    item_id              VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '资源项ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '资源项表';
-- File: GameEveMarketGroup.ddl.sql 
DROP TABLE IF EXISTS market_game_eve_group;
CREATE TABLE market_game_eve_group (
    game_eve_market_group_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '游戏EVE市场分组ID',
    market_group_id          VARCHAR(255) NOT NULL COMMENT '市场分组ID',
    code                     VARCHAR(255) NOT NULL COMMENT '游戏EVE市场分组编码',
    create_user_id           VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id           VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed               BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at                BIGINT       NOT NULL COMMENT '创建时间',
    modify_at                BIGINT       NOT NULL COMMENT '修改时间',
    remove_at                BIGINT       NULL DEFAULT 0 COMMENT '删除时间',
    UNIQUE key (market_group_id, remove_at),
    UNIQUE key (code, remove_at)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '游戏EVE市场分组表';

-- File: MarketGroup.ddl.sql 
DROP TABLE IF EXISTS market_group;
CREATE TABLE market_group (
    market_group_id      VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '市场分组ID',
    name_zh_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_zh_alias        VARCHAR(255) NULL COMMENT '别名',
    name_zh_abbreviation VARCHAR(255) NULL COMMENT '简称',
    name_en_full_name    VARCHAR(255) NOT NULL COMMENT '全称',
    name_en_alias        VARCHAR(255) NULL COMMENT '别名',
    name_en_abbreviation VARCHAR(255) NULL COMMENT '简称',
    parent_id            VARCHAR(255) NULL COMMENT '父市场分组ID',
    create_user_id       VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id       VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed           BOOLEAN      NOT NULL COMMENT '是否已删除',
    create_at            BIGINT       NOT NULL COMMENT '创建时间',
    modify_at            BIGINT       NOT NULL COMMENT '修改时间',
    remove_at            BIGINT       NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '市场分组表';
CREATE INDEX idx_parent_id ON market_group (parent_id);
