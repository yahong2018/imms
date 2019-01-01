
CREATE TABLE `requirement_order`  (
  `record_id`                       char(36)              NOT NULL,
  `requirement_order_no`            varchar(12)           NOT NULL               COMMENT '需求订单号',
  `requirement_order_type`          varchar(10)           NOT NULL               COMMENT '需求订单类型',
  `requirement_order_status`        varchar(10)           NOT NULL               COMMENT '状态',
  `priority`                        int                   NOT NULL               COMMENT '优先级',
  `plant_id`                        char(36)              NOT NULL               COMMENT '工厂主键',
  `work_center_id`                  char(36)              NOT NULL               COMMENT '工作中心主键',
  `fg_material_id`                  char(36)              NOT NULL               COMMENT '物料号',
  `planned_qty`                     int                   NOT NULL               COMMENT '计划生产数量',
  `required_delivery_date`          datetime              NOT NULL               COMMENT '需求交期',
  `sale_order_no`                   varchar(64)           NULL                   COMMENT '销售订单号',
  `repeat_type`                     int                   NOT NULL DEFAULT 0     COMMENT '重复类型:0.首单 1.返单 2.补单',

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_REQUIREMENT_ORDER_01`(`requirement_order_no`) ,
  INDEX `IDX_REQUIREMENT_ORDER_02`(`work_center_id`)
) COMMENT = '需求订单';


CREATE TABLE `production_order`  (
  `record_id`                   char(36)          NOT NULL,
  `production_order_no`         varchar(64)       NOT NULL,
  `production_order_status`     int               NOT NULL default 0,
  `material_ready`              varchar(10)       NULL       COMMENT '物料准备',
  `priority`                    varchar(10)       NOT NULL,
  `requirement_order_id`        char(36)          NOT NULL,
  `plant_id`                    char(36)          NOT NULL,
  `work_center_id`              char(36)          NULL ,
  `fg_material_id`              varchar(64)       NULL       COMMENT '成品物料主键',
  `planned_qty`                 int               NULL ,
  `finished_qty`                int               NULL ,
  `second_quality_qty`          int               NULL       COMMENT '次品数量',
  `defect_qty`                  int               NULL ,
  `actual_qty`                  int               NULL ,
  `required_delivery_date`      datetime(0)       NULL ,
  `planned_start_date`          datetime(0)       NULL ,
  `planned_end_date`            datetime(0)       NULL ,
  `actual_start_date`           datetime(0)       NULL ,
  `actual_end_date`             datetime(0)       NULL ,
  `schedule_order_id`           char(36)          NULL       COMMENT '排程编号',

  `create_by`                   char(36)          NOT NULL,
  `create_date`                 datetime          NOT NULL,
  `update_by`                   char(36)          NULL,
  `update_date`                 datetime          NOT NULL,
  `optLock`                     int               NOT NULL DEFAULT 0,

  PRIMARY KEY (`record_id`)
) COMMENT = '生产订单';


CREATE TABLE `production_order_measure_data`  (
  `record_id`                   char(36)          NOT NULL,
  `production_order_id`         char(36)          NULL       COMMENT '生产订单主键',
  `measure_body`                varchar(20)       NULL       COMMENT '量体部位',
  `measure_data`                varchar(20)       NULL       COMMENT '量体数据',
  `measure_body_no`             varchar(20)       NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_PRO_ORDER_MD_01`(`production_order_id`)
) COMMENT = '生产订单量体数据';


