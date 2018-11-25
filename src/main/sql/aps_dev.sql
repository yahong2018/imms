-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id`              int(11) 					  NOT NULL AUTO_INCREMENT,
  `code` 			      varchar(32) 				DEFAULT NULL 				COMMENT '区域编码',
  PRIMARY KEY (`id`) ,
  KEY `ix_name` (`code`)  
) COMMENT='行政区域表';

-- ----------------------------
-- Table structure for algorithm
-- ----------------------------
DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `id`                bigint(20)        NOT NULL AUTO_INCREMENT ,
  `client`            int(11) DEFAULT '1'                   COMMENT '客户端代码，默认为1',
  `code`              varchar(268)      DEFAULT NULL        COMMENT '计算算法的类全限定名',
  `name`              varchar(268)      DEFAULT NULL        COMMENT '计算算法名称',
  `create_time`       datetime          DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id`    int(11)           DEFAULT NULL        COMMENT '创建人ID',
  `update_time`       datetime          DEFAULT NULL        COMMENT '修改时间',
  `update_user_id`    int(11)           DEFAULT NULL        COMMENT '修改人ID',
  `description`       varchar(2000)     DEFAULT NULL        COMMENT '描述',
  `status`            bit(1)            DEFAULT b'1'        COMMENT '状态， 1:启用  0:禁用',
  `is_delete`         bit(1)            DEFAULT b'0'        COMMENT '是否删除，0:否 1:是',
  PRIMARY KEY (`id`) 
)  COMMENT='计算算法表';

-- ----------------------------
-- Table structure for algorithm_group
-- ----------------------------
DROP TABLE IF EXISTS `algorithm_group`;
CREATE TABLE `algorithm_group` (
  `id`                bigint(20)        NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `client`            int(11)           DEFAULT '1'             COMMENT '公司标识代码; 默认为1',
  `code`              varchar(268)      DEFAULT NULL            COMMENT '计算算法分组code',
  `name`              varchar(268)      DEFAULT NULL            COMMENT '计算算法分组名称',
  `description`       varchar(2000)     DEFAULT NULL            COMMENT '描述',
  `create_time`       datetime          DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id`    bigint(20)        DEFAULT NULL              COMMENT '创建人ID',
  `update_time`       datetime          DEFAULT NULL              COMMENT '修改时间',
  `update_user_id`    bigint(20)        DEFAULT NULL              COMMENT '修改人ID',
  `status`            bit(1)            DEFAULT b'1'              COMMENT '状态，0:禁用 1:启用',
  `is_delete`         bit(1)            DEFAULT b'0'              COMMENT '是否删除，0:否 1:是',
  PRIMARY KEY (`id`) 
) ;

-- ----------------------------
-- Table structure for algorithm_group_relation
-- ----------------------------
DROP TABLE IF EXISTS `algorithm_group_relation`;
CREATE TABLE `algorithm_group_relation` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT,
  `algorithm_group_id`  bigint(20)        NOT NULL    DEFAULT '0'     COMMENT '组ID',
  `algorithm_id`        bigint(20)        NOT NULL    DEFAULT '0'     COMMENT '计算算法ID',
  `sort`                int(11)           NOT NULL    DEFAULT '0'     COMMENT '算法的顺序，由小到大排序',
  `is_delete`           bit(1)            DEFAULT b'0'                COMMENT '是否删除，0:否 1:是',
  PRIMARY KEY (`id`) 
) ;

-- ----------------------------
-- Table structure for algorithm_parameter
-- ----------------------------
DROP TABLE IF EXISTS `algorithm_parameter`;
CREATE TABLE `algorithm_parameter` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '主键ID',
  `parent_id`           bigint(20)        DEFAULT NULL                COMMENT '父节点ID',
  `client`              int(11)           DEFAULT '1'                 COMMENT '客户端代码，默认为1',
  `code`                varchar(268)      DEFAULT NULL                COMMENT '参数code',
  `name`                varchar(268)      DEFAULT NULL                COMMENT '参数名称',
  `description`         varchar(2000)     DEFAULT NULL                COMMENT '描述',
  `create_time`         datetime          DEFAULT CURRENT_TIMESTAMP   COMMENT '创建时间',
  `create_user_id`      bigint(20)        DEFAULT NULL                COMMENT '创建人ID',
  `update_time`         datetime          DEFAULT NULL                COMMENT '修改时间',
  `update_user_id`      bigint(20)        DEFAULT NULL                COMMENT '修改人ID',
  `type`                int(11)           DEFAULT NULL                COMMENT '参数类型，1:约束参数 2:普通参数',
  `status`              bit(1)            DEFAULT b'1'                COMMENT '状态, 0:禁用 1:启用',
  `is_delete`           bit(1)            DEFAULT b'0'                COMMENT '是否删除， 0:否 1:是',
  PRIMARY KEY (`id`) 
)  COMMENT='算法参数配置表';

-- ----------------------------
-- Table structure for algorithm_parameter_value
-- ----------------------------
DROP TABLE IF EXISTS `algorithm_parameter_value`;
CREATE TABLE `algorithm_parameter_value` (
  `type`                int(20)           DEFAULT NULL,
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '主键ID',
  `algorithm_group_id`  bigint(20)        DEFAULT NULL,
  `algorithm_id`        bigint(20)        DEFAULT NULL                COMMENT '计算算法表ID',
  `algorithm_parameter_id` bigint(20)     DEFAULT NULL                COMMENT '参数配置表ID',
  `value`               varchar(268)      DEFAULT NULL                COMMENT '参数值',
  `priority_weight`     double(8,2)       DEFAULT NULL                COMMENT '权重',
  `is_delete`           bit(1)            DEFAULT b'0'                COMMENT '是否删除， 0:否 1:是',
  PRIMARY KEY (`id`) 
) COMMENT='计算算法与参数配置关联表';

-- ----------------------------
-- Table structure for attribute_type
-- ----------------------------
DROP TABLE IF EXISTS `attribute_type`;
CREATE TABLE `attribute_type` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '流水id',
  `client`              int(11)           DEFAULT '1'                 COMMENT '客户端',
  `code`                varchar(255)      DEFAULT NULL                COMMENT '大类编码',
  `name`                varchar(255)      DEFAULT NULL                COMMENT '大类名称',

  `create_time`         datetime          DEFAULT CURRENT_TIMESTAMP,
  `create_user_id`      bigint(20)        DEFAULT NULL                COMMENT '创建人id',
  `update_time`         datetime          DEFAULT NULL                COMMENT '修改时间',
  `update_user_id`      bigint(20)        DEFAULT NULL                COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ;

-- ----------------------------
-- Table structure for attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `attribute_value`;
CREATE TABLE `attribute_value` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '主键id',
  `client`              int(11)           DEFAULT '1'                 COMMENT '系统id 1 赢家',
  `parent_id`           bigint(20)        DEFAULT NULL                COMMENT '父id',
  `code`                varchar(30)       NOT NULL                    COMMENT '参数编码',
  `name`                varchar(30)       DEFAULT NULL                COMMENT '参数名称',
  `level`               int(11)           DEFAULT NULL,

  `create_time`         datetime          DEFAULT CURRENT_TIMESTAMP   COMMENT '创建时间',
  `update_time`         datetime          DEFAULT NULL                COMMENT '修改时间',
  `update_user_id`      bigint(20)        DEFAULT NULL                COMMENT '更新人id',
  `create_user_id`      bigint(20)        DEFAULT NULL                COMMENT '创建人id',
  `status`              varchar(20)       DEFAULT 'AVAILABLE'         COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) COMMENT='参数表';

-- ----------------------------
-- Table structure for average_production_time
-- ----------------------------
DROP TABLE IF EXISTS `average_production_time`;
CREATE TABLE `average_production_time` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '流水id',
  `client`              int(11)           DEFAULT '1'                 COMMENT '客户端',
  `band_id`             bigint(20)        DEFAULT NULL                COMMENT '产品季id',
  `product_category_id` bigint(20)        DEFAULT NULL                COMMENT '品类id',
  `average_production_time` double(4,2)   DEFAULT NULL                COMMENT '平均单件工时（小时）',

  `create_time`         datetime          DEFAULT CURRENT_TIMESTAMP   COMMENT '创建时间',
  `update_time`         datetime          DEFAULT NULL                COMMENT '修改时间',
  `create_user_id`      bigint(20)        DEFAULT NULL                COMMENT '创建人id',
  `update_user_id`      bigint(20)        DEFAULT NULL                COMMENT '更新人id',
  `status`              varchar(255)      DEFAULT NULL                COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) COMMENT='平均单件工时表';

-- ----------------------------
-- Table structure for band_planning
-- ----------------------------
DROP TABLE IF EXISTS `band_planning`;
CREATE TABLE `band_planning` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '流水id',
  `client`              int(11)           DEFAULT '1'                 COMMENT '客户端',
  `calendar_year`       int(11)           DEFAULT NULL                COMMENT '年份',
  `brand`               varchar(255)      DEFAULT NULL                COMMENT '品牌编码',
  `brand_name`          varchar(20)       DEFAULT NULL                COMMENT '品牌名称',
  `is_regular_price`    varchar(20)       DEFAULT NULL                COMMENT '正特价',
  `a_band`              int(11)           DEFAULT NULL                COMMENT 'A',
  `b_band`              int(11)           DEFAULT NULL                COMMENT 'B',
  `c_band`              int(11)           DEFAULT NULL                COMMENT 'C',
  `d_band`              int(11)           DEFAULT NULL                COMMENT 'D',
  `e_band`              int(11)           DEFAULT NULL                COMMENT 'E',
  `f_band`              int(11)           DEFAULT NULL                COMMENT 'F',
  `g_band`              int(11)           DEFAULT NULL                COMMENT 'G',
  `h_band`              int(11)           DEFAULT NULL                COMMENT 'H',
  `i_band`              int(11)           DEFAULT NULL                COMMENT 'I',
  `unit`                varchar(255)      DEFAULT NULL                COMMENT '单位',

  `create_time`         datetime          DEFAULT CURRENT_TIMESTAMP,
  `create_user_id`      varchar(20)       DEFAULT NULL                COMMENT '创建人id',
  `update_time`         datetime          DEFAULT NULL                COMMENT '修改时间',
  `update_user_id`      varchar(20)       DEFAULT NULL                COMMENT '更新人id',
  `status`              char(255)         DEFAULT NULL                COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ;

-- ----------------------------
-- Table structure for brand_plant_priority
-- ----------------------------
DROP TABLE IF EXISTS `brand_plant_priority`;
CREATE TABLE `brand_plant_priority` (
  `id`                  bigint(20)        NOT NULL AUTO_INCREMENT     COMMENT '主键id',
  `client`              int(11)           DEFAULT '1'                 COMMENT '系统id 1 赢家',
  `brand_id`            bigint(20)        NOT NULL                    COMMENT '品牌id',
  `plant_id`            bigint(20)        NOT NULL                    COMMENT '工厂id',
  `priority`            int(11)           DEFAULT '1'                 COMMENT '优先级',

  `create_time`         datetime          DEFAULT CURRENT_TIMESTAMP   COMMENT '创建时间',
  `update_time`         datetime          DEFAULT NULL                COMMENT '修改时间',
  `update_user_id`      bigint(20)        DEFAULT NULL                COMMENT '更新人id',
  `create_user_id`      bigint(20)        DEFAULT NULL                COMMENT '创建人id',
  `status`              varchar(20)       DEFAULT 'AVAILABLE'         COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) COMMENT='品牌擅长工厂表';

-- ----------------------------
-- Table structure for category_group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `category_group_capacity`;
CREATE TABLE `category_group_capacity` (
  `id`                 bigint(20) NOT NULL  AUTO_INCREMENT            COMMENT '流水id',
  `client`             int(11)              DEFAULT '1'               COMMENT '公司代码，默认1',
  `plant_id`           bigint(20)           NOT NULL                  COMMENT '品类组id',
  `calendar_year`      int(20)              DEFAULT NULL              COMMENT '年份',
  `calendar_month`     int(20)              DEFAULT NULL              COMMENT '月份',
  `capacity_by_quantity` double             DEFAULT NULL              COMMENT '件产能',

  `create_time`         datetime            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`         datetime            DEFAULT NULL              COMMENT '修改时间',
  `create_user_id`      bigint(20)          DEFAULT NULL              COMMENT '创建人id',
  `update_user_id`      bigint(20)          DEFAULT NULL              COMMENT '更新人id',
  `status`              varchar(20)         DEFAULT 'AVAILABLE'       COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
);

