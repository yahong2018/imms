CREATE TABLE `data_dict`  (
  `id`                        bigint(10)            NOT NULL        AUTO_INCREMENT,
  `code`                      varchar(32)           NOT NULL,
  `name`                      varchar(64)           NOT NULL,
  `type`                      varchar(64)           NOT NULL,
  `locale`                    varchar(32)           NOT NULL DEFAULT 'zh_CN',
  PRIMARY KEY (`id`) ,
  INDEX `IDX_DD_01`(`code`) ,
  INDEX `IDX_DD_02`(`locale`) ,
  INDEX `IDX_DD_03`(`type`)
) COMMENT = '数据字典表';

-- -------------------------------------------------------------------------------------------------------------------
CREATE TABLE `code_seed`(
  `code_seed_id`                  char(36)            NOT NULL,
  `code_seed_no`                  varchar(50)         NOT NULL,
  `code_seed_name`                varchar(50)         NOT NULL,
  `code_seed_intial_value`        int                 NOT NULL,
  `code_seed_prefix`              varchar(10)         NOT NULL,
  `code_seed_postfix`             varchar(10)         NOT NULL,
  `code_seed_total_length`        int                 NOT NULL,

  PRIMARY KEY (`code_seed_id`)
);

insert into `code_seed` values(UUID(),'bomOrderId','Bom单号',1,'','',10);
insert into `code_seed` values(UUID(),'productionOrderId','生产计划单号',1,'','',10);
insert into `code_seed` values(UUID(),'pickingOrderId','领料单号',1,'','',10);
insert into `code_seed` values(UUID(),'cuttingOrderId','裁剪单号',1,'','',10);
insert into `code_seed` values(UUID(),'workOrderId','作业单号',1,'','',10);


CREATE TABLE `media`  (
  `media_id`                       char(36)            NOT NULL,
  `media_type`                     varchar(10)         NOT NULL,            -- 类型：Pad需要根据类型来显示图片或者播放视频
  `media_url`                      varchar(255)        NOT NULL ,
  `media_name`                     varchar(100)        NOT NULL ,
  `media_size`                     int                 NOT NULL ,
  `media_description`              varchar(250)        NULL ,
  `media_data_source`              enum('I','O') default 'I'      NOT NULL ,   -- I:内部Url,存储相对路径，O:外部Url地址,存储绝对路径

  PRIMARY KEY (`media_id`)
) COMMENT = '多媒体';


CREATE TABLE `size`  (
  `size_id`                char(36)             NOT NULL,
  `size_no`                varchar(10)          NULL          COMMENT '尺码编码',
  `size_name`              varchar(30)          NULL          COMMENT '尺码名称',
  `size_description`       varchar(250)         NULL,
  `parent_size_id`         char(36)             NOT NULL,
  `size_no_path`           varchar(110)         NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `size_name_path`         varchar(330)         NOT NULL,

  PRIMARY KEY (`size_id`) ,
  INDEX `IDX_SIZE_01`(`size_no`) ,
  INDEX `IDX_SIZE_02`(`size_name`) ,
  INDEX `IDX_SIZE_03`(`parent_size_id`)
) COMMENT = '尺码';


CREATE TABLE `defect_code`  (
  `defect_code_id`            char(36)              NOT NULL,
  `defect_code_no`            varchar(10)           NOT NULL,
  `defect_code_name`          varchar(30)           NOT NULL,
  `defect_code_description`   varchar(250)          NULL ,
  `parent_defect_code_id`     char(36)              NOT NULL,
  `defect_code_no_path`       varchar(110)          NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `defect_code_name_path`     varchar(330)          NOT NULL,

  PRIMARY KEY (`defect_code_id`) ,
  INDEX `IDX_DEFECT_CODE_01`(`defect_code_no`) ,
  INDEX `IDX_DEFECT_CODE_02`(`defect_code_name`) ,
  INDEX `IDX_DEFECT_CODE_03`(`parent_defect_code_id`)
) COMMENT = '缺陷类型';


CREATE TABLE `machine_type`  (
  `machine_type_id`           char(36)             NOT NULL,
  `machine_type_no`           varchar(10)          NOT NULL,
  `machine_type_name`         varchar(30)          NOT NULL ,
  `machine_type_description`  varchar(250)         NULL,
  `parent_machine_type_id`    char(36)             NOT NULL,
  `machine_type_no_path`      varchar(110)         NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `machie_type_name_path`     varchar(330)         NOT NULL,

  PRIMARY KEY (`machine_type_id`) ,
  INDEX `IDX_MACHINE_TYPE_01`(`machine_type_no`) ,
  INDEX `IDX_MACHINE_TYPE_02`(`machine_type_name`),
  INDEX `IDX_MACHINE_TYPE_03`(`parent_machine_type_id`)
)  COMMENT = '设备类型';


CREATE TABLE `material_type`  (
  `material_type_id`          char(36)           NOT NULL,
  `material_type_no`          varchar(10)        NOT NULL               COMMENT '物料类型编码',
  `material_type_name`        varchar(30)        NOT NULL               COMMENT '物料类型名称',
  `material_type_description` varchar(250)       NULL                   COMMENT '物料类型描述',
  `parent_material_type_id`   char(36)           NOT NULL,
  `material_type_no_path`     varchar(110)       NOT NULL,     -- 最大层级为10级，中间以'\'隔开
  `material_type_name_path`   varchar(330)       NOT NULL,

  PRIMARY KEY (`material_type_id`) ,
  INDEX `IDX_MT_01`(`material_type_no`) ,
  INDEX `IDX_MT_02`(`material_type_name`),
  INDEX `IDX_MT_03`(`parent_material_type_id`)
) COMMENT = '物料类型';