CREATE TABLE `measure_body_classify`  (
  `record_id`                char(36)            NOT NULL,
  `classify_no`              varchar(10)         NOT NULL   COMMENT '选项编码',
  `classify_name`            varchar(20)         NULL       COMMENT '选项名称',
  `parent_id`                bigint(20)          NULL       COMMENT '上层选项主键',
  `unit`                     varchar(10)         NULL       COMMENT '数据单位',

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MBC_01`(`classify_no`) ,
  INDEX `IDX_MBC_02`(`classify_name`) ,
  INDEX `IDX_MBC_03`(`parent_id`)
) COMMENT = '针对服装类型 定义量体选项的内容 ';


CREATE TABLE `production_order_size`  (
  `record_id`                         char(36)         NOT NULL AUTO_INCREMENT,
  `production_order_id`        char(36)         NOT NULL,
  `size`                       varchar(10)      NULL ,
  `planned_qty`                int              NULL ,
  `actual_qty`                 int              NULL ,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_PRO_SIZE_01`(`production_order_id`)
) COMMENT = '生产订单尺码明细';


CREATE TABLE `material_picking_order`  (
  `record_id`                            char(36)           NOT NULL,
  `material_picking_order_no`            varchar(64)        NOT NULL,
  `production_order_id`                  char(36)           NOT NULL,
  `material_picking_order_status`        tinyint            NOT NULL ,
  `material_picking_order_type`          tinyint            NOT NULL ,
  `planned_picking_date`                 datetime           NULL ,
  `actual_picking_date`                  datetime           NULL ,
  `operator_id`                          char(36)           NULL ,

  `create_by`                   char(36)          NOT NULL,
  `create_date`                 datetime          NOT NULL,
  `update_by`                   char(36)          NULL,
  `update_date`                 datetime          NOT NULL,
  `optLock`                     int               NOT NULL DEFAULT 0,

  PRIMARY KEY (`record_id`) ,
  INDEX `IDX_MATERIAL_PO_01`(`material_picking_order_no`) ,
  INDEX `IDX_MATERIAL_PO_02`(`production_order_id`)
) COMMENT = '领料单';



CREATE TABLE `material_picking_order_bom`  (
  `id`                        bigint(20)         NOT NULL AUTO_INCREMENT,
  `component_material_id`     bigint(200)        NULL       COMMENT '组件主键',
  `qty`                       double             NULL       COMMENT '组件用量',
  `component_material_uom`    varchar(20)        NULL       COMMENT '组件单位',
  `picked_qty`                double             NULL ,
  `material_picking_order_id` bigint(20)         NULL ,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_MATERIAL_POB_01`(`component_material_id`) ,
  INDEX `IDX_MATERIAL_POB_02`(`material_picking_order_id`)
) COMMENT = '领料单物料清单';


CREATE TABLE `material_picking_list`  (
  `id`                        bigint(20)          NOT NULL AUTO_INCREMENT,
  `status`                    varchar(10)         NULL          COMMENT '状态',
  -- `line_no`                   int(11)             NULL          COMMENT '行项目',
  `container_no`              varchar(64)         NOT NULL                  COMMENT '领料容器',
  `material_picking_order_id` bigint(20)          NULL          COMMENT '领料单主键',

  `created_date` datetime(0) NOT NULL,
  `created_by` varchar(10) NOT NULL,
  `last_modified_date` datetime(0) NULL ,
  `last_modified_by` varchar(10) NULL ,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_MATERIAL_PL_01`(`container_no`) ,
  INDEX `IDX_MATERIAL_PL_02`(`material_picking_order_id`)
) COMMENT = '领料单明细';


