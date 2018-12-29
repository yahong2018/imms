drop table code_seed;
drop table media;
drop table media_belong;
drop table size;
drop table defect_code;
drop table machine_type;
drop table material_type;
drop table uom;

CREATE TABLE `code_seed`(
  `record_id`                char(36)            NOT NULL,
  `seed_no`                  varchar(50)         NOT NULL,
  `seed_name`                varchar(50)         NOT NULL,
  `initial_value`            int                 NOT NULL,
  `prefix`                   varchar(10)         NOT NULL,
  `postfix`                  varchar(10)         NOT NULL,
  `total_length`             int                 NOT NULL,

  PRIMARY KEY (`record_id`),
  index IDX_CODE_SEED_0(`seed_no`)
);

CREATE TABLE `media`  (
  `record_id`                      char(36)            NOT NULL,
  `media_type`                     varchar(10)         NOT NULL,            -- 类型：Pad需要根据类型来显示图片或者播放视频
  `media_url`                      varchar(255)        NOT NULL,
  `media_name`                     varchar(100)        NOT NULL,
  `media_size`                     int                 NOT NULL,
  `media_description`              varchar(250)        NULL ,

  PRIMARY KEY (`record_id`),
  INDEX IDX_MEDIA_0 (`media_name`)
) COMMENT = '多媒体';

CREATE TABLE `media_belong`(
    `record_id`                   char(36)            NOT NULL,
    `belong_to_id`                char(36)            NOT NULL,
    `media_id`                    char(36)            NOT NULL,

    primary key(`record_id`),
    INDEX IDX_MEDIA_BELONG_0 (`belong_to_id`),
    INDEX IDX_MEDIA_BELONG_1 (`media_id`)
) COMMENT ='多媒体所属';

CREATE TABLE `size`  (
  `record_id`                     char(36)             NOT NULL,
  `size_no`                       varchar(10)          NULL          COMMENT '尺码编码',
  `size_name`                     varchar(30)          NULL          COMMENT '尺码名称',
  `size_description`              varchar(250)         NULL,
  `parent_size_id`                char(36)             NOT NULL,
  `size_no_path`                  varchar(110)         NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `size_name_path`                varchar(330)         NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_SIZE_01`(`size_no`) ,
  INDEX `IDX_SIZE_02`(`size_name`) ,
  INDEX `IDX_SIZE_03`(`parent_size_id`)
) COMMENT = '尺码';

CREATE TABLE `defect_code`  (
  `record_id`                     char(36)              NOT NULL,
  `defect_code_no`                varchar(10)           NOT NULL,
  `defect_code_name`              varchar(30)           NOT NULL,
  `defect_code_description`       varchar(250)          NULL ,
  `parent_defect_code_id`         char(36)              NOT NULL,
  `defect_code_no_path`           varchar(110)          NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `defect_code_name_path`         varchar(330)          NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_DEFECT_CODE_01`(`defect_code_no`) ,
  INDEX `IDX_DEFECT_CODE_02`(`defect_code_name`) ,
  INDEX `IDX_DEFECT_CODE_03`(`parent_defect_code_id`)
) COMMENT = '缺陷类型';

CREATE TABLE `machine_type`  (
  `record_id`                     char(36)             NOT NULL,
  `machine_type_no`               varchar(10)          NOT NULL,
  `machine_type_name`             varchar(30)          NOT NULL ,
  `machine_type_description`      varchar(250)         NULL,
  `parent_machine_type_id`        char(36)             NOT NULL,
  `machine_type_no_path`          varchar(110)         NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `machine_type_name_path`        varchar(330)         NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MACHINE_TYPE_01`(`machine_type_no`) ,
  INDEX `IDX_MACHINE_TYPE_02`(`machine_type_name`),
  INDEX `IDX_MACHINE_TYPE_03`(`parent_machine_type_id`)
)  COMMENT = '设备类型';

CREATE TABLE `material_type`  (
  `record_id`                     char(36)             NOT NULL,
  `material_type_no`              varchar(10)          NOT NULL               COMMENT '物料类型编码',
  `material_type_name`            varchar(30)          NOT NULL               COMMENT '物料类型名称',
  `material_type_description`     varchar(250)         NULL                   COMMENT '物料类型描述',
  `parent_material_type_id`       char(36)             NOT NULL,
  `material_type_no_path`         varchar(110)         NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `material_type_name_path`       varchar(330)         NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MT_01`(`material_type_no`) ,
  INDEX `IDX_MT_02`(`material_type_name`),
  INDEX `IDX_MT_03`(`parent_material_type_id`)
) COMMENT = '物料类型';

CREATE TABLE `uom`  (
  `record_id`                     char(36)              NOT NULL,
  `uom_no`                        varchar(10)           NOT NULL ,
  `uom_name`                      varchar(30)           NOT NULL               COMMENT '名称',
  `uom_description`               varchar(250)          NULL                   COMMENT '描述',

  PRIMARY KEY (`record_id`),
  INDEX `IDX_UOM_01`(`uom_no`) ,
  INDEX `IDX_UOM_02`(`uom_name`)
) COMMENT = '单位';

INSERT INTO `size` VALUES ('24977845-0b5c-11e9-a12a-d481d7fe257a', 'SZ', '尺码', NULL, '24977845-0b5c-11e9-a12a-d481d7fe257a','SZ','尺码');
INSERT INTO `defect_code` VALUES ('30b2c580-0b5c-11e9-a12a-d481d7fe257a', 'FT', '缺陷类型', NULL, '30b2c580-0b5c-11e9-a12a-d481d7fe257a','FT','缺陷类型');
INSERT INTO `machine_type` VALUES ('3b370cbb-0b5c-11e9-a12a-d481d7fe257a', 'DT', '设备类型', NULL, '3b370cbb-0b5c-11e9-a12a-d481d7fe257a','DT','设备类型');
INSERT INTO `material_type` VALUES ('45efcfe1-0b5c-11e9-a12a-d481d7fe257a', 'MT', '物料类型', NULL, '45efcfe1-0b5c-11e9-a12a-d481d7fe257a','MT','物料类型');

insert into `code_seed` values('76abacb6-0b5d-11e9-a12a-d481d7fe257a','bomOrderId','Bom单号',1,'','',10);
insert into `code_seed` values('7fb1c543-0b5d-11e9-a12a-d481d7fe257a','productionOrderId','生产计划单号',1,'','',10);
insert into `code_seed` values('867d24cb-0b5d-11e9-a12a-d481d7fe257a','pickingOrderId','领料单号',1,'','',10);
insert into `code_seed` values('8b822e3b-0b5d-11e9-a12a-d481d7fe257a','cuttingOrderId','裁剪单号',1,'','',10);
insert into `code_seed` values('90a02fe6-0b5d-11e9-a12a-d481d7fe257a','workOrderId','作业单号',1,'','',10);