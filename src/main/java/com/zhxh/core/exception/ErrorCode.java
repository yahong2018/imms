package com.zhxh.core.exception;

public enum ErrorCode {
    ERROR_UNKNOWN_EXCEPTION,
    ERROR_DATA_ALREADY_EXISTS,
    ERROR_DATA_NOT_EXISTS,
    ERROR_LOGIN_ACCOUNT_ERROR,
    ERROR_OLD_PASSWORD_ERROR,
    ERROR_LOGIN_ACCOUNT_DISABLED,
    ERROR_ROLE_CONTAINS_USERS,
   
    /**
     * 有下级菜单不可删除
     */
    DELECT_DEPARTMENT_CODE,
    
    /**
     * 有下级菜单不可删除
     */
    DELECT_PROGRAM_ID,
    
    /**
     * 有下级菜单不可删除
     */
    MATERIAL_TYPE_CODE,
    /**
     * 校验物料类别是否存在物料信息
     */
    MATERIAL,
    
    /**
     * 部门编码不可重复 
     */
    DEPARTMENT_CODE,
    
    /**
     * 菜单编码不可重复 
     */
    PROGRAM_ID,
    
    /**
     * 菜单编码不可为空
     */
    PROGRAM_ID_IS_NULL,
    
    /**
     * 部门是否被使用
     */
    IS_QUOTE_DEPARTMENT_CODE,
    /**
     * 物料类别是否被使用
     */

    IS_QUOTE_MATERIAL_TYPE_CODE,
    
    /**
     * 仓库是否被使用
     */
    IS_QUOTE_WAREHOUSE_CODE,


    /**
     * 设备类型表主键被设备信息表引用
     */
    ERROR_QUOTED_BY_EQUIPMENT,

    /**
     * 设备信息表主键被料站信息表引用
     */
    ERROR_QUOTED_BY_MATERIAL_STATION,

    /**
     * 设备信息表主键被IO信息表引用
     */
    ERROR_QUOTED_BY_IO_MESSAGE,
    /**
     * 设备信息表主键被工作中心表引用
     */
    ERROR_QUOTED_BY_EQUIPMENT_PE,

    /**
     * 校验工作中心是否有设备产能
     */     
    IS_QUOTE_WORK_CENTER_CODE,
    
    /**
     * 校验工作中心是否有设备产能
     */
    IS_QUOTE_PROCESS_AND_WORK_CENTER,
    
    /**
     * 校验工作中心编码是否已存在
     */
    WORK_CENTER_CODE_ALREADY_EXISTED,
    /**
     * 校验工艺信息是否存在工作中心优先级
     */
    IS_QUOTE_PROCESS_CODE, 
    
    /**
     * BOM已引用
     */
    ERROR_QUOTED_BY_BOM,
    /**
     * 校验料站信息是否存在料站优先级
     */
    IS_QUOTE_MATERIAL_STATION_CODE,
    
    /**
     * 校验工艺信息是否引用工作中心
     */
    IS_WORK_CENTER_PRIORITY,

    /**
     * 取替代信息表主键被优先级表引用
     */
    ERROR_QUOTED_BY_PRIORITY,
    /**
     * 校验工艺信息是否被产品工艺引用
     */

    IS_QUOTE_PRODUCT_PROCESS_CODE,
    

    /**
     * 校验实际用量，不可小于标准用量
     */
    IS_QUOTE_ACTION_NUMBER,
    
    /**
     * 没有库存，或者库存数量不够！
     */
    IS_QUOTE_CURRENT_STOCK,

  /**
 * 该工单已发放不能删除
 */
DELETE_WORK_ORDER,
    
    /**
     * 校验BOM单号唯一
     */
    ERROR_UNIQU_EXCEPTION,
    /**
     * 校验派工数量
     */
    AMOUNT,
    /**
     * 系统出错
     */
    ERROR,
    /**
     * 校验派工单被引用数量
     */
    ERROR_BE_ADOPTED_DIS_ORDER,
    /**
     * 本次退料数量不能大于（工作中心）库存数量
     */
    ERROR_CURRENTSTOCK_EXCEPTION,
    /**
     * 本次领料数量不能大于仓库库存数量
     */
    ERROR_REQUISITION_EXCEPTION,
    /**
     *  该生产计划已发放不能删除
     */
    DELETE_PRODUCTION_PLAN,
    /**
     * 派工单发放回写工单时，派工量不能大于工单数量
     */
    ERROR_WORK_ORDER_AMOUNT,
    /**
     * 派工单撤销发放回写工单时，派工量不能小于0
     */
    ERROR_WORK_ORDER_AMOUNT_LOW,
    /**
     * 派工单明细发放回写工单时，虚设已派工量不能大于需领用量
     */
    ERROR_DISPATCH_ORDER_SUB_AMOUNT,
    /**
     * 派工单明细发放回写工单时，虚设已派工量不能小于0
     */
    ERROR_DISPATCH_ORDER_SUB_AMOUNT_LOW,
    /**
     * 领料量不能大于未领量
     */
    ERROR_REQUISITION_EXCEPTION_1,
    /**
     * 仓库库存数量不够
     */
    ERROR_REQUISITION_EXCEPTION_2,
    /**
     * 查找不到该批次的库存
     */
    ERROR_REQUISITION_EXCEPTION_3,
    
    /**
     * 退料数量不能大于（已领用量-已耗用量）
     */
    ERROR_RETREATING_EXCEPTION,
    
    /**
     * 你输入的物料名称+规格不能重复！
     */
    ERROR_UNKNOWN_MATERIAL_1,
    /**
     * 进料检验单只有待检验的才能删除
     */
    ERROR_INCOMING_INS_DEL_CHECK_RESULT,
    
    /**
     * 同一采购单下的物料收料数量不能大于采购单当前的已交货量
     */
    ERROR_INSUFFICIENT_EXCEPTION, 
    
    /**
     * 明细记录已被引用，不能撤销
     */
    IS_QUOTE_CANCEL_SUBMISSION_INTO_WAREHOUSE, 
    
    /**
     * 采购批次不能为空或收料数量不能为0
     */
    ERROR_EMPTY_EXCEPTION,
    /**
     * 托板位置状态
     */
    PALLET_TRACKING_INFO_STATUS,
    /**
     * 校验进仓单是否有子件
     */
    PALLET_UNUSUAL_DETIAL_SOURCE_ORDER_ID, 
     
    /**
     *只有状态为“待收料”单据，才可以删除
     */
    IS_QUOTE_STATUS,
    
    /**
     * 托板已被占
     */
    ERROR_PALLETCOUNT, 
    
    /**
     * 非单件或采购批次为空均不能添加批次物料ID
     */
    ERROR_MATERIAL_ID_INFO_EXCEPTION, 
    
    
    /**
     * 批次物料ID收料量为空不能再添加批次物料ID
     */
    ERROR_NOT_EMPTY_EXCEPTION,
    /**
     * 点检配置 新增主键重复异常 
     * 提示语：点检代码重复， 请确认！
     */
    ERROR_EQUIPMENT_CHECKING_CONFIG_EXCEPTION
}

