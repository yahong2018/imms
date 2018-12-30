
CREATE TABLE `plant`  (
  `record_id`                 char(36)          NOT NULL,
  `plant_no`                  varchar(10)       NOT NULL,
  `plant_name`                varchar(30)       NULL ,
  `description`               varchar(250)      NULL ,
  `cost_price_ratio`          decimal(8, 4)     NOT NULL DEFAULT 0.0100  COMMENT '工资提成',

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_PLANT_01`(`plant_no`) ,
  INDEX `IDX_PLANT_02`(`plant_name`)
) COMMENT = '工厂';


CREATE TABLE `work_center`  (
  `record_id`                 char(36)          NOT NULL,
  `work_center_no`            varchar(10)       NOT NULL,
  `work_center_name`          varchar(30)       NOT NULL,
  `description`               varchar(1000)     NULL,
  `plant_id`                  char(36)          NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_WORK_CENTER_01`(`work_center_no`) ,
  INDEX `IDX_WORK_CENTER_02`(`work_center_name`) ,
  INDEX `IDX_WORK_CENTER_03`(`plant_id`)
) COMMENT = '工作中心';


CREATE TABLE `work_station`  (
  `record_id`                char(36)           NOT NULL,
  `work_station_no`          varchar(10)        NOT NULL,
  `plant_id`                 char(36)           NOT NULL,
  `work_center_id`           char(36)           NULL ,
  `description`              varchar(250)       NULL ,
  `work_station_type`        int                NOT NULL              COMMENT '工位类型:0.裁剪 1.缝制 2.吊挂  3.质检  4.打印',
  `virtual`                  bool   NOT NULL    DEFAULT 0             COMMENT '是否虚拟工位：0.真实工位 1.虚拟工位',
  `work_station_status`      varchar(10)        NOT NULL,
  `direction`                tinyint            NOT NULL              COMMENT '0.左边 1.右边',
  `ip_address`               varchar(20)        NULL ,
  `max_wip_qty`              int(11)            NOT NULL              COMMENT '最大的WIP数',
  `current_wip_qty`          int(11)            NULL                  COMMENT '当前WIP数',
  `remote_file_address`      varchar(255)       NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_WORK_STATION_01`(`work_station_no`) ,
  INDEX `IDX_WORK_STATION_02`(`plant_id`) ,
  INDEX `IDX_WORK_STATION_03`(`work_center_id`)
) COMMENT = '工位';


CREATE TABLE `machine`  (
  `record_id`                char(36)           NOT NULL,
  `machine_no`               varchar(12)        NULL ,
  `machine_name`             varchar(30)        NULL ,
  `machine_type_id`          char(36)           NULL ,
  `machine_status`           int                NOT NULL DEFAULT 0    comment '设备状态：0.正常  1.禁用',
  `description`              varchar(250)       NULL ,
  `work_station_id`          char(36)           NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MACHINE_01`(`machine_no`) ,
  INDEX `IDX_MACHINE_02`(`machine_name`) ,
  INDEX `IDX_MACHINE_03`(`machine_type_id`) ,
  INDEX `IDX_MACHINE_04`(`work_station_id`)
) COMMENT = '设备';


CREATE TABLE `principal_axis`  (
  `record_id`                char(36)           NOT NULL,
  `principal_axis_no`        varchar(10)        NOT NULL ,
  `sequence_number`          int                NULL ,
  `rotating_direction`       tinyint            NOT  NULL DEFAULT 0 COMMENT '旋转方向：0.顺时钟  1.逆时钟',
  `length`                   double             NULL ,
  `width`                    double             NULL ,
  `speed`                    double             NULL ,
  `work_center_id`           char(36)           NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_PRINCIPAL_AXIS_01`(`principal_axis_no`) ,
  INDEX `IDX_PRINCIPAL_AXIS_02`(`work_center_id`)
) COMMENT = '主轨';

CREATE TABLE `line`  (
  `record_id`                 char(36)          NOT NULL,
  `work_center_id`            char(36)          NULL ,
  `sequence_number`           int               NULL ,
  `start_main_line_id`        char(36)          NULL ,
  `end_main_line_id`          char(36)          NULL ,
  `length`                    double            NULL ,
  `width`                     double            NULL ,
  `rotating_direction`        enum('C','A')     NOT  NULL DEFAULT 'A' COMMENT '旋转方向：C 顺时钟  A 逆时钟',
  `speed`                     double            NULL ,
  `pre_lines_pacing`          double            NULL ,
  `left_distance`             double            NULL ,
  `production_line_code`      varchar(50)       NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_LINE_01`(`work_center_id`) ,
  INDEX `IDX_LINE_02`(`production_line_code`) ,
  INDEX `IDX_LINE_03`(`end_main_line_id`) ,
  INDEX `IDX_LINE_04`(`start_main_line_id`)
)  COMMENT = '产线';


CREATE TABLE `operator`  (
  `record_id`                  char(36)       NOT NULL,
  `user_id`                    char(36)       NOT NULL,
  `plant_id`                   char(36)       NOT NULL,
  `supervisor_id`              char(36)       NOT NULL,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_OPERATOR_01`(`user_id`) ,
  INDEX `IDX_OPERATOR_02`(`plant_id`) ,
  INDEX `IDX_OPERATOR_03`(`supervisor_id`)
) COMMENT = '操作员';