-- ----------------------------
-- Table structure for config_parameter
-- ----------------------------
DROP TABLE IF EXISTS `config_parameter`;
CREATE TABLE `config_parameter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,

  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`,`name`) 
);

-- ----------------------------
-- Table structure for cron_expression
-- ----------------------------
DROP TABLE IF EXISTS `cron_expression`;
CREATE TABLE `cron_expression` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron_expression_value` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cron_description` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `requirement_order` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `requirement_order_id` bigint(20) DEFAULT NULL COMMENT '需求订单主键',
  `code` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '客户编码',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `mail_address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '邮寄地址',
  `telephone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `type` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '客户类型',
  `region` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `consignee` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人 ',
  `province_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '省',
  `city_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '市',
  `district_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `zip_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码',
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=507 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户信息';

-- ----------------------------
-- Table structure for daily_sewing_quantity
-- ----------------------------
DROP TABLE IF EXISTS `daily_sewing_quantity`;
CREATE TABLE `daily_sewing_quantity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `quantity` double NOT NULL COMMENT '数量',
  `daily_sewing_start_time` datetime DEFAULT NULL COMMENT '日缝制开始时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `status` varchar(120) DEFAULT NULL COMMENT '商品状态-是否被ERP获取',
  `goods_sn` varchar(120) DEFAULT NULL COMMENT '商品代码',
  `goods_name` varchar(120) DEFAULT NULL COMMENT '名称',
  `old_goods_sn` varchar(120) DEFAULT NULL COMMENT '基准款商品代码',
  `brand_code` varchar(120) DEFAULT NULL COMMENT '品牌代码',
  `brand_name` varchar(120) DEFAULT NULL COMMENT '品牌名称',
  `cat_code` varchar(120) DEFAULT NULL COMMENT '分类代码',
  `cat_name` varchar(120) DEFAULT NULL COMMENT '分类名称',
  `series_code` varchar(120) DEFAULT NULL COMMENT '系列代码',
  `series_name` varchar(120) DEFAULT NULL COMMENT '系列名称',
  `year_code` varchar(120) DEFAULT NULL COMMENT '年度代码',
  `year_name` varchar(120) DEFAULT NULL COMMENT '年度名称',
  `season_code` varchar(120) DEFAULT NULL COMMENT '季节代码',
  `season_name` varchar(120) DEFAULT NULL COMMENT '季节名称',
  `dw_code` varchar(120) DEFAULT NULL COMMENT '单位代码',
  `dw_name` varchar(120) DEFAULT NULL COMMENT '单位名称',
  `goods_weight` double(11,3) DEFAULT NULL COMMENT '商品重量',
  `market_price` double(11,3) DEFAULT NULL COMMENT '市场价',
  `shop_price` double(11,3) DEFAULT NULL COMMENT '售价',
  `cbj` double(11,3) DEFAULT NULL COMMENT '成本价',
  `ckj` double(11,3) DEFAULT NULL COMMENT '参考价（调价单价格）',
  `ghs_code` varchar(120) DEFAULT NULL COMMENT '供货商代码',
  `ghs_name` varchar(120) DEFAULT NULL COMMENT '供货商名称',
  `goods_desc` varchar(300) DEFAULT NULL COMMENT '商品描述',
  `created` datetime DEFAULT NULL COMMENT '商品创建时间',
  `sku` varchar(120) DEFAULT NULL COMMENT '商品SKU',
  `color_code` varchar(120) DEFAULT NULL COMMENT '颜色代码',
  `color_name` varchar(120) DEFAULT NULL COMMENT '颜色名称',
  `size_code` varchar(120) DEFAULT NULL COMMENT '尺码代码',
  `size_name` varchar(120) DEFAULT NULL COMMENT '颜色名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for holiday_setting
-- ----------------------------
DROP TABLE IF EXISTS `holiday_setting`;
CREATE TABLE `holiday_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `monday` varchar(255) DEFAULT NULL COMMENT '星期一',
  `tuesday` varchar(255) DEFAULT NULL COMMENT '星期二',
  `wednesday` varchar(255) DEFAULT NULL COMMENT '星期三',
  `thursday` varchar(255) DEFAULT NULL COMMENT '星期四',
  `friday` varchar(255) DEFAULT NULL COMMENT '星期五',
  `saturday` varchar(255) DEFAULT NULL COMMENT '星期六',
  `sunday` varchar(255) DEFAULT NULL COMMENT '星期日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(255) DEFAULT '' COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for interface_log
