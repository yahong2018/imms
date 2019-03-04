drop table material;
drop table bom_order;
drop table bom;

CREATE TABLE `material`
(
  `record_id`            bigint     auto_increment     NOT NULL,
  `material_no`          varchar(12)    NOT NULL COMMENT '物料号',
  `material_name`        varchar(30)    NOT NULL COMMENT '物料名称',
  `material_type_id`     bigint       NOT NULL COMMENT '物料类型',
  `material_uom_id`      bigint       NOT NULL COMMENT '单位',
  `material_width`       decimal(10, 4) NULL COMMENT '幅宽',
  `material_weight`      decimal(10, 4) NULL COMMENT '纺织克重',
  `material_size_id`     bigint       NULL COMMENT '尺码',
  `material_price`       decimal(10, 2) NULL COMMENT '价格',
  `material_color`       varchar(20)    NULL COMMENT '颜色',
  `material_description` varchar(250)   NULL COMMENT '物料描述',

  PRIMARY KEY (`record_id`),
  INDEX `IDX_MATERIAL_01` (`material_no`),
  INDEX `IDX_MATERIAL_02` (`material_name`),
  INDEX `IDX_MATERIAL_03` (`material_type_id`),
  INDEX `IDX_MATERIAL_04` (`material_size_id`)
) COMMENT = '物料';







CREATE TABLE `bom_order`
(
  `record_id`         bigint   auto_increment                                             NOT NULL,
  `bom_order_no`      varchar(25)                                                         NOT NULL COMMENT 'Bom 单号',
  `bom_order_type`    enum ('PART', 'STANDARD', 'ORDER', 'DESIGN', 'MANUFACTURE', 'WORK') NOT NULL DEFAULT 'PART'
    COMMENT 'PART: "部件BOM", STANDARD: "基准BOM", ORDER: "订单BOM", DESIGN: "设计BOM",  MANUFACTURE: "生产BOM",  WORK: "作业BOM"',

  PRIMARY KEY (`record_id`),
  INDEX `IDX_BOM_ORDER_01` (`bom_order_no`),
  INDEX `IDX_BOM_ORDER_02` (`bom_order_type`)
) COMMENT = '物料单';

CREATE TABLE `bom`
(
  `record_id`                        bigint   auto_increment    NOT NULL,
  `bom_order_id`                     bigint                     NOT NULL,
  `component_type`                   enum ('CUSTOM', 'DEFAULT') NOT NULL COMMENT '子件类型 CUSTOM: "定制", DEFAULT: "默认"',
  `component_material_id`            bigint                     NOT NULL COMMENT '子件物料Id',
  `component_abstract_material_id`   bigint                     NULL COMMENT '子件抽象物料Id',
  `component_qty`                    float(8,2)                 NOT NULL COMMENT '子件用量',
  `component_uom_id`                 int                        NOT NULL COMMENT '子件单位',
#   `component_material_no_path`       varchar(130)               NOT NULL,
#   `component_material_name_path`     varchar(330)               NOT Null,
  `component_material_match_rule_id` bigint                     NULL COMMENT '子件匹配规则',
  `if_main_fabric`                   tinyint(1)                 NULL COMMENT '是否主面料',
  `parent_bom_id`                    bigint                     NULL COMMENT '上级BOM id',

  create_by                   bigint            not null,
  create_date                 datetime          not null,
  update_by                   bigint            null,
  update_date                 datetime          null,
  optlock                     int               not null default 0,

  PRIMARY KEY (`record_id`),
  INDEX `IDX_BOM_01` (`component_material_id`),
  INDEX `IDX_BOM_02` (`component_abstract_material_id`),
  INDEX `IDX_BOM_03` (`parent_bom_id`),
  INDEX `IDX_BOM_04` (`component_material_match_rule_id`),
  INDEX `IDX_BOM_05` (`bom_order_id`)
) COMMENT = '物料清单';




