#
#  需求订单在生产管理系统里面实际上不是必须的，只需要生产排程，通过排程来找需求订单。
#
# create table requirement_order  (
#   record_id                       bigint    auto_increment                     not null,
#   requirement_order_no            varchar(12)           not null               comment '需求订单号',
#   requirement_order_type          varchar(10)           not null               comment '需求订单类型',
#   requirement_order_status        varchar(10)           not null               comment '状态',
#   priority                        int                   not null               comment '优先级',
#   plant_id                        bigint              not null               comment '工厂主键',
#   work_center_id                  bigint              not null               comment '工作中心主键',
#   fg_material_id                  bigint              not null               comment '物料号',
#   planned_qty                     int                   not null               comment '计划生产数量',
#   required_delivery_date          datetime              not null               comment '需求交期',
#   sale_order_no                   varchar(64)           null                   comment '销售订单号',
#   repeat_type                     int                   not null default 0     comment '重复类型:0.首单 1.返单 2.补单',
#
#   primary key (record_id) ,
#   index idx_requirement_order_01(requirement_order_no) ,
#   index idx_requirement_order_02(work_center_id)
# ) comment = '需求订单';
#


create table schedule_order(
  record_id                       bigint       auto_increment        not null,
  
  schedule_no                     varchar(12)                        not null,
  requirement_order_no            varchar(12)                        not null,
  production_order_id             bigint                             null,
  production_order_no             varchar(12)                        null,

  plan_id                         bigint                             not null,
  plant_no                        varchar(3)                         not null,
  work_center_id                  bigint                             not null,
  work_center_no                  varchar(6)                         not null,

  fg_material_id                  bigint                             not null,
  fg_material_no                  varchar(12)                        not null comment '主面料号/款号',
  
  qty_planned                     int                                not null,
  qty_actual                      int                                null,
  
  date_required_delivery          datetime                           not null,
  date_plan_start                 datetime                           not null,
  date_plan_end                   datetime                           not null,
  date_actual_start               datetime                           null,
  date_actual_end                 datetime                           null,
  
  order_status                    tinyint                            not null,

  create_by                       bigint                             not null,
  create_date                     datetime                           not null,
  update_by                       bigint                             null,
  update_date                     datetime                           null,
  optlock                         int                                not null default 0,

  primary key (record_id),
  index idx_schedule_order_01(schedule_no),
  index idx_schedule_order_02(requirement_order_no),
  index idx_schedule_order_03(production_order_no),
  index idx_schedule_order_04(fg_material_no),
  index idx_schedule_order_05(date_required_delivery),
  index idx_schedule_order_06(date_plan_start),
  index idx_schedule_order_07(date_plan_end),
  index idx_schedule_order_08(order_status)
)comment '生产排程';


create table production_order  (
  record_id                   bigint    auto_increment          not null,
  production_order_no         varchar(12)       not null,
  production_order_status     int               not null default 0,
  material_ready              varchar(10)       null       comment '物料准备',
  priority                    varchar(10)       not null,
  requirement_order_id        bigint            not null,
  plant_id                    bigint            not null,
  work_center_id              bigint            null ,
  fg_material_id              bigint            null       comment '成品物料主键',
  planned_qty                 int               null ,
  finished_qty                int               null ,
  second_quality_qty          int               null       comment '次品数量',
  defect_qty                  int               null ,
  actual_qty                  int               null ,
  required_delivery_date      datetime          null ,
  planned_start_date          datetime          null ,
  planned_end_date            datetime          null ,
  actual_start_date           datetime          null ,
  actual_end_date             datetime          null ,
  schedule_order_id           bigint            null       comment '排程编号',   -- 生产计划可以没有排程

  create_by                   bigint            not null,
  create_date                 datetime          not null,
  update_by                   bigint            null,
  update_date                 datetime          not null,
  optlock                     int               not null default 0,

  primary key (record_id)
) comment = '生产订单';

create table order_size  (
  record_id                    bigint  auto_increment  not null ,
  order_id                     bigint                  not null,
  ref_record_type              int                     not null,
  size_id                      bigint                  not null,
  size_code                    varchar(10)             not null,
  qyt_planned                  int                     null,

  create_by                    bigint                  not null,
  create_date                  datetime                not null,
  update_by                    bigint                  null,
  update_date                  datetime                null,
  optlock                      int                     not null default 0,

  primary key (record_id),
  index idx_order_size_01(order_id),
  index idx_order_size_02(ref_record_type)
) comment = '订单尺码明细';