-- ----------------------------
DROP TABLE IF EXISTS `interface_log`;
CREATE TABLE `interface_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `direction` varchar(255) DEFAULT NULL COMMENT '系统请求方向',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `exceptions` longtext COMMENT '异常记录',
  `flag` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `get_json_description` longtext,
  `get_json` longtext COMMENT '收到的json',
  `interface_flag` varchar(255) DEFAULT NULL COMMENT '接口标识',
  `method` varchar(255) DEFAULT NULL COMMENT '请求的方法',
  `set_json_description` longtext,
  `set_json` longtext COMMENT '发送的json',
  `start_time` datetime DEFAULT NULL COMMENT '请求开始时间',
  `status_code` varchar(255) DEFAULT NULL COMMENT '状态编码(200/500)',
  `target_system` varchar(255) DEFAULT NULL COMMENT '对方系统',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址URL',
  `way` varchar(255) DEFAULT NULL COMMENT '请求方式(同步/异步)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `is_send` bit(1) DEFAULT NULL COMMENT '是否已经发送',
  PRIMARY KEY (`id`) ,
  KEY `interfacelog_end_time` (`end_time`) ,
  KEY `interfacelog_interface_id` (`interface_flag`) 
) ENGINE=InnoDB AUTO_INCREMENT=209748 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job_list
-- ----------------------------
DROP TABLE IF EXISTS `job_list`;
CREATE TABLE `job_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job_log_info
-- ----------------------------
DROP TABLE IF EXISTS `job_log_info`;
CREATE TABLE `job_log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `log_info` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `modify_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lead_time_type
-- ----------------------------
DROP TABLE IF EXISTS `lead_time_type`;
CREATE TABLE `lead_time_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `production_schedue_type_id` bigint(20) DEFAULT NULL COMMENT '排产类型id',
  `code` varchar(50) NOT NULL COMMENT '类型编码',
  `name` varchar(50) NOT NULL COMMENT '类型名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='提前期类型表';

-- ----------------------------
-- Table structure for lead_time_value
-- ----------------------------
DROP TABLE IF EXISTS `lead_time_value`;
CREATE TABLE `lead_time_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `product_type_id` bigint(20) NOT NULL COMMENT '款号类型',
  `urgency_type_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '紧急度 黑 B 红 R 绿G',
  `repeat_order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '首/翻单',
  `is_front` bit(1) NOT NULL COMMENT '前/后置 0后置 1前置',
  `operation_id` bigint(20) NOT NULL COMMENT '工序id',
  `lead_time_type_id` bigint(20) NOT NULL COMMENT '提前期类型id',
  `value` double(20,0) NOT NULL COMMENT '提前期参数值',
  `timeuom` varchar(20) NOT NULL COMMENT '单位 H:小时 D 天 下拉选择',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='提前期参数值表';

-- ----------------------------
-- Table structure for learn_curve
-- ----------------------------
DROP TABLE IF EXISTS `learn_curve`;
CREATE TABLE `learn_curve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `first_day` double DEFAULT NULL COMMENT '第一天效率',
  `second_day` double DEFAULT NULL COMMENT '第二天效率',
  `third_day` double DEFAULT NULL COMMENT '第三天效率',
  `fourth_day` double DEFAULT NULL COMMENT '第四天效率',
  `fifth_day` double DEFAULT NULL COMMENT '第五天效率',
  `sixth_day` double DEFAULT NULL COMMENT '第六天效率',
  `seventh_day` double DEFAULT NULL COMMENT '第七天效率',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '产品类别id',
  `repeat_flag` varchar(255) DEFAULT NULL COMMENT '首、翻单',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logs_system
-- ----------------------------
DROP TABLE IF EXISTS `logs_system`;
CREATE TABLE `logs_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `msg_describe` varchar(255) DEFAULT NULL COMMENT '消息描述',
  `msg_type_code` varchar(255) DEFAULT NULL COMMENT '业务成功:01;业务错误:02;警告:03',
  `order_no` varchar(255) DEFAULT NULL COMMENT 'mtm订单号',
  `order_line_id` varchar(255) DEFAULT NULL COMMENT 'mtm行项目',
  `step_code` varchar(255) DEFAULT NULL COMMENT '所属流程节点编号例如APS05',
  `target_step_code` varchar(255) DEFAULT NULL COMMENT '目标流程节点编号,多个用英文’,’分开',
  `business_time` datetime DEFAULT NULL COMMENT '业务发生时间',
  `source_system_code` varchar(255) DEFAULT NULL COMMENT '消息来源系统',
  `reference_status` varchar(255) DEFAULT NULL COMMENT '系统参考状态码，有就传1605',
  `redo_flag` varchar(255) DEFAULT NULL COMMENT '是否重复(返工)标志:0，否；1，是',
  `is_send` bit(1) DEFAULT NULL COMMENT '是否已经发送',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mtm_order
-- ----------------------------
DROP TABLE IF EXISTS `mtm_order`;
CREATE TABLE `mtm_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `customer_order` varchar(255) DEFAULT NULL COMMENT '订单状态编码',
  `customer_order_item` varchar(255) DEFAULT NULL COMMENT '订单状态名称',
  `product` varchar(255) DEFAULT NULL,
  `mtm_create_time` datetime DEFAULT NULL,
  `mtm_send_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1166 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1' COMMENT '系统id:1赢家',
  `code` varchar(50) DEFAULT NULL COMMENT '工序编码',
  `name` varchar(50) DEFAULT NULL COMMENT '工序描叙',
  `type` varchar(50) DEFAULT NULL COMMENT '工序类型：01裁剪，02缝制，03外协',
  `status` varchar(255) DEFAULT NULL COMMENT '工序状态 AVAILABLE：可用  DELETED：删除 FREEZED：冻结',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` varchar(200) DEFAULT NULL COMMENT '创建人',
  `update_user_id` varchar(200) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='工序表';

-- ----------------------------
-- Table structure for operation_plant_relevancy
-- ----------------------------
DROP TABLE IF EXISTS `operation_plant_relevancy`;
CREATE TABLE `operation_plant_relevancy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `client` int(11) DEFAULT '1' COMMENT '系统id\r\n1:赢家',
  `operation_id` bigint(20) DEFAULT NULL COMMENT '工序id',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `status` varchar(20) NOT NULL COMMENT '状态 AVAILABLE：可用，DELETED：删除 ，FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='工序工厂关联表';

-- ----------------------------
-- Table structure for operation_price_period
-- ----------------------------
DROP TABLE IF EXISTS `operation_price_period`;
CREATE TABLE `operation_price_period` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `client` int(11) DEFAULT '1' COMMENT '系统id\r\n1:赢家',
  `operation_plan_relevancy_id` int(11) NOT NULL COMMENT '工序工厂关联表id ',
  `start_price` double DEFAULT NULL COMMENT '开始价格范围',
  `end_price` double DEFAULT NULL COMMENT '结束价格范围',
  `operation_time` int(11) DEFAULT NULL COMMENT '工时',
  `timeuom` varchar(20) DEFAULT NULL COMMENT '单位id H小时 D天',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `status` varchar(20) NOT NULL COMMENT '状态 AVAILABLE：可用，DELETED：删除 ，FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='工序价格周期表';

-- ----------------------------
-- Table structure for order_attribute
-- ----------------------------
DROP TABLE IF EXISTS `order_attribute`;
CREATE TABLE `order_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `attribute_value_id` bigint(20) DEFAULT NULL COMMENT '大类id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=10002801 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_operation
-- ----------------------------
DROP TABLE IF EXISTS `order_operation`;
CREATE TABLE `order_operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `operation_id` varchar(255) DEFAULT NULL COMMENT '工序编号',
  `operation_id_description` varchar(255) DEFAULT NULL COMMENT '工序编码描述',
  `operation_item` varchar(255) DEFAULT NULL COMMENT '工序号',
  `standard_time` double(11,3) DEFAULT NULL COMMENT '标准时间',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `price` varchar(255) DEFAULT NULL COMMENT '价格',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=4255 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_planning
-- ----------------------------
DROP TABLE IF EXISTS `order_planning`;
CREATE TABLE `order_planning` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `calendar_year` int(11) DEFAULT NULL COMMENT '年份',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌编码',
  `brand_name` varchar(20) DEFAULT NULL COMMENT '品牌名称',
  `is_regular_price` varchar(20) DEFAULT NULL COMMENT '正特价',
  `january` int(11) DEFAULT NULL COMMENT '1月',
  `february` int(11) DEFAULT NULL COMMENT '2月',
  `march` int(11) DEFAULT NULL COMMENT '3月',
  `april` int(11) DEFAULT NULL COMMENT '4月',
  `may` int(11) DEFAULT NULL COMMENT '5月',
  `june` int(11) DEFAULT NULL COMMENT '6月',
  `july` int(11) DEFAULT NULL COMMENT '7月',
  `august` int(11) DEFAULT NULL COMMENT '8月',
  `september` int(11) DEFAULT NULL COMMENT '9月',
  `october` int(11) DEFAULT NULL COMMENT '10月',
  `november` int(11) DEFAULT NULL COMMENT '11月',
  `december` int(11) DEFAULT NULL COMMENT '12月',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` varchar(20) DEFAULT NULL COMMENT '更新人id',
  `status` char(255) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_schedule_attribute
-- ----------------------------
DROP TABLE IF EXISTS `order_schedule_attribute`;
CREATE TABLE `order_schedule_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `parent_attribute_id` bigint(20) DEFAULT NULL COMMENT '中类id',
  `attribute_type_id` bigint(20) DEFAULT NULL COMMENT '大类id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=474563 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_status
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `code` varchar(255) DEFAULT NULL COMMENT '订单状态编码',
  `name` varchar(255) DEFAULT NULL COMMENT '订单状态名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_status_log