CREATE TABLE `uom`  (
  `uom_id`                 char(36)              NOT NULL,
  `uom_no`                 varchar(10)           NOT NULL ,
  `uom_name`               varchar(30)           NOT NULL               COMMENT '名称',
  `uom_description`        varchar(250)          NULL                   COMMENT '描述',

  PRIMARY KEY (`uom_id`),
  INDEX `IDX_UOM_01`(`uom_no`) ,
  INDEX `IDX_UOM_02`(`uom_name`)
) COMMENT = '单位';

CREATE TABLE `material`  (
  `material_id`                varchar(36)      NOT NULL ,
  `material_no`                varchar(12)      NOT NULL      COMMENT '物料号',
  `material_name`              varchar(30)      NOT NULL      COMMENT '物料名称',
  `material_material_type_id`  char(36)         NOT NULL      COMMENT '物料类型',
  `material_uom_id`            char(36)         NOT NULL      COMMENT '单位',
  `material_width`             decimal(10, 4)   NULL          COMMENT '幅宽',
  `material_weight`            decimal(10, 4)   NULL          COMMENT '纺织克重',
  `material_size_id`           char(36)         NULL          COMMENT '尺码组',
  `material_price`             decimal(10, 2)   NULL          COMMENT '价格',
  `material_color`             varchar(20)      NULL          COMMENT '颜色',
  `material_description`       varchar(250)     NULL          COMMENT '物料描述',

  PRIMARY KEY (`material_id`) ,
  INDEX `IDX_MATERIAL_01`(`material_no`) ,
  INDEX `IDX_MATERIAL_02`(`material_name`) ,
  INDEX `IDX_MATERIAL_03`(`material_material_type_id`) ,
  INDEX `IDX_MATERIAL_04`(`material_size_id`)
) COMMENT = '物料';

CREATE TABLE `material_media`  (
  `material_media_id`                     char(36)          NOT NULL,
  `material_media_media_id`               char(36)          NOT NULL ,
  `material_media_material_id`            char(36)          NOT NULL ,

  PRIMARY KEY (`material_media_id`) ,
  INDEX `IDX_MM_01`(`material_media_media_id`) ,
  INDEX `IDX_MM_02`(`material_media_material_id`)
) COMMENT = '物料多媒体';


CREATE TABLE `bom_order`  (
  `bom_order_id`                  char(36)                      NOT NULL,
  `bom_order_no`                  varchar(25)                   NOT NULL
                                                COMMENT 'Bom 单号: 物料号（12位）+ 日期(8位) + 序列号(2位),中间以点号隔开',
  `bom_order_type_no`             enum('P','S','O','D','M','W') NOT NULL DEFAULT 'P'
                         COMMENT 'P: "部件BOM", S: "基准BOM", O: "订单BOM", D: "设计BOM",  M: "生产BOM",  W: "作业BOM"',

  PRIMARY KEY (`bom_order_id`),
  INDEX `IDX_BOM_ORDER_01`(`bom_order_no`),
  INDEX `IDX_BOM_ORDER_02`(`bom_order_type_no`)
) COMMENT = '物料单' ;



CREATE TABLE `bom`  (
  `bom_id`                             char(36)        NOT NULL,
  `bom_bom_order_id`                   char(36)        NOT NULL,
  `component_material_id`              char(36)        NOT NULL               COMMENT '子件物料Id',
  `component_abstract_material_id`     char(36)        NULL                   COMMENT '子件抽象物料Id',
  `component_qty`                      double          NOT NULL               COMMENT '子件用量',
  `component_material_uom_id`          char(36)        NOT NULL               COMMENT '子件单位',
  `component_type_no`                  enum('C','D')   DEFAULT 'C'            COMMENT '子件类型 C: "定制", D: "默认"',
  `component_material_no_path`         varchar(130)    NOT NULL,
  `component_material_name_path`       varchar(330)    NOT Null,
  `component_material_match_rule_id`   char(36)        NULL                   COMMENT '子件匹配规则',
  `if_main_fabric`                     tinyint(1)      NULL                   COMMENT '是否主面料',
  `bom_data_source`                    enum('I','O')   NOT NULL DEFAULT 'I'   COMMENT 'Bom数据来源(I:内建,O.导入)',
  `parent_bom_id`                      char(36)        NULL                   COMMENT '上级BOM id',

  PRIMARY KEY (`bom_id`),
  INDEX `IDX_BOM_01`(`component_material_id`),
  INDEX `IDX_BOM_02`(`component_abstract_material_id`),
  INDEX `IDX_BOM_03`(`parent_bom_id`),
  INDEX `IDX_BOM_04`(`component_material_match_rule_id`),
  INDEX `IDX_BOM_05`(`bom_bom_order_id`)
) COMMENT = '物料清单' ;


/*
drop table media;
drop table customer;
drop table size;
drop table defect_code;
drop table machine_type;
drop table material_type;
drop table uom;
drop table material;
drop table material_media;
drop table bom_order;
drop table bom;
*/


/*
set @id = UUID();
INSERT INTO `size` VALUES (@id, 'SZ', '尺码', NULL, @id,'SZ','尺码');
set @id = UUID();
INSERT INTO `defect_code` VALUES (@id, 'FT', '缺陷类型', NULL, @id,'FT','缺陷类型');
set @id = UUID();
INSERT INTO `machine_type` VALUES (@id, 'DT', '设备类型', NULL, @id,'DT','设备类型');
set @id = UUID();
INSERT INTO `material_type` VALUES (@id, 'MT', '物料类型', NULL, @id,'MT','物料类型');
*/