create table order_measure  (
  record_id                    bigint   auto_increment  not null,
  order_id                     bigint                   not null ,
  ref_record_type              int                      not null,
  body_no                      varchar(20)              not null ,
  measure_data                 int                      not null ,

  create_by                    bigint                   not null,
  create_date                  datetime                 not null,
  update_by                    bigint                   null,
  update_date                  datetime                 null,
  optlock                      int                      not null default 0,

  primary key (record_id) ,
  index idx_pro_order_md_01(order_id)
) comment = '量体数据';

#
# create table measure_body_classify  (
#   record_id                char(36)            not null,
#   classify_no              varchar(10)         not null   comment '选项编码',
#   classify_name            varchar(20)         null       comment '选项名称',
#   parent_id                bigint(20)          null       comment '上层选项主键',
#   unit                     varchar(10)         null       comment '数据单位',
#
#   primary key (record_id) ,
#   index idx_mbc_01(classify_no) ,
#   index idx_mbc_02(classify_name) ,
#   index idx_mbc_03(parent_id)
# ) comment = '针对服装类型 定义量体选项的内容 ';




create table material_picking_order  (
  record_id                            char(36)           not null,
  material_picking_order_no            varchar(64)        not null,
  production_order_id                  char(36)           not null,
  material_picking_order_status        tinyint            not null ,
  material_picking_order_type          tinyint            not null ,
  planned_picking_date                 datetime           null ,
  actual_picking_date                  datetime           null ,
  operator_id                          char(36)           null ,

  create_by                   char(36)          not null,
  create_date                 datetime          not null,
  update_by                   char(36)          null,
  update_date                 datetime          not null,
  optlock                     int               not null default 0,

  primary key (record_id) ,
  index idx_material_po_01(material_picking_order_no) ,
  index idx_material_po_02(production_order_id)
) comment = '领料单';



create table material_picking_order_bom  (
  id                        bigint(20)         not null auto_increment,
  component_material_id     bigint(200)        null       comment '组件主键',
  qty                       double             null       comment '组件用量',
  component_material_uom    varchar(20)        null       comment '组件单位',
  picked_qty                double             null ,
  material_picking_order_id bigint(20)         null ,

  primary key (id) ,
  index idx_material_pob_01(component_material_id) ,
  index idx_material_pob_02(material_picking_order_id)
) comment = '领料单物料清单';


create table material_picking_list  (
  id                        bigint(20)          not null auto_increment,
  status                    varchar(10)         null          comment '状态',
  -- line_no                   int(11)             null          comment '行项目',
  container_no              varchar(64)         not null                  comment '领料容器',
  material_picking_order_id bigint(20)          null          comment '领料单主键',

  created_date datetime(0) not null,
  created_by varchar(10) not null,
  last_modified_date datetime(0) null ,
  last_modified_by varchar(10) null ,

  primary key (id) ,
  index idx_material_pl_01(container_no) ,
  index idx_material_pl_02(material_picking_order_id)
) comment = '领料单明细';


create table material_picking_list_detail  (
  id                        bigint(20)         not null  auto_increment,
  material_picking_list_id  bigint(20)         not null                   comment '领料单明细主键',
  --  line_no                   int(11)            null           comment '行项目',
  material_id               bigint(20)         null           comment '物料号',
  picked_qty                double             null           comment '领用量',

  primary key (id) ,
  index idx_material_pld_01(material_picking_list_id) ,
  index idx_material_pld_02(material_id)
) comment = '领料明细';


create table cutting_order  (
  id                          bigint(20)          not null auto_increment,
  cutting_order_no            varchar(64)         null                 comment '裁剪单号',
  line_no                     int(11)             null                 comment '行项目',
  production_order_id         bigint(20)          not null             comment '生产订单主键',
  cutting_table_no            varchar(64)         null                 comment '床次',
  status                      varchar(10)         null                 comment '状态',
  container_no                varchar(64)         null                 comment '裁剪单容器',
  planned_qty                 int(11)             not null   default 0 comment '计划数量',
  finished_qty                int(11)             not null   default 0 comment '实际完工数量',
  fg_material_id              varchar(64)         null                 comment '成品物料号',
  fabric_material_type        varchar(64)         null                 comment '面料类型',
  fabric_material_id          varchar(64)         null                 comment '面料物料主键',
  plies                       int(11)             null                 comment '层数',
  width                       double              null                 comment '幅宽',
  length                      double              null                 comment '长度',
  cutting_efficiency          double              null                 comment '利用率',
  work_station_id             bigint(20)          null                 comment '裁剪工位',
  planned_cutting_date        datetime(0)         null                 comment '计划领料时间',
  actual_cutting_date         datetime(0)         null                 comment '实际领料时间',
  planned_end_date            datetime(0)         null                 comment '计划完成时间',
  actual_end_date             datetime(0)         null                 comment '实际完成时间',
  hanging_station_id          bigint(20)          null                 comment '上吊挂工位',

  created_by                  varchar(20)         not null,
  created_date                datetime(0)         not null,
  last_modified_by            varchar(20)         not null,
  last_modified_date          datetime(0)         not null,

  primary key (id),
  index idx_cutting_order_01(cutting_order_no),
  index idx_cutting_order_02(production_order_id),
  index idx_cutting_order_03(work_station_id)
)comment = '裁剪单' ;