CREATE TABLE `material_picking_list_detail`  (
  `id`                        bigint(20)         NOT NULL  AUTO_INCREMENT,
  `material_picking_list_id`  bigint(20)         NOT NULL                   COMMENT '领料单明细主键',
  --  `line_no`                   int(11)            NULL           COMMENT '行项目',
  `material_id`               bigint(20)         NULL           COMMENT '物料号',
  `picked_qty`                double             NULL           COMMENT '领用量',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_MATERIAL_PLD_01`(`material_picking_list_id`) ,
  INDEX `IDX_MATERIAL_PLD_02`(`material_id`)
) COMMENT = '领料明细';


CREATE TABLE `cutting_order`  (
  `id`                          bigint(20)          NOT NULL AUTO_INCREMENT,
  `cutting_order_no`            varchar(64)         NULL                 COMMENT '裁剪单号',
  `line_no`                     int(11)             NULL                 COMMENT '行项目',
  `production_order_id`         bigint(20)          NOT NULL             COMMENT '生产订单主键',
  `cutting_table_no`            varchar(64)         NULL                 COMMENT '床次',
  `status`                      varchar(10)         NULL                 COMMENT '状态',
  `container_no`                varchar(64)         NULL                 COMMENT '裁剪单容器',
  `planned_qty`                 int(11)             NOT NULL   DEFAULT 0 COMMENT '计划数量',
  `finished_qty`                int(11)             NOT NULL   DEFAULT 0 COMMENT '实际完工数量',
  `fg_material_id`              varchar(64)         NULL                 COMMENT '成品物料号',
  `fabric_material_type`        varchar(64)         NULL                 COMMENT '面料类型',
  `fabric_material_id`          varchar(64)         NULL                 COMMENT '面料物料主键',
  `plies`                       int(11)             NULL                 COMMENT '层数',
  `width`                       double              NULL                 COMMENT '幅宽',
  `length`                      double              NULL                 COMMENT '长度',
  `cutting_efficiency`          double              NULL                 COMMENT '利用率',
  `work_station_id`             bigint(20)          NULL                 COMMENT '裁剪工位',
  `planned_cutting_date`        datetime(0)         NULL                 COMMENT '计划领料时间',
  `actual_cutting_date`         datetime(0)         NULL                 COMMENT '实际领料时间',
  `planned_end_date`            datetime(0)         NULL                 COMMENT '计划完成时间',
  `actual_end_date`             datetime(0)         NULL                 COMMENT '实际完成时间',
  `hanging_station_id`          bigint(20)          NULL                 COMMENT '上吊挂工位',

  `created_by`                  varchar(20)         NOT NULL,
  `created_date`                datetime(0)         NOT NULL,
  `last_modified_by`            varchar(20)         NOT NULL,
  `last_modified_date`          datetime(0)         NOT NULL,

  PRIMARY KEY (`id`),
  INDEX `IDX_CUTTING_ORDER_01`(`cutting_order_no`),
  INDEX `IDX_CUTTING_ORDER_02`(`production_order_id`),
  INDEX `IDX_CUTTING_ORDER_03`(`work_station_id`)
)COMMENT = '裁剪单' ;

CREATE TABLE `cutting_order_size`  (
  `id`                          bigint(20)          NOT NULL        AUTO_INCREMENT,
  `cutting_order_id`            bigint(20)          NOT NULL        COMMENT '裁剪单主键',
  `line_no`                     int(11)             NULL            COMMENT '行项目',
  `size`                        varchar(10)         NULL            COMMENT '尺码',
  `layer_qty`                   int(11)             NULL            COMMENT '单层配比数量',
  `planned_qty`                 int(11)             NULL            COMMENT '计划裁剪数量',
  `actual_qty`                  int(11)             NULL            COMMENT '实际裁剪数量',
  `created_work_order_qty`      int(11)             NULL            COMMENT '已创建作业单数量',

  PRIMARY KEY (`id`),
  INDEX `IDX_CUTTING_ORDER_SIZE_01`(`cutting_order_id`)
)COMMENT = '裁剪单尺码明细';



CREATE TABLE `production_cutting_plan`  (
  `id`                          bigint(20)        NOT NULL AUTO_INCREMENT,
  `production_cutting_plan_no`  varchar(64)       NOT NULL,
  `production_order_id`         bigint(20)        NOT NULL,
  `line_no`                     int(11)           NULL     COMMENT '行项目',
  `cutting_table_no`            varchar(64)       NULL ,
  `size`                        varchar(10)       NULL ,
  `status`                      varchar(10)       NULL ,
  `cutting_qty`                 int(11)           NULL ,
  `fg_material_id`              varchar(64)       NULL ,
  `fabric_material_type`        varchar(64)       NULL ,
  `fabric_material_no`          varchar(64)       NULL ,
  `plies`                       int(11)           NULL     COMMENT '层数',
  `width`                       double            NULL ,
  `length`                      double            NULL ,
  `cutting_efficiency`          double            NULL ,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_PRO_CUTTING_PLAN_01`(`production_cutting_plan_no`) ,
  INDEX `IDX_PRO_CUTTING_PLAN_02`(`production_order_id`)
) COMMENT = '生产裁剪排料计划';