-- ----------------------------------------------------------------------------------------------------------

CREATE TABLE `plant`  (
  `plant_id`                         char(36)          NOT NULL,
  `plant_no`                         varchar(10)       NOT NULL,
  `plant_name`                       varchar(30)      NULL ,
  `plant_description`                varchar(250)      NULL ,
  `plant_cost_price_ratio`           decimal(8, 4)     NOT NULL DEFAULT 0.0100  COMMENT '工资提成',

  PRIMARY KEY (`plant_id`) ,
  INDEX `IDX_PLANT_01`(`plant_no`) ,
  INDEX `IDX_PLANT_02`(`plant_name`)
) COMMENT = '工厂';


CREATE TABLE `work_center`  (
  `work_center_id`               char(36)               NOT NULL,
  `work_center_no`               varchar(10)            NOT NULL,
  `work_center_name`             varchar(30)            NOT NULL,
  `work_center_description`      varchar(1000)          NULL ,
  `work_center_plant_id`         char(36)               NOT NULL,
 -- `work_center_group_id`         char(36)               NOT NULL,

  PRIMARY KEY (`work_center_id`) ,
  INDEX `IDX_WORK_CENTER_01`(`work_center_no`) ,
  INDEX `IDX_WORK_CENTER_02`(`work_center_name`) ,
  INDEX `IDX_WORK_CENTER_03`(`work_center_plant_id`)
--  INDEX `IDX_WORK_CENTER_04`(`work_center_group_id`)
) COMMENT = '工作中心';

# CREATE TABLE `work_center_group`  (
#   `work_center_group_id`            char(36)             NOT NULL,
#   `work_center_group_no`            varchar(10)          NOT NULL,
#   `work_center_group_plant_id`      char(36)             NOT NULL,
#   `work_center_group_name`          varchar(30)         NOT NULL,
#   `work_center_group_description`   varchar(250)        NULL ,
#
#   PRIMARY KEY (`work_center_group_id`) ,
#   INDEX `IDX_WORK_CENTER_GROUP_01`(`work_center_group_no`) ,
#   INDEX `IDX_WORK_CENTER_GROUP_02`(`work_center_group_plant_id`) ,
#   INDEX `IDX_WORK_CENTER_GROUP_03`(`work_center_group_name`)
# ) COMMENT = '工作中心组';

CREATE TABLE `work_station`  (
  `work_station_id`                      char(36)           NOT NULL,
  `work_station_no`                      varchar(10)        NOT NULL,
  `work_station_plant_id`                char(36)           NOT NULL,
  `work_station_description`             varchar(250)       NULL ,
  `work_station_work_type`               char(3)            NOT NULL              COMMENT '工位类型:CUT 裁剪 STI 缝制 HNG 吊挂  QLT 质检  PRT 打印',
  `work_station_type`                    ENUM('R','F')      NOT NULL DEFAULT 'R'  COMMENT 'R	真实工位     F 虚拟工位',
  `work_station_status`                  varchar(10)        NOT NULL,
  `work_station_direction`               enum('R','L')      NOT NULL              COMMENT 'R：右边   L:左边',
  `work_station_ip_address`              varchar(20)        NULL ,
  `work_station_max_wip_qty`             int(11)            NOT NULL              COMMENT '最大的WIP数',
  `work_station_current_wip_qty`         int(11)            NULL                  COMMENT '当前WIP数',
  `work_station_work_center_id`          char(36)           NULL ,
  `work_station_remote_file_address`     varchar(255)       NULL ,

  PRIMARY KEY (`work_station_id`) ,
  INDEX `IDX_WORK_STATION_01`(`work_station_no`) ,
  INDEX `IDX_WORK_STATION_02`(`work_station_plant_id`) ,
  INDEX `IDX_WORK_STATION_03`(`work_station_work_center_id`)
) COMMENT = '工位';


CREATE TABLE `machine`  (
  `machine_id`                        char(36) NOT NULL,
  `machine_no`                        varchar(12) NULL ,
  `machine_name`                      varchar(30) NULL ,
  `machine_machine_type_id`           char(36) NULL ,
  `machine_status`                    enum('E','D') NOT NULL DEFAULT 'E'    comment '设备状态：E 可用  D 不可用',
  `machine_description`               varchar(250) NULL ,
  `machine_work_station_id`           char(36) NULL ,

  PRIMARY KEY (`machine_id`) ,
  INDEX `IDX_MACHINE_01`(`machine_no`) ,
  INDEX `IDX_MACHINE_02`(`machine_name`) ,
  INDEX `IDX_MACHINE_03`(`machine_machine_type_id`) ,
  INDEX `IDX_MACHINE_04`(`machine_work_station_id`)
) COMMENT = '设备';


CREATE TABLE `principal_axis`  (
  `principal_axis_id`                       char(36)           NOT NULL,
  `principal_axis_no`                       varchar(10)        NOT NULL ,
  `principal_axis_sequence_number`          int                NULL ,
  `principal_axis_rotating_direction`       enum('C','A')      not  NULL default 'A' comment '旋转方向：C 顺时钟  A 逆时钟',
  `principal_axis_length`                   double             NULL ,
  `principal_axis_width`                    double             NULL ,
  `principal_axis_speed`                    double             NULL ,
  `principal_axis_work_center_id`           char(36)           NULL ,

  PRIMARY KEY (`principal_axis_id`) ,
  INDEX `IDX_PRINCIPAL_AXIS_01`(`principal_axis_no`) ,
  INDEX `IDX_PRINCIPAL_AXIS_02`(`principal_axis_work_center_id`)
) COMMENT = '主轨';