-- ----------------------------
DROP TABLE IF EXISTS `order_status_log`;
CREATE TABLE `order_status_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `order_status` varchar(255) DEFAULT NULL COMMENT '订单状态(mtm)',
  `is_send` bit(1) DEFAULT NULL COMMENT '是否已经发送',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_status_report
-- ----------------------------
DROP TABLE IF EXISTS `order_status_report`;
CREATE TABLE `order_status_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(20) DEFAULT NULL COMMENT '客户端',
  `plant_code` varchar(255) DEFAULT NULL COMMENT '工厂code',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单',
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `repeat_order` varchar(255) DEFAULT NULL COMMENT '首/翻单',
  `series` varchar(255) DEFAULT NULL COMMENT '系列',
  `product_type` varchar(255) DEFAULT NULL COMMENT '款号类型',
  `order_type` varchar(255) DEFAULT NULL COMMENT '订单类型',
  `urgency_type` varchar(255) DEFAULT NULL COMMENT '紧急度',
  `standard_time` double DEFAULT NULL COMMENT '标准工时',
  `material_readiness_flag` varchar(255) DEFAULT NULL COMMENT '齐料标记',
  `material_is_ready` varchar(255) DEFAULT NULL COMMENT '主辅料到齐信息',
  `operation_code` varchar(255) DEFAULT NULL COMMENT '外协类型',
  `total_operation_time` datetime DEFAULT NULL COMMENT '外协周期',
  `fcut_flag` varchar(255) DEFAULT NULL COMMENT '尽裁标识',
  `sc_flag` varchar(255) DEFAULT NULL COMMENT '拆合标识',
  `workcenter_code` varchar(255) DEFAULT NULL COMMENT '工作中心',
  `received_time` datetime DEFAULT NULL COMMENT '接单时间',
  `issued_time` datetime DEFAULT NULL COMMENT '下发时间',
  `quantity` int(20) DEFAULT NULL COMMENT '订单数',
  `actual_cutting_quantity` int(20) DEFAULT NULL COMMENT '实裁数',
  `schedule_status` varchar(255) DEFAULT NULL COMMENT '排产状态',
  `plan_show_start_time` datetime DEFAULT NULL COMMENT '计划上线时间',
  `plan_show_end_time` datetime DEFAULT NULL COMMENT '计划下线时间',
  `premature` varchar(255) DEFAULT NULL COMMENT '计划提前交货',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际上线时间',
  `actual_end_time` datetime DEFAULT NULL COMMENT '实际下线时间',
  `quantity_finish` int(20) DEFAULT NULL COMMENT '累计下线数',
  `total_storage` int(20) DEFAULT NULL COMMENT '累计入库数',
  `product_backlog` int(20) DEFAULT NULL COMMENT '车间成品积压',
  `total_product_backlog` int(20) DEFAULT NULL COMMENT '累计昨天积压',
  `not_sewn_quantity` int(20) DEFAULT NULL COMMENT '未车缝数',
  `expected_storage` int(20) DEFAULT NULL COMMENT '预计月底入库数',
  `latest_end_time` datetime DEFAULT NULL COMMENT '要求下线时间',
  `storage_time` datetime DEFAULT NULL COMMENT '要求入库时间',
  `require_delivery_time` datetime DEFAULT NULL COMMENT '计划上市时间',
  `production_order` varchar(255) DEFAULT NULL COMMENT '生产订单号',
  `customer_order` varchar(255) DEFAULT NULL COMMENT 'MTM销售订单号',
  `customer_order_item` varchar(255) DEFAULT NULL COMMENT 'MTM行项目',
  `accessary_material` varchar(255) DEFAULT NULL COMMENT '缝纫线料号',
  `material_process_complexity` varchar(255) DEFAULT NULL COMMENT '面料难度等级',
  `product_complexity` varchar(255) DEFAULT NULL COMMENT '款式复杂度',
  `garment_structure` varchar(255) DEFAULT NULL COMMENT '脚口结构',
  `fabric_elastic_level` varchar(255) DEFAULT NULL COMMENT '径向弹力级别',
  `fabric_weight` varchar(255) DEFAULT NULL COMMENT '面料克重',
  `fabric_category` varchar(255) DEFAULT NULL COMMENT '面料风格',
  `collar_process` varchar(255) DEFAULT NULL COMMENT '领型结构',
  `material_process` varchar(255) DEFAULT NULL COMMENT '里布结构',
  `detachment_process` varchar(255) DEFAULT NULL COMMENT '脱卸方式',
  `waist_process` varchar(255) DEFAULT NULL COMMENT '腰节结构',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for outsource_config
-- ----------------------------
DROP TABLE IF EXISTS `outsource_config`;
CREATE TABLE `outsource_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `min_quantity` int(11) DEFAULT NULL COMMENT '最下数量',
  `max_quantity` int(11) DEFAULT NULL COMMENT '最大数量',
  `material_process_complexity` varchar(255) DEFAULT NULL COMMENT '面料等级',
  `outsource_flag` varchar(255) DEFAULT NULL COMMENT '有无工序',
  `min_day_quantity` int(11) DEFAULT NULL COMMENT '最小天数',
  `max_day_quantity` int(11) DEFAULT NULL COMMENT '最大天数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for outsource_order
-- ----------------------------
DROP TABLE IF EXISTS `outsource_order`;
CREATE TABLE `outsource_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `production_order` varchar(255) DEFAULT NULL COMMENT '生产订单号',
  `send_time` datetime DEFAULT NULL COMMENT '外发外协发出时间',
  `back_time` datetime DEFAULT NULL COMMENT '外发外协回货时间',
  `plan_start_time` date DEFAULT NULL COMMENT '计划发出时间',
  `plan_end_time` date DEFAULT NULL COMMENT '计划结束时间',
  `operation_code` varchar(255) DEFAULT NULL COMMENT '工序编码',
  `delete_flag` varchar(255) DEFAULT NULL COMMENT '删除标志',
  `po_request` varchar(255) DEFAULT NULL COMMENT '采购申请',
  `po_request_line` varchar(255) DEFAULT NULL COMMENT '采购申请行项目',
  `price` varchar(255) DEFAULT NULL COMMENT '价格',
  `currency_code` varchar(255) DEFAULT NULL COMMENT '货币代码',
  `quantity` double(255,0) DEFAULT NULL COMMENT '数量',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `plant_code` varchar(255) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商id',
  `supplier_code` varchar(255) DEFAULT NULL,
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `workcenter_code` varchar(255) DEFAULT NULL,
  `outsource_flag` varchar(255) DEFAULT NULL COMMENT '外协标志',
  `outsource_type` varchar(255) DEFAULT NULL COMMENT '外发外协类型',
  `operation_time` double DEFAULT NULL COMMENT '工序周期',
  `comments` varchar(255) DEFAULT NULL COMMENT '文本',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for parent_attribute
-- ----------------------------
DROP TABLE IF EXISTS `parent_attribute`;
CREATE TABLE `parent_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `code` varchar(255) DEFAULT NULL COMMENT '中类编码',
  `name` varchar(255) DEFAULT NULL COMMENT '中类名称',
  `attribute_type_id` bigint(20) DEFAULT NULL COMMENT '大类id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=57004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plant
-- ----------------------------
DROP TABLE IF EXISTS `plant`;
CREATE TABLE `plant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `code` varchar(50) DEFAULT NULL COMMENT '工厂编码',
  `name` varchar(50) DEFAULT NULL COMMENT '工厂编码',
  `integration` varchar(10) DEFAULT NULL COMMENT '接口控制（0:关闭 1 打开）关闭不会发送数据',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='工厂表';

-- ----------------------------
-- Table structure for plant_calendar
-- ----------------------------
DROP TABLE IF EXISTS `plant_calendar`;
CREATE TABLE `plant_calendar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '公司代码，默认为1',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `calendar_day` date DEFAULT NULL COMMENT '日期：2018-01-04',
  `day_of_week` varchar(255) DEFAULT NULL COMMENT '星期几',
  `holiday_setting` varchar(255) DEFAULT NULL COMMENT '假期设置',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) DEFAULT 'AVAILABLE' COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=4381 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `plant_capacity`;
CREATE TABLE `plant_capacity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '公司代码，默认为1',
  `plant_id` bigint(20) NOT NULL COMMENT '工厂id',
  `product_category_group_id` bigint(20) NOT NULL COMMENT '品类组id',
  `calendar_year` int(20) DEFAULT NULL COMMENT '年份',
  `calendar_month` int(20) DEFAULT NULL COMMENT '月份',
  `capacity_by_quantity` double DEFAULT NULL COMMENT '件产能',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) DEFAULT 'AVAILABLE' COMMENT '状态值： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_category_group
