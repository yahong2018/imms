drop table code_seed;
drop table size;
drop table defect_code;
drop table machine_type;
drop table material_type;
drop table uom;

CREATE TABLE `code_seed`(
  `record_id`                BIGINT AUTO_INCREMENT        NOT NULL,
  `seed_no`                  varchar(50)                  NOT NULL,
  `seed_name`                varchar(50)                  NOT NULL,
  `initial_value`            int                          NOT NULL,
  `prefix`                   varchar(10)                  NOT NULL,
  `postfix`                  varchar(10)                  NOT NULL,
  `total_length`             int                          NOT NULL,

  PRIMARY KEY (`record_id`),
  index IDX_CODE_SEED_0(`seed_no`)
);

CREATE TABLE `size`  (
  `record_id`                     BIGINT AUTO_INCREMENT          NOT NULL,
  `size_no`                       varchar(10)                    NULL          COMMENT '尺码编码',
  `size_name`                     varchar(30)                    NULL          COMMENT '尺码名称',
  `description`                   varchar(250)                   NULL,
  `parent_size_id`                bigint                         NOT NULL,
  `size_no_path`                  varchar(110)                   NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `size_name_path`                varchar(330)                   NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_SIZE_01`(`size_no`) ,
  INDEX `IDX_SIZE_02`(`size_name`) ,
  INDEX `IDX_SIZE_03`(`parent_size_id`)
) COMMENT = '尺码';

CREATE TABLE `defect_code`  (
  `record_id`                     BIGINT AUTO_INCREMENT         NOT NULL,
  `defect_code_no`                varchar(10)                   NOT NULL,
  `defect_code_name`              varchar(30)                   NOT NULL,
  `description`                   varchar(250)                  NULL ,
  `parent_defect_code_id`         bigint                        NOT NULL,
  `defect_code_no_path`           varchar(110)                  NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `defect_code_name_path`         varchar(330)                  NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_DEFECT_CODE_01`(`defect_code_no`) ,
  INDEX `IDX_DEFECT_CODE_02`(`defect_code_name`) ,
  INDEX `IDX_DEFECT_CODE_03`(`parent_defect_code_id`)
) COMMENT = '缺陷类型';

CREATE TABLE `machine_type`  (
  `record_id`                     BIGINT AUTO_INCREMENT        NOT NULL,
  `machine_type_no`               varchar(10)                  NOT NULL,
  `machine_type_name`             varchar(30)                  NOT NULL ,
  `description`                   varchar(250)                 NULL,
  `parent_machine_type_id`        bigint                       NOT NULL,
  `machine_type_no_path`          varchar(110)                 NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `machine_type_name_path`        varchar(330)                 NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MACHINE_TYPE_01`(`machine_type_no`) ,
  INDEX `IDX_MACHINE_TYPE_02`(`machine_type_name`),
  INDEX `IDX_MACHINE_TYPE_03`(`parent_machine_type_id`)
)  COMMENT = '设备类型';

CREATE TABLE `material_type`  (
  `record_id`                     BIGINT AUTO_INCREMENT        NOT NULL,
  `material_type_no`              varchar(10)                  NOT NULL               COMMENT '物料类型编码',
  `material_type_name`            varchar(30)                  NOT NULL               COMMENT '物料类型名称',
  `description`                   varchar(250)                 NULL                   COMMENT '物料类型描述',
  `parent_material_type_id`       bigint                       NOT NULL,
  `material_type_no_path`         varchar(110)                 NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `material_type_name_path`       varchar(330)                 NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MT_01`(`material_type_no`) ,
  INDEX `IDX_MT_02`(`material_type_name`),
  INDEX `IDX_MT_03`(`parent_material_type_id`)
) COMMENT = '物料类型';

CREATE TABLE `uom`  (
  `record_id`                     BIGINT AUTO_INCREMENT       NOT NULL,
  `uom_no`                        varchar(10)                 NOT NULL ,
  `uom_name`                      varchar(30)                 NOT NULL               COMMENT '名称',
  `description`                   varchar(250)                NULL                   COMMENT '描述',

  PRIMARY KEY (`record_id`),
  INDEX `IDX_UOM_01`(`uom_no`) ,
  INDEX `IDX_UOM_02`(`uom_name`)
) COMMENT = '单位';

insert into `size` (`size_no`, `size_name`, `description`, `parent_size_id`, `size_no_path`,  `size_name_path` ) VALUES ( 'SZ', '尺码', NULL, 1,'SZ','尺码');
INSERT INTO `defect_code` (`defect_code_no`,`defect_code_name`,`description`,`parent_defect_code_id`,`defect_code_no_path`,`defect_code_name_path`) VALUES ('FT', '缺陷类型', NULL, 1,'FT','缺陷类型');
INSERT INTO `machine_type`(`machine_type_no`,`machine_type_name`,`description`,`parent_machine_type_id`,`machine_type_no_path`,`machine_type_name_path`  ) VALUES ('DT', '设备类型', NULL, 1,'DT','设备类型');
INSERT INTO `material_type`(`material_type_no`,`material_type_name` ,`description`,`parent_material_type_id`,`material_type_no_path` ,`material_type_name_path`) VALUES ('MT', '物料类型', NULL, 1,'MT','物料类型');

insert into `code_seed`(`seed_no`,`seed_name`,`initial_value`,`prefix`,`postfix` ,`total_length`) values('bomOrderNo','Bom单号',1,'','',10);
insert into `code_seed` (`seed_no`,`seed_name`,`initial_value`,`prefix`,`postfix` ,`total_length`) values('productionOrderNo','生产计划单号',1,'','',10);
insert into `code_seed` (`seed_no`,`seed_name`,`initial_value`,`prefix`,`postfix` ,`total_length`) values('pickingOrderNo','领料单号',1,'','',10);
insert into `code_seed` (`seed_no`,`seed_name`,`initial_value`,`prefix`,`postfix` ,`total_length`) values('cuttingOrderNo','裁剪单号',1,'','',10);
insert into `code_seed` (`seed_no`,`seed_name`,`initial_value`,`prefix`,`postfix` ,`total_length`) values('workOrderNo','作业单号',1,'','',10);
insert into `code_seed` (`seed_no`,`seed_name`,`initial_value`,`prefix`,`postfix` ,`total_length`) values('operationRoutingOrderNo','工艺路线单号',1,'','',10)