CREATE TABLE `line`  (
  `line_id`                        char(36)                NOT NULL,
  `line_work_center_id`            char(36)                NULL ,
  `line_sequence_number`           int                     NULL ,
  `line_start_main_line_id`        char(36)                NULL ,
  `line_end_main_line_id`          char(36)                NULL ,
  `line_length`                    double                  NULL ,
  `line_width`                     double                  NULL ,
  `line_rotating_direction`        enum('C','A')           NOT  NULL default 'A' comment '旋转方向：C 顺时钟  A 逆时钟',
  `line_speed`                     double                  NULL ,
  `line_pre_lines_pacing`           double                  NULL ,
  `line_left_distance`             double                  NULL ,
  `line_production_line_code`      varchar(50)             NULL ,

  PRIMARY KEY (`line_id`) ,
  INDEX `IDX_LINE_01`(`line_work_center_id`) ,
  INDEX `IDX_LINE_02`(`line_production_line_code`) ,
  INDEX `IDX_LINE_03`(`line_end_main_line_id`) ,
  INDEX `IDX_LINE_04`(`line_start_main_line_id`)
)  COMMENT = '产线';


CREATE TABLE `operator`  (
  `operator_id`                         char(36)          NOT NULL,
  `operator_user_id`                    varchar(20)       NOT NULL,
  `operator_plant_id`                   char(36)          NOT NULL,
  `operator_supervisor_id`              varchar(20)       NOT NULL ,

  PRIMARY KEY (`operator_id`) ,
  INDEX `IDX_OPERATOR_01`(`operator_user_id`) ,
  INDEX `IDX_OPERATOR_02`(`operator_plant_id`) ,
  INDEX `IDX_OPERATOR_03`(`operator_supervisor_id`)
) COMMENT = '操作员';

-- -----------------------------------------------------------------------------------------------------------

CREATE TABLE `operation`  (
  `operation_id`                               char(36)             NOT NULL,
  `operation_no`                               varchar(20)          NOT NULL,
  `operation_name`                             varchar(120)         NOT NULL ,
  `operation_standard_operation_procedure`     varchar(200)         NULL ,
  `operation_machine_type_id`                  char(36)             NULL ,
  `operation_standard_time`                    float(8,4)           NULL ,
  `operation_standard_price`                   float(8,4)           NULL ,
  `operation_part_type`                        varchar(12)          NULL ,
  `operation_section_type`                     varchar(12)          NULL ,
  `operation_section_name`                     varchar(30)          NULL ,
  `operation_if_outsource`                     tinyint(1)           NULL ,
  `operation_qa_procedure`                     varchar(1000)        NULL ,
  `operation_requirement`                      varchar(1000)        NULL ,
  `operation_level`                            varchar(10)          NULL ,
  `operation_design_part_code`                 varchar(12)          NULL ,
  `operation_part_code`                        varchar(12)          NULL ,

  PRIMARY KEY (`operation_id`) ,
  INDEX `IDX_OPERATION_01`(`operation_no`) ,
  INDEX `IDX_OPERATION_02`(`operation_machine_type_id`)
) COMMENT = '工艺';


CREATE TABLE `operation_media`  (
  `operation_media_id`                       char(36)      NOT NULL,
  `operation_media_operation_id`             char(36)      NOT NULL,
  `operation_media_media_id`                 char(36)      NOT NULL ,

  PRIMARY KEY (`operation_media_id`) ,
  INDEX `IDX_OM_01`(`operation_media_operation_id`) ,
  INDEX `IDX_OM_02`(`operation_media_media_id`)
) COMMENT = '工艺多媒体';


CREATE TABLE `operator_capability`  (
  `operator_capability_id`               char(36)        NOT NULL,
  `operator_capability_operator_id`      char(20)        NULL,
  `operator_capability_operation_id`     char(20)        NOT NULL,
  `operator_capability_level`            varchar(10)     NULL,
  PRIMARY KEY (`operator_capability_id`),
  INDEX `IDX_CAPABILITY_01`(`operator_capability_operator_id`),
  INDEX `IDX_CAPABILITY_02`(`operator_capability_operation_id`)
) COMMENT = '操作员工序能力';


CREATE TABLE `operation_routing_order`  (
  `operation_routing_order_id`    char(36)            NOT NULL,
  `operation_routing_order_no`    varchar(10)         NOT NULL ,
  `operation_routing_type`        enum('M','P','W')   NOT NULL  COMMENT 'M:物料工艺路线,P:生产订单工艺路线,W:作业单工艺路线',

  PRIMARY KEY (`operation_routing_order_id`) ,
  INDEX `IDX_OPERATION_RO_01`(`operation_routing_order_no`)
) COMMENT = '工艺路线单';