-- ----------------------------
DROP TABLE IF EXISTS `product_category_group`;
CREATE TABLE `product_category_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `code` varchar(20) NOT NULL COMMENT '编码',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8 COMMENT='品类组表';

-- ----------------------------
-- Table structure for product_category_group_efficiency
-- ----------------------------
DROP TABLE IF EXISTS `product_category_group_efficiency`;
CREATE TABLE `product_category_group_efficiency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plant_id` bigint(11) DEFAULT NULL COMMENT '工厂id',
  `product_category_group_id` bigint(20) DEFAULT NULL COMMENT '品类组id',
  `calendar_year` int(11) DEFAULT NULL COMMENT '年',
  `calendar_month` int(11) DEFAULT NULL COMMENT '月',
  `average_efficiency` double DEFAULT NULL COMMENT '平均效率',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_category_group_relation
-- ----------------------------
DROP TABLE IF EXISTS `product_category_group_relation`;
CREATE TABLE `product_category_group_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `product_category_id` bigint(20) NOT NULL COMMENT '品类id',
  `product_category_group_id` bigint(20) NOT NULL COMMENT '品类组编码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='品类关联表';

-- ----------------------------
-- Table structure for product_category_preference
-- ----------------------------
DROP TABLE IF EXISTS `product_category_preference`;
CREATE TABLE `product_category_preference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `workcenter_id` bigint(20) NOT NULL COMMENT '工作中心id',
  `preference_sequence` int(11) NOT NULL COMMENT '优先级',
  `product_category_id` bigint(20) NOT NULL COMMENT '品类id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='工作中心擅长品类表';

-- ----------------------------
-- Table structure for product_category_relation
-- ----------------------------
DROP TABLE IF EXISTS `product_category_relation`;
CREATE TABLE `product_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `product_category_id` bigint(20) NOT NULL COMMENT '品类id',
  `product_category_group_id` bigint(20) NOT NULL COMMENT '品类组id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='品类关联表';

-- ----------------------------
-- Table structure for product_complexity
-- ----------------------------
DROP TABLE IF EXISTS `product_complexity`;
CREATE TABLE `product_complexity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `min_process_time` varchar(255) DEFAULT NULL,
  `max_process_time` varchar(255) DEFAULT NULL,
  `attribute_type_id` bigint(20) DEFAULT NULL COMMENT '大类id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_preference
-- ----------------------------
DROP TABLE IF EXISTS `product_preference`;
CREATE TABLE `product_preference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `plant_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=2229 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_type_brand_plant
-- ----------------------------
DROP TABLE IF EXISTS `product_type_brand_plant`;
CREATE TABLE `product_type_brand_plant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `product_type` varchar(255) DEFAULT NULL COMMENT '采购申请',
  `brand` varchar(255) DEFAULT NULL COMMENT '采购申请行项目',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '排产状态id',
  `plant_code` varchar(255) DEFAULT NULL COMMENT '采购申请类型',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for production_details
-- ----------------------------
DROP TABLE IF EXISTS `production_details`;
CREATE TABLE `production_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `production_order` varchar(255) DEFAULT NULL COMMENT '生产订单号',
  `check_point` varchar(255) DEFAULT NULL COMMENT '检查点',
  `production_order_item` varchar(20) DEFAULT NULL COMMENT '生产订单行项目',
  `production_time` datetime DEFAULT NULL COMMENT '生产时间',
  `operation_item` varchar(255) DEFAULT NULL COMMENT '工序类型(裁剪/缝制)',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `quantity` double DEFAULT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1480 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for production_order_measure_data
-- ----------------------------
DROP TABLE IF EXISTS `production_order_measure_data`;
CREATE TABLE `production_order_measure_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `requirement_order` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `requirement_order_id` bigint(20) DEFAULT NULL COMMENT '需求订单主键',
  `measure_body` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '量体部位',
  `measure_data` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '量体数据',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `measure_body_no` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=10997 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='生产订单量体数据';

-- ----------------------------
-- Table structure for production_order_measure_data_url
-- ----------------------------
DROP TABLE IF EXISTS `production_order_measure_data_url`;
CREATE TABLE `production_order_measure_data_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `requirement_order_id` bigint(20) NOT NULL COMMENT '需求订单主键',
  `measure_data_url` varchar(200) NOT NULL COMMENT '量体数据图片',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for purchase_requisition
-- ----------------------------
DROP TABLE IF EXISTS `purchase_requisition`;
CREATE TABLE `purchase_requisition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `main_purchase_requisition` varchar(255) DEFAULT NULL COMMENT '采购申请',
  `schedule_status_id` bigint(20) DEFAULT NULL COMMENT '排产状态id',
  `purchase_requisition_type` varchar(255) DEFAULT NULL COMMENT '采购申请类型',
  `purchase_requisition_plant` varchar(255) DEFAULT NULL COMMENT '采购申请工厂',
  `urgency_type` varchar(255) DEFAULT NULL COMMENT '紧急类型',
  `repeat_order` varchar(255) DEFAULT NULL COMMENT '首/翻单',
  `delete_flag` varchar(255) DEFAULT NULL COMMENT '删除标识',
  `product_category` varchar(255) DEFAULT NULL COMMENT '品类',
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `product_description` varchar(255) DEFAULT NULL COMMENT '款号描述',
  `product_type` varchar(255) DEFAULT NULL COMMENT '款号类型',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `quantity` double DEFAULT NULL COMMENT '数量',
  `calender_year` varchar(255) DEFAULT NULL COMMENT '年份',
  `band` varchar(255) DEFAULT NULL COMMENT '波段',
  `series` varchar(255) DEFAULT NULL COMMENT '系列',
  `material_delivery_time` datetime DEFAULT NULL COMMENT '材料交期',
  `material_process_complexity` varchar(255) DEFAULT NULL COMMENT '面料等级',
  `outsource_flag` varchar(255) DEFAULT NULL COMMENT '外发标识',
  `operation_outsource_flag` varchar(255) DEFAULT NULL COMMENT '外协标识',
  `requirement_delivery_time` datetime DEFAULT NULL COMMENT '需求交期',
  `listing_time` datetime DEFAULT NULL COMMENT '上市日期',
  `sales_order` varchar(255) DEFAULT NULL COMMENT '销售订单',
  `sales_order_item` varchar(255) DEFAULT NULL COMMENT '销售订单行项目',
  `sales_plant` varchar(255) DEFAULT NULL COMMENT '工厂',
  `comments` varchar(255) DEFAULT NULL COMMENT '文本',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中排产采购订单';