CREATE TABLE `production_cutting_size`  (
  `id`                          bigint(20)        NOT NULL AUTO_INCREMENT,
  `production_cutting_plan_id`  bigint(20)        NOT NULL,
  `line_no`                     int(11)           NULL     COMMENT '行项目',
  `cutting_table_no`            varchar(64)       NULL ,
  `size`                        varchar(10)       NULL ,
  `layer_qty`                   int(11)           NULL ,
  `planned_qty`                 int(11)           NULL ,
  `actual_qty`                  int(11)           NULL ,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_PRO_CUTTING_SIZE_01`(`production_cutting_plan_id`)
) COMMENT = '生产裁剪排料尺码';


CREATE TABLE `cutting_marker`  (
  `id`                          bigint(20)         NOT NULL AUTO_INCREMENT,
  `cutting_order_id`            bigint(20)         NOT NULL,
  `line_no`                     int(11)            NULL                   COMMENT '行项目',
  `media_id`                    bigint(20)         NULL,
  `remark`                      varchar(64)        NULL,
  `marker_file_id`              bigint(20)         NULL,
  PRIMARY KEY (`id`),
  INDEX `IDX_CUTTING_MARKER_01`(`cutting_order_id`),
  INDEX `IDX_CUTTING_MARKER_02`(`media_id`)
) COMMENT = '生产裁剪排料图' ;

CREATE TABLE `production_work_order`  (
  `id`                         bigint(20)         NOT NULL AUTO_INCREMENT,
  `line_no`                    int(11)            NULL       COMMENT '行项目',
  `production_work_order_no`   varchar(64)        NOT NULL,
  `production_order_id`        bigint(20)         NOT NULL,
  `bom_order_id`               bigint(20)         NULL       COMMENT '物料清单主键',
  `operation_routing_order_id` bigint(20)         NULL       COMMENT '工序单主键',
  `cutting_order_id`           bigint(20)         NULL       COMMENT '裁剪单主键',
  `size`                       varchar(10)        NULL       COMMENT '尺码',
  `status`                     varchar(10)        NULL       COMMENT '已创建	created  已开工	started  已完工	finished',
  `planned_start_date`         datetime(0)        NULL ,
  `planned_end_date`           datetime(0)        NULL ,
  `actual_start_date`          datetime(0)        NULL ,
  `actual_end_date`            datetime(0)        NULL ,
  `container_no`               varchar(64)        NULL       COMMENT '衣架号',
  `if_syn_finish_status`       tinyint(1)         NOT NULL DEFAULT 0     COMMENT '同步完成状态',

  `created_by` varchar(20) NOT NULL,
  `created_date` datetime(0) NOT NULL,
  `last_modified_by` varchar(20) NOT NULL,
  `last_modified_date` datetime(0) NOT NULL,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_PRO_WORK_ORDER_01`(`production_work_order_no`) ,
  INDEX `IDX_PRO_WORK_ORDER_02`(`production_order_id`) ,
  INDEX `IDX_PRO_WORK_ORDER_03`(`bom_order_id`) ,
  INDEX `IDX_PRO_WORK_ORDER_04`(`operation_routing_order_id`) ,
  INDEX `IDX_PRO_WORK_ORDER_05`(`cutting_order_id`)
) COMMENT = '生产作业单';