CREATE TABLE `operation_routing`  (
  `operation_routing_id`                  char(36)            NOT NULL,
  `operation_routing_operation_id`        char(36)            NOT NULL ,
  `operation_routing_order_id`            char(36)            NOT NULL             COMMENT '工艺路线单主键',
  `operation_routing_qa_procedure`        varchar(250)        NULL                 COMMENT '品质说明',
  `operation_routing_standard_price`      float(8,4)          NOT NULL             COMMENT '标准单价',
  `operation_routing_section_type`        varchar(12)         NULL                 COMMENT '所属工段',
  `operation_routing_machine_type_id`     char(36)            NULL                 COMMENT '机器类型',
  `operation_routing_actual_station_id`   char(36)            NULL ,
  `operation_routing_operator_id`         char(36)            NULL                 COMMENT '操作员主键',
  `operation_routing_standard_time`       float(8,4)          NULL                 COMMENT '标准时间',
  `operation_routing_actual_time`         float(8,4)          NULL ,
  `operation_routing_pre_operation_id`    char(36)            NULL                 COMMENT '依赖关系-上道工艺',
  `operation_routing_sop_file_path`       varchar(255)        NULL ,
  `operation_routing_status`              enum('P','S','F')   NULL DEFAULT 'P'     COMMENT 'P.已计划	S.已开始	 F.已完成',
  `operation_routing_required_level`      varchar(10)         NULL                 COMMENT '需要工艺等级',
  `operation_routing_scrap_qty`           int                 NULL DEFAULT 0       COMMENT '报废数量',
  `operation_routing_complete_qty`        int                 NULL DEFAULT 0       COMMENT '完工数量',
  `operation_routing_pre_routing_id`      char(36)            NULL                 COMMENT '依赖关系-上道工序',
  `operation_routing_sequence_no`         int                 NOT NULL             COMMENT '工序顺序',
  `operation_routing_part_type`           varchar(40)         NULL ,
  `operation_routing_if_outsource`        tinyint(1)          NULL ,
  `operation_routing_pull_in_time`        datetime(0)         NULL                 COMMENT '进站时间',
  `operation_routing_pull_out_time`       datetime(0)         NULL                 COMMENT '出站时间',

  PRIMARY KEY (`operation_routing_id`) ,
  INDEX `IDX_OPERATION_ROUTING_01`(`operation_routing_operation_id`) ,
  INDEX `IDX_OPERATION_ROUTING_02`(`operation_routing_order_id`) ,
  INDEX `IDX_OPERATION_ROUTING_03`(`operation_routing_operator_id`) ,
  INDEX `IDX_OPERATION_ROUTING_04`(`operation_routing_actual_station_id`) ,
  INDEX `IDX_OPERATION_ROUTING_05`(`operation_routing_pre_operation_id`) ,
  INDEX `IDX_OPERATION_ROUTING_06`(`operation_routing_pre_routing_id`)
) COMMENT = '工艺路线';

-- -----------------------------------------------------------------------------------------------------------

CREATE TABLE `requirement_order`  (
  `requirement_order_id`                       char(36)              NOT NULL,
  `requirement_order_no`                       varchar(12)           NOT NULL               COMMENT '需求订单号',
  `requirement_order_type`                     varchar(10)           NOT NULL               COMMENT '需求订单类型',
  `requirement_order_status`                   varchar(10)           NOT NULL               COMMENT '状态',
  `requirement_order_priority`                 varchar(10)           NOT NULL               COMMENT '优先级',
  `requirement_order_plant_id`                 char(36)              NOT NULL               COMMENT '工厂主键',
  `requirement_order_work_center_id`           char(36)              NOT NULL               COMMENT '工作中心主键',
  `requirement_order_fg_material_id`           char(36)              NOT NULL               COMMENT '物料号',
  `requirement_order_planned_qty`              int                   NOT NULL               COMMENT '计划生产数量',
  `requirement_order_required_delivery_date`   datetime              NOT NULL               COMMENT '需求交期',
  `requirement_order_sale_order_no`            varchar(64)           NULL                   COMMENT '销售订单号',
  `requirement_order_repeat_type`              enum('F','R','S')     NOT NULL DEFAULT 'F'   COMMENT '标识:F 首单  R 翻单 S 补单',

  PRIMARY KEY (`requirement_order_id`) ,
  INDEX `IDX_REQUIREMENT_ORDER_01`(`requirement_order_no`) ,
  INDEX `IDX_REQUIREMENT_ORDER_02`(`requirement_order_work_center_id`)
) COMMENT = '需求订单';


CREATE TABLE `customer`  (
  `customer_id`                          char(36)           NOT NULL ,
  `customer_production_order_id`         varchar(36)        NOT NULL       COMMENT '生产订单主键',
  `customer_name`                        varchar(30)        NOT NULL       COMMENT '姓名',
  `customer_sex`                         enum('M','F')      NULL           COMMENT '性别',
  `customer_mail_address`                varchar(120)       NULL           COMMENT '邮寄地址',
  `customer_telephone`                   varchar(24)        NULL           COMMENT '电话',
  `customer_type`                        varchar(20)        NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `IDX_CUSTOMER_01`(`customer_production_order_id`),
  INDEX `IDX_CUSTOMER_02`(`customer_name`)
) COMMENT = '客户信息';

-- -----------------------------------------------------------------------------------------------------------

CREATE TABLE `production_order`  (
  `production_order_id`                          char(36)          NOT NULL,
  `production_order_no`                          varchar(64)       NOT NULL,
  `production_order_type`                        varchar(10)       NOT NULL,
  `production_order_bom_order_id`                char(36)          NULL ,
  `production_order_operation_routing_order_id`  char(36)          NULL ,
  `production_order_source`                      varchar(10)       NULL       COMMENT '订单来源',
  `production_order_material_ready`              varchar(10)       NULL       COMMENT '物料准备',
  `production_order_status`                      varchar(10)       NOT NULL,
  `production_order_priority`                    varchar(10)       NOT NULL,
  `production_order_requirement_order_id`        char(36)          NOT NULL,
  `production_order_plant_id`                    char(36)          NOT NULL,
  `production_order_work_center_id`              char(36)          NULL ,
  `production_order_fg_material_id`              varchar(64)       NULL       COMMENT '成品物料主键',
  `production_order_planned_qty`                 int               NULL ,
  `production_order_finished_qty`                int               NULL ,
  `production_order_second_quality_qty`          int               NULL       COMMENT '次品数量',
  `production_order_defect_qty`                  int               NULL ,
  `production_order_actual_qty`                  int               NULL ,
  `production_order_required_delivery_date`      datetime(0)       NULL ,
  `production_order_planned_start_date`          datetime(0)       NULL ,
  `production_order_planned_end_date`            datetime(0)       NULL ,
  `production_order_actual_start_date`           datetime(0)       NULL ,
  `production_order_actual_end_date`             datetime(0)       NULL ,
  `production_order_schedule_order_id`           char(36)          NULL       COMMENT '排程编号',

  `production_order_create_by`                   varchar(6)        NOT NULL,
  `production_order_create_date`                 datetime          NOT NULL,
  `production_order_update_by`                   varchar(6)        NULL,
  `production_order_update_date`                 datetime          NOT NULL,
  `production_order_optLock`                     int               NOT NULL DEFAULT 0,

  PRIMARY KEY (`production_order_id`)
) COMMENT = '生产订单';