-- ----------------------------
-- Table structure for purchase_requisition_detail
-- ----------------------------
DROP TABLE IF EXISTS `purchase_requisition_detail`;
CREATE TABLE `purchase_requisition_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `main_purchase_requisition` varchar(255) DEFAULT NULL,
  `purchase_requisition` varchar(255) DEFAULT NULL COMMENT '采购申请',
  `purchase_requisition_item` varchar(255) DEFAULT NULL COMMENT '采购申请行项目',
  `sto_order` varchar(255) DEFAULT NULL COMMENT 'sto单号',
  `quantity` double DEFAULT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中排产订单明细表';

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) ,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) ,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) ,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) ,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) ,
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) ,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for requirement_order
-- ----------------------------
DROP TABLE IF EXISTS `requirement_order`;
CREATE TABLE `requirement_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `source` varchar(255) DEFAULT NULL COMMENT '订单来源',
  `bom_order_id` bigint(20) DEFAULT NULL,
  `schedule_status_id` bigint(20) DEFAULT NULL COMMENT '订单状态id',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `comments` varchar(255) DEFAULT NULL COMMENT '文本',
  `delete_flag` varchar(255) DEFAULT NULL COMMENT '删除标志',
  `fcut_flag` varchar(255) DEFAULT NULL COMMENT '尽裁标识',
  `material_readiness_flag` varchar(255) DEFAULT NULL COMMENT '齐套标志',
  `material_type_id` bigint(20) DEFAULT NULL,
  `order_type` varchar(255) DEFAULT NULL COMMENT '订单类型',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `plant_code` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `product_category_id` bigint(20) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL COMMENT '款号描述',
  `quantity` double DEFAULT NULL COMMENT '数量',
  `repeat_order` varchar(255) DEFAULT NULL COMMENT '首/翻单',
  `required_delivery_date` datetime DEFAULT NULL COMMENT '交期',
  `sales_order` varchar(255) DEFAULT NULL COMMENT '销售订单',
  `sales_order_line` varchar(255) DEFAULT NULL COMMENT '销售订单行项目',
  `sales_plant` varchar(255) DEFAULT NULL COMMENT '销售工厂',
  `so_required_delivery_date` datetime DEFAULT NULL COMMENT '销售订单需求交期',
  `standard_time` double(11,3) DEFAULT NULL COMMENT '标志工时',
  `unit_price` double DEFAULT NULL COMMENT '单件价格',
  `urgency_type` varchar(255) DEFAULT NULL COMMENT '紧急类型',
  `sc_flag` varchar(255) DEFAULT NULL COMMENT '拆合单标志',
  `sc_requirement_order` varchar(255) DEFAULT NULL COMMENT '拆合单号',
  `accessary_material` varchar(255) DEFAULT NULL,
  `product_type` varchar(64) DEFAULT NULL COMMENT '款号类型',
  `customer_order` varchar(255) DEFAULT NULL COMMENT 'mtm订单号',
  `customer_order_item` varchar(255) DEFAULT NULL COMMENT 'mtm订单行项目',
  `outsource_flag` varchar(255) DEFAULT NULL COMMENT '外发外协标志',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `remark` varchar(4000) DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`id`) ,
  KEY `FK_boopn3dd9bd86kwonsugemwil` (`plant_id`) ,
  KEY `FK_qbski5itib5yul1s8fox2pjce` (`product_category_id`) ,
  KEY `FK_90p4xwoef12xo4wbym9khmxgw` (`schedule_status_id`) ,
  KEY `UK_mqu26os0p0wxs8u7ur6dtu3q5` (`requirement_order`) 
) ENGINE=InnoDB AUTO_INCREMENT=448 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for requirement_order_grid
-- ----------------------------
DROP TABLE IF EXISTS `requirement_order_grid`;
CREATE TABLE `requirement_order_grid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(255) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `product_sku` varchar(255) DEFAULT NULL,
  `grid` varchar(255) DEFAULT NULL COMMENT '尺码',
  `grid_description` varchar(255) DEFAULT NULL COMMENT '尺码描述',
  `plant_id` varchar(255) DEFAULT NULL COMMENT '工厂id',
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `quantity` double NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=17330 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_brand_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_brand_relation`;
CREATE TABLE `role_brand_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `brand_id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=2085 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_plant_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_plant_relation`;
CREATE TABLE `role_plant_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `plant_id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rushorder_log
-- ----------------------------
DROP TABLE IF EXISTS `rushorder_log`;
CREATE TABLE `rushorder_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `plan_show_start_time` datetime DEFAULT NULL COMMENT '计划开始时间',
  `plan_show_end_time` datetime DEFAULT NULL COMMENT '计划结束时间',
  `order_access_time` datetime DEFAULT NULL COMMENT '订单接单时间',
  `premature` varchar(255) DEFAULT NULL COMMENT '提前交换期',
  `required_delivery_date` datetime DEFAULT NULL COMMENT '交期',
  `schedule_line` int(11) DEFAULT NULL COMMENT '排产方式(01裁剪/02缝制)',
  `schedule_line_name` varchar(255) DEFAULT NULL COMMENT '排产名称(01裁剪/02缝制)',
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `workcenter_name` varchar(255) DEFAULT NULL COMMENT '工作中心名称',
  `is_send` bit(1) DEFAULT NULL COMMENT '是否已经发送',
  `schedule_id` bigint(20) DEFAULT NULL COMMENT '排产id',
  `type` varchar(255) DEFAULT NULL COMMENT '日志类型(新/旧)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sales_order