create table cutting_order_size  (
  id                          bigint(20)          not null        auto_increment,
  cutting_order_id            bigint(20)          not null        comment '裁剪单主键',
  line_no                     int(11)             null            comment '行项目',
  size                        varchar(10)         null            comment '尺码',
  layer_qty                   int(11)             null            comment '单层配比数量',
  planned_qty                 int(11)             null            comment '计划裁剪数量',
  actual_qty                  int(11)             null            comment '实际裁剪数量',
  created_work_order_qty      int(11)             null            comment '已创建作业单数量',

  primary key (id),
  index idx_cutting_order_size_01(cutting_order_id)
)comment = '裁剪单尺码明细';



create table production_cutting_plan  (
  id                          bigint(20)        not null auto_increment,
  production_cutting_plan_no  varchar(64)       not null,
  production_order_id         bigint(20)        not null,
  line_no                     int(11)           null     comment '行项目',
  cutting_table_no            varchar(64)       null ,
  size                        varchar(10)       null ,
  status                      varchar(10)       null ,
  cutting_qty                 int(11)           null ,
  fg_material_id              varchar(64)       null ,
  fabric_material_type        varchar(64)       null ,
  fabric_material_no          varchar(64)       null ,
  plies                       int(11)           null     comment '层数',
  width                       double            null ,
  length                      double            null ,
  cutting_efficiency          double            null ,

  primary key (id) ,
  index idx_pro_cutting_plan_01(production_cutting_plan_no) ,
  index idx_pro_cutting_plan_02(production_order_id)
) comment = '生产裁剪排料计划';

create table production_cutting_size  (
  id                          bigint(20)        not null auto_increment,
  production_cutting_plan_id  bigint(20)        not null,
  line_no                     int(11)           null     comment '行项目',
  cutting_table_no            varchar(64)       null ,
  size                        varchar(10)       null ,
  layer_qty                   int(11)           null ,
  planned_qty                 int(11)           null ,
  actual_qty                  int(11)           null ,

  primary key (id) ,
  index idx_pro_cutting_size_01(production_cutting_plan_id)
) comment = '生产裁剪排料尺码';


create table cutting_marker  (
  id                          bigint(20)         not null auto_increment,
  cutting_order_id            bigint(20)         not null,
  line_no                     int(11)            null                   comment '行项目',
  media_id                    bigint(20)         null,
  remark                      varchar(64)        null,
  marker_file_id              bigint(20)         null,
  primary key (id),
  index idx_cutting_marker_01(cutting_order_id),
  index idx_cutting_marker_02(media_id)
) comment = '生产裁剪排料图' ;

create table production_work_order  (
  id                         bigint(20)         not null auto_increment,
  line_no                    int(11)            null       comment '行项目',
  production_work_order_no   varchar(64)        not null,
  production_order_id        bigint(20)         not null,
  bom_order_id               bigint(20)         null       comment '物料清单主键',
  operation_routing_order_id bigint(20)         null       comment '工序单主键',
  cutting_order_id           bigint(20)         null       comment '裁剪单主键',
  size                       varchar(10)        null       comment '尺码',
  status                     varchar(10)        null       comment '已创建	created  已开工	started  已完工	finished',
  planned_start_date         datetime(0)        null ,
  planned_end_date           datetime(0)        null ,
  actual_start_date          datetime(0)        null ,
  actual_end_date            datetime(0)        null ,
  container_no               varchar(64)        null       comment '衣架号',
  if_syn_finish_status       tinyint(1)         not null default 0     comment '同步完成状态',

  created_by varchar(20) not null,
  created_date datetime(0) not null,
  last_modified_by varchar(20) not null,
  last_modified_date datetime(0) not null,

  primary key (id) ,
  index idx_pro_work_order_01(production_work_order_no) ,
  index idx_pro_work_order_02(production_order_id) ,
  index idx_pro_work_order_03(bom_order_id) ,
  index idx_pro_work_order_04(operation_routing_order_id) ,
  index idx_pro_work_order_05(cutting_order_id)
) comment = '生产作业单';