CREATE TABLE `production_order_routing`  (
  `production_order_routing_id`                         char(36)         NOT NULL       AUTO_INCREMENT,
  `production_order_routing_production_order_id`        char(36)         NULL ,
  `production_order_routing_operation_id`               char(36)         NOT NULL,
  `production_order_routing_qa_procedure`               varchar(200)     NULL ,
  `production_order_routing_machine_type_id`            char(36)         NULL ,
  `production_order_routing_standard_time`              float(10,4)      NULL ,
  `production_order_routing_standard_price`             float(8,4)       NULL ,
  `production_order_routing_section_type`               varchar(20)      NULL ,
  `production_order_routing_pre_operation_id`           char(36)         NULL       COMMENT '依赖关系-上道工序',
  `production_order_routing_sop_file_path`              varchar(255)     NULL ,

  PRIMARY KEY (`production_order_routing_id`)
) COMMENT = '生产订单工序信息';

CREATE TABLE `production_order_size`  (
  `production_order_size_id`                         char(36)         NOT NULL AUTO_INCREMENT,
  `production_order_size_production_order_id`        char(36)         NOT NULL,
  -- `line_no`                    int(11)            NULL       COMMENT '行项目',
  `production_order_size_size`                       varchar(10)      NULL ,
  `production_order_size_planned_qty`                int              NULL ,
  `production_order_size_actual_qty`                 int              NULL ,

  PRIMARY KEY (`production_order_size_id`) ,
  INDEX `IDX_PRO_SIZE_01`(`production_order_size_production_order_id`)
) COMMENT = '生产订单尺码明细';

-- -----------------------------------------------------------------------------------------------------------