-- ----------------------------
DROP TABLE IF EXISTS `sales_order`;
CREATE TABLE `sales_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `sale_order_no` varchar(50) DEFAULT NULL COMMENT '前端销售系统的销售订单号',
  `sd_code` varchar(50) DEFAULT NULL COMMENT '店铺代码提供固定值',
  `status` varchar(10) DEFAULT NULL,
  `pay_status` varchar(50) DEFAULT NULL COMMENT '付款状态（0，未付款；1，付款中；2，已付款；3，已结算）',
  `pos_code` varchar(50) DEFAULT NULL COMMENT 'O2O门店代码',
  `sale_shop_code` varchar(50) DEFAULT NULL COMMENT '下单门店代码',
  `saler_employee_no` varchar(50) DEFAULT '' COMMENT '下单店员编号',
  `pay_code` varchar(50) DEFAULT NULL COMMENT '支付方式代码',
  `shipping_code` varchar(50) DEFAULT NULL COMMENT '快递公司代码',
  `shipping_fee` varchar(50) DEFAULT NULL COMMENT '运费',
  `order_amount` varchar(50) DEFAULT NULL COMMENT '买家应付金额',
  `payment` varchar(50) DEFAULT NULL COMMENT '买家已付金额',
  `required_delivery_date` varchar(50) DEFAULT NULL COMMENT '工厂编码',
  `order_type` varchar(50) DEFAULT NULL COMMENT '订单类型CUSTOM定制订单(默认)',
  `urgency_type` varchar(20) DEFAULT NULL COMMENT '优先级HIGN高 (默认)MIDDLE 中LOW低',
  `product_category` varchar(50) DEFAULT NULL COMMENT '品类',
  `product_no` varchar(20) DEFAULT NULL COMMENT '商品基准款款号',
  `product_spu` varchar(50) DEFAULT NULL COMMENT '商品spu',
  `product_description` varchar(20) DEFAULT NULL COMMENT '款号描述商品基准款',
  `color` varchar(50) DEFAULT NULL COMMENT '款颜色',
  `price` varchar(20) DEFAULT NULL COMMENT '商品单价',
  `quantity` varchar(50) DEFAULT NULL COMMENT '计划订单数量',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8 COMMENT='工厂表';

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '客户端，默认为1',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `schedule_line` int(11) DEFAULT NULL COMMENT '排产方式(01裁剪/02缝制)',
  `production_order` varchar(255) DEFAULT NULL COMMENT '生产订单号',
  `schedule_status_id` bigint(20) DEFAULT NULL COMMENT '订单状态id',
  `plan_start_time` datetime DEFAULT NULL COMMENT 'plan(除去休息时间)开始时间',
  `plan_end_time` datetime DEFAULT NULL COMMENT 'plan(除去休息时间)结束时间',
  `plan_show_start_time` datetime DEFAULT NULL COMMENT 'show(包含休息时间)开始时间',
  `plan_show_end_time` datetime DEFAULT NULL COMMENT 'show(包含休息时间)结束时间',
  `rest_plan_start_time` datetime DEFAULT NULL COMMENT 'plan（休息）开始时间',
  `rest_plan_end_time` datetime DEFAULT NULL COMMENT 'plan（休息）结束时间',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际报工开始时间',
  `actual_finish_time` datetime DEFAULT NULL COMMENT '实际报工结束时间',
  `daily_sewing_start_time` datetime DEFAULT NULL COMMENT '日缝制时间',
  `earliest_start_time` datetime DEFAULT NULL COMMENT '最早开始时间',
  `latest_end_time` datetime DEFAULT NULL COMMENT '最晚结束时间',
  `required_delivery_date` datetime DEFAULT NULL COMMENT '交期',
  `standard_time` double DEFAULT NULL COMMENT '标准工时',
  `premature` bigint(20) DEFAULT NULL COMMENT '提前交货期',
  `quantity` double NOT NULL COMMENT '数量',
  `quantity_finish` double DEFAULT NULL COMMENT '完成数量',
  `schedule_version` varchar(255) DEFAULT NULL COMMENT '排产版本',
  `plant_id` bigint(20) DEFAULT NULL,
  `plant_code` varchar(255) DEFAULT NULL,
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `workcenter_code` varchar(255) DEFAULT NULL,
  `issued_time` datetime DEFAULT NULL COMMENT '下发时间',
  `bom_order_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) ,
  KEY `FK_33srm3gasdej5gxd3dmhyj3pd` (`workcenter_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=3995 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for schedule_score
-- ----------------------------
DROP TABLE IF EXISTS `schedule_score`;
CREATE TABLE `schedule_score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `schedule_score` varchar(255) DEFAULT NULL COMMENT '排产打分',
  `version` varchar(255) DEFAULT NULL COMMENT '版本',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `score` varchar(255) DEFAULT NULL COMMENT '分数比例',
  `plant_id` bigint(255) DEFAULT NULL COMMENT '工厂id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=3031 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scheduling_to_plant
-- ----------------------------
DROP TABLE IF EXISTS `scheduling_to_plant`;
CREATE TABLE `scheduling_to_plant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `purchase_requisition` varchar(255) DEFAULT NULL COMMENT '采购申请',
  `purchase_requisition_item` varchar(255) DEFAULT NULL COMMENT '采购申请行项目',
  `schedule_status_id` bigint(20) DEFAULT NULL COMMENT '排产状态id',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `plant_code` varchar(255) DEFAULT NULL COMMENT '工厂编码',
  `product_category_group_id` bigint(20) DEFAULT NULL COMMENT '品类组id',
  `product_category_group_code` varchar(255) DEFAULT NULL COMMENT '品类组编码',
  `plan_start_time` datetime DEFAULT NULL COMMENT '计划上线时间',
  `plan_end_time` datetime DEFAULT NULL COMMENT '计划下线时间',
  `latest_end_time` datetime DEFAULT NULL COMMENT '最迟下线',
  `earliest_start_time` datetime DEFAULT NULL COMMENT '最早上线',
  `sto_order` varchar(255) DEFAULT NULL COMMENT 'STO单号',
  `outsource_flag` varchar(255) DEFAULT NULL COMMENT '外发标识',
  `issused_time` datetime DEFAULT NULL COMMENT '下发时间',
  `comments` varchar(255) DEFAULT NULL COMMENT '文本',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for season_band_relation
-- ----------------------------
DROP TABLE IF EXISTS `season_band_relation`;
CREATE TABLE `season_band_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `season_id` bigint(20) DEFAULT NULL COMMENT '产品季id',
  `band_id` bigint(20) NOT NULL COMMENT '波段id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='产品季季节关联表';

-- ----------------------------
-- Table structure for sewing_scheduling_report
-- ----------------------------
DROP TABLE IF EXISTS `sewing_scheduling_report`;
CREATE TABLE `sewing_scheduling_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(20) DEFAULT '1' COMMENT '客户端',
  `workcenter_code` varchar(255) DEFAULT NULL COMMENT '工作中心code',
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单',
  `production_order` varchar(255) DEFAULT NULL COMMENT '生产订单号',
  `schedule_status` varchar(255) DEFAULT NULL COMMENT '排产状态',
  `repeat_order` varchar(255) DEFAULT NULL COMMENT '首/翻单',
  `urgency_type` varchar(255) DEFAULT NULL COMMENT '紧急度',
  `standard_time` double DEFAULT NULL COMMENT 'GST缝制工时',
  `material_is_ready` varchar(255) DEFAULT NULL COMMENT '主辅料到齐信息',
  `quantity` int(20) DEFAULT NULL COMMENT '订单数',
  `actual_cutting_quantity` int(20) DEFAULT NULL COMMENT '实裁数',
  `series` varchar(255) DEFAULT NULL COMMENT '系列',
  `received_time` datetime DEFAULT NULL COMMENT '接单时间',
  `issued_time` datetime DEFAULT NULL COMMENT '下发时间',
  `plan_show_start_time` datetime DEFAULT NULL COMMENT '计划上线时间',
  `plan_show_end_time` datetime DEFAULT NULL COMMENT '计划下线时间',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际上线时间',
  `actual_end_time` datetime DEFAULT NULL COMMENT '实际下线时间',
  `quantity_finish` int(20) DEFAULT NULL COMMENT '累计下线数',
  `total_storage` int(20) DEFAULT NULL COMMENT '累计入库数',
  `product_backlog` int(20) DEFAULT NULL COMMENT '车间成品积压',
  `total_product_backlog` int(20) DEFAULT NULL COMMENT '累计昨天积压',
  `not_sewn_quantity` int(20) DEFAULT NULL COMMENT '未车缝数',
  `expected_storage` int(20) DEFAULT NULL COMMENT '预计月底入库数',
  `latest_end_time` datetime DEFAULT NULL COMMENT '要求下线时间',
  `storage_time` datetime DEFAULT NULL COMMENT '要求入库时间',
  `require_delivery_time` datetime DEFAULT NULL COMMENT '计划上市时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) DEFAULT 'AVAILABLE' COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shift
-- ----------------------------
DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `shift` varchar(255) DEFAULT NULL COMMENT '班组',
  `time_slot` int(11) DEFAULT NULL COMMENT '时间段',
  `start_time` time DEFAULT NULL COMMENT '开始时间：08:00',
  `end_time` time DEFAULT NULL COMMENT '结束时间：12:00',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(255) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for single_working_hours
-- ----------------------------
DROP TABLE IF EXISTS `single_working_hours`;
CREATE TABLE `single_working_hours` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `calendar_year` int(11) NOT NULL COMMENT '年度',
  `calendar_month` int(11) NOT NULL COMMENT '月份',
  `product_category_id` bigint(20) NOT NULL COMMENT '品类id',
  `value` double(4,2) NOT NULL COMMENT '单件工时',
  `timeuom` varchar(20) NOT NULL COMMENT '单位 H:小时 D 天 下拉选择',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='单件工时表';

-- ----------------------------
-- Table structure for status_map
-- ----------------------------
DROP TABLE IF EXISTS `status_map`;
CREATE TABLE `status_map` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `system` varchar(255) DEFAULT NULL,
  `node` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '大类编码',
  `status_description` varchar(255) DEFAULT NULL COMMENT '大类名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sub_attribute
-- ----------------------------
DROP TABLE IF EXISTS `sub_attribute`;
CREATE TABLE `sub_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `attribute_type_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sub_parent_attribute_relationship
-- ----------------------------
DROP TABLE IF EXISTS `sub_parent_attribute_relationship`;
CREATE TABLE `sub_parent_attribute_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `attribute_type_id` bigint(20) DEFAULT NULL,
  `parent_attribute_id` bigint(20) DEFAULT NULL,
  `sub_attribute_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `code` varchar(50) NOT NULL COMMENT '供应商编码',
  `name` varchar(50) NOT NULL COMMENT '供应商名称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `schedule_type_id` varchar(50) NOT NULL COMMENT '类型编码 ：01 工序外协 02  成品外发 03  成品外购',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='供应商表';

-- ----------------------------
-- Table structure for supplier_capacity
-- ----------------------------
DROP TABLE IF EXISTS `supplier_capacity`;
CREATE TABLE `supplier_capacity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '公司代码，默认为1',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商id',
  `supplier_type_id` bigint(20) DEFAULT NULL COMMENT '类型id',
  `calendar_year` int(20) DEFAULT NULL COMMENT '年份',
  `calendar_month` int(20) DEFAULT NULL COMMENT '月份',
  `capacity_by_quantity` double DEFAULT NULL COMMENT '件产能',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) COLLATE utf8_bin DEFAULT 'AVAILABLE' COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='供应商产能表';

-- ----------------------------
-- Table structure for t_base_data
-- ----------------------------
DROP TABLE IF EXISTS `t_base_data`;
CREATE TABLE `t_base_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `code` varchar(50) DEFAULT NULL COMMENT '编码',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) NOT NULL COMMENT '类型：品类:1  品类组：2 品牌：3 产品季：4  供应商类型 5  款号类型 6  紧急度 7  首/翻单 8 产线类型 9 生产类型 10 订单类型 11 排产类型 12 季节 13',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8 COMMENT='公共基础数据表，type类型包含了现12种基础数据';

-- ----------------------------
-- Table structure for tailor_scheduling_report
-- ----------------------------
DROP TABLE IF EXISTS `tailor_scheduling_report`;
CREATE TABLE `tailor_scheduling_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(20) DEFAULT NULL COMMENT '客户端',
  `workcenter_code` varchar(255) DEFAULT NULL COMMENT '工作中心code',
  `product` varchar(255) DEFAULT NULL COMMENT '款号',
  `requirement_order` varchar(255) DEFAULT NULL COMMENT '计划订单号',
  `cutting_item` varchar(255) DEFAULT NULL COMMENT '裁剪行项目',
  `production_order` varchar(255) DEFAULT NULL COMMENT '生产订单号',
  `schedule_status` varchar(255) DEFAULT NULL COMMENT '排产状态',
  `repeat_order` varchar(255) DEFAULT NULL COMMENT '首/翻单',
  `urgency_type` varchar(255) DEFAULT NULL COMMENT '紧急度',
  `quantity` int(20) DEFAULT NULL COMMENT '订单数',
  `actual_cutting_quantity` int(20) DEFAULT NULL COMMENT '实裁数',
  `series` varchar(255) DEFAULT NULL COMMENT '系列',
  `received_time` datetime DEFAULT NULL COMMENT '接单时间',
  `issued_time` datetime DEFAULT NULL COMMENT '下发时间',
  `plan_sewing_time` datetime DEFAULT NULL COMMENT '缝制计划上线时间',
  `plan_show_start_time` datetime DEFAULT NULL COMMENT '计划开裁时间',
  `plan_show_end_time` datetime DEFAULT NULL COMMENT '计划裁完时间',
  `daily_sewing_quantity` int(20) DEFAULT NULL COMMENT '每日要求裁剪数',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际开裁时间',
  `actual_end_time` datetime DEFAULT NULL COMMENT '实际裁完时间',
  `today_cutting_quantity` int(20) DEFAULT NULL COMMENT '当日裁剪完成数量',
  `total_cutting_quantity` int(20) DEFAULT NULL COMMENT '累计裁完数量',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for temp_capacity
