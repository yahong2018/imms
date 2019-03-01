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

-- -----------------------------------------------------------------------------------------------------------



-- -----------------------------------------------------------------------------------------------------------





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
