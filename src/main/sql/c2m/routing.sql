
CREATE TABLE `operation`  (
  `record_id`                        char(36)                      NOT NULL,
  `operation_no`                     varchar(20)                   NOT NULL,
  `operation_name`                   varchar(120)                  NOT NULL ,
  `standard_operation_procedure`     varchar(200)                  NULL ,
  `machine_type_id`                  char(36)                      NULL ,
  `standard_time`                    float(8,4)                    NULL ,
  `standard_price`                   float(8,4)                    NULL ,
  `part_type`                        varchar(12)                   NULL ,
  `section_type`                     varchar(12)                   NULL ,
  `section_name`                     varchar(30)                   NULL ,
  `if_outsource`                     tinyint(1)                    NULL ,
  `qa_procedure`                     varchar(1000)                 NULL ,
  `requirement`                      varchar(1000)                 NULL ,
  `level`                            varchar(10)                   NULL ,
  `design_part_code`                 varchar(12)                   NULL ,
  `part_code`                        varchar(12)                   NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_OPERATION_01`(`operation_no`) ,
  INDEX `IDX_OPERATION_02`(`machine_type_id`)
) COMMENT = '工艺';


CREATE TABLE `operator_capability`  (
  `record_id`                        char(36)                      NOT NULL,
  `operator_id`                      char(20)                      NULL,
  `operation_id`                     char(20)                      NOT NULL,
  `level`                            varchar(10)                   NULL,
  PRIMARY KEY (`record_id`),
  INDEX `IDX_CAPABILITY_01`(`operator_id`),
  INDEX `IDX_CAPABILITY_02`(`operation_id`)
) COMMENT = '操作员工序能力';


CREATE TABLE `operation_routing_order`  (
  `record_id`                        char(36)            NOT NULL,
  `operation_routing_order_no`       varchar(10)         NOT NULL ,
  `operation_routing_order_type`     tinyint             NOT NULL     COMMENT '0:物料工艺路线,1:生产订单工艺路线,2:作业单工艺路线',
  `ref_id`                           char(36)            NOT NULL     COMMENT '引用单号：物料号/生产订单号/作业单号',

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_OPERATION_ROUTING_ORDER_01`(`operation_routing_order_no`),
  INDEX `IDX_OPERATION_ROUTING_ORDER_02`(`ref_id`)
) COMMENT = '工艺路线单';


CREATE TABLE `operation_routing`  (
  `record_id`                       char(36)            NOT NULL,
  `operation_id`                    char(36)            NOT NULL             COMMENT '工艺',
  `operation_routing_order_id`      char(36)            NOT NULL             COMMENT '工艺路线单主键',
  `qa_procedure`                    varchar(250)        NULL                 COMMENT '品质说明',
  `standard_price`                  float(8,4)          NOT NULL             COMMENT '标准单价',
  `section_type`                    varchar(12)         NULL                 COMMENT '所属工段',
  `machine_type_id`                 char(36)            NULL                 COMMENT '机器类型',
  `actual_station_id`               char(36)            NULL ,
  `operator_id`                     char(36)            NULL                 COMMENT '操作员主键',
  `standard_time`                   float(8,4)          NULL                 COMMENT '标准时间',
  `actual_time`                     float(8,4)          NULL ,
  `pre_operation_id`                char(36)            NULL                 COMMENT '依赖关系-上道工艺',
  `sop_file_path`                   varchar(255)        NULL ,
  `operation_routing_status`        tinyint             NOT NULL             COMMENT '0.已计划	  1.已开始  	2.已完成',
  `required_level`                  varchar(10)         NULL                 COMMENT '需要工艺等级',
  `scrap_qty`                       int                 NULL DEFAULT 0       COMMENT '报废数量',
  `complete_qty`                    int                 NULL DEFAULT 0       COMMENT '完工数量',
  `pre_routing_id`                  char(36)            NULL                 COMMENT '依赖关系-上道工序',
  `sequence_no`                     int                 NOT NULL             COMMENT '工序顺序',
  `part_type`                       varchar(40)         NULL ,
  `if_outsource`                    tinyint             NULL ,
  `pull_in_time`                    datetime            NULL                 COMMENT '进站时间',
  `pull_out_time`                   datetime            NULL                 COMMENT '出站时间',

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_OPERATION_ROUTING_01`(`operation_id`) ,
  INDEX `IDX_OPERATION_ROUTING_02`(`operation_routing_order_id`) ,
  INDEX `IDX_OPERATION_ROUTING_03`(`operator_id`) ,
  INDEX `IDX_OPERATION_ROUTING_04`(`actual_station_id`) ,
  INDEX `IDX_OPERATION_ROUTING_05`(`pre_operation_id`) ,
  INDEX `IDX_OPERATION_ROUTING_06`(`pre_routing_id`)
) COMMENT = '工艺路线';