-- ----------------------------
DROP TABLE IF EXISTS `temp_capacity`;
CREATE TABLE `temp_capacity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(20) DEFAULT NULL COMMENT '客户端',
  `plant_id` bigint(20) NOT NULL COMMENT '工厂id',
  `workcenter_group_id` bigint(20) NOT NULL COMMENT '车间id',
  `workcenter_id` bigint(20) NOT NULL COMMENT '工作中心id',
  `product_category_group_id` bigint(20) DEFAULT NULL COMMENT '品类组id',
  `calendar_year` int(20) DEFAULT NULL COMMENT '年份',
  `calendar_month` int(20) DEFAULT NULL COMMENT '月份',
  `capacity_by_hour` double DEFAULT NULL COMMENT '时产能',
  `capacity_by_quantity` double DEFAULT NULL COMMENT '件产能',
  `average_production_time` double DEFAULT NULL COMMENT '平均单件工时',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` char(20) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `init_password` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for workcenter
-- ----------------------------
DROP TABLE IF EXISTS `workcenter`;
CREATE TABLE `workcenter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `workcenter_group_id` bigint(20) DEFAULT NULL COMMENT '车间id',
  `code` varchar(50) DEFAULT NULL COMMENT '工作中心编码',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `workcenter_category_id` bigint(20) NOT NULL COMMENT '产线类型 传统/智能',
  `production_category_id` bigint(20) NOT NULL COMMENT '生产类型  裁剪/缝制',
  `wip_number` int(11) DEFAULT NULL COMMENT 'WIP数量 智能线产等待区数量',
  `relation_workcenter_id` bigint(20) DEFAULT NULL COMMENT '关联工作中心 传统缝制关联传统裁剪工作中心',
  `order_type_id` bigint(20) DEFAULT NULL COMMENT '订单类型(智能裁剪时显示订单类型) 批量 订制',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='工作中心表';

-- ----------------------------
-- Table structure for workcenter_attribute
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_attribute`;
CREATE TABLE `workcenter_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `workcenter_id` bigint(20) NOT NULL COMMENT '工作中心id',
  `attribute_value_id` bigint(20) DEFAULT NULL COMMENT '参数类别id: 面料风格id',
  `priority` int(11) DEFAULT NULL COMMENT '中类优先等级 1：一级 2:二级 3:三级 4:四级 5：五级 6：六级 7:七级 8:八级 9：九级 10：十级',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  `group` int(11) DEFAULT NULL COMMENT '能力组 1~10',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8 COMMENT='工作中心参数表';

-- ----------------------------
-- Table structure for workcenter_capacity
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_capacity`;
CREATE TABLE `workcenter_capacity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `workcenter_group_id` bigint(20) DEFAULT NULL COMMENT '车间id',
  `workcenter_id` bigint(20) DEFAULT NULL,
  `calendar_day` date DEFAULT NULL COMMENT '日期：2018-01-04',
  `capacity_by_hour` double DEFAULT NULL COMMENT '时产能',
  `labor_quantity` int(11) DEFAULT NULL COMMENT '投入人数',
  `working_hours` double DEFAULT NULL COMMENT '工作时长',
  `efficiency` double DEFAULT NULL COMMENT '效率',
  `start_time` time DEFAULT NULL COMMENT '开始时间',
  `end_time` time DEFAULT NULL COMMENT '结束时间（=开始时间+工作时长）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` char(255) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=6648 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for workcenter_capacity_tailoring
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_capacity_tailoring`;
CREATE TABLE `workcenter_capacity_tailoring` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT '1' COMMENT '公司代码，默认为1',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `workcenter_group_id` bigint(20) DEFAULT NULL COMMENT '车间id',
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `capacity_by_hour` double DEFAULT NULL COMMENT '时产能',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(255) DEFAULT 'AVAILABLE' COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  `production_category_id` bigint(20) DEFAULT NULL COMMENT '生产方式（裁剪）',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for workcenter_category_group_relation
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_category_group_relation`;
CREATE TABLE `workcenter_category_group_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `workcenter_id` bigint(20) NOT NULL COMMENT '工作中心id',
  `product_category_group_id` bigint(20) NOT NULL COMMENT '品类组id',
  `select_year` int(11) NOT NULL COMMENT '年度',
  `select_month` int(11) NOT NULL COMMENT '月份',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='工作中心与品类组表';

-- ----------------------------
-- Table structure for workcenter_efficiency
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_efficiency`;
CREATE TABLE `workcenter_efficiency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT NULL,
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `calendar_year` int(11) DEFAULT NULL COMMENT '年',
  `calendar_month` int(11) DEFAULT NULL COMMENT '月',
  `efficiency` double DEFAULT NULL COMMENT '效率',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `workcenter_group_id` bigint(20) DEFAULT NULL COMMENT '车间id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改用户id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建用户id',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for workcenter_group
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_group`;
CREATE TABLE `workcenter_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `code` varchar(50) DEFAULT NULL COMMENT '车间编码',
  `name` varchar(50) DEFAULT NULL COMMENT '车间名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='车间表';

-- ----------------------------
-- Table structure for workcenter_labor
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_labor`;
CREATE TABLE `workcenter_labor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `workcenter_id` bigint(20) NOT NULL COMMENT '工作中心id',
  `labor_quantity` int(11) DEFAULT NULL COMMENT '计划投入人数',
  `actual_operators` int(11) DEFAULT NULL COMMENT '实际投入人数',
  `calendar_day` date DEFAULT NULL COMMENT '日期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=4468 DEFAULT CHARSET=utf8 COMMENT='投入人数表';

-- ----------------------------
-- Table structure for workcenter_operation
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_operation`;
CREATE TABLE `workcenter_operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `client` int(11) DEFAULT '1' COMMENT '系统id 1 赢家',
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `available_start_time` datetime DEFAULT NULL COMMENT '可开始排产时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='工作中心操作表';

-- ----------------------------
-- Table structure for workcenter_parameter
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_parameter`;
CREATE TABLE `workcenter_parameter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client` int(11) DEFAULT '1',
  `workcenter_id` bigint(20) NOT NULL COMMENT '工作中心id',
  `attribute_type_id` bigint(20) NOT NULL COMMENT '参数类别id: 面料风格id',
  `attribute_type_name` varchar(50) DEFAULT NULL COMMENT '参数类别名称',
  `parent_attribute_id` bigint(20) NOT NULL COMMENT '参数值id: 格条id 净色id',
  `priority` int(11) DEFAULT NULL COMMENT '中类优先等级 1：一级 2:二级 3:三级 4:四级 5：五级 6：六级 7:七级 8:八级 9：九级 10：十级',
  `parent_attribute_name` varchar(50) DEFAULT NULL COMMENT '参数值名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `status` varchar(20) DEFAULT NULL COMMENT '状态： AVAILABLE：可用 DELETED：删除 FREEZED：冻结',
  `group` int(11) DEFAULT NULL COMMENT '能力组 1~10',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='工作中心参数表';

-- ----------------------------
-- Table structure for workcenter_shift
-- ----------------------------
DROP TABLE IF EXISTS `workcenter_shift`;
CREATE TABLE `workcenter_shift` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水id',
  `client` int(11) DEFAULT NULL COMMENT '客户端',
  `plant_id` bigint(20) DEFAULT NULL COMMENT '工厂id',
  `workcenter_group_id` bigint(20) DEFAULT NULL COMMENT '车间id',
  `workcenter_id` bigint(20) DEFAULT NULL COMMENT '工作中心id',
  `calendar_day` date DEFAULT NULL COMMENT '日期：2018-01-04',
  `shift` varchar(255) DEFAULT NULL COMMENT '班组',
  `start_time` time DEFAULT NULL COMMENT '开始时间：08:00',
  `end_time` time DEFAULT NULL COMMENT '结束时间：12:00（=开始时间+工作时长）',
  `working_hours` double DEFAULT NULL COMMENT '工作时长',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `status` varchar(255) DEFAULT NULL COMMENT '状态：AVAILABLE("AVAILABLE",1), DELETED("DELETED",2), FREEZED("FREEZED",3);',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=7654 DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for outsource_order_view
-- ----------------------------
DROP VIEW IF EXISTS `outsource_order_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `outsource_order_view` AS select `outsource`.`requirement_order` AS `requirement_order`,sum((case when (`outsource`.`operation_code` = '0901') then `outsource`.`operation_time` else 0 end)) AS `frontOperationDays`,sum((case when (`outsource`.`operation_code` <> '0901') then `outsource`.`operation_time` else 0 end)) AS `laterOperationDays` from `outsource_order` `outsource` group by `outsource`.`requirement_order`;

SET FOREIGN_KEY_CHECKS = 1;