#
# CREATE TABLE `size_label_match_rule`
# (
#   `record_id`                  bigint      NOT NULL AUTO_INCREMENT,
#   `rule_no`                    varchar(10) NULL COMMENT '规则编码',
#   `product_category_id`        bigint      NULL COMMENT '产品品类',
#   `product_size`               varchar(10) NULL COMMENT '产品尺码',
#   `size_label_size`            varchar(10) NULL COMMENT '号标尺码',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_SLMR_01` (`rule_no`),
#   INDEX `IDX_SLMR_02` (`product_category_id`)
# ) COMMENT = '号标匹配规则';
#
# CREATE TABLE `size_match_rule`
# (
#   `record_id`            bigint              NOT NULL AUTO_INCREMENT,
#   `rule_no`              varchar(10)         NULL COMMENT '规则编码',
#   `description`          varchar(200)        NULL COMMENT '规则描述',
#   `fg_material_size`     varchar(10)         NULL COMMENT '产品规格',
#   `assist_material_size` varchar(10)         NULL COMMENT '辅材规格',
#   `unit`                 varchar(10)         NULL COMMENT '单位',
#   `type`                 varchar(10)         NOT NULL COMMENT 'zipper:拉链长度匹配 sizelabel:号标匹配',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_SMR_01` (`rule_no`)
# ) COMMENT = '规格匹配规则';
#
#
# CREATE TABLE `zipper_match_rule`
# (
#   `record_id`           bigint             NOT NULL AUTO_INCREMENT,
#   `rule_no`             varchar(10)        NULL COMMENT '规则编码',
#   `product_category_id` bigint             NULL COMMENT '产品品类',
#   `product_size`        varchar(10)        NULL COMMENT '产品尺码',
#   `zipper_category_id`  bigint             NULL COMMENT '拉链品类',
#   `zipper_size`         varchar(10)        NULL COMMENT '拉链长度',
#   `unit`                varchar(10)        NULL COMMENT '单位',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_ZMR_01` (`rule_no`),
#   INDEX `IDX_ZMR_02` (`product_category_id`),
#   INDEX `IDX_ZMR_03` (`zipper_category_id`)
# ) COMMENT = '拉链长度匹配规则';
#
#
#
# CREATE TABLE `price_scopes`
# (
#   `record_id`         bigint(20)     NOT NULL AUTO_INCREMENT,
#   `price_scopes_no`   varchar(10)    NULL COMMENT '价格带编码',
#   `price`             decimal(10, 2) NULL COMMENT '价格',
#   `material_group_id` bigint(20)     NULL COMMENT '物料组',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_PRICE_SCOPES_01` (`price_scopes_no`),
#   INDEX `IDX_PRICE_SCOPES_02` (`material_group_id`)
# ) COMMENT = '价格带';
#
# CREATE TABLE `price_scopes_match_rule`
# (
#   `record_id`                 bigint(20)   NOT NULL AUTO_INCREMENT,
#   `main_material_id`          bigint(20)   NULL COMMENT '主材物料',
#   `rule_no`                   varchar(10)  NULL COMMENT '规则编码',
#   `assist_material_id`        bigint(20)   NULL COMMENT '辅材物料',
#   `description`               varchar(200) NULL COMMENT '规则描述',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_PSMR_01` (`main_material_id`),
#   INDEX `IDX_PSMR_02` (`rule_no`),
#   INDEX `IDX_PSMR_03` (`assist_material_id`)
# ) COMMENT = '价格带匹配规则';
#
#
# CREATE TABLE `match_rule`
# (
#   `record_id`          bigint(20)   NOT NULL AUTO_INCREMENT,
#   `rule_no`            varchar(10)  NULL,
#   `description`        varchar(200) NULL,
#   `version`            varchar(10)  NULL,
#   `disable`            int(1)       NULL,
#   `unit`               varchar(10)  NULL,
#   `script`             longtext     NULL,
#   `type`               varchar(10)  NOT NULL COMMENT 'zipper:拉链长度匹配 sizelabel:号标匹配',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_MATCH_RULE_01` (`rule_no`)
# ) COMMENT ='规则表';
#
#
# CREATE TABLE `material_match_rule`
# (
#   `record_id`          bigint(20)  NOT NULL AUTO_INCREMENT,
#   `material_id`        bigint(20)  NULL,
#   `rule_id`            bigint(20)  NULL,
#   `type`               varchar(10) NULL COMMENT 'price:价格匹配 zipper:拉链长度匹配 sizelabel:号标匹配 color:颜色匹配',
#
#   PRIMARY KEY (`record_id`),
#   INDEX `IDX_MMR_01` (`material_id`),
#   INDEX `IDX_MMR_02` (`rule_id`)
# ) COMMENT ='物料匹配规则';
#
# CREATE TABLE `material_match_rule_log`
# (
#   `record_id`      bigint(20) NOT NULL AUTO_INCREMENT,
#   `bom_id`         bigint(20) NULL,
#   `rule_id`        bigint(20) NULL,
#
#   PRIMARY KEY (`record_id`)
# ) COMMENT = '物料匹配规则日志';