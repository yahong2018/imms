drop table material;
drop table bom_order;
drop table bom;

CREATE TABLE `material`  (
  `record_id`                  char(36)         NOT NULL ,
  `material_no`                varchar(12)      NOT NULL      COMMENT '物料号',
  `material_name`              varchar(30)      NOT NULL      COMMENT '物料名称',
  `material_type_id`           char(36)         NOT NULL      COMMENT '物料类型',
  `material_uom_id`            char(36)         NOT NULL      COMMENT '单位',
  `material_width`             decimal(10, 4)   NULL          COMMENT '幅宽',
  `material_weight`            decimal(10, 4)   NULL          COMMENT '纺织克重',
  `material_size_id`           char(36)         NULL          COMMENT '尺码',
  `material_price`             decimal(10, 2)   NULL          COMMENT '价格',
  `material_color`             varchar(20)      NULL          COMMENT '颜色',
  `material_description`       varchar(250)     NULL          COMMENT '物料描述',

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MATERIAL_01`(`material_no`) ,
  INDEX `IDX_MATERIAL_02`(`material_name`) ,
  INDEX `IDX_MATERIAL_03`(`material_type_id`) ,
  INDEX `IDX_MATERIAL_04`(`material_size_id`)
) COMMENT = '物料';

CREATE TABLE `bom_order`  (
  `record_id`                  char(36)          NOT NULL,
  `bom_order_no`               varchar(25)       NOT NULL     COMMENT 'Bom 单号',
  `bom_order_type_no`          enum('PART','STANDARD','ORDER','DESIGN','MANUFACTURE','WORK') NOT NULL DEFAULT 'PART'
                               COMMENT 'PART: "部件BOM", STANDARD: "基准BOM", ORDER: "订单BOM", DESIGN: "设计BOM",  MANUFACTURE: "生产BOM",  WORK: "作业BOM"',

  PRIMARY KEY (`record_id`),
  INDEX `IDX_BOM_ORDER_01`(`bom_order_no`),
  INDEX `IDX_BOM_ORDER_02`(`bom_order_type_no`)
) COMMENT = '物料单' ;

CREATE TABLE `bom`  (
  `record_id`                          char(36)        NOT NULL,
  `bom_order_id`                       char(36)        NOT NULL,
  `component_type`                     enum('CUSTOM','DEFAULT')   NOT NULL    COMMENT '子件类型 CUSTOM: "定制", DEFAULT: "默认"',
  `component_material_id`              char(36)        NOT NULL               COMMENT '子件物料Id',
  `component_abstract_material_id`     char(36)        NULL                   COMMENT '子件抽象物料Id',
  `component_qty`                      double          NOT NULL               COMMENT '子件用量',
  `component_uom_id`                   char(36)        NOT NULL               COMMENT '子件单位',
  `component_material_no_path`         varchar(130)    NOT NULL,
  `component_material_name_path`       varchar(330)    NOT Null,
  `component_material_match_rule_id`   char(36)        NULL                   COMMENT '子件匹配规则',
  `if_main_fabric`                     tinyint(1)      NULL                   COMMENT '是否主面料',
  `parent_bom_id`                      char(36)        NULL                   COMMENT '上级BOM id',

  PRIMARY KEY (`record_id`),
  INDEX `IDX_BOM_01`(`component_material_id`),
  INDEX `IDX_BOM_02`(`component_abstract_material_id`),
  INDEX `IDX_BOM_03`(`parent_bom_id`),
  INDEX `IDX_BOM_04`(`component_material_match_rule_id`),
  INDEX `IDX_BOM_05`(`bom_order_id`)
) COMMENT = '物料清单' ;