CREATE TABLE `material_picking_order`  (
  `id`                        bigint(20)         NOT NULL AUTO_INCREMENT,
  `material_picking_order_no` varchar(64)        NOT NULL,
  `production_order_id`       bigint(20)         NOT NULL,
  `status`                    varchar(10)        NULL ,
  `type`                      varchar(10)        NULL ,
  `planned_picking_date`      datetime(0)        NULL ,
  `actual_picking_date`       datetime(0)        NULL ,
  `operator`                  varchar(10)        NULL ,

  `created_date` datetime(0) NOT NULL,
  `created_by` varchar(10) NOT NULL,
  `last_modified_date` datetime(0) NULL ,
  `last_modified_by` varchar(10) NULL ,

  PRIMARY KEY (`id`) ,
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


-- ----------------------------------------------------------------------------------------------------------------


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

-- -----------------------------------------------------------------------------------------------------------


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




CREATE TABLE `size_label_match_rule`  (
  `id`                      bigint(20)           NOT NULL AUTO_INCREMENT,
  `rule_no`                 varchar(10)          NULL         COMMENT '规则编码',
  `product_category_id`     bigint(20)           NULL         COMMENT '产品品类',
  `product_size`            varchar(10)          NULL         COMMENT '产品尺码',
  `size_label_size`         varchar(10)          NULL         COMMENT '号标尺码',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_SLMR_01`(`rule_no`) ,
  INDEX `IDX_SLMR_02`(`product_category_id`)
)  COMMENT = '号标匹配规则';

CREATE TABLE `size_match_rule`  (
  `id`                      bigint(20)            NOT NULL AUTO_INCREMENT,
  `rule_no`                 varchar(10)           NULL       COMMENT '规则编码',
  `description`             varchar(200)          NULL       COMMENT '规则描述',
  `fg_material_size`        varchar(10)           NULL       COMMENT '产品规格',
  `assist_material_size`    varchar(10)           NULL       COMMENT '辅材规格',
  `unit`                    varchar(10)           NULL       COMMENT '单位',
  `type`                    varchar(10)           NOT NULL               COMMENT 'zipper:拉链长度匹配 sizelabel:号标匹配',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_SMR_01`(`rule_no`)
) COMMENT = '规格匹配规则';


CREATE TABLE `zipper_match_rule`  (
  `id`                        bigint(20)         NOT NULL AUTO_INCREMENT,
  `rule_no`                   varchar(10)        NULL      COMMENT '规则编码',
  `product_category_id`       bigint(20)         NULL      COMMENT '产品品类',
  `product_size`              varchar(10)        NULL      COMMENT '产品尺码',
  `zipper_category_id`        bigint(20)         NULL      COMMENT '拉链品类',
  `zipper_size`               varchar(10)        NULL      COMMENT '拉链长度',
  `unit`                      varchar(10)        NULL      COMMENT '单位',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_ZMR_01`(`rule_no`) ,
  INDEX `IDX_ZMR_02`(`product_category_id`) ,
  INDEX `IDX_ZMR_03`(`zipper_category_id`)
) COMMENT = '拉链长度匹配规则';



CREATE TABLE `price_scopes`  (
  `id`                         bigint(20)        NOT NULL AUTO_INCREMENT,
  `price_scopes_no`            varchar(10)       NULL         COMMENT '价格带编码',
  `price`                      decimal(10, 2)    NULL         COMMENT '价格',
  `material_group_id`          bigint(20)        NULL         COMMENT '物料组',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_PRICE_SCOPES_01`(`price_scopes_no`) ,
  INDEX `IDX_PRICE_SCOPES_02`(`material_group_id`)
) COMMENT = '价格带';

CREATE TABLE `price_scopes_match_rule`  (
  `id`                        bigint(20)         NOT NULL AUTO_INCREMENT,
  `main_material_id`          bigint(20)         NULL        COMMENT '主材物料',
  `rule_no`                   varchar(10)        NULL        COMMENT '规则编码',
  `assist_material_id`        bigint(20)         NULL        COMMENT '辅材物料',
  `description`               varchar(200)       NULL        COMMENT '规则描述',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_PSMR_01`(`main_material_id`) ,
  INDEX `IDX_PSMR_02`(`rule_no`) ,
  INDEX `IDX_PSMR_03`(`assist_material_id`)
) COMMENT = '价格带匹配规则';


CREATE TABLE `match_rule`  (
  `id`                        bigint(20) NOT NULL AUTO_INCREMENT,
  `rule_no`                   varchar(10) NULL ,
  `description`               varchar(200) NULL ,
  `version`                   varchar(10) NULL ,
  `disable`                   int(1) NULL ,
  `unit`                      varchar(10) NULL ,
  `script`                    longtext NULL,
  `type`                      varchar(10) NOT NULL                  COMMENT 'zipper:拉链长度匹配 sizelabel:号标匹配',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_MATCH_RULE_01`(`rule_no`)
) COMMENT='规则表' ;


CREATE TABLE `material_match_rule`  (
  `id`                      bigint(20)          NOT NULL AUTO_INCREMENT,
  `material_id`             bigint(20)          NULL ,
  `rule_id`                 bigint(20)          NULL ,
  `type`                   varchar(10)         NULL      COMMENT 'price:价格匹配 zipper:拉链长度匹配 sizelabel:号标匹配 color:颜色匹配',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_MMR_01`(`material_id`) ,
  INDEX `IDX_MMR_02`(`rule_id`)
) COMMENT='物料匹配规则';

CREATE TABLE `material_match_rule_log`  (
  `id`                     bigint(20)          NOT NULL AUTO_INCREMENT,
  `bom_id`                 bigint(20)          NULL ,
  `rule_id`                bigint(20)          NULL ,

  PRIMARY KEY (`id`)
) COMMENT = '物料匹配规则日志';






CREATE TABLE `operator_check_in`  (
  `id`                         bigint(20)         NOT NULL AUTO_INCREMENT,
  `operator_id`                bigint(20)         NOT NULL           COMMENT '操作员主键',
  `work_station_id`            bigint(20)         NOT NULL           COMMENT '工位主键',
  `check_in_time`              datetime(0)        NULL   COMMENT '入岗时间',
  `check_out_time`             datetime(0)        NULL   COMMENT '出岗时间',
  `status`                     varchar(10)        NULL   COMMENT '状态',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_OPERATOR_CHECK_IN_01`(`operator_id`) ,
  INDEX `IDX_OPERATOR_CHECK_IN_02`(`work_station_id`)
) COMMENT = '操作员入岗';

-- ----------

CREATE TABLE `quality_check`  (
  `id`                         bigint(20)          NOT NULL AUTO_INCREMENT,
  `production_order_id`        bigint(20)          NULL ,
  `size_no`                    varchar(20)         NULL ,
  `name`                       varchar(20)         NULL ,

  PRIMARY KEY (`id`) 
) ;

CREATE TABLE `quality_check_detail`  (
  `id`                         bigint(20) NOT NULL AUTO_INCREMENT,
  `quality_check_id`           bigint(20)         NULL ,
  `component_no`               varchar(10)        NULL ,
  `component_name`             varchar(20)        NULL ,
  `value`                      varchar(20)        NULL ,

  PRIMARY KEY (`id`) 
);

CREATE TABLE `quality_issue`  (
  `id`                        bigint(20)          NOT NULL AUTO_INCREMENT,
  `issue_order_id`            bigint(20)          NOT NULL               COMMENT '单据主键',
  `line_no`                   int(11)             NULL       COMMENT '行项目',
  `operation_routing_id`      bigint(20)          NOT NULL               COMMENT '工艺工序主键',
  `workstation_id`            bigint(20)          NOT NULL               COMMENT '工位主键',
  `operator_id`               bigint(20)          NOT NULL               COMMENT '操作员主键',
  `machine_id`                bigint(20)          NOT NULL               COMMENT '操作设备主键',
  `defect_id`                 bigint(20)          NULL       COMMENT '不合格原因主键',
  `section_type`              varchar(10)         NULL       COMMENT '质量问题工段类型 (裁剪阶段	cutting、缝制阶段	stitching)',
  `correction_id`             bigint(20)          NULL       COMMENT '处理方式主键',
  `if_repaired`               tinyint(1)          NULL DEFAULT 0         COMMENT '是否修复 n:未修复 y:已修复',
  `remark`                    varchar(100)        NULL       COMMENT '质量备注',

  `created_date` datetime(0) NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `last_modified_date` datetime(0) NULL ,
  `last_modified_by` varchar(20) NULL ,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_QUALITY_ISSUE_01`(`issue_order_id`) ,
  INDEX `IDX_QUALITY_ISSUE_02`(`operation_routing_id`) ,
  INDEX `IDX_QUALITY_ISSUE_03`(`workstation_id`) ,
  INDEX `IDX_QUALITY_ISSUE_04`(`operator_id`) ,
  INDEX `IDX_QUALITY_ISSUE_05`(`machine_id`) ,
  INDEX `IDX_QUALITY_ISSUE_06`(`defect_id`) ,
  INDEX `IDX_QUALITY_ISSUE_07`(`correction_id`) 
) COMMENT = '质量问题记录';


-- ---------------------------------------------------------------------------------------------------------------------


CREATE TABLE `request_warehousing`  (
  `id`                        bigint(20)           NOT NULL AUTO_INCREMENT,
  `request_no`                varchar(30)          NOT NULL             COMMENT '单据编号',
  `finish_date`               datetime(0)          NULL     COMMENT '生产完成日期',
  `sale_order_no`             varchar(64)          NOT NULL             COMMENT '销售订单编号',
  `description`               varchar(1000)        NULL     COMMENT '备注',
  `is_storage`                tinyint(1)           NOT NULL DEFAULT 0   COMMENT '是否入库',
  `created_date`              timestamp(0)         NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_RE_WAREHOUSING_01`(`request_no`) ,
  INDEX `IDX_RE_WAREHOUSING_02`(`sale_order_no`) 
)  COMMENT = '商品进货单';

CREATE TABLE `request_warehousing_entry`  (
  `id`                       bigint(20)             NOT NULL AUTO_INCREMENT,
  `request_warehouing_id`    bigint(20)             NOT NULL              COMMENT '入库申请ID',
  `material_no`              varchar(30)            NULL      COMMENT '产品编码',
  `material_name`            varchar(30)            NULL      COMMENT '商品名称',
  `color_no`                 varchar(30)            NULL      COMMENT '颜色代码',
  `color_name`               varchar(30)            NULL      COMMENT '颜色名称',
  `size_no`                  varchar(30)            NULL      COMMENT '尺寸代码',
  `size_name`                varchar(30)            NULL      COMMENT '尺寸名称',
  `count`                    int(11)                NULL      COMMENT '数量',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_RE_WAREHOUSING_ENTRY_01`(`request_warehouing_id`) 
) COMMENT = '商品进货单明细';

CREATE TABLE `sequence`  (
  `sequence_key`             varchar(64)          NOT NULL,
  `sequence_value`           bigint(20)           NOT NULL,

  PRIMARY KEY (`sequence_key`) ,
  INDEX `IDX_SEQ_01`(`sequence_key`) 
) COMMENT = 'ID序列';

CREATE TABLE `measure_body_classify`  (
  `id`                       bigint(20)          NOT NULL AUTO_INCREMENT,
  `classify_no`              varchar(10)         NOT NULL               COMMENT '选项编码',
  `name`                     varchar(20)         NULL       COMMENT '选项名称',
  `parent_id`                bigint(20)          NULL       COMMENT '上层选项主键',
  `unit`                     varchar(10)         NULL       COMMENT '数据单位',

  PRIMARY KEY (`id`) ,
  INDEX `IDX_MBC_01`(`classify_no`) ,
  INDEX `IDX_MBC_02`(`name`) ,
  INDEX `IDX_MBC_03`(`parent_id`)
) COMMENT = '针对服装类型 定义量体选项的内容 ';

CREATE TABLE `production_order_measure_data`  (
  `id`                          bigint(20)        NOT NULL AUTO_INCREMENT,
  `production_order_id`         bigint(20)        NULL       COMMENT '生产订单主键',
  `measure_body`                varchar(20)       NULL       COMMENT '量体部位',
  `measure_data`                varchar(20)       NULL       COMMENT '量体数据',
  `measure_body_no`             varchar(20)       NULL ,

  PRIMARY KEY (`id`) ,
  INDEX `IDX_PRO_ORDER_MD_01`(`production_order_id`)
) COMMENT = '生产订单量体数据';





CREATE TABLE `interface_log_visualization`  (
  `id`                         bigint(20)             NOT NULL        AUTO_INCREMENT,
  `chart_type`                 varchar(20)            NOT NULL                COMMENT '图表类型',
  `chart_code`                 varchar(20)            NOT NULL                COMMENT '图表编码',
  `chart_series_name`          varchar(20)            NOT NULL                COMMENT '图表数据-类型',
  `chart_data_key`             varchar(64)            NOT NULL                COMMENT '图表数据-键',
  `chart_data_value`           varchar(64)            NOT NULL                COMMENT '图表数据-值',

  `created_by`                 varchar(20)            NOT NULL                COMMENT '创建人',
  `created_date`               datetime(0)            NOT NULL                COMMENT '创建日期',
  `last_modified_by`           varchar(20)            NOT NULL                COMMENT '修改人',
  `last_modified_date`         datetime(0)            NOT NULL                COMMENT '修改日期',
  PRIMARY KEY (`id`)
) COMMENT = '可视化接口日志';

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
delimiter ;;
CREATE FUNCTION `nextval`(str VARCHAR(20))
 RETURNS int(11)
BEGIN
    DECLARE a INT;
    SET a = (
                  SELECT sequence_value
      FROM sequence
      WHERE sequence_key = str
                );
    IF a IS NULL
    THEN
      SET a = 0;
      INSERT INTO sequence (sequence_key, sequence_value) VALUES (str, 1);
    ELSE
      UPDATE sequence
      SET sequence_value = a + 1
                  WHERE sequence_key = str;
    END IF;
    RETURN a + 1;
  END
;;
delimiter